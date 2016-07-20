<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ekunt.entity.User"%>
<%@page import="com.ekunt.service.UserService" %>
<%@page import="com.ekunt.service.impl.UserServiceImpl"%>
<%
	String user = request.getParameter("user");
	String passwd = request.getParameter("passwd");
	String passwd2 = request.getParameter("passwd2");
	System.out.println("user:" + user + "\npasswd:" + passwd + "\npasswd2:" + passwd2);

	if (!passwd.equals(passwd2)) {
		response.sendRedirect("registerFail.jsp");
		return;
	}

	UserService userService = UserServiceImpl.getInstance();
	User u = new User(user, passwd);

	//检查用户名是否已存在
	if (userService.exist(u)) {
		response.sendRedirect("registerFail.jsp");
		return;
	}
	//注册用户，插入数据
	if (!userService.add(u)) {
		response.sendRedirect("registerFail.jsp");
		return;
	}
	response.sendRedirect("registerSuccess.jsp");
%>