package com.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.modelos.Contato;
import com.agenda.repositories.ContatoRepository;

@Service
public class ContatoService {
	@Autowired
	private ContatoRepository repository;

	public List<Contato> getAll(){
		return repository.findAll();
	}
	
	public void delete(Long id) {
		Contato ct = getOne(id);
		repository.delete(ct);
	}
	
	public Contato update(Long id, Contato contato) {
		Contato ct = getOne(id);
		
		ct.setNome(contato.getNome());
	    ct.setEmail(contato.getEmail());
	    
		return repository.save(ct);
	}
	
	public Contato salvar(Contato contato) {
		//fazer validações
		return repository.save(contato);
	}
	
	public Contato getOne(long id) {
		Optional<Contato> opt = repository.findById(id);
	    return opt.orElseThrow(()-> new RuntimeException("contato não encontrado"));
	}
	
	
}
