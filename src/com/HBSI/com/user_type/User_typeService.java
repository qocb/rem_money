package com.HBSI.com.user_type;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 用户种类表M层接口
 * @author 
 *
 */
public interface User_typeService {
	
	//查询
	List<Map<String , Object>> query() throws ClassNotFoundException, SQLException;
	//用户种类增加
	void add_userType(Integer user_type,String type_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
}
