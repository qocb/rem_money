package com.HBSI.com.outs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HBSI.com.budget.BudgetService;
import com.HBSI.com.budget.BudgetServiceimpl;

/**   
 * @Description: 支出表c层
 * @author TianShuo
 * @date 2020年12月23日 下午5:02:36  
 */
@SuppressWarnings("serial")
public class OutsServlet extends HttpServlet{
	//初始化
	OutsServiceimpl outsService = new OutsServiceimpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OutsServlet--->service()");
		request.setCharacterEncoding("UTF-8");  
		
		String method=request.getParameter("method");
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
	System.out.println("OutsServlet--->add()");
	//种类
	Map<String, Object> outkindMap = outsService.queryByOut_name(request.getParameter("type"));
	int  out_type = -1 ;
	System.out.println(outkindMap);
	//如果不存在
	if (outkindMap != null) 
	{
		out_type = 	(int) outkindMap.get("out_type");
		System.out.println(out_type);
	}
	else 
	{
		System.out.println();
		return;
	}
	//获取session对象
	HttpSession sesssion = request.getSession();
	//获取user Map
	Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
	//获取用户id
	String user_id = (String) user.get("user_id");
	
	//支出金额
	String out_money =  request.getParameter("money") ;
		
	//备注
	String out_rem = request.getParameter("mark");
	
	//时间
	String out_date = request.getParameter("time");	
	
	String budget_id = request.getParameter("budget_id");
	
	if (!budget_id.equals("")) {
		BudgetService budgetService = new BudgetServiceimpl();
		Map<String, Object> budget = budgetService.queryById(budget_id);
		int budget_remain = Integer.parseInt((String) budget.get("budget_remain"));
		int budget_out = Integer.parseInt((String) budget.get("budget_out"));
		int money = Integer.parseInt(out_money);
		
		budgetService.updateByIdAnByUserId(budget_id, user_id,budget_remain-money, budget_out+money);
	}
	
	outsService.save(out_money, out_type, out_date, user_id, out_rem);
	response.sendRedirect(request.getContextPath()+"/index.do?method=queryouts");
}
	
}
