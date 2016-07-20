<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
	Connection conn = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmtQuery = null;
	ResultSet rs = null;
%>
<%
	String user = request.getParameter("user");
	String passwd = request.getParameter("passwd");
	String passwd2 = request.getParameter("passwd2");
	System.out.println("user:" + user + "\npasswd:" + passwd + "\npasswd2:" + passwd2);
	
	if(!passwd.equals(passwd2)) {
		response.sendRedirect("registerFail.jsp");
		return;
	}
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?useSSL=false", "root", "tiger");
		conn.setAutoCommit(false);
		//检查用户名是否已存在
		pstmtQuery = conn.prepareStatement("select count(*) from user where user = ?");
		pstmtQuery.setString(1, user);
		rs = pstmtQuery.executeQuery();
		rs.next();
		if(rs.getInt(1) > 0) {
			response.sendRedirect("registerFail.jsp");
			return;
		}
		//注册用户，插入数据
		pstmt = conn.prepareStatement("insert into user values(null,?,?)");
		pstmt.setString(1, user);
		pstmt.setString(2, passwd);
		pstmt.executeUpdate();
		conn.commit();
		conn.setAutoCommit(true);
		response.sendRedirect("registerSuccess.jsp");
	} catch (SQLException e) {
		e.printStackTrace();
		conn.rollback();
		conn.setAutoCommit(true);
		response.sendRedirect("registerFail.jsp");
	} finally {
		if (pstmtQuery != null) {
			pstmtQuery.close();
			pstmtQuery = null;
		}
		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
%>