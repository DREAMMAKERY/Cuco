package tj.ustb.studentFunding.department.service;

import java.util.List;

import tj.ustb.studentFunding.department.Dao.DepartmentDao;
import tj.ustb.studentFunding.department.domain.Department;
import tj.ustb.studentFunding.user.dao.HeadmasterDao;
import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.domain.Student;
import tj.ustb.studentFunding.user.service.StudentException;

public class DepartmentService {
	DepartmentDao departmentDao = new DepartmentDao();

	/*
	 * 登录功能
	 * */
	public Department login(Department form) throws StudentException{
		Department department = departmentDao.findByDepartmentPassword(form);
		if(department == null) throw new StudentException("账号不存在或密码错误");
		return department;
	}
	public List<Department> findAll(){
		return departmentDao.findAll();
	}
	
	public void delete(String id){
		departmentDao.delete(id);
	}
}
