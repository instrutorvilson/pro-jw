<%@page import="controllers.ClienteControler"%>
<%@page import="dao.DaoCliente"%>
<%@page import="classes.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
       if(request.getMethod().equals("POST")){
    	   String id = request.getParameter("id");
           Cliente cliente = new DaoCliente().getById(Integer.parseInt(id));
           new ClienteControler().delete(cliente);
           response.sendRedirect("consulta.jsp");
       }
    %>
    <%
        String id = request.getParameter("id");
        Cliente cliente = new DaoCliente().getById(Integer.parseInt(id));
    %>
    
    <Label>Nome: "<%= cliente.getNome() %>"</Label>
    <Label>Email: "<%= cliente.getEmail() %>"</Label>
    
    <form action="excluir.jsp" method="POST">
       <input type="hidden" name="id" value="<%= cliente.getId() %>"/>
        <button>Excluir</button>
    </form>
   
    
</body>
</html>