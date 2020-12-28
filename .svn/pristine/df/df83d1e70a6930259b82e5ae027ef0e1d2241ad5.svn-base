package com.HBSI.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器
 * @author 孙雨桐
 *
 */
public class SessionFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response =(HttpServletResponse) arg1;
		
		String path = request.getServletPath();
		String a = request.getRequestURI();
		if("/login.jsp".equals(path) ||"/UserServlet.do".equals(path)|| a.contains(".css") || a.contains(".js") || a.contains(".png")|| a.contains(".jpg")){
			chain.doFilter(request, response);
			return ;
		}
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			request.getRequestDispatcher("/notlogin.jsp").forward(request, response);;
			return ;
		}else{
			chain.doFilter(request, response);
			return ;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter初始化");
	}

}
