package tj.ustb.studentFunding.user.service;

import java.util.List;

import tj.ustb.studentFunding.user.dao.StudentDao;
import tj.ustb.studentFunding.user.domain.Student;
/*
 * User业务层
 * */
public class StudentService {
	private StudentDao studentDao = new StudentDao();
	/*
	 * 注册功能
	 * */
	public void regist(Student form) throws StudentException{
		
		//校验学号
		Student student = studentDao.findByStudentId(form.getSid());
		if(student != null) throw new StudentException("该学号已被注册！");
		
		//插入学生信息到数据库
		studentDao.add(form);
	}
	
	/*
	 * 登录功能
	 * */
	public Student login(Student form) throws StudentException{
		Student student = studentDao.findByStudentPassword(form);
		if(student == null) throw new StudentException("账号不存在或密码错误");
		return student;
	}
	
public Student personalInformation(String studentId) throws StudentException{
		return studentDao.findByStudentId(studentId);
	}

public String queryApplication(String studentId) throws StudentException{
	return studentDao.queryApplication(studentId);
}

public List<Student> findAll(){
	return studentDao.findAll();
}

public void delete(String id){
	studentDao.delete(id);
}
}
