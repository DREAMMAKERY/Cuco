package tj.ustb.studentFunding.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import tj.ustb.studentFunding.user.domain.Headmaster;
import tj.ustb.studentFunding.user.domain.Student;

import cn.itcast.jdbc.TxQueryRunner;

public class HeadmasterDao {

	private QueryRunner qr = new TxQueryRunner();
	
	/*
	 * 账户，密码查询
	 * */
	public Headmaster findByHeadmasterPassword(Headmaster headmaster){
		try{
			String sql = "select * from t_headmaster where hid=? and hpassword=?";
			return qr.query(sql, new BeanHandler<Headmaster>(Headmaster.class),headmaster.getHid(),headmaster.getHpassword());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Headmaster> findAll(){
		try{
			String sql = "select * from t_headmaster";
			return qr.query(sql, new BeanListHandler<Headmaster>(Headmaster.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	//根据账号id删除对应数据库信息
		public void delete(String id){
			try{
				String sql = "delete from t_headmaster where hid=?";
				qr.update(sql,id);
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
		
	
	
}
