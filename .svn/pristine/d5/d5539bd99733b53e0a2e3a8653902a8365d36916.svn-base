package com.HBSI.com.outkind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 支出种类表M层接口
 * @author mxj
 * @time 2020-12-22
 */
public interface OutKindService {
	List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException;
	void save(int out_type,String out_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void delete(int out_type) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void edit(int out_type,String out_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	void deleteManey(String out_type) throws ClassNotFoundException, SQLException;
}
