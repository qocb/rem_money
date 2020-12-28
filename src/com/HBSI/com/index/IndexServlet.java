package com.HBSI.com.index;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HBSI.com.Utils.Dates;
import com.HBSI.com.getall.GetAllServiceimpl;
import com.HBSI.com.gets.GetsService;
import com.HBSI.com.gets.GetsServiceimpl;
import com.HBSI.com.outall.OutAllServiceimpl;
import com.HBSI.com.outs.OutsService;
import com.HBSI.com.outs.OutsServiceimpl;
import com.sun.java.swing.plaf.motif.resources.motif;

public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		
		try {
			if("query".equals(method)){
				this.query(request,response);
			}else if("queryouts".equals(method)){
				this.queryouts(request,response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * 查找支出方法
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void queryouts(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		GetsService getsService = new GetsServiceimpl();
		OutsService outsService = new OutsServiceimpl();
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
		//获取用户id
		String user_id = (String) user.get("user_id");
		List<Map<String, Object>> outs_list = outsService.queryAllbyuserid(user_id);
		
		
		//获取当前月分
		String currentmonth =  Dates.CurrentMonth();
		String currnetyear = Dates.CurrentYear();
		String currentday = Dates.CurrentTime();
		
		
		System.out.println(currentmonth);
		List<Map<String, Object>> outyearall = outsService.querycurrentmonth(currnetyear,user_id);
		List<Map<String, Object>> outmonthall = outsService.querycurrentmonth(currentmonth,user_id);
		List<Map<String, Object>> outdayall = outsService.querycurrentmonth(currentday,user_id);
		
		List<Map<String, Object>> getmonthall = getsService.querycurrentmonth(currentmonth,user_id);
		
		
		int yearoutnum = 0;
		int monthoutnum = 0;
		int dayoutnum = 0;
		
		int monthgetnum = 0;
		
		for (int i = 0; i < outyearall.size(); i++) {
			yearoutnum += Integer.parseInt((String)outyearall.get(i).get("out_money"));
		}
		for (int i = 0; i < outmonthall.size(); i++) {
			monthoutnum += Integer.parseInt((String)outmonthall.get(i).get("out_money"));
		}
		for (int i = 0; i < outdayall.size(); i++) {
			dayoutnum += Integer.parseInt((String)outdayall.get(i).get("out_money"));
		}
		
		for (int i = 0; i < getmonthall.size(); i++) {
			monthgetnum += Integer.parseInt((String)getmonthall.get(i).get("get_money"));
		}
		
		System.out.println(outs_list);
		request.setAttribute("yearoutnum", yearoutnum);
		request.setAttribute("monthoutnum", monthoutnum);
		request.setAttribute("dayoutnum", dayoutnum);
		
		request.setAttribute("outs_list", outs_list);
		request.setAttribute("monthgetnum", monthgetnum);
		request.getRequestDispatcher("/outs.jsp").forward(request, response);
		
	}

	/**
	 * 查找获取方法
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void query(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		System.out.println("query");
		GetsService getsService = new GetsServiceimpl();
		OutsService outsService = new OutsServiceimpl();
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
		//获取用户id
		String user_id = (String) user.get("user_id");
		List<Map<String, Object>> gets_list = getsService.queryAllbyuserid(user_id);
		
		//获取当前月分
		String currentmonth =  Dates.CurrentMonth();
		String currnetyear = Dates.CurrentYear();
		String currentday = Dates.CurrentTime();
		
		
		
		
		
		System.out.println(currentmonth);
		List<Map<String, Object>> getyearall = getsService.querycurrentmonth(currnetyear,user_id);
		List<Map<String, Object>> getmonthall = getsService.querycurrentmonth(currentmonth,user_id);
		List<Map<String, Object>> getdayall = getsService.querycurrentmonth(currentday,user_id);
		
		List<Map<String, Object>> outmonthall = outsService.querycurrentmonth(currentmonth,user_id);
		System.out.println(getmonthall);
		
		
		
		int yeargetnum = 0;
		int monthgetnum = 0;
		int daygetnum = 0;
		
		int monthoutnum = 0;
		
		for (int i = 0; i < getyearall.size(); i++) {
			yeargetnum += Integer.parseInt((String)getyearall.get(i).get("get_money"));
		}
		for (int i = 0; i < getmonthall.size(); i++) {
			monthgetnum += Integer.parseInt((String)getmonthall.get(i).get("get_money"));
		}
		for (int i = 0; i < getdayall.size(); i++) {
			daygetnum += Integer.parseInt((String)getdayall.get(i).get("get_money"));
		}
		
		for (int i = 0; i < outmonthall.size(); i++) {
			monthoutnum += Integer.parseInt((String)outmonthall.get(i).get("out_money"));
		}
		
		System.out.println(gets_list);
		request.setAttribute("yeargetnum", yeargetnum);
		request.setAttribute("monthoutnum", monthoutnum);
		request.setAttribute("daygetnum", daygetnum);
		
		request.setAttribute("gets_list", gets_list);
		request.setAttribute("monthgetnum", monthgetnum);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	

}
