package com.aula.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula.modelos.Contato;
import com.aula.repositories.ContatoRepository;

@Service
public class ContatoDao {
	// private static List<Contato> lista = new ArrayList<Contato>();

	@Autowired
	private ContatoRepository repository;

	public void add(Contato contato) {
		// lista.add(contato);
		if(contato.getId() != null) {
			Contato contatoExistente = repository.getById(contato.getId());
			contatoExistente.setNome(contato.getNome());
			contatoExistente.setEmail(contato.getEmail());
			repository.save(contatoExistente);
		}
		else
		  repository.save(contato);
	}

	public List<Contato> getAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Contato getById(Long id) {
		return repository.getById(id);
	}
}
