package Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class LoginServlet implements Servlet{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("paw");
		System.out.println(username+password);
		PrintWriter out = response.getWriter();
        out.println("Hello.\nusername:"+username+"\npassword:"+password);
   }
	public void destroy() {
	}
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return null;
	}
	public void init(ServletConfig arg0) throws ServletException {
		
	}
}
