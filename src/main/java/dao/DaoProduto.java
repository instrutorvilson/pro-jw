package dao;

import java.util.ArrayList;
import java.util.List;

import classes.Produto;

public class DaoProduto {
   private static List<Produto> produtos = new ArrayList<>(); 
   
   public static void inserir(Produto produto) {
	   produto.setId(produtos.size()+1);
	   produtos.add(produto);
   }
   
   public static List<Produto> getAll(){
	   return produtos;
   }
}
