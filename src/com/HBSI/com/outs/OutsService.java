package com.HBSI.com.outs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @支出表M层接口
 * @author mxj
 * @time 2020--12-12
 */
public interface OutsService {
	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;
	void save(String out_money, int out_type,String out_date,String user_id,String out_rem ) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void delete(String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void edit(String out_id, String out_money, int out_type,String out_date,String user_id,String out_rem) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void editOutMoney(String out_money,String user_id ) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void editOutType(int out_type,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void editOutRem(String out_rem,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	List<Map<String, Object>> querycurrentmonth(String currentmonth, String user_id) throws ClassNotFoundException, SQLException;
	List<Map<String, Object>> queryAllbyuserid(String user_id) throws ClassNotFoundException, SQLException;
	List<Map<String, Object>> querycurrentdescmonth(String currentMonth, String user_id) throws ClassNotFoundException, SQLException;
	List<Map<String, Object>> querycurrentday(String currentMonth, String user_id)
			throws ClassNotFoundException, SQLException;
	List<Map<String, Object>> querykindByuid(String user_id) throws ClassNotFoundException, SQLException;
	
	Map<String, Object> queryByOut_name(String out_name) throws ClassNotFoundException, SQLException;
	/**
	 * 根据支出id查询
	 * @param out_id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	Map<String, Object> querybyout_id(String out_id) throws ClassNotFoundException, SQLException;
	/**
	 * 根据id删除
	 * @param string
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	void deletebyout_id(String string) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
}
