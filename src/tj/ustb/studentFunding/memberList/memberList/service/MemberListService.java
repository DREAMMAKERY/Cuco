package tj.ustb.studentFunding.memberList.memberList.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import tj.ustb.studentFunding.application.ApplicationDao.ApplicationDao;
import tj.ustb.studentFunding.application.domain.Application;
import tj.ustb.studentFunding.memberList.memberList.Dao.MemberListDao;
import tj.ustb.studentFunding.memberList.memberList.domain.MemberList;

public class MemberListService {
	MemberListDao memberListDao = new MemberListDao();
	public void submit(MemberList form) throws FileNotFoundException, SerialException, IOException, SQLException{	
		memberListDao.add(form);
		}
	
	
	public byte[] findFileById(String department,String major,String classno){
		return memberListDao.findFileById(department,major,classno);
	}
	
	public List<MemberList> findAll() throws FileNotFoundException, SerialException, IOException, SQLException{
		return memberListDao.findAll();
	}
}
