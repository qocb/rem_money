package com.HBSI.com.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.HBSI.com.Utils.EmailUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.HBSI.com.Utils.ExcelUtils;


/**
 * 用户C层
 * @author 孙雨桐
 *
 */
public class UserServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	UserService userservice = new UserServiceimpl();
	ExcelUtils excel=new ExcelUtils();
	static String user_excel = null;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求
		String method = request.getParameter("method");
		
		try 
		{
			if("regist".equals(method))
			{
				this.regist(request,response);
			}
			else if("action".endsWith(method))
			{
				this.action(request,response);
			}
			else if ("login".equals(method)) 
			{
				this.login(request, response);
			}else if("showuser".equals(method)){
				this.showuser(request,response);
			}else if ("uplaodimgpath".equals(method)) {
				this.uplaodimgpath(request,response);
			}else if ("uploadimg".equals(method)) {
				this.uploadimg(request,response);
			}else if ("downloadimg".equals(method)) {
				this.downloadimg(request,response);
			}else if ("doExportExcel".equals(method)) {
				this.doExportExcel(request,response);
			}else if ("changePassword".equals(method)) {
				this.changePassword(request,response);
			}else if("logout".equals(method)){
				this.logout(request,response);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 退出登录方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取session对象
		HttpSession sesssion = request.getSession();
		sesssion.invalidate();
	}

	/**
	 * @desc 修改密码
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ServletException 
	 */
	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, ServletException {
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
		//获取用户id
		String user_id = (String) user.get("user_id");
		System.out.println("该用户id为："+user_id);
		//获取用户输入密码
		String old_pass=request.getParameter("old_pass");
		System.out.println(old_pass);
		String new_pass = request.getParameter("new_pass");
//		System.out.println(new_pass);
		 
		Map<String, Object> oldPassword	=userservice.queryOldPassword(user_id);
//		String a = (String) oldPassword.get("user_password");
//		System.out.println(a);
		//System.out.println(oldPassword.get("user_password"));
		if (oldPassword.get("user_password").equals(old_pass)) {
			userservice.editPassword(new_pass,user_id);
			response.sendRedirect(request.getContextPath()+"/user.jsp");
		}else {
			System.out.println("密码不正确");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	/**
	 * @desc  导出excel
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void doExportExcel(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
		
		String budget_user_id=request.getParameter("budget_user_id");
		System.out.println(budget_user_id);
	   
	    String filename="交易详细.xls";
	    excel.settings(request, response, filename);
		
		//1.获取数据
		List<Map<String, Object>> list_examinee = userservice.queryExaminee(budget_user_id);
		
		List<Map<String, Object>> list_gets = userservice.queryusergets(budget_user_id);
		
		System.out.println(list_gets);
		//2.写入excel中
		//2.1初始化poi的核心类，产生一个工作簿，并创建一个sheet，且命名
		HSSFWorkbook workbook=new HSSFWorkbook();
		String sheetname="支出的详细信息";
		HSSFSheet sheet = workbook.createSheet(sheetname);
		
		System.out.println(list_examinee);
		//2.2设定表头
		String[] tableTop = { "支出金额","备注","支出类型","支出时间","  ","  ","收入金额","备注","收入类型","收入时间","  ","  "};
		String[] columnName = { "out_money","out_rem","out_name","out_date"};
		String[] columnName2 = { "get_money","get_rem","get_name","get_date"};
	    //创建表头
		HSSFRow row = sheet.createRow(0);//创建第一行
		for(int i =0;i<tableTop.length;i++)
		{
			row.createCell(i).setCellValue(tableTop[i]);		
		}
		
//		//2.3从第二行开始向表格中添加数据
		for(int i =0;i<list_examinee.size();i++)
		{
	     HSSFRow row2 = sheet.createRow(i+1);
	 	 sheet.autoSizeColumn(i, true);//poi自带的解决表格中的数据自动适配宽度（对中文不太好使）
		 Map<String, Object> map = list_examinee.get(i);//取出list_examinee中的map,其实就是数据库表中的一行数据	


		 for(int k=0;k<columnName.length;k++)
		  {
			  row2.createCell(k).setCellValue((String)map.get(columnName[k]));
		  }
		}
		
		for(int i =0;i<list_gets.size();i++)
		{
	     HSSFRow row2 = sheet.getRow(i+1);
	 	 sheet.autoSizeColumn(i, true);//poi自带的解决表格中的数据自动适配宽度（对中文不太好使）
		 Map<String, Object> map = list_gets.get(i);//取出list_examinee中的map,其实就是数据库表中的一行数据	

		 for(int k=0;k<columnName2.length;k++)
		  {
			  row2.createCell(k+6).setCellValue((String)map.get(columnName2[k]));
		  }
		}
		
		excel.setColumnAutoAdapter(sheet, list_examinee.size());
		       //通过流写入到工作簿中
		        OutputStream out = response.getOutputStream();
		        workbook.write(out);
		        out.close();
	}

	
	/**
	 * @desc  用户头像的默认图片
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void downloadOutsider(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		//1.外链图片的网络资源地址
		String imgUrl="https://himg.bdimg.com/sys/portrait/hotitem/wildkid/29";

		//2.实例化URL类
		URL  url=new URL(imgUrl);

		//3.获取URLConnection对象
		 URLConnection connection = url.openConnection();
		
		 //4.利用urlConnection获取输入流对象
		InputStream inputStream = connection.getInputStream();
		
		//5.设定允许跨域访问
		response.setContentType("image/jpg"); //设置返回的文件类型   
		response.setHeader("Access-Control-Allow-Origin", "*");//设置该图片允许跨域访问
		
		//6.下载图片
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	
	
	/**
	 * @desc  下载图片
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void downloadimg(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException {
		
		//获取session对象
		HttpSession sesssion = request.getSession();
		//获取user Map
		Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
		//获取用户id
		String user_id = (String) user.get("user_id");
		
		Map<String, Object> list_img = userservice.query_userimg(user_id);
		System.out.println(list_img);
		String user_img = (String) list_img.get("user_img");
		System.out.println("========="+user_img+"===========");
		try {
			String path = this.getServletContext().getRealPath("/") + "WEB-INF/image/";
			File file = new File(path+user_img);//将服务器上的图片路径转换为文件
			System.out.println(file);
			FileInputStream fileInputStream = new FileInputStream(file);//将上步的文件转变为流
			System.out.println("fileInputStream----->"+fileInputStream);
			response.setContentType("image/jpg"); //设置返回的文件类型
			response.setHeader("Access-Control-Allow-Origin", "*");//设置该图片允许跨域访问
			IOUtils.copy(fileInputStream, response.getOutputStream());//利用commons-io.jar包中的方法实现根据文件输出流转换为图片
		}
		catch (FileNotFoundException e) //当服务器响应异常时候的处理
		{
			downloadOutsider(request,response);
		}
		
	}

	/**
	 * @desc  上传图片
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 * @throws FileUploadException 
	 * @throws ServletException 
	 */
	private void uploadimg(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, FileUploadException, ServletException {
		//4.0.设定类型和编码
		  response.setContentType("text/html;charset=utf-8");
		  //4.1声明变量
		  String fileSaveName=null;//将来保存再服务器硬盘上的图片的名字
		  List<FileItem> formItemList;//解析的上传页面的表单元素的结果集合
		  
	      //4.2.设定图片保存在服务器上的路径
			String path = this.getServletContext().getRealPath("/") + "WEB-INF/image";
		    System.out.println("图片存储路径：" + path);
		
		    //4.3.根据路径名创建一个 File实例其目的是为了创建存储的路径目录
		    File file=new File(path);
		    if (!file.exists()) 
		    {
			 file.mkdir();//创建image文件夹	
			}
		    
		   //4.4.将请求消息实体中的每一个项目封装成单独的DiskFileItem (FileItem接口的实现) 对象的任务
	       //直白的说就是将本次请求的request封装成DiskFileItemFactory对象 
		   DiskFileItemFactory factory=new DiskFileItemFactory();
		   
		   //4.5.使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		   ServletFileUpload upload=new ServletFileUpload(factory);

		   //4.6设定中文处理
		   upload.setHeaderEncoding("utf-8");
		   formItemList =upload.parseRequest(request);
		   
		   if ((formItemList!=null)&&(formItemList.size()>0))
		   {
			   for (FileItem Item : formItemList) 
			   {
				   if (!Item.isFormField()) 
				   {
					   //System.out.println("--->"+Item);
					   
					   //获取上传图片的名字
					   String fileName = Item.getName();
					   System.out.println("上传文件的名字:"+fileName);
					  //获取后缀
					   String prifix = fileName.substring(fileName.lastIndexOf(".")+1);
					   System.out.println("上传文件的后缀:"+prifix);
					   
					   //重新设定保存再服务器硬盘上的图片的名字，UUID+(session)
					   String id=UUID.randomUUID().toString();
					   fileSaveName =id+"."+prifix;
					   System.out.println("保存文件的名字："+fileSaveName);
					   
					   //利用commons-io.jar包中的方法实现保存到硬盘上
					   FileUtils.copyInputStreamToFile(Item.getInputStream(), new File(path+"/"+fileSaveName));
				   }
			   }
		   }
		   //5.将添加页面的数据信息保存到数据库中
		   String virtualPath=fileSaveName;
		   String user_id=request.getParameter("user_id"); //接session中user_id的值
		   System.out.println("user_id"+user_id);
		   userservice.updata_userid_img(virtualPath,user_id);
		   //6.重定向
		   response.sendRedirect(request.getContextPath()+"/user.jsp");
		   //request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	/**
	 * @desc 转向上传图片页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void uplaodimgpath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/uplaod_img.jsp").forward(request, response);
		
	}
	
	
	/**
	 * 获取用户的方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
private void showuser(HttpServletRequest request, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		
	//获取session对象
	HttpSession sesssion = request.getSession();
	
	Map<String, Object> user =(Map<String, Object>)sesssion.getAttribute("user");
	
	//调用jackon转换为json
	ObjectMapper mapper = new ObjectMapper();
	String json = mapper.writeValueAsString(user);
	
	response.setContentType("application/json;charset=utf-8");
	response.getWriter().write(json);
	}

/**
 * @desc 验证邮箱的方法
 * @param request
 * @param response
 * @throws SQLException 
 * @throws ClassNotFoundException 
 * @throws IOException 
 */
private void action(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
	
	String user_code = request.getParameter("user_code");
	
	System.out.println(user_code);
	//根据code查找用户
	 Map<String, Object> user = userservice.getuserByCode(user_code);
	 
	 String msg;
	
	 if(user!=null)
	 {
	 	String user_id = (String) user.get("user_id");
	 	userservice.mate_code(user_id);
		msg="激活成功";
	 }
	 else 
	 {
		msg="激活失败请联系管理员";
	 }
	response.setContentType("text/html;charset=utf-8");
	response.getWriter().write(msg);
	
}

/**
 * @desc 验证用户的方法
 * @param request
 * @param response
 * @throws IOException 
 * @throws SQLException 
 * @throws FileNotFoundException 
 * @throws ClassNotFoundException 
 * @throws MessagingException 
 */
private void regist(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException, MessagingException {
	System.out.println("验证用户方法执行了");
	//获取用户邮箱
	String user_email = request.getParameter("user_email");
	//获取用户账号
	String user_uname = request.getParameter("user_uname");
	//获取用户密码
	String user_password = request.getParameter("user_password");
	System.out.println("user_email:"+user_email);
	System.out.println("user_uname:"+user_uname);
	System.out.println("user_password:"+user_password);
	
	
	String user_code = UUID.randomUUID().toString();
	//保存用户
	userservice.add_user("u"+System.currentTimeMillis(), user_uname, user_password, user_email, "N", user_code, 1, "");
	
	//发送邮箱
	EmailUtils.createMimeMessage(user_email,"【金钱规】APP用户激活","<a href='http://localhost:8089/rem_Money/UserServlet.do?method=action&user_code="+user_code+"'>新用户"+user_uname+"你好：【点击激活账号】</a>");
}

private void login(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
	//获取用户名
	String user_uname = request.getParameter("user_uname");
	
	//获取密码
	String user_password = request.getParameter("user_password");
	
	System.out.println(user_uname);
	System.out.println(user_password);
	
	//根据用户名和密码查找用户
	Map<String, Object> user = userservice.querybyUsernameAndPassword(user_uname,user_password);
	System.out.println(user);
	
	Map<String, Object> msg = new HashMap<String, Object>();
	
	//判断用户是否存在
	if (user!=null) {
		if (user.get("user_state").equals("Y")) {
			msg.put("flag", true);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}else {
			msg.put("flag", false);
			msg.put("errmsg", "您的账号还未激活");
		}
	}else{
		msg.put("flag", false);
		msg.put("errmsg", "账号密码错误");
	}
	//如果激活登录成功保存将用户保存到sesssion中,返回json "flag":"true"
	ObjectMapper mapper = new ObjectMapper();
	String json = mapper.writeValueAsString(msg);
	response.setContentType("application/json;charset=utf-8");
	response.getWriter().write(json);
	
}


}
