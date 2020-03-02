package tj.ustb.studentFunding.admain.AdmainDao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import tj.ustb.studentFunding.admain.domain.Admain;
import cn.itcast.jdbc.TxQueryRunner;

public class AdmainDao {
private QueryRunner qr = new TxQueryRunner();
	
	/*
	 * 账户，密码查询
	 * */
	public Admain findByAdmainPassword(Admain admain){
		try{
			String sql = "select * from t_institute where iid=?";
			return qr.query(sql, new BeanHandler<Admain>(Admain.class),admain.getIid());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
