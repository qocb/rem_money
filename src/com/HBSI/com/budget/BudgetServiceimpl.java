package com.HBSI.com.budget;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;

/**
 * 预算表M层实现类
 * @author TianShuo
 *
 */
public class BudgetServiceimpl implements BudgetService{
	//实例化
	Dao dao = new DaoImpl();

/**
 * @desc 【查询所有】
 */
@Override
public List<Map<String, Object>> queryAll() throws ClassNotFoundException, SQLException {
	
	return dao.executeQueryForList("  select * from budget ");
	
}


/**
 * @desc 【增加】
 * @throws IOException 
 * @throws FileNotFoundException 
 */
@Override
public void save( String budget_money, String budget_remain, String budget_out, String user_id,
		String budget_name) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

	String sql = "   insert into budget values(?,?,?,?,?,?)  ";
	//类型列表
	int[] types = new int[6];
	
	for (int i = 0; i < types.length; i++) {
		types[i] = Types.VARCHAR;
	}
	
	//值
	Object[] values = new Object[6];
	values[0] = UUID.randomUUID().toString();
	values[1] = budget_money;
	values[2] = budget_remain;
	values[3] = budget_out;
	values[4] = user_id;
	values[5] = budget_name;
	
	dao.executeUpdate(sql, types, values);
}


/**
 * @desc 根据【预算id】删除
 */
@Override
public void delById(String budget_id) throws ClassNotFoundException, SQLException {
	
	String sql = "delete from budget where budget_id='"+budget_id+"'";
	
	dao.executeUpdate(sql);
}


/**
 * @desc 根据【用户id】来删除
 */
@Override
public void delByUserId(String user_id) throws ClassNotFoundException, SQLException {
	
	String sql = "delete from budget where user_id='"+user_id+"'";
	
	dao.executeUpdate(sql);

}

/**
 * @desc 根据【预算ID】查询全部数据
 */
@Override
public Map<String, Object> queryById(String budget_id) throws ClassNotFoundException, SQLException {
	
	return dao.executeQueryForMap("  select * from budget where budget_id='"+budget_id+"'");
	
}

/**
 * @desc 根据【用户ID】查询全部数据
 */
@Override
public List<Map<String, Object>> queryByUserId(String user_id) throws ClassNotFoundException, SQLException {
	
	return  dao.executeQueryForList("  select * from budget where user_id='"+user_id+"'");

}

/**
 * @desc 根据【预算ID 和 用户ID 】 修改
 *   budget_money    
 */
@Override
public void updateByIdAnByUserId(String budget_id, String user_id, String budget_money, String budget_remain,
		String budget_out, String budget_name)
		throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
	//类型数组
	int[] types = new int[6];
	
	for (int i = 0; i < types.length; i++) {
		types[i] = Types.VARCHAR;
	}
	//值数组
	Object[] values = new Object[6];
	values[0] = budget_money ;
	values[1] = budget_remain ;
	values[2] = budget_out ;
	values[3] = budget_name ;
	values[4] = budget_id ;
	values[5] = user_id ;
	
    dao.executeUpdate("update budget set budget_money=?,budget_remain=?,budget_out=?,budget_name=? where budget_id=? and user_id=?",types,values);		
}


/**
 * @throws SQLException 
 * @throws ClassNotFoundException 
 * @throws IOException 
 * @throws FileNotFoundException 
 * @desc 删除此预算
 */
@Override
public void reomveBudget_id(String budget_id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
	dao.executeUpdate("DELETE FROM budget WHERE budget_id = ?", new int[]{Types.VARCHAR}, new Object[]{budget_id});
}


/**
 * @desc 查询
 */
@Override
public List<Map<String, Object>> queryAllByuser_id(String user_id) throws ClassNotFoundException, SQLException {
	return dao.executeQueryForList("select * from budget where user_id = ?", new int []{Types.VARCHAR}, new Object[]{user_id});
}


/**
 * 预算更新
 * @throws IOException 
 * @throws SQLException 
 * @throws FileNotFoundException 
 * @throws ClassNotFoundException 
 */
@Override
public void updateByIdAnByUserId(String budget_id, String user_id, int budget_remain, int budget_out) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
	
	int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};
	Object[] values = {budget_remain,budget_out,budget_id,user_id};
	String sql = "UPDATE budget SET budget_remain = ?,budget_out=? WHERE budget_id = ? AND user_id = ?";
	dao.executeUpdate(sql, types, values);
	
}

}
