package com.formlogin.services;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.formlogin.entidades.Usuario;
import com.formlogin.repositories.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {
    private UsuarioRepository repository;
    
    public UsuarioDetailsService(UsuarioRepository repository) {
    	this.repository = repository;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByusername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		
		return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRole()))
        );
	}

}
