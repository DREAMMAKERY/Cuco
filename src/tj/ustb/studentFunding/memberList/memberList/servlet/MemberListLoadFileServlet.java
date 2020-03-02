package tj.ustb.studentFunding.memberList.memberList.servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import tj.ustb.studentFunding.application.service.ApplicationService;
import tj.ustb.studentFunding.memberList.memberList.service.MemberListService;

public class MemberListLoadFileServlet extends HttpServlet {
	private MemberListService memberListService = new MemberListService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		byte[] bytes = memberListService.findFileById(request.getParameter("department"), request.getParameter("major"), request.getParameter("classno"));
		
		String contentType = "application/vnd.ms-excel"; 
		String contentDisposition = "attachment;filename=评审名单.xls";
		
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition",contentDisposition);
		
		//获取绑定客户端的流
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(new ByteArrayInputStream(bytes), response.getOutputStream());

	}

}
