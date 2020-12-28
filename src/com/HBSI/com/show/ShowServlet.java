package com.HBSI.com.show;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HBSI.com.Utils.Dates;
import com.HBSI.com.gets.GetsService;
import com.HBSI.com.gets.GetsServiceimpl;
import com.HBSI.com.outall.OutAllServiceimpl;
import com.HBSI.com.outs.OutsService;
import com.HBSI.com.outs.OutsServiceimpl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class ShowServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String method = request.getParameter("method");
		
		if("showTu".equals(method)){
			try {
				this.showTu(request,response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	
	}

	/**
	 * 展示饼图和线图的方法
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showTu(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
		//获取用户id
		String user_id = (String) user.get("user_id");
		OutsService outsService = new OutsServiceimpl();
		List<Map<String, Object>> outsbymonth = outsService.querycurrentday(Dates.CurrentMonth(), user_id);

		Map<String, Integer> outmap = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        return obj1.compareTo(obj2);
                    }
                });
		for (int i = 0; i < outsbymonth.size(); i++) {
			String day = (String)outsbymonth.get(i).get("out_date");
			int money = 0;
			List<Map<String, Object>> monthinDay= outsService.querycurrentmonth(day, user_id);
			 for (int k = 0; k < monthinDay.size(); k++) {
				 money += Integer.parseInt((String) monthinDay.get(k).get("out_money"));
			}
			 outmap.put(day, money);
		}
		System.out.println(outmap);
		
		Set<String> set = outmap.keySet();
		
		List<String> outdays = new ArrayList<String>();
		List<Integer> outmoneys = new ArrayList<Integer>();
		
		for (String string : set) {
			outdays.add(string.replace("-", "+'-'+"));
			outmoneys.add(outmap.get(string));
		}
		
		GetsService getsService = new GetsServiceimpl();
		List<Map<String, Object>> getsbymonth = getsService.querycurrentday(Dates.CurrentMonth(), user_id);
		Map<String, Integer> getmap = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        return obj1.compareTo(obj2);
                    }
                });
		
		
		System.out.println("getsbymonth>>>>>>>>>>"+getsbymonth);
		for (int i = 0; i < getsbymonth.size(); i++) {
			String day = (String)getsbymonth.get(i).get("get_date");
			int money = 0;
			List<Map<String, Object>> monthinDay= getsService.querycurrentmonth(day, user_id);
			System.out.println("monthinDay"+monthinDay);
			 for (int k = 0; k < monthinDay.size(); k++) {
				 money += Integer.parseInt((String) monthinDay.get(k).get("get_money"));
				 System.out.println(money);
			}
			 getmap.put(day, money);
		}
		
		Set<String> set1 = getmap.keySet();
		
		List<String> getdays = new ArrayList<String>();
		List<Integer> getmoneys = new ArrayList<Integer>();
		
		System.out.println("getmap>>>>>>>>>>>>>>>>>>"+getmap);
		
		for (String string : set1) {
			getdays.add(string.replace("-", "+'-'+"));
			getmoneys.add(getmap.get(string));
		}
		
		request.setAttribute("outdays", outdays);
		request.setAttribute("outmoneys", outmoneys);
		
		request.setAttribute("getdays", getdays);
		request.setAttribute("getmoneys", getmoneys);
		
		System.err.println("getmoneys>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>."+getmoneys);
		
		
		//饼状图
		Map<String, Integer> kindmoney = new HashMap<String, Integer>();
		List<String> kinds = new ArrayList<String>();
		List<Integer> moneys = new ArrayList<Integer>();
		List<Map<String, Object>>kindandmoney = outsService.querykindByuid(user_id);
		
		for (int i = 0; i < kindandmoney.size(); i++) {
			String kindname = (String) kindandmoney.get(i).get("out_name");
			Integer money =Integer.parseInt((String) kindandmoney.get(i).get("out_money"));
			
			if(kindmoney.get(kindname)==null){
				kindmoney.put(kindname, money);
			}else{
				 Integer agomoney= kindmoney.get(kindname);
				 money+=agomoney;
				 kindmoney.put(kindname, money);
			}
			
		}

		Set<String> kindmoneyset = kindmoney.keySet();
		
		for (String string : kindmoneyset) {
			kinds.add(string);
			moneys.add(kindmoney.get(string));
		}
		
		request.setAttribute("moneys", moneys);
		request.setAttribute("kinds",kinds);
		
		request.setAttribute("kindandmoney", kindandmoney);
		
		request.getRequestDispatcher("/show.jsp").forward(request, response);
	
	
	
	}
	

}
