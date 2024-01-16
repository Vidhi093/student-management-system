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

@WebServlet(value = "/changePassword", loadOnStartup = 3)
public class ForgetPassword extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("confirmpassword");
		
		StudentController controller = new StudentController();
		PrintWriter printWriter = resp.getWriter();
		
		if (password.equals(confirmpassword)) {
			Student find = controller.find(username);
			if (find!=null) {
				find.setPassword(confirmpassword);
				if (controller.changePassword(find)) {
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
							+ "<center> <h1>Password changed Successfully</h1></center>\r\n"
							+ "</body>\r\n"
							+ "</html>\r\n");
					
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginform.html");
					requestDispatcher.include(req, resp);
				}
			} else {
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
						+ "<center> <h1>Please check your username</h1></center>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n");
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("forgetpassword.html");
				requestDispatcher.include(req, resp);
			
			}
		} else {
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
					+ "<center> <h1>Please check your password</h1></center>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("forgetpassword.html");
			requestDispatcher.include(req, resp);
		}
	}
}
