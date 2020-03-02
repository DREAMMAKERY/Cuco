package tj.ustb.studentFunding.application.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import tj.ustb.studentFunding.application.ApplicationDao.ApplicationDao;
import tj.ustb.studentFunding.application.domain.Application;

public class ApplicationService {
	
	ApplicationDao applicationDao = new ApplicationDao();
	public void submit(Application form) throws FileNotFoundException, SerialException, IOException, SQLException{	
			applicationDao.add(form);
		}
	
	
	public byte[] findFileById(String id){
		return applicationDao.findFileById(id);
	}
	
	public byte[] findPictureById(String id){
		return applicationDao.findPictureById(id);
	}
		
	public List<Application> findByClass(String classno) throws SQLException{
		return  applicationDao.findByClass(classno);
	}
	
	public void setClassVerifyResult(String id) throws SQLException{
		applicationDao.setClassVerifyResult(id);
	}
	
	
	public void setClassVerifyResultFail(String id) throws SQLException{
		applicationDao.setClassVerifyResultFail(id);
	}
	
	public String queryClassResult(String id) throws SQLException{
		return applicationDao.queryClassResult(id);
	}
	
	public String queryDepartmentResult(String id) throws SQLException{
		return applicationDao.queryDepartmentResult(id);
	}
	
	public String queryLastResult(String id) throws SQLException{
		return applicationDao.queryLastResult(id);
	}
	
	public 	List<Application> findByClassVerfiy() throws SQLException {
		
		return  applicationDao.findByClassVerfiy();
}
	
	
	public void setDepartmentVerifyResult(String id) throws SQLException{
		applicationDao.setDepartmentVerifyResult(id);
	}
	
	public void setDepartmentVerifyResultFail(String id) throws SQLException{
		applicationDao.setDepartmentVerifyResultFail(id);
	}
	
	public void setLastVerifyResult(String id) throws SQLException{
		applicationDao.setLastVerifyResult(id);
	}
	
	public void setLastVerifyResultFail(String id) throws SQLException{
		applicationDao.setLastVerifyResultFail(id);
	}
	
	public List<Application> findByDepartmentVerfiy(String department) throws SQLException{
		return applicationDao.findByDepartmentVerfiy(department);
	}
	
	public List<Application> findByDepartmentVerfiy() throws SQLException{
		return applicationDao.findByDepartmentVerfiy();
	}
	
	public 	void addToDatabase()  throws SQLException{
		applicationDao.addToDatabase();
	}
	public 	Application query(String sid)  throws SQLException{
		return applicationDao.query(sid);
	}
	
	}


