<%@page import="dao.DaoProduto"%>
<%@page import="classes.Produto"%>
<%
   String descricao = request.getParameter("descricao");
   String preco = request.getParameter("preco");   
   
   if( preco != null){
	   Produto prod = new Produto();
	   prod.setDescricao(descricao);
	   prod.setPreco(Float.parseFloat(preco));
	   DaoProduto.inserir(prod); 
	   response.sendRedirect("./consultaproduto.jsp");
   }   
   
%>