package ru.suhorukov.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloWorldServlet
 */
//@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	
//	private Connection conn = null;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		System.out.println(config.getInitParameter("param1"));//value1
		System.out.println(config.getInitParameter("param2"));//value2
		
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(
					name + "=" + config.getInitParameter(name));//value1
		}
		
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext.getInitParameter("applicationParameter"));
		
		servletContext.setAttribute("hasVisitedHelloWorld", true);
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			this.conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@//localhost:1521/orcl", "scott", "scottNew");
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getHeader("User-Agent"));
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header = headers.nextElement();
			System.out.println(header + "=" + request.getHeader(header));
		}
		
		String login = request.getParameter("login");
		
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getQueryString());
		System.out.println(request.getPathInfo());
		System.out.println(request.getPathTranslated());
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
			for (int i = 0; i < cookies.length; i++){
				Cookie cookie = cookies[i];
				System.out.println(cookie.getName() + ":" + cookie.getValue());
			}
		
		response.getWriter().append("User requests the get method by context ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		session.setAttribute("helloWorldVisited", Boolean.TRUE.toString());
		session.setMaxInactiveInterval(30);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("User requests the post method by context ").append(request.getContextPath());
	}
	
//	@Override
//	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		switch(request.getMethod().toLowerCase()){
//			case "get" : doGet(request, response); break;
//			case "post" : doPost(request, response); break;
//			case "put" : doPut(request, response); break;
//		}
//	}

	@Override
	public void destroy(){
//		try {
//			this.conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
