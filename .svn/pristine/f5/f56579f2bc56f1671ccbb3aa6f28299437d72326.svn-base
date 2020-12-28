package com.HBSI.com.getkind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @desc 收入种类表M层接口
 * @author 秦天成
 * @time 2020-12-22
 */
public interface GetKindService {
	/**
	 * @desc 查询全部
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;
	/**
	 * @desc 修改
	 * @param get_type
	 * @param get_name
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void update(int get_type,String get_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	/**
	 * @desc 删除
	 * @param get_type
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void deleByGet_type(String get_type) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
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
	public void save(int get_type,String get_name) throws NumberFormatException, ClassNotFoundException, SQLException, FileNotFoundException, IOException;
}
