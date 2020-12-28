package com.HBSI.com.outall;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @支出详细表M层接口
 * @author mxj
 * @time 2020--12-12
 */
public interface OutAllService {
	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;	
	void save(String out_day_money,String out_month_money,String out_year_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void delete(String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void edit(String outall_id,String out_day_money,String out_month_money,String out_year_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void editDay(String out_day_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void editMonth(String out_month_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void editYear(String out_year_money,String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
}
