package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.controller.StudentController;
import com.jsp.model.Student;

@WebServlet(value = "/view" )
public class View extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentController controller = new StudentController();
		Student student = new Student();
		
		String username = req.getParameter("username");
		
		Student find = controller.find(username);
		if (find!=null) {
			req.setAttribute("student", find);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewdetail.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "<style>\r\n"
					+ "\r\n"
					+ "h1{\r\n"
					+ "color: white;\r\n"
					+ "}\r\n"
					+ "</style>\r\n"
					+ "<body>\r\n"
					+ "<center> <h1>Invalid Credentials try again</h1></center>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.html");
			requestDispatcher.include(req, resp);
		}
		
		 
		
	}
}
