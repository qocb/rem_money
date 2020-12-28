package com.HBSI.com.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;
import com.sun.glass.ui.CommonDialogs.Type;

/**
 * @desc 用户表M层实现类
 * @author T
 *
 */
public class UserServiceimpl implements UserService{
	
	Dao dao = new DaoImpl();
	
	/**
	 * 获取用户数量
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String Countnum() throws ClassNotFoundException, SQLException{
		String sql = "select count(user_id) from user";
		int num = dao.executeQueryForInt(sql);
		String num2 ="u"+(num+1);
		return num2;
		
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public void add_user(String user_id, String user_name, String user_password, String user_email, String user_state,
			String user_code, Integer user_Type, String user_img) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		dao.executeUpdate(sql, 
				new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.VARCHAR}, 
				new Object[]{user_id,user_name,user_password,user_email,user_state,user_code,user_Type,user_img});
	}
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Map<String, Object>> query() throws ClassNotFoundException, SQLException {
		String sql = "select * from user";
		List<Map<String, Object>> list = dao.executeQueryForList(sql);
		return list;
	}

	
	/**
	 * 根据用户id修改用户user_state状态
	 */
	public void mate_code(String user_id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "update user set  user_state='Y' where user_id=?";
		dao.executeUpdate(sql, new int[]{Types.VARCHAR}, new Object[]{user_id});
	}
	
	/**
	 * 根据用户id更改用户头像
	 */
	@Override
	public void updata_userid_img(String user_img, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "update user set user_img=? where user_id=?";
		dao.executeUpdate(sql, new int[]{Types.VARCHAR,Types.VARCHAR }, new Object[]{user_img,user_id});
		
	}
	
	/**
	 * 根据用户uuid 查找用户
	 * @return 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public Map<String, Object> getuserByCode(String user_code) throws ClassNotFoundException, SQLException {
		String sql = "select * from user where user_code = ?";
		return dao.executeQueryForMap(sql,new int[]{Types.VARCHAR},new Object[]{user_code});
	}
	/**
	 * @desc 根据用户名 查找用户
	 * @param user_uname
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Override
	public Map<String , Object> getuserByUName(String user_uname) throws ClassNotFoundException, SQLException{
		String sql = "select * from user where user_uname = ?";
		return dao.executeQueryForMap(sql,new int[]{Types.VARCHAR},new Object[]{user_uname});
	}

	
	
	
	//测试
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		UserServiceimpl userServiceimpl = new UserServiceimpl();
		System.out.println(userServiceimpl.query_userimg("u1"));
	}

	/**
	 * 根据用户名用户密码查找用户
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public Map<String, Object> querybyUsernameAndPassword(String user_uname, String user_password) throws ClassNotFoundException, SQLException {
		int [] types = {Types.VARCHAR,Types.VARCHAR};
		Object [] values = {user_uname,user_password};
		
		return dao.executeQueryForMap("select * from user where user_uname = ? and user_password = ?",types,values);
	}

	@Override
	public List<Map<String, Object>> queryExaminee(String budget_user_id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT outs.out_money,outs.out_rem,outkind.out_name,outs.out_date FROM outs LEFT JOIN outkind ON outkind.out_type = outs.out_type WHERE outs.user_id = ? ORDER BY outs.out_date DESC";
		return dao.executeQueryForList(sql, new int[]{Types.VARCHAR}, new Object[]{budget_user_id});
	}

	@Override
	public List<Map<String, Object>> queryusergets(String budget_user_id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT gets.get_money,gets.get_rem,getkind.get_name,gets.get_date FROM gets LEFT JOIN getkind ON getkind.get_type = gets.get_type WHERE gets.user_id = ? ORDER BY gets.get_date DESC";
		return dao.executeQueryForList(sql, new int[]{Types.VARCHAR}, new Object[]{budget_user_id});
	}
	/**
	 * 查询用户上传的图片
	 */
	@Override
	public Map<String, Object> query_userimg(String user_id) throws ClassNotFoundException, SQLException {
		String sql=("SELECT user_img FROM USER WHERE user_id=?");
		return dao.executeQueryForMap(sql, new int[]{Types.VARCHAR}, new Object[]{user_id});
	}

	@Override
	public void editPassword(String new_pass, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String sql = "UPDATE USER SET user_password=? WHERE user_id=?";
		dao.executeUpdate(sql,new int [] {Types.VARCHAR,Types.VARCHAR}, new Object[]{new_pass,user_id});
	}

	@Override
	public Map<String, Object> queryOldPassword(String user_id) throws ClassNotFoundException, SQLException {
		String sql = "select * from user where user_id = ?";
		return dao.executeQueryForMap(sql,new int[]{Types.VARCHAR},new Object[]{user_id});
	}

	

}
