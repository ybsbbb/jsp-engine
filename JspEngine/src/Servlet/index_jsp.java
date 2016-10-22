package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
public class index_jsp implements Servlet{
@Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
PrintWriter out = response.getWriter();
out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
out.println("<html>");
out.println("<head>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
out.println("<title>123</title>");
out.println("</head>");
out.println("<body>");
out.println("</body>");
out.println("</html>");
System.out.print(out);
}
}