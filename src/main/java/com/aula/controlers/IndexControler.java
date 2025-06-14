package com.aula.controlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aula.dao.ContatoDao;
import com.aula.modelos.Contato;

@Controller
public class IndexControler {


	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("nome", "ana");
		return "index";
	}
	
	@GetMapping("/contato")
	public String get(Model model) {
		model.addAttribute("lista", ContatoDao.getAll());
		return "contato";
	}
	
}
