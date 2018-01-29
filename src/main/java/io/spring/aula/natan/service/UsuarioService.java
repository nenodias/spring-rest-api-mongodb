package io.spring.aula.natan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.aula.natan.entity.Usuario;

@Service
public class UsuarioService {

	public List<Usuario> listaUsuario(){
		List<Usuario> usuarioLista = new ArrayList<>();
		
		Usuario usuario = new Usuario();
		usuario.setEmail("nataniel.paiva@gmail.com");
		usuario.setIdade(26);
		usuario.setNome("Nataniel");
		
		usuarioLista.add(usuario);
		
		usuario = new Usuario();
		usuario.setEmail("fulano@gmail.com");
		usuario.setIdade(35);
		usuario.setNome("Fulano");
		
		usuarioLista.add(usuario);
		
		return usuarioLista;
	}

	public List<Usuario> listaUsuario(Usuario usuario){
		List<Usuario> usuarioLista = listaUsuario();
		usuarioLista.add(usuario);
		return usuarioLista;
	}

}
