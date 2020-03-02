package tj.ustb.studentFunding.application.ApplicationDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.io.IOUtils;

import cn.itcast.jdbc.TxQueryRunner;

import tj.ustb.studentFunding.application.domain.Application;
import tj.ustb.studentFunding.user.domain.Student;

public class ApplicationDao {
	
	private QueryRunner qr = new TxQueryRunner();
	
	
	//添加申请表信息，包括申请表文件
	public void add(Application application) throws FileNotFoundException, IOException, SerialException, SQLException{
		
		String sql = "insert into t_application(id,name,department,major,grade,classno,application_file,application_picture) values(?,?,?,?,?,?,?,?)";
	/*	
		//把文件转换成byte[]
		byte[] bytes1=IOUtils.toByteArray(new FileInputStream(application.getApplcation_file()));
		byte[] bytes2=IOUtils.toByteArray(new FileInputStream(application.getApplcation_picture()));
		//使用byte[]创建Blob
		Blob blob1 = new SerialBlob(bytes1);
		Blob blob2 = new SerialBlob(bytes2);
		*/
		Object[] params = {application.getId(),application.getName(),application.getDepartment(),application.getMajor(),application.getGrade(),application.getClassno(),application.getApplication_file(),application.getApplication_picture()};
		
		qr.update(sql, params);
	
	}
	
	
	//根据ID查询申请表信息和文件，还有审核情况
	public Application findByStudentId(String studentId){
		
		try{
			String sql = "select id,name,department,major,grade,classno,application_file,application_picture from t_application where id=?";
			return qr.query(sql, new BeanHandler<Application>(Application.class),studentId);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	//根据班级进行审核
	public List<Application> findByClass(String classno) throws SQLException {
		
			String sql = "select id,name,department,major,grade,classno,application_file,application_picture from t_application where classno=?";
			return  qr.query(sql, new BeanListHandler<Application>(Application.class),classno);
			
		}
	
	//根据学号设置班级审核通过
	public void setClassVerifyResult(String id) throws SQLException{
		
		String sql = "update t_student set classverify='审核通过',lastverify='正在审核' where sid=?";
		qr.update(sql, id);
	}
	//根据学号设置班级审核失败
		public void setClassVerifyResultFail(String id) throws SQLException{
			
			String sql = "update t_student set lastverify='审核失败' where sid=?";
			qr.update(sql, id);
		}
	//根据学号设置院系审核通过
	public void setDepartmentVerifyResult(String id) throws SQLException{
		
		String sql = "update t_student set dpverify='审核通过',lastverify='正在审核' where sid=?";
		qr.update(sql, id);
	}
	//根据学号设置院系审核失败
	public void setDepartmentVerifyResultFail(String id) throws SQLException{
		
		String sql = "update t_student set lastverify='审核失败' where sid=?";
		qr.update(sql, id);
	}
	//根据学号设置最终审核通过
	public void setLastVerifyResult(String id) throws SQLException{
		
		String sql = "update t_student set lastverify='审核通过' where sid=?";
		qr.update(sql, id);
		String sql1 = "update t_application set situation='审核通过' where id=?";	
		qr.update(sql1, id);
	}
	//根据学号设置最终审核失败
		public void setLastVerifyResultFail(String id) throws SQLException{
			
			String sql = "update t_student set lastverify='审核失败' where sid=?";
			qr.update(sql, id);
		}
		
		//查询班级审核结果
		public String queryClassResult(String id) throws SQLException{
			
			String sql = "select classverify from t_student where sid=?";
			Map<String,Object> map =  qr.query(sql, new MapHandler(),id);
		
			return (String)map.get("classverify");
		}
		//查询院系审核结果
		public String queryDepartmentResult(String id) throws SQLException{
					
		String sql = "select dpverify from t_student where sid=?";
		Map<String,Object> map =  qr.query(sql, new MapHandler(),id);
				
		return (String)map.get("dpverify");
				}
		//查询最终审核结果
				public String queryLastResult(String id) throws SQLException{
					
					String sql = "select lastverify from t_student where sid=?";
					Map<String,Object> map =  qr.query(sql, new MapHandler(),id);
				
					return (String)map.get("lastverify");
				}
	//根据班级审核通过筛选学生申请表等信息
	public 	List<Application> findByClassVerfiy() throws SQLException {
		String sql ="select  a.id,a.name,a.department,a.major,a.grade,a.classno,a.application_file,a.application_picture from t_application a,`t_student` s where  a.id = s.sid and s.classverify='审核通过'";
		return  qr.query(sql, new BeanListHandler<Application>(Application.class));
}
	//根据院系审核通过筛选学生申请表等信息
	public 	List<Application> findByDepartmentVerfiy(String department) throws SQLException {
		String sql = "select  a.id,a.name,a.department,a.major,a.grade,a.classno,a.application_file,a.application_picture from t_application a,`t_student` s where  a.id = s.sid and s.dpverify='审核通过'";
		return  qr.query(sql, new BeanListHandler<Application>(Application.class));
}
	//根据院系审核通过筛选学生申请表等信息(学工办)
		public 	List<Application> findByDepartmentVerfiy() throws SQLException {
			String sql = "select  a.id,a.name,a.department,a.major,a.grade,a.classno,a.application_file,a.application_picture from t_application a,`t_student` s where  a.id = s.sid and s.dpverify='审核通过'";
			return  qr.query(sql, new BeanListHandler<Application>(Application.class));
	}
	//根据最终审核通过筛选学生申请表等信息
	public 	List<Application> findByLastVerfiy() throws SQLException {
		String sql = "select  a.id,a.name,a.department,a.major,a.grade,a.classno,a.application_file,a.application_picture from t_application a,`t_student` s where  a.id = s.sid and s.lastverify='审核通过'";
		return  qr.query(sql, new BeanListHandler<Application>(Application.class));
}
	
	public 	Application query(String sid) throws SQLException {
		String sql = "select * from funding_info where id=?";
		return  qr.query(sql, new BeanHandler<Application>(Application.class),sid);
	}
	
	//添加最终审核通过学生信息和申请表进入数据库
	public 	void addToDatabase() throws SQLException {
		List<Application> list = findByLastVerfiy();
		Iterator<Application> iterator = list.iterator();
		String sql = "insert into funding_info(id,name,department,major,grade,classno,application_file,application_picture) values(?,?,?,?,?,?,?,?) ";
		while(iterator.hasNext()){
		Application data =  iterator.next();
			qr.update(sql, data.getId(),data.getName(),data.getDepartment(),data.getMajor(),data.getGrade(),
					data.getClassno(),data.getApplication_file(),data.getApplication_picture());	
		}
}


	public byte[] findFileById(String id){
		try {
			String sql = "select application_file from t_application where id=?";
			Map<String,Object> map = qr.query(sql, new MapHandler(),id);

			byte[] file = (byte[])map.get("application_file");
			return file;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	
	public byte[] findPictureById(String id){
		try {
			String sql = "select application_picture from t_application where id=?";
			Map<String,Object> map = qr.query(sql, new MapHandler(),id);
			byte[] picture = (byte[])map.get("application_picture");
			return picture;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}