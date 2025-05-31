<%@page import="java.util.List"%>
<%@page import="classes.Cliente"%>
<%@page import="dao.DaoCliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Consulta de clientes</h1>
	<hr />
	<div>
      <a href="index.html">Home</a>
      <a href="cadastro.jsp">Cadastro Cliente</a>
      <a href="consulta.jsp">Consulta Cliente</a>
      <a href="cadproduto.html">Cadastro Produto</a>
      <a href="#">Consulta Produto</a>
   </div>
	<hr />
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Cliente> clientes = new DaoCliente().getAll();
			for (Cliente c : clientes) {
				out.print("<tr>");
				out.print("<td>" + c.getId() + "</td>");
				out.print("<td>" + c.getNome() + "</td>");
				out.print("<td>" + c.getEmail() + "</td>");
				out.print("<td><a href='cadastro.jsp?id="+c.getId()+"'>editar</a></td>");
				out.print("</tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>