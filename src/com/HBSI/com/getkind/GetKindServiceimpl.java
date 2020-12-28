package com.HBSI.com.getkind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;

/**
 * @desc 收入详细表M层实现类
 * @author 秦天成
 * @time 2020-12-22
 */
public class GetKindServiceimpl implements GetKindService{
	Dao dao=new DaoImpl();
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @desc 查询
	 */
	@Override
	public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException {
		
		return dao.executeQueryForList("select * from getkind");
		
	}
	
	/**
	 * @desc 添加
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void save(int get_type,String get_name) throws NumberFormatException, ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		dao.executeUpdate(" insert into getkind values(?,?) ",
				new int[] { Types.INTEGER, Types.VARCHAR},
				new Object[] {get_type,get_name});
		}
	
	
	/**
	 * @desc 删除
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	
	public void deleByGet_type(String get_type) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		/*dao.executeUpdate("delete from gets where get_type='"+get_type+"'",
				new int[]{Types.INTEGER}, 
				new Object[]{get_type});*/
		String sql1 = "delete from gets where get_type='"+get_type+"'";
		String sql2="delete from getkind where get_type='"+get_type+"'";
		dao.executeUpdate(sql1);
		dao.executeUpdate(sql2);
	}
	
	/**
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @desc 根据收入种类id进行修改
	 */
	public void update(int get_type,String get_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException{
		dao.executeUpdate("update getkind set get_name=? where get_type=?",
				new int[]{Types.VARCHAR,Types.INTEGER},
				new Object[]{get_name,get_type});
	}
}
