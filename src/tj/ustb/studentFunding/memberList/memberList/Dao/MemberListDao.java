package tj.ustb.studentFunding.memberList.memberList.Dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import tj.ustb.studentFunding.application.domain.Application;
import tj.ustb.studentFunding.memberList.memberList.domain.MemberList;
import cn.itcast.jdbc.TxQueryRunner;

public class MemberListDao {
private QueryRunner qr = new TxQueryRunner();
	
	
	//添加申请表信息，包括申请表文件
	public void add(MemberList memberList) throws FileNotFoundException, IOException, SerialException, SQLException{
		
		String sql = "insert into member(department,major,classno,file) values(?,?,?,?)";
		Object[] params = {memberList.getDepartment(),memberList.getMajor(),memberList.getClassno(),memberList.getFile()};		
		qr.update(sql, params);
	}
	
	public List<MemberList> findAll()throws FileNotFoundException, IOException, SerialException, SQLException{
		
		String sql = "select * from member";
		return qr.query(sql, new BeanListHandler<MemberList>(MemberList.class));		
	}
	
	public byte[] findFileById(String department,String major,String classno){
		try {
			String sql = "select file from member where department=? and major=? and classno=?";
			Map<String,Object> map = qr.query(sql, new MapHandler(),department,major,classno);
			byte[] file = (byte[])map.get("file");
			return file;
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
