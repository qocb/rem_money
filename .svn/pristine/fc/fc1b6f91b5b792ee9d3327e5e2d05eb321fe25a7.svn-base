package com.HBSI.com.user_type;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;

/**
 * 用户种类表M层实现类
 * @author 
 *
 */
public class User_typeServiceimpl implements User_typeService{
	Dao dao = new DaoImpl();
	//用户种类增加
	@Override
	public void add_userType(Integer user_type,String type_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql="insert into user_type values(?,?)";
		
		dao.executeUpdate(sql, 
				new int[]{Types.INTEGER,Types.VARCHAR}, 
				new Object[]{user_type,type_name});
	}
	
	//查询
	@Override
	public List<Map<String, Object>> query() throws ClassNotFoundException, SQLException {
		String sql = "select * from user_type";
		List<Map<String, Object>> list = dao.executeQueryForList(sql);
		return list;
	}

	//测试
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		User_typeServiceimpl user_typeServiceimpl = new User_typeServiceimpl();
		//user_typeServiceimpl.add_userType(4,"乞丐用户");
		//user_typeServiceimpl.delete_userType(4);
		List<Map<String, Object>> list2= user_typeServiceimpl.query();
		for (Map<String, Object> map : list2) {
			System.out.println(map);
		}
	}

	
}
