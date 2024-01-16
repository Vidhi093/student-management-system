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

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentController controller = new StudentController();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		Student find = controller.find(username);
		
		PrintWriter printWriter = resp.getWriter();
		
		if (find!=null && password.equals("789456")) {
			if (controller.deleteStudentDetail(find) ) {
				printWriter.print("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "  <title>Registration Successful</title>\r\n"
						+ "  <style>\r\n"
						+ "    body {\r\n"
						+ "      margin: 0;\r\n"
						+ "      padding: 0;\r\n"
						+ "      font-family: sans-serif;\r\n"
						+ "      background: linear-gradient(#141e30, #243b55);\r\n"
						+ "      display: flex;\r\n"
						+ "      justify-content: center;\r\n"
						+ "      align-items: center;\r\n"
						+ "      height: 100vh;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    .login-box {\r\n"
						+ "      width: 400px;\r\n"
						+ "      padding: 40px;\r\n"
						+ "      background: rgba(0, 0, 0, .5);\r\n"
						+ "      box-sizing: border-box;\r\n"
						+ "      box-shadow: 0 15px 25px rgba(0, 0, 0, .6);\r\n"
						+ "      border-radius: 10px;\r\n"
						+ "      color: #fff;\r\n"
						+ "      text-align: center;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    .login-box h2 {\r\n"
						+ "      margin: 0 0 30px;\r\n"
						+ "      padding: 0;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    .login-box .user-box {\r\n"
						+ "      position: relative;\r\n"
						+ "      margin-bottom: 30px;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    .login-box .user-box input {\r\n"
						+ "      width: 100%;\r\n"
						+ "      padding: 10px 0;\r\n"
						+ "      font-size: 16px;\r\n"
						+ "      color: #fff;\r\n"
						+ "      border: none;\r\n"
						+ "      border-bottom: 1px solid #fff;\r\n"
						+ "      outline: none;\r\n"
						+ "      background: transparent;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    .login-box .user-box label {\r\n"
						+ "      position: absolute;\r\n"
						+ "      top: 0;\r\n"
						+ "      left: 0;\r\n"
						+ "      padding: 10px 0;\r\n"
						+ "      font-size: 16px;\r\n"
						+ "      color: #fff;\r\n"
						+ "      pointer-events: none;\r\n"
						+ "      transition: .5s;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "    .login-box .user-box input:focus ~ label,\r\n"
						+ "    .login-box .user-box input:valid ~ label {\r\n"
						+ "      top: -20px;\r\n"
						+ "      left: 0;\r\n"
						+ "      color: #03e9f4;\r\n"
						+ "      font-size: 12px;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "   .login-box a {\r\n"
						+ "      display: inline-block;\r\n"
						+ "      padding: 10px 20px;\r\n"
						+ "      color: #03e9f4;\r\n"
						+ "      font-size: 16px;\r\n"
						+ "      text-decoration: none;\r\n"
						+ "      text-transform: uppercase;\r\n"
						+ "      overflow: hidden;\r\n"
						+ "      transition: .5s;\r\n"
						+ "      margin-top: 20px;\r\n"
						+ "      border-radius: 5px;\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "    .login-box a:hover {\r\n"
						+ "      background: #03e9f4;\r\n"
						+ "      color: #fff;\r\n"
						+ "      border-radius: 5px;\r\n"
						+ "      box-shadow: 0 0 5px #03e9f4, 0 0 25px #03e9f4, 0 0 50px #03e9f4, 0 0 100px #03e9f4;\r\n"
						+ "    }\r\n"
						+ "  </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "<div class=\"login-box\">\r\n"
						+ "  <h2>Account Deleted!</h2>\r\n"
						+ "  <a href=\"loginform.html\">Go to Login Page</a>\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n");
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
					+ "<center> <h1>Invalid Credentials try again</h1></center>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("deleteform.html");
			requestDispatcher.include(req, resp);
		}
	}
}
