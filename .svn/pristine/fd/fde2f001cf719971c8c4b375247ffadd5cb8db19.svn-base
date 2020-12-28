package com.HBSI.com.gets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @desc 收入表M层接口
 * @author 秦天成
 * @time 2020-12-22
 */
public interface GetsService {
	/**
	 * @desc 查询全部
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;
	
	
	/**
	 * @desc 根据用户id进行修改
	 * @param get_type
	 * @param get_name
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void updateUser_id(String get_id,String get_money,int get_type,String get_date,String user_id,String get_rem) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id对收入金钱进行修改
	 */
	public void updateUser_idAndGet_money(String get_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户id对收入种类进行修改
	 */
	public void updateUser_idAndGet_type(int get_type,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据用户收入对备注进行修改
	 */
	public void updateUser_idAndGet_rem(String get_rem,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	
	/**
	 * @desc 添加
	 * @param get_type
	 * @param get_name
	 * @throws NumberFormatException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	
	
	/**
	 * @desc 根据用户id进行删除
	 * @param getall_id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void deleByUser_id(String user_id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;


	List<Map<String, Object>> queryAllbyuserid(String user_id) throws ClassNotFoundException, SQLException;


	List<Map<String, Object>> querycurrentmonth(String currentmonth, String user_id) throws ClassNotFoundException, SQLException;


	List<Map<String, Object>> querycurrentday(String currentMonth, String user_id) throws ClassNotFoundException, SQLException;


	Map<String, Object> queryByGet_name(String get_name) throws ClassNotFoundException, SQLException;


	void save(String get_money, int get_type, String get_date, String user_id, String get_rem)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
}
