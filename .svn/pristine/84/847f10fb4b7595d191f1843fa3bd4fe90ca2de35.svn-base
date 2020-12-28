package com.HBSI.com.outkind;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;

/**
 * @desc支出种类表M层实现类
 * @author mxj
 * @time 
 */
public class OutKindServiceimpl implements OutKindService{
	Dao dao = new DaoImpl();
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		OutKindServiceimpl outKindServiceimpl = new OutKindServiceimpl();
		System.out.println(outKindServiceimpl.queryAll());
		outKindServiceimpl.save(7, "其他");
		//outKindServiceimpl.update(6);
		outKindServiceimpl.edit(5, "女人");
	}
	/**
	 * @desc 1.查询全部
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException {
		return dao.executeQueryForList("  select * from outkind  ");
	}
	
	/**
	 * @desc 2.添加
	 * @param out_type
	 * @param out_name
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Override
	public void save(int out_type, String out_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("insert into outkind values(?,?)",new int[]{Types.INTEGER,Types.VARCHAR},new Object[]{out_type,out_name});
	}
	
	/**
	 * @desc 3.删除
	 * @param out_type
	 * @param out_name
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Override
	public void delete(int out_type) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("delete from outkind where out_type=?",new int[]{Types.INTEGER},new Object[]{out_type});
		
	}


	/**
	 * @desc 4.修改
	 * @param out_type
	 * @param out_name
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public void edit(int out_type, String out_name) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		dao.executeUpdate("update outkind set out_name=? where out_type=?", new int[]{Types.VARCHAR,Types.INTEGER},new Object[]{out_name,out_type});
	}
	/**
	 * @desc 5.级联删除
	 * @throws SQLException 
	 * @throws ClassNotFoundException 

	 */
	@Override
	public void deleteManey(String out_type) throws ClassNotFoundException, SQLException {
		String sql1 = "delete from gets where out_type='"+out_type+"'";
		String sql2="delete from getkind where out_type='"+out_type+"'";
		dao.executeUpdate(sql1);
		dao.executeUpdate(sql2);
	}
	
}
