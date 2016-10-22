package Servlet;import java.io.IOException;import java.io.PrintWriter;import javax.servlet.Servlet;import javax.servlet.ServletConfig;import javax.servlet.ServletException;import javax.servlet.ServletRequest;import javax.servlet.ServletResponse;
public class test_jsp implements Servlet{
ServletRequest request=null;ServletResponse response=null;
public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException{
this.request=request;this.response=response;PrintWriter out=response.getWriter();
out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=GB18030\"><title>JSP Engine</title></head><body><p>A simple JSP Engine</p><br/><p>The argument is build-in, show 7 times in a html list.</p><ul>");
for(int i = 0;i<7;i++) 

{ 
out.println("<li>");
out.println(request.getParameter("key") );
out.println("</li>");
} 
out.println("</ul></body></html>");

}
public void destroy(){}public ServletConfig getServletConfig(){return null;}public String getServletInfo(){return null;}public void init(ServletConfig arg0) throws ServletException {}
}