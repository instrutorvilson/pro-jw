<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autenticação de usuários</title>
</head>
<body>
	<h1>Autenticação</h1>
	<%
	String user = (String) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<h2>
		Bem-vindo,
		<%=user%>!
	</h2>
	<a href="logout">Sair</a>
	<a href="adm.jsp">Adm</a>
	

</body>
</html>