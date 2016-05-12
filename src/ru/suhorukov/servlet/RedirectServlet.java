package ru.suhorukov.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.sendRedirect(req.getContextPath() + "/HelloWorldServlet?" + req.getQueryString());
		
		
//		req.getRequestDispatcher("index.html").forward(req, resp);
		
		req.getRequestDispatcher("/WEB-INF/NewFile.jsp").include(req, resp);
		
//		resp.getOutputStream().println("HeLLo World");
		resp.getWriter().println("HeLLo World");
	}

	
}
