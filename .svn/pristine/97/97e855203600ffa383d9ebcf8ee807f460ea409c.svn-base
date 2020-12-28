package com.HBSI.com.getall;
/**
 * 收入详细表M层实现类
 * @author 
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;

public class GetAllServiceimpl implements GetAllService{
	
	Dao dao=new DaoImpl();
	/**
	 * @desc 查询全部
	 */
	public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException{
		return dao.executeQueryForList("select * from getall");
		
	}
	
	/**
	 * @desc 根据用户id进行来修改全部
	 */
	@Override
	public void updateUser_id(String getall_id, String get_day_money,String get_month_money,String get_year_money,String user_id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update getall set getall_id=?,get_day_money=?,get_month_money=?,get_year_money=? where user_id=?", 
				new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,},
				new Object[]{getall_id,get_day_money,get_month_money,get_year_money,user_id});


	}
	/**
	 * @desc 根据用户id进行删除
	 */
	@Override
	public void deleByUser_id(String user_id) throws ClassNotFoundException, SQLException {
		dao.executeUpdate("delete from getall where user_id='"+user_id+"'");
	}
	/**
	 * @desc 向表内添加
	 */
	@Override
	public void save(String getall_id, String get_day_money, String get_month_money, String get_year_money,
			String user_id)throws NumberFormatException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		/*dao.executeUpdate("insert into getall values(?,?,?,?,?)", 
				new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,},
				new Object[]{getall_id,get_day_money,get_month_money,get_year_money,user_id});*/
		String  sql = "insert into getall values(?,?,?,?,?)";
		int []types = new int[5];
		types[0]=Types.VARCHAR;
		types[1]=Types.VARCHAR;
		types[2]=Types.VARCHAR;
		types[3]=Types.VARCHAR;
		types[4]=Types.VARCHAR;
		
		
		Object[]values=new Object[5];
		values[0]=UUID.randomUUID().toString();
		values[1]=get_day_money;
		values[2]=get_month_money;
		values[3]=get_year_money;
		values[4]=user_id;
		
		dao.executeUpdate(sql, types, values);
		
	}
	/**
	 * @desc 根据用户id对今日收入进行修改
	 */
	@Override
	public void updateUser_idAndGet_day_money(String get_day_money, String user_id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update getall set get_day_money=? where user_id=?",
				new int[]{Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{get_day_money,user_id});
	}

	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id来修改本月收入
	 */
	@Override
	public void updateUser_idAneGet_month_money(String get_month_money, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update getall set get_month_money=? where user_id=?",
				new int[]{Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{get_month_money,user_id});
	}
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id来修改本年收入
	 */
	@Override
	public void updateUser_idAndGet_year_money(String get_year_money, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update getall set get_month_money=? where user_id=?",
				new int[]{Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{get_year_money,user_id});
	}
}
