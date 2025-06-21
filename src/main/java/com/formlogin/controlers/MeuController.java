package com.formlogin.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuController {

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "pagina inicial";
	}
	
	@GetMapping("/publico")
	@ResponseBody
	public String publico() {
		return "conteudo publico";
	}
	
	@GetMapping("/restrito")
	@ResponseBody
	public String restrito() {
		return "conteudo restrito";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
}
