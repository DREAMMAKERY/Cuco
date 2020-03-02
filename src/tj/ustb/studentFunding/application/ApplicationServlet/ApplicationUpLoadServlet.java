package tj.ustb.studentFunding.application.ApplicationServlet;

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

public class ApplicationUpLoadServlet extends HttpServlet {
	private ApplicationService applicationService = new ApplicationService();
	private Application form = new Application();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		try {
			List<FileItem> fileItem = sfu.parseRequest(request);
			
			form.setName(fileItem.get(0).getString("UTF-8"));
			form.setId(fileItem.get(1).getString("UTF-8"));
			form.setDepartment(fileItem.get(2).getString("UTF-8"));
			form.setGrade(fileItem.get(3).getString("UTF-8"));
			form.setMajor(fileItem.get(4).getString("UTF-8"));
			form.setClassno(fileItem.get(5).getString("UTF-8"));
			
			String name1 = fileItem.get(6).getName();//获取上传文件的名字
			int lastIndex = name1.lastIndexOf("\\");//获取最后一个“\”的位置
			if(lastIndex != -1) {//注意，如果不是完整路径，那么就不会有“\”的存在。
				name1 = name1.substring(lastIndex + 1);//获取文件名称
			}
			
			// 获取真实路径，对应${项目目录}/uploads，当然，这个目录必须存在
			String savepath = this.getServletContext().getRealPath("/uploads");
			// 通过uploads目录和文件名称来创建File对象
			File file1 = new File(savepath, name1);
			// 把上传文件保存到指定位置(以文件流的形式写入新创建的file文件中)
			
			fileItem.get(6).write(file1);
		
			 String name2 = fileItem.get(7).getName();
			 int lastIndex1 = name2.lastIndexOf("\\");//获取最后一个“\”的位置
				if(lastIndex1 != -1) {//注意，如果不是完整路径，那么就不会有“\”的存在。
					name2 = name2.substring(lastIndex1 + 1);//获取文件名称
				}

			 File file2 = new File(savepath, name2);
			 fileItem.get(7).write(file2);
			 
			 byte[] bytes1=IOUtils.toByteArray(new FileInputStream(file1));
			 byte[] bytes2=IOUtils.toByteArray(new FileInputStream(file2));
		
			 form.setApplication_file(bytes1);
			 form.setApplication_picture(bytes2);
			 applicationService.submit(form);
			 
			request.setAttribute("upload", "上传成功"); 
			RequestDispatcher rd = request.getRequestDispatcher("/jsps/ApplicationForm/application.jsp");
			rd.forward(request,response);

		} catch (Exception e) {
			throw new ServletException(e);
		} 
	
		
		
	}

}
