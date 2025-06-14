package com.aula.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.dao.ContatoDao;
import com.aula.modelos.Contato;

@Controller
public class IndexControler {
	
	@Autowired
	private ContatoDao cdao;

	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable Long id) {
		cdao.delete(id);
		return "redirect:/contato";
	}
	
	@GetMapping("/novoContato")
	public String novoContato(Model model) {
		model.addAttribute("contato", new Contato());
		return "formCadContato";
	}
	
	@PostMapping("/saveContato")
	public String saveContato(@ModelAttribute Contato contato) {
		cdao.add(contato);
		return "redirect:contato";
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("nome", "ana");
		return "index";
	}
	
	@GetMapping("/contato")
	public String get(Model model) {
		model.addAttribute("lista", cdao.getAll());
		return "contato";
	}
	
	
	
	
}
