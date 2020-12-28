package com.HBSI.com.outall;

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
 * @支出详细表M层实现类
 * @author mxj
 * @time 2020--12--22
 */
public class OutAllServiceimpl implements OutAllService{
	Dao dao = new DaoImpl();
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		OutAllServiceimpl outAllServiceimpl = new OutAllServiceimpl();
		System.out.println("查询全部："+outAllServiceimpl.queryAll());
		//outAllServiceimpl.save("oc", "500", "15000", "200000", "u2");
		//outAllServiceimpl.update("u3");
		//outAllServiceimpl.edit("ob", "5000", "20000", "300000", "u2");
		//System.out.println("修改成功");
//		outAllServiceimpl.save("55555", "656565", "1000909", "u2");
//		System.out.println("修改成功");
		
	}
	/**
	 * @desc  1.查询全部
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException {
		return dao.executeQueryForList("  select * from outall  ");
	}
	/**
	 * @desc 2.添加
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 

	 */
	@Override
	public void save(String out_day_money, String out_month_money, String out_year_money,
			String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		//dao.executeUpdate("insert into outall values(?,?,?,?,?)", new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR},new Object[]{outall_id,out_day_money,out_month_money,out_year_money,user_id});
		String  sql = "insert into outall values(?,?,?,?,?)";
		int []types = new int[5];
		types[0]=Types.VARCHAR;
		types[1]=Types.VARCHAR;
		types[2]=Types.VARCHAR;
		types[3]=Types.VARCHAR;
		types[4]=Types.VARCHAR;
		
		
		Object[]values=new Object[5];
		values[0]=UUID.randomUUID().toString();
		values[1]=out_day_money;
		values[2]=out_month_money;
		values[3]=out_year_money;
		values[4]=user_id;
		
		dao.executeUpdate(sql, types, values);
	
	}
	/**
	 * @desc 3.删除
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * 
	 * 
	 */
	@Override
	public void delete(String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("delete from outall where user_id=?", new int[]{Types.VARCHAR},new Object[]{user_id});
		
	}
	
	/**
	 * @desc 4.修改支出模块
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public void edit(String outall_id, String out_day_money, String out_month_money, String out_year_money,
			String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update outall set outall_id=?,out_day_money=?,out_month_money=?,out_year_money=? where user_id=?", new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR}, new Object[]{outall_id,out_day_money,out_month_money,out_year_money,user_id});
	}
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 5.根据用户id 修改今日支出
	 * 
	 */
	@Override
	public void editDay(String out_day_money, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update outall set out_day_money=? where user_id=? ", 
				new int[]{Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{out_day_money,user_id});
		
	}
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 6.根据用户id 修改本月支出
	 * 
	 */
	@Override
	public void editMonth(String out_month_money, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update outall set out_month_money=? where user_id=?",
				new int[]{Types.VARCHAR,Types.VARCHAR},
				new Object[]{out_month_money,user_id});
		
	}
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 7.根据用户id 修改本年支出
	 * 
	 */
	@Override
	public void editYear(String out_year_money, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update outall set out_year_money=? where user_id=?", 
				new int[]{Types.VARCHAR,Types.VARCHAR}, 
				new Object[]{out_year_money,user_id});
		
	}
	
	
	
	
	
	
}
