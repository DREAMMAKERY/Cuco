package tj.ustb.studentFunding.department.Dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import tj.ustb.studentFunding.department.domain.Department;
import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.domain.Student;
import cn.itcast.jdbc.TxQueryRunner;

public class DepartmentDao {
private QueryRunner qr = new TxQueryRunner();
	
	/*
	 * 账户，密码查询
	 * */
	public Department findByDepartmentPassword(Department department){
		try{
			String sql = "select * from t_department where did=?";
			return qr.query(sql, new BeanHandler<Department>(Department.class),department.getDid());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	public List<Department> findAll(){
		try{
			String sql = "select * from t_department";
			return qr.query(sql, new BeanListHandler<Department>(Department.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//根据账号删除对应数据库信息
		public void delete(String id){
			try{
				String sql = "delete from t_department where did=?";
				qr.update(sql,id);
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		
	
}
