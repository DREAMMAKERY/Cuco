package tj.ustb.studentFunding.application.ApplicationServlet;



import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import tj.ustb.studentFunding.application.service.ApplicationService;

public class ApplicationLoadFileServlet extends HttpServlet {

	ApplicationService applicationService = new ApplicationService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		byte[] bytes = applicationService.findFileById(request.getParameter("id"));
		
		String contentType = "application/msword"; 
		String contentDisposition = "attachment;filename=申请表.doc";
		
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition",contentDisposition);
		
		//获取绑定客户端的流
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(new ByteArrayInputStream(bytes), response.getOutputStream());

	}

}
