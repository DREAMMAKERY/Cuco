package tj.ustb.studentFunding.memberList.memberList.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import tj.ustb.studentFunding.application.domain.Application;
import tj.ustb.studentFunding.application.service.ApplicationService;
import tj.ustb.studentFunding.memberList.memberList.domain.MemberList;
import tj.ustb.studentFunding.memberList.memberList.service.MemberListService;

public class MemberListUpLoadServlet extends HttpServlet {
	private MemberListService memberListService = new MemberListService();
	private MemberList form = new MemberList();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		try {
			List<FileItem> fileItem = sfu.parseRequest(request);
			
			
			form.setDepartment(fileItem.get(0).getString("UTF-8"));
			form.setMajor(fileItem.get(1).getString("UTF-8"));
			form.setClassno(fileItem.get(2).getString("UTF-8"));
			
			String name = fileItem.get(3).getName();//获取上传文件的名字
			int lastIndex = name.lastIndexOf("\\");//获取最后一个“\”的位置
			if(lastIndex != -1) {//注意，如果不是完整路径，那么就不会有“\”的存在。
				name = name.substring(lastIndex + 1);//获取文件名称
			}
			
			// 获取真实路径，对应${项目目录}/uploads，当然，这个目录必须存在
			String savepath = this.getServletContext().getRealPath("/uploads");
			// 通过uploads目录和文件名称来创建File对象
			File file1 = new File(savepath, name);
			// 把上传文件保存到指定位置(以文件流的形式写入新创建的file文件中)
			
			fileItem.get(3).write(file1);
		
			 byte[] bytes1=IOUtils.toByteArray(new FileInputStream(file1));
			
			 form.setFile(bytes1);
			 memberListService.submit(form);
			
			request.setAttribute("upload", "上传成功"); 
			RequestDispatcher rd = request.getRequestDispatcher("/ClassReview/user/Member.jsp");
			rd.forward(request,response);

		} catch (Exception e) {
			throw new ServletException(e);
		} 
	
		
		
	}


}
