package com.cors.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cors.models.Contato;

@RestController
@RequestMapping("/api/v1/contatos")
public class MeuController {
	private static List<Contato> contatos = new ArrayList<>();
	
	@PostMapping("/inserir") /*restrito*/
    public ResponseEntity<?> salvar(@RequestBody Contato contato){
       contato.setId(contatos.size()+1);	
       contatos.add(contato);
       return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }
	
	@GetMapping("/consultar") /*publico*/
    public ResponseEntity<?> getAll(){
       return ResponseEntity.status(HttpStatus.CREATED).body(contatos);
    }
	
}
