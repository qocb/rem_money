package com.HBSI.com.deal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HBSI.com.outs.OutsService;
import com.HBSI.com.outs.OutsServiceimpl;

/**
 * 交易详细
 * @author 孙雨桐
 *
 */
public class DealmsgServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	OutsService outsService = new OutsServiceimpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String method  = request.getParameter("method");
	
			try {
				
				if ("query".equals(method)) {
					this.query(request,response);
				}else if("delete".equals(method)){
					this.delete(request, response);
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	/**
	 * 删除的方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		String out_id = request.getParameter("out_id");
		
		outsService.deletebyout_id(out_id);
		
		response.sendRedirect(request.getContextPath()+"/index.do?method=queryouts");
		
	}

	/**
	 * 查找的方法
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void query(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		String out_id = request.getParameter("out_id");
		
		
		 Map<String, Object>outmsg = outsService.querybyout_id(out_id);
		 
		 
		 System.out.println(outmsg);
		 request.setAttribute("outmsg", outmsg);
		
		
		 request.getRequestDispatcher("/dealMsg.jsp").forward(request, response);;
		
	}
	
	

}
