package controllers;

import classes.Cliente;
import dao.DaoCliente;

public class ClienteControler {
    
	public Cliente salvar(Cliente cliente) {
		try {
			//valida regras de negócio
		  return new DaoCliente().salvar(cliente);
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Cliente update(Cliente cliente) {
		try {
			//valida regras de negócio
		  return new DaoCliente().update(cliente);			
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void delete(Cliente cliente) {
		try {
			//valida regras de negócio
		  new DaoCliente().delete(cliente.getId());			
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
