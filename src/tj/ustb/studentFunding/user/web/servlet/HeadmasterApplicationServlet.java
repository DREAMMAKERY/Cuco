package tj.ustb.studentFunding.user.web.servlet;

import java.io.IOException;
import java.sql.Blob;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tj.ustb.studentFunding.application.domain.Application;
import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.domain.Student;
import tj.ustb.studentFunding.user.service.HeadmasterService;

public class HeadmasterApplicationServlet extends HttpServlet {
	
	HeadmasterService headmasterService = new HeadmasterService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/*
		 * 1.调用service方法，得到该班级的所有学生的申请信息
		 * 2.保存到request域，转发到application.jsp
		 * */
		
		Headmaster headmaster = (Headmaster)request.getSession().getAttribute("session_headmaster");
		String classno = headmaster.getClassno();
	
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/ClassReview/user/ApplicationInfo.jsp");
		rd.forward(request, response);
		
	}

}
