package com.HBSI.com.getall;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @desc 收入详细表M层接口
 * @author 秦天成
 * @time 2020-12-22
 */
public interface GetAllService {
	/**
	 * @desc 查询全部
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;
	
	/**
	 * @desc 根据用户id来修改全部
	 * @param get_type
	 * @param get_name
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void updateUser_id(String getall_id, String get_day_money,String get_month_money,String get_year_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	/**
	 * @desc 根据用户id来修改今日收入
	 */
	public void updateUser_idAndGet_day_money(String get_day_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;

	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id来修改本月收入
	 */
	public void updateUser_idAneGet_month_money(String get_month_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id来修改本年收入
	 */
	public void updateUser_idAndGet_year_money(String get_year_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	/**
	 * @desc 根据用户id进行删除
	 * @param get_type
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleByUser_id(String user_id) throws ClassNotFoundException, SQLException;
	
	/**
	 * @desc 向表内添加
	 * @param get_type
	 * @param get_name
	 * @throws NumberFormatException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void save(String getall_id, String get_day_money,String get_month_money,String get_year_money,String user_id)
			throws NumberFormatException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;
}
