package ru.suhorukov.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		if (login != null && password != null &&
				login.equalsIgnoreCase(password)){
			
			Cookie authCookie = new Cookie("authCookie", "true");
			authCookie.setMaxAge(1000 * 60 * 60 * 2);
			authCookie.setPath("/");
			response.addCookie(authCookie);
			request.getSession().removeAttribute("helloWorldVisited");
			
			response.addHeader("Test Header", "Test Header Value");
			
			PrintWriter pw = response.getWriter();
			pw.println("<html><head><title>Успешная авторизация</title></head><body>Вы успешно авторизовались! Ваш логин : " + login + "</body></html>");
			pw.flush();
			pw.close();
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.println("<html><head><title>Авторизация отклонена.</title></head><body>Неуспешная попытка авторизации. <a href=\"" +  request.getContextPath() + "/index.html\">Попробуйте еще раз!</a></body></html>");
//			pw.print(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()));
			
			pw.flush();
			pw.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String helloWorldVisited = (String) req.getSession().getAttribute("helloWorldVisited");
		resp.getWriter().println(helloWorldVisited);
	}
	
	
}
