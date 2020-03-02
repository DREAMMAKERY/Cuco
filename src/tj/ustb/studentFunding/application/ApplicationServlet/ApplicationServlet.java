package tj.ustb.studentFunding.application.ApplicationServlet;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tj.ustb.studentFunding.application.domain.Application;
import tj.ustb.studentFunding.application.service.ApplicationService;
import tj.ustb.studentFunding.department.domain.Department;
import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.service.StudentException;
import cn.itcast.servlet.BaseServlet;


public class ApplicationServlet extends BaseServlet {
	ApplicationService applicationService = new ApplicationService();
	
	
	//将最终审核通过学生录入数据库
	public 	String addToDatabase(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
		applicationService.addToDatabase();
		request.setAttribute("addMsg", "添加成功");
		return "f:/Admain/user/Save.jsp";
	}
	
	//根据学生id在学生资助数据库中查询信息
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, StudentException {
		Application application = applicationService.query(request.getParameter("sid"));
		
		
		if(application == null) throw new StudentException("暂无显示信息");
		request.setAttribute("application",application);
		return "f:/Admain/user/QueryApplicationInfo.jsp";
	}
	//根据班级查找学生申请信息
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Headmaster headmaster = (Headmaster)request.getSession().getAttribute("session_headmaster");
		String classno = headmaster.getClassno();
		request.setAttribute("ApplicationList", applicationService.findByClass(classno));
	
		return "f:/ClassReview/user/ApplicationInfo.jsp";
	}
	
	//设置审核成功
	public void setClassVerifyResult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		applicationService.setClassVerifyResult(request.getParameter("id"));
		request.setAttribute("msg1", "提交成功");
	//	return "f:/ClassReview/user/ApplicationInfo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher("/ClassReview/user/ApplicationInfo.jsp");
		rd.forward(request,response);
	
	}
	
	//设置审核失败
		public String setClassVerifyResultFail(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
			
			applicationService.setClassVerifyResultFail(request.getParameter("id"));
			request.setAttribute("msg1", "提交成功");
			return "f:/ClassReview/user/ApplicationInfo.jsp";
		
		}
		
		public void queryClassResult(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
	
			String result = applicationService.queryClassResult(request.getParameter("id"));
			
			response.getWriter().print(result);
		
		}
	
		//根据班级审核通过 查找学生申请信息
		public String findByClassVerfiy(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {

			request.setAttribute("ApplicationList", applicationService.findByClassVerfiy());
			return "f:/DepartmentReview/user/ApplicationInfo.jsp";
		}
	

		//设置审核成功
		public void setDepartmentVerifyResult(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, SQLException {
			
			applicationService.setDepartmentVerifyResult(request.getParameter("id"));
			request.setAttribute("msg1", "提交成功");
		//	return "f:/ClassReview/user/ApplicationInfo.jsp";
			RequestDispatcher rd = request.getRequestDispatcher("/DepartmentReview/user/ApplicationInfo.jsp");
			rd.forward(request,response);
		
		}
		
		//设置审核失败
				public void setDepartmentVerifyResultFail(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException, SQLException {
					
					applicationService.setDepartmentVerifyResultFail(request.getParameter("id"));
					request.setAttribute("msg1", "提交成功");
				//	return "f:/ClassReview/user/ApplicationInfo.jsp";
					RequestDispatcher rd = request.getRequestDispatcher("/DepartmentReview/user/ApplicationInfo.jsp");
					rd.forward(request,response);
				
				}
				
				//根据院系审核通过 查找学生申请信息
				public String findByDepartmentVerfiy(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException, SQLException {

					request.setAttribute("ApplicationList", applicationService.findByDepartmentVerfiy(request.getParameter("department")));
					return "f:/DepartmentReview/user/PublicStudentFunding.jsp";
				}
				
				//根据院系审核通过 查找学生申请信息（学工办）
				public String findByDepartmentVerfiyXue(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException, SQLException {

					request.setAttribute("ApplicationList", applicationService.findByDepartmentVerfiy());
					return "f:/Admain/user/ApplicationInfo.jsp";
				}
				//设置审核成功
				public void setLastVerifyResult(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException, SQLException {
					
					applicationService.setLastVerifyResult(request.getParameter("id"));
					request.setAttribute("msg1", "提交成功");
				//	return "f:/ClassReview/user/ApplicationInfo.jsp";
					RequestDispatcher rd = request.getRequestDispatcher("/Admain/user/ApplicationInfo.jsp");
					rd.forward(request,response);
				
				}
				
				//设置审核失败
						public void setLastVerifyResultFail(HttpServletRequest request, HttpServletResponse response)
								throws ServletException, IOException, SQLException {
							
							applicationService.setLastVerifyResultFail(request.getParameter("id"));
							request.setAttribute("msg1", "提交成功");
						//	return "f:/ClassReview/user/ApplicationInfo.jsp";
							RequestDispatcher rd = request.getRequestDispatcher("/Admain/user/ApplicationInfo.jsp");
							rd.forward(request,response);
						
						}
}
