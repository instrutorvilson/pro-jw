package com.agenda.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.modelos.Contato;
import com.agenda.services.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
	private static List<Contato> contatos = new ArrayList<Contato>();
	@Autowired
	private ContatoService service;
    
	@GetMapping
	public ResponseEntity<List<Contato>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") int id) {
		/*for(Contato ct : contatos) {
			if(ct.getId() == id) {
				return ResponseEntity.ok(ct);
			}
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Contato não encontrado");*/
		try {
		   return ResponseEntity.ok(service.getOne(id));
		}catch(RuntimeException ex) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(ex.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") long id) {
		/*for(Contato ct : contatos) {
			if(ct.getId() == id) {
				contatos.remove(ct);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Contato não encontrado");
				*/
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> inserir(@RequestBody Contato contato) {
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(service.salvar(contato));
		}
		catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(
			@PathVariable("id") long id, 
			@RequestBody Contato contato){
		/*Contato ctAlterar = new Contato();
		for(Contato ct : contatos) {
			if(ct.getId() == id) {
				ctAlterar = ct;
				break;
			}
		}
		
		if(ctAlterar.getId() == id) {
			ctAlterar.setNome(contato.getNome());
			ctAlterar.setEmail(contato.getEmail());
			return ResponseEntity.ok(ctAlterar);
		}
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Contato não encontrado");
				*/
		try {
			return ResponseEntity.ok(service.update(id, contato));
		}
		catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(e.getMessage());
		}
		catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		
		
	}
}
//http://localhost:8080/contatos