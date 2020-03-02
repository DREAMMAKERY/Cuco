package tj.ustb.studentFunding.admain.service;

import tj.ustb.studentFunding.admain.AdmainDao.AdmainDao;
import tj.ustb.studentFunding.admain.domain.Admain;
import tj.ustb.studentFunding.user.service.StudentException;

public class AdmainService {
	AdmainDao admainDao = new AdmainDao();

	/*
	 * 登录功能
	 * */
	public Admain login(Admain form) throws StudentException{
		Admain admain = admainDao.findByAdmainPassword(form);
		if(admain == null) throw new StudentException("账号不存在或密码错误");
		return admain;
	}
}
