package tj.ustb.studentFunding.user.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import tj.ustb.studentFunding.user.domain.Student;

import cn.itcast.jdbc.TxQueryRunner;

/*User持久层
 * */
public class StudentDao {
	
	private QueryRunner qr = new TxQueryRunner();
	/*
	 * 按学号查询
	 * */
	public Student findByStudentId(String studentId){
		try{
			String sql = "select * from t_student where sid=?";
			return qr.query(sql, new BeanHandler<Student>(Student.class),studentId);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 账户，密码查询
	 * */
	public Student findByStudentPassword(Student student){
		try{
			String sql = "select * from t_student where sid=? and spassword=?";
			return qr.query(sql, new BeanHandler<Student>(Student.class),student.getSid(),student.getSpassword());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//通过班级查找学生
/*	public List<Student> findByStudentClassno(String classno) {
		try {
			String sql = "select * from t_application";
			return qr.query(sql, new BeanListHandler<Student>(Student.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	*/
	/*
	 * 插入Student
	 * */
	public void add(Student student){
		try{
			String sql = "insert into t_student(sid,sname,department,major,grade,classno,spassword) values(?,?,?,?,?,?,?)";
			Object[] params = {student.getSid(),student.getSname(),student.getDepartment(),student.getMajor(),student.getGrade(),student.getClassno(),student.getSpassword()};
			qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public String queryApplication(String studentId){
		String result=null;
		try{
			String sql = "select dpverify from t_student where sid=?";
			List<Object> objects = qr.query(sql, new ColumnListHandler("dpverify"),studentId);
			Iterator iterator = objects.iterator();
			while(iterator.hasNext()){
			result = (String)iterator.next();
			}
			return result;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
	
	public List<Student> findAll(){
		try{
			String sql = "select * from t_student";
			return qr.query(sql, new BeanListHandler<Student>(Student.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//根据学号删除对应数据库信息
	public void delete(String id){
		try{
			String sql = "delete from t_student where sid=?";
			qr.update(sql,id);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
}