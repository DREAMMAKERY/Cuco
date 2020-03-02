package tj.ustb.studentFunding.department.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tj.ustb.studentFunding.department.domain.Department;
import tj.ustb.studentFunding.department.service.DepartmentService;
import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.service.HeadmasterService;
import tj.ustb.studentFunding.user.service.StudentException;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

public class DepartmentServlet extends BaseServlet {
	private DepartmentService departmentService = new DepartmentService();
	//实现登录功能
	public String login(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		/*
		 * 1. 封装表单数据到form中
		 * 2. 输入校验
		 * 3. 若校验失败保存错误信息、form到request，转发到login.jsp
		 * 4. 保存用户信息到session中，然后重定向到index.jsp
		 */
		
		Department form = CommonUtils.toBean(request.getParameterMap(), Department.class);
		try {
			Department department = departmentService.login(form);
			request.getSession().setAttribute("session_department", department);
			return "r:/DepartmentReview/index.jsp";
		} catch (StudentException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/DepartmentReview/user/login.jsp";
		}
		
	}
	
      public String findAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, StudentException{
		
		
		request.setAttribute("DepartmentList",departmentService.findAll());

		return "f:/Admain/user/DepartmentAccount.jsp";
		
	}
      public String delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, StudentException{
  		
  		departmentService.delete(request.getParameter("did"));
  		request.setAttribute("msgdel", "操作成功");
  		return "f:/Admain/user/DepartmentAccount.jsp";
  	}
}
