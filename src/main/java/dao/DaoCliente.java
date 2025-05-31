package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Cliente;
import interfaces.CRUD;
import utils.ConexaoDB;

public class DaoCliente implements CRUD<Cliente> {
	@Override
	public Cliente salvar(Cliente obj) {
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "insert into tb_clientes(nome, email)values(?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getEmail());
			stm.execute();
			
			return obj;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	@Override
	public Cliente update(Cliente obj) {
		try {
			Connection con = ConexaoDB.getConexao();
			String sql = "update tb_clientes set nome=?, email=? where id = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getEmail());
			stm.setInt(3, obj.getId());
			stm.execute();
			
			return obj;
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente getById(int id) {
		 try{
			Cliente cliente = new Cliente();
	    	String sql = "select * from tb_clientes where id = ?";
	    	PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
	    	stm.setInt(1, id);
	    	ResultSet rs = stm.executeQuery();
	    	if(rs.next()) {
	    		cliente.setId(rs.getInt("id"));
	    		cliente.setNome(rs.getString("nome"));
	    		cliente.setEmail(rs.getString("email"));	    		
	    	}
	    	return cliente;
	    }catch(Exception e) {
	    	throw new RuntimeException(e.getMessage());
	    }		
	}

	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<>();
	    try{
	    	String sql = "select * from tb_clientes";
	    	PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
	    	ResultSet rs = stm.executeQuery();
	    	while(rs.next()) {
	    		clientes.add(new Cliente(
	    				rs.getInt("id"),
	    				rs.getString("nome"),
	    				rs.getString("email"))
	    				);
	    	}
	    	return clientes;
	    }catch(Exception e) {
	    	throw new RuntimeException(e.getMessage());
	    }		
	}
}
