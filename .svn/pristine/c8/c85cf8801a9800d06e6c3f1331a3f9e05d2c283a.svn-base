package com.HBSI.com.budget;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;

/**   
 * @Description: 预算表的增查改查的测试
 * @author TianShuo
 * @date 2020年12月22日 下午4:14:30  
 */
public class Test {
	static //初始化
	BudgetService budgetService = new BudgetServiceimpl();

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
//		for (int i = 0; i < 10; i++) {
//			zeng();
//
//		}
//		cha();
		//shanId();
		
		try {
			gai();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
/**
 * @desc  改
 */
public static void gai() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
	budgetService.updateByIdAnByUserId("a2e5-1efc2c94d113", "u1", "2", "30", "30", "2020年预算");
}
/**
 * @desc 查
 */
public static void cha(){

	try 
	{
		//1.查询所有
		List<Map<String, Object>> list = budgetService.queryAll();
		//2.打印结果
		System.out.println(list);
		
	}
	catch (ClassNotFoundException e) 
	{
		System.out.println("类没有找到");
	}
	catch (SQLException e) 
	{
		System.out.println("SQL异常");
	}
	
}
	
/**
 * @desc 增
 */
public static void zeng() {
	try 
	{
		budgetService.save( "100", "100", "100", "u1", "1月支出预算");
	}
	catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	}
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
	
	
	
}
	
/**
 * @desc 删
 * @throws ClassNotFoundException
 * @throws SQLException
 */
public static void shanId(  ) throws ClassNotFoundException, SQLException {
	
	budgetService.delById("9290-a37aaf1378b3");
	budgetService.delById("a419-556003492539");
	budgetService.delById("a8fb-421d737c1d46");
	budgetService.delById("a940-389846a7be06");
	budgetService.delByUserId("u2");
} 



}
