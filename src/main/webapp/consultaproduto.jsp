<%@page import="dao.DaoProduto"%>
<%@page import="java.util.List"%>
<%@page import="classes.Produto"%>

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
   </div>
	<hr />
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>R$ </th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Produto> produtos = DaoProduto.getAll();
			for (Produto c : produtos) {
				out.print("<tr>");
				out.print("<td>" + c.getId() + "</td>");
				out.print("<td>" + c.getDescricao() + "</td>");
				out.print("<td>" + c.getPreco() + "</td>");
				out.print("</tr>");
			}
			%>
		</tbody>
	</table>
</body>
</html>