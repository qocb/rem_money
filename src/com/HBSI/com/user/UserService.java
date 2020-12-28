package com.HBSI.com.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 用户表M层接口
 * @author 
 *
 */
public interface UserService {
	//查找
	List<Map<String, Object>> query() throws ClassNotFoundException, SQLException;
	//添加
	void add_user(String user_id,String user_name,String user_password,String user_email,String user_state,String user_code,Integer user_Type,String user_img) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	//根据用户id修改用户user_state状态
	void mate_code(String user_id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	//根据用户id修改用户头像
	void updata_userid_img(String user_id,String user_img) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	//根据用户的UUID查找用户
	Map<String , Object> getuserByCode(String user_code) throws ClassNotFoundException, SQLException;
	//根据用户名查找用户
	Map<String , Object> getuserByUName(String user_uname) throws ClassNotFoundException, SQLException;
	Map<String, Object> querybyUsernameAndPassword(String user_uname, String user_password) throws ClassNotFoundException, SQLException;
	List<Map<String, Object>> queryExaminee(String budget_user_id) throws ClassNotFoundException, SQLException;
	
	List<Map<String, Object>> queryusergets(String budget_user_id) throws ClassNotFoundException, SQLException;
	
	Map<String, Object> query_userimg(String user_id) throws ClassNotFoundException, SQLException;
	/**
	 * 更改密码
	 * @param new_pass
	 * @param user_id
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	void editPassword(String new_pass, String user_id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	/**
	 * 根据用户id查询到旧密码
	 * @param user_id
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	Map<String, Object> queryOldPassword(String user_id) throws ClassNotFoundException, SQLException;
}
