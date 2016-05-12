package ru.suhorukov.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AsyncServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		final AsyncContext context = req.startAsync(req, resp);
		context.start(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					PrintWriter writer = context.getResponse().getWriter();
					writer.println("Hello World!");
					writer.flush();
					writer.close();
					context.complete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
