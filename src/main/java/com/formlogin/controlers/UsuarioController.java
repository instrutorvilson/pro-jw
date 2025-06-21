package com.formlogin.controlers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.formlogin.entidades.Usuario;
import com.formlogin.repositories.UsuarioRepository;

@Controller
public class UsuarioController {
   private UsuarioRepository repository;
   private final BCryptPasswordEncoder encoder;
   
   public UsuarioController(UsuarioRepository repository,  BCryptPasswordEncoder encoder) {
	   this.repository = repository;
	   this.encoder = encoder;
   }   
	
   @GetMapping("/cadastro")
   public String cadastro(Model model) {
	   model.addAttribute("usuario", new Usuario());
	   return "cadastro";
   }
   
   @PostMapping("/salvar")
   public String salvar(@ModelAttribute Usuario usuario) {
	   usuario.setPassword(encoder.encode(usuario.getPassword()));
	   repository.save(usuario);
	   return "redirect:/login";
   }
}
