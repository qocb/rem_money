package com.HBSI.com.gets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;

/**
 * @desc 收入表M层实现类
 * @author 秦天成
 * @time 2020-12-22
 */
public class GetsServiceimpl implements GetsService{
	Dao dao =new DaoImpl();
	/**
	 * @desc 查询全部
	 */
	@Override
	public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException {
		return dao.executeQueryForList("select * from gets");
	}
	/**
	 * @desc 向gets表内添加
	 */
	/**
	 * @desc 向gets表内添加
	 */
	@Override
	public void save( String get_money, int get_type, String get_date, String user_id, String get_rem) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		/*dao.executeUpdate(
				"insert into gets values(?,?,?,?,?,?)", 
				new int []{Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{get_id,get_money,get_type,get_date,user_id,get_rem});*/
		String  sql = "insert into gets values(?,?,?,?,?,?)";
		int []types = new int[6];
		types[0]=Types.VARCHAR;
		types[1]=Types.VARCHAR;
		types[2]=Types.INTEGER;	
		types[3]=Types.VARCHAR;
		types[4]=Types.VARCHAR;
		types[5]=Types.VARCHAR;
		
		
		Object[]values=new Object[6];
		values[0]=UUID.randomUUID().toString();
		values[1]=get_money;
		values[2]=get_type;
		values[3]=get_date;
		values[4]=user_id;
		values[5]=get_rem;
		
		dao.executeUpdate(sql, types, values);

	}
	
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id进行修改
	 */
	@Override
	public void updateUser_id(String get_id, String get_money, int get_type, String get_date, String user_id, String get_rem)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
			dao.executeUpdate("update gets set get_id=?,get_money=?,get_type=?,get_date=? ,get_rem=? where user_id=?", 
					new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR},
					new Object[]{get_id,get_money,get_type,get_date,get_rem,user_id});
		}
	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @desc 根据用户id进行删除
	 */
	@Override
	public void deleByUser_id(String user_id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		//dao.executeUpdate("delete from gets where user_id='"+user_id+"'");
		dao.executeUpdate("delete from gets where user_id='"+user_id+"'",
				new int[]{Types.INTEGER}, 
				new Object[]{user_id});
	}
	
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id对收入金钱进行修改
	 */
	@Override
	public void updateUser_idAndGet_money(String get_money, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update gets set get_money=? where user_id=?",
				new int[]{Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{get_money,user_id});
		
	}
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id对收入种类进行修改
	 */
	@Override
	public void updateUser_idAndGet_type(int get_type, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update gets set get_type=? where user_id=?",
				new int[]{Types.VARCHAR,Types.INTEGER}, 
				new Object[]{get_type,user_id});
	}
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户收入对备注进行修改
	 */
	@Override
	public void updateUser_idAndGet_rem(String get_rem, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update gets set get_rem=? where user_id=?",
				new int[]{Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{get_rem,user_id});
	}
	@Override
	public List<Map<String, Object>> queryAllbyuserid(String user_id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT gets.user_id,gets.get_money,gets.get_date,getkind.get_name FROM gets  LEFT  JOIN getkind ON gets.get_type=getkind.get_type WHERE user_id= ?";
		return dao.executeQueryForList(sql, new int[]{Types.VARCHAR}, new Object[]{user_id});
	}
	/**
	 * 根据月份查找
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public List<Map<String, Object>> querycurrentmonth(String currentmonth, String user_id) throws ClassNotFoundException, SQLException {
		
		if(currentmonth==null){
			currentmonth ="";
		}
		
		int []types = {Types.VARCHAR,Types.VARCHAR};
		
		Object[] values = {"%"+currentmonth.trim()+"%",user_id};
		String sql = "SELECT * FROM gets  WHERE get_date LIKE ?  AND user_id = ?";
		return dao.executeQueryForList(sql,types,values);
	}
	@Override
	public List<Map<String, Object>> querycurrentday(String currentMonth, String user_id) throws ClassNotFoundException, SQLException {
		if(currentMonth==null){
			currentMonth ="";
		}
		
		int []types = {Types.VARCHAR,Types.VARCHAR};
		
		Object[] values = {user_id,"%"+currentMonth.trim()+"%"};
		String sql = "SELECT gets.get_date FROM gets WHERE user_id = ? AND get_date LIKE ? ORDER BY  get_date";
		return dao.executeQueryForList(sql,types,values);
	}
	

	@Override
	public Map<String, Object> queryByGet_name(String get_name) throws ClassNotFoundException, SQLException {
		return dao.executeQueryForMap("select * from getkind  where get_name =  '"+get_name+"'");
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GetsServiceimpl l = new GetsServiceimpl();
		System.out.println(l.querycurrentmonth("2020-12", "u1"));;
	}
}
