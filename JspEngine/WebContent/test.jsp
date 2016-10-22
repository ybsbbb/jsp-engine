<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>JSP Engine</title>
</head>
<body>
<p>A simple JSP Engine</p>
<br/>
<p>The argument is build-in, show 7 times in a html list.</p>
<ul>
<%for(int i = 0;i<7;i++) %>
<%{ %>
<li><%=request.getParameter("key") %></li>
<%} %>
</ul>
</body>
</html>