package tj.ustb.studentFunding.admain.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tj.ustb.studentFunding.admain.domain.Admain;
import tj.ustb.studentFunding.admain.service.AdmainService;
import tj.ustb.studentFunding.department.domain.Department;
import tj.ustb.studentFunding.department.service.DepartmentService;
import tj.ustb.studentFunding.user.service.StudentException;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

public class AdmainServlet extends BaseServlet {

	private AdmainService admainService = new AdmainService();
	//实现登录功能
	public String login(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		/*
		 * 1. 封装表单数据到form中
		 * 2. 输入校验
		 * 3. 若校验失败保存错误信息、form到request，转发到login.jsp
		 * 4. 保存用户信息到session中，然后重定向到index.jsp
		 */
		
		Admain form = CommonUtils.toBean(request.getParameterMap(), Admain.class);
		try {
			Admain admain = admainService.login(form);
			request.getSession().setAttribute("session_admain", admain);
			return "r:/Admain/index.jsp";   
		} catch (StudentException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return  "f:/Admain/user/login.jsp";  
		}
		
	}
}
