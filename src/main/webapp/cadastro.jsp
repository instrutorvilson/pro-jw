<%@page import="controllers.ClienteControler"%>
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
    <%
       Cliente cliente = new Cliente();
       String id = request.getParameter("id");
       if(id != null){
    	  out.print("<h1>Editar cliente:" + id +"</h1>");
    	  int idcliente = Integer.parseInt(id.replace("/",""));
          cliente = new DaoCliente().getById(idcliente);
       }
       else{
    	   out.print("<h1>Novo registro</h1>");
       }
    %>
	
	<div>
      <a href="index.html">Home</a>
      <a href="cadastro.jsp">Cadastro Cliente</a>
      <a href="consulta.jsp">Consulta Cliente</a>
      <a href="cadproduto.html">Cadastro Produto</a>
      <a href="#">Consulta Produto</a>
   </div>
	<form method="POST" action="./cadastro.jsp">
        <input type="hidden" name="id" value=<%= cliente.getId() %>/>
		<Label for="nome">Informe nome</Label> 
		<input 
		    type="text" id="nome"
		    name="nome"
			placeholder="Informe nome"
			value=<%= cliente.getNome() %>
			 />
		
		<Label for="email">Informe email</Label> 
		<input type="text" id="email"
		    name="email"
			placeholder="Informe email"
			value=<%= cliente.getEmail() %>
		/>	
			
		<button>Gravar</button>
	</form>
    
    <%
        String nome = request.getParameter("nome");
		String email = request.getParameter("email");
	    id = request.getParameter("id");
		
	    /*out.println("Nome: " + nome);
	    out.print("Email: " + email);*/
	    
	    if("POST".equals(request.getMethod())){
	    	cliente.setNome(nome);
		    cliente.setEmail(email);
		    
		    out.print("<p>"+id+"</p>");
		    int idcliente = Integer.parseInt(id.replace("/",""));
		    if(idcliente > 0){
		    	cliente.setId(idcliente);
		    	new ClienteControler().update(cliente);	
		    	out.print("<p>entrou aqui</p>");
		    }
		    else{
		    	new ClienteControler().salvar(cliente);	
		    	out.print("<p>salvar</p>");
		    }		    	    
		    response.sendRedirect("./consulta.jsp");
	    }	    
				
    %>

</body>
</html>