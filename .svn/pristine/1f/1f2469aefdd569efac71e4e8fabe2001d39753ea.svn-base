package com.HBSI.com.budget;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HBSI.com.Dao.Dao;
import com.HBSI.com.Dao.DaoImpl;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class BudgetServlet extends HttpServlet{
	BudgetService budgetService=new BudgetServiceimpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BudgetServlet - >>>>>>service()");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		
		try {
			if("savebudget".equals(method)){
				this.savebudget(request,response);
			}else if("queryBudgetAll".equals(method)){
				this.queryBudgetAll(request,response);
			}else if("remove".equals(method)){
				this.remove(request,response);
			}else if("getallbudgetname".equals(method)){
				this.getallbudgetname(request,response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取所有预算名字
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	private void getallbudgetname(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
		//获取用户id
		String user_id = (String) user.get("user_id");
		
		List<Map<String, Object>> budgets = budgetService.queryAllByuser_id(user_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(budgets);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		
	}
	/**
	 * @desc　删除此预算
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void remove(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		System.out.println("删除方法执行了");
		
		String budget_id=request.getParameter("budget_id");
		
		budgetService.reomveBudget_id(budget_id);
		
		response.sendRedirect(request.getContextPath()+"/BudgetServlet.do?method=queryBudgetAll");
	}
	/**
	 * @desc 查询
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void queryBudgetAll(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
		//获取用户id
		String user_id = (String) user.get("user_id");
		
		
		List<Map<String, Object>> userbudget_list = budgetService.queryAllByuser_id(user_id);
		request.setAttribute("userbudget_list", userbudget_list);
		System.out.println(userbudget_list);
		request.getRequestDispatcher("/budget.jsp").forward(request, response);
	}
	

	/**
	 * 保存预算
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void savebudget(HttpServletRequest request, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException, ClassNotFoundException, SQLException {
		System.out.println("BudgetServlet---->savebudget");
		//获取值
		String budget_name=request.getParameter("budget_name");
		String budget_money = request.getParameter("budget_money");
		String budget_remain = budget_money;
		String budget_out = "0";
		System.out.println(budget_name);
		//进行非空验证
		if (budget_name == null || budget_money  == null  ) {
			System.out.println("非空验证生效");
			return ;
		}
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>) sesssion.getAttribute("user");
		System.out.println(user);
		String user_id = (String) user.get("user_id");
		System.out.println(user_id);
		//重定向
		budgetService.save(budget_money, budget_remain, budget_out, user_id, budget_name);
		response.sendRedirect(request.getContextPath()+"/BudgetServlet.do?method=queryBudgetAll");
	}
	

}
