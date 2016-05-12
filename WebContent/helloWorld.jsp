<%@page import="java.util.Random"%>
<%@page import="ru.suhorukov.auto.Car"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="static java.util.Date.from"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	errorPage="errorHandler.jsp" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<!-- Пример HTML-комментария! -->
<%-- Пример JSP-комментария --%>
<%!
	public String getCurrentDateAsString(){
		return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
	}

	public void jspInit(){
		counter = 25;
	}
	
	public void jspDestroy(){
		
	}
	int counter = 1;
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Тестовый Хелло Ворлд</title>
</head>
<body>
	<% if (new Random().nextInt() % 2 == 0) { %>
	<span>Текущее время: <%= getCurrentDateAsString() %></span>
	<% } else { %>
	<span>Текущее время (еще раз): <%= getCurrentDateAsString() %></span>
	<% } %>
	<%= counter++ %>
	<jsp:include page="index.html"></jsp:include>
	
	<%= request.getParameter("index") %>
	<% out.append("11111111"); %>
	
	<% pageContext.setAttribute("", "") %>	
	
	${5 + 5}
	
</body>
</html>