package com.aula.dao;

import java.util.ArrayList;
import java.util.List;

import com.aula.modelos.Contato;

public class ContatoDao {
   private static List<Contato> lista = new ArrayList<Contato>();
   
   public static void add(Contato contato) {
	   lista.add(contato);
   }
   
   public static List<Contato> getAll(){
	   return lista;
   }
}
