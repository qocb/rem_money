package com.HBSI.com.gets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**   
 * @Description: 收入表c层
 * @author TianShuo
 * @date 2020年12月23日 下午5:02:36  
 */
@SuppressWarnings("serial")
public class GetsServlet extends HttpServlet{
	//初始化
	GetsService getService = new GetsServiceimpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetsServlet--->service()");
		request.setCharacterEncoding("UTF-8");  
		
		String method = request.getParameter("method");
		try 
		{
			if ("add".equals(method)) 
			{
				this.add(request,response);
		}
		
		}catch (IOException e) {
			System.out.println("Io异常");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @desc 增加数据
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
	System.out.println("GetsServlet--->add()");
	
	//获取session对象
	HttpSession sesssion = request.getSession();
	//获取user Map
	Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
	//获取用户id
	String user_id = (String) user.get("user_id");
		
	//类型
	int get_type = -1 ;
		//种类
		Map<String, Object> outkindMap = getService.queryByGet_name(request.getParameter("type"));
		
		//如果不存在
		if (outkindMap != null) 
		{
			get_type = 	(int) outkindMap.get("get_type");
		}
		else 
		{
			return;
		}
	//支出金额
	String get_money =  request.getParameter("money") ;
		
	//备注
	String get_rem = request.getParameter("mark");
	
	//时间
	String get_date = request.getParameter("time");	
	
	getService.save(get_money, get_type, get_date, user_id, get_rem);
	
	response.sendRedirect(request.getContextPath()+"/index.do?method=query");
}
	
}
