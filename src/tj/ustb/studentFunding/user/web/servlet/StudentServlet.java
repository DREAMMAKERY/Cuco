package tj.ustb.studentFunding.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tj.ustb.studentFunding.user.domain.Student;
import tj.ustb.studentFunding.user.service.StudentException;
import tj.ustb.studentFunding.user.service.StudentService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/*User表述层
 * */
public class StudentServlet extends BaseServlet {
	
	private StudentService studentService = new StudentService();
	//完成注册功能
	public String regist(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	/*
	 * 1.封装表单到Student对象中 
	 * 2.输入校验 ：保存错误信息，from到request域中，转发到regist.jsp
	 * 3.调用service方法完成注册 :保存错误信息，from到request域中，转发到regist.jsp
	 * 4.保存成功信息到msg.jsp
	 * */
	
		//封装表单数据	
		Student form = CommonUtils.toBean(request.getParameterMap(), Student.class);
		
		/*输入校验
		 * 1.创建一个Map，用来封装错误信息（学号信息，密码信息，验证码信息）,其中key为表单字段名称，值为错误信息
		 * 2.获取form中的信息进行校验
		 * */
	
		Map<String,String> errors = new HashMap<String,String>();
		String studentId = form.getSid();
		if(studentId == null || studentId.trim().isEmpty()){
			errors.put("studentId","学号不能为空！" );
		}else if(studentId.length()<9 || studentId.length()>14){
				errors.put("studentId", "学号长度必须大于9！");
				};
				
		String studentName = form.getSname();
		if(studentName == null || studentName.trim().isEmpty()){
				errors.put("studentName","名字不能为空！" );
		}else if(studentId.length()<1 || studentId.length()>10){
				errors.put("studentName", "名字长度必须大于1！");
			};		
			
		String password = form.getSpassword();
		if(password == null || password.trim().isEmpty()){
			errors.put("password","密码不能为空！" );
		}else if(password.length()<5 || password.length()>10){
					errors.put("password", "密码长度必须在5~10之间！");
		};			
		
		//判断是否存在错误信息
		if(errors.size()>0){
			/*1.保存错误信息
			 *2.保存表单数据
			 *3.转发到regist.jsp
			 * */
			request.setAttribute("errors", errors);
			request.setAttribute("form", form);
			return "r:/regist.jsp";
		}
		
		/*
		 * 调用service的regist()方法
		 * */
		
		try {
			studentService.regist(form);
			/*
			 * 执行到这说明StudentService成功，没有抛出异常
			 * 保存成功信息，转发到msg.jsp
			 * */
			
			
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			/*
			 * 1.保存异常信息
			 * 2.保存form
			 * 3.转发到regist.jsp
			 * */
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/regist.jsp";
			
		}
		request.setAttribute("msg", "注册成功！");
		return "f:/jsps/msg.jsp";
	}
	
	//完成登录功能
	public String login(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		/*
		 * 1. 封装表单数据到form中
		 * 2. 输入校验
		 * 3. 若校验失败保存错误信息、form到request，转发到login.jsp
		 * 4. 保存用户信息到session中，然后重定向到index.jsp
		 */
		
		Student form = CommonUtils.toBean(request.getParameterMap(), Student.class);
		try {
			Student student = studentService.login(form);
			request.getSession().setAttribute("session_student", student);
			return "r:/index.jsp";
		} catch (StudentException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			return "f:/jsps/user/login.jsp";
		}
		
	}

	//退出功能
	public String quit(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.getSession().invalidate();
		return "r:/index.jsp";
	}
	
	//查看个人信息
	public String personalInformation(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, StudentException{
		/*
		Student form = (Student)request.getSession().getAttribute("session_student");
		
			response.getWriter().println(form.getSid()+form.getSname()+form.getDepartment()+form.getMajor()+form.getGrade()+ form.getClassno());
			
			request.getSession().setAttribute("sid", form.getSid());
			request.getSession().setAttribute("sname", form.getSname());
			request.getSession().setAttribute("department", form.getDepartment());
			request.getSession().setAttribute("major", form.getMajor());
			request.getSession().setAttribute("grade", form.getGrade());
			request.getSession().setAttribute("classno", form.getClassno());
			*/
			
		Student form = (Student)request.getSession().getAttribute("session_student");
		String id = form.getSid();
		request.setAttribute("studentInfo", studentService.personalInformation(id));
	
		return "f:/jsps/StudentInfo/StudentInfo.jsp";
	}
	
	public String queryApplication(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, StudentException{
		
		Student form = (Student)request.getSession().getAttribute("session_student");
		String id = form.getSid();
		request.setAttribute("studentInfo", studentService.personalInformation(id));
		request.setAttribute("queryResult", studentService.queryApplication(id));
		
		return "f:/jsps/StudentInfo/StudentApplicationInfo.jsp";
		
	}
	
	public String findAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, StudentException{
		
		
		request.setAttribute("StudentList",studentService.findAll());

		return "f:/Admain/user/StudentAccount.jsp";
		
	}
	
	public String delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException, StudentException{
		
		studentService.delete(request.getParameter("sid"));
		request.setAttribute("msgdel", "操作成功");
		return "f:/Admain/user/StudentAccount.jsp";
	}
}

	