package tj.ustb.studentFunding.user.service;

import java.util.List;

import tj.ustb.studentFunding.application.ApplicationDao.ApplicationDao;
import tj.ustb.studentFunding.application.domain.Application;
import tj.ustb.studentFunding.user.dao.HeadmasterDao;
import tj.ustb.studentFunding.user.dao.StudentDao;
import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.domain.Student;

public class HeadmasterService {
	HeadmasterDao headmasterDao = new HeadmasterDao();
	ApplicationDao applicationDao = new ApplicationDao();
	/*
	 * 登录功能
	 * */
	public Headmaster login(Headmaster form) throws StudentException{
		Headmaster headmaster = headmasterDao.findByHeadmasterPassword(form);
		if(headmaster == null) throw new StudentException("账号不存在或密码错误");
		return headmaster;
	}
	
	public List<Headmaster> findAll(){
		return headmasterDao.findAll();
	}
	
	public void delete(String id){
		headmasterDao.delete(id);
	}
}
