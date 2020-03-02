package tj.ustb.studentFunding.memberList.memberList.servlet;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import tj.ustb.studentFunding.application.service.ApplicationService;
import tj.ustb.studentFunding.memberList.memberList.service.MemberListService;

public class MemberListLoadServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String fileName = "E:\\学生资助管理系统\\系统毕设\\北京科技大学天津学院佳通经济困难学生评议小组成员名单-模板.xls";
		String contentType = this.getServletContext().getMimeType(fileName); //通过文件名称获取MIME类型
		String contentDisposition = "attachment;filename=北京科技大学天津学院评议小组成员名单.doc";
		FileInputStream input = new FileInputStream(fileName);
		
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition",contentDisposition);
		
		//获取绑定客户端的流
		ServletOutputStream output = response.getOutputStream();
		
		IOUtils.copy(input,output);//将输入流中的数据写入到输出流中
		
		
		input.close();
	}

}
