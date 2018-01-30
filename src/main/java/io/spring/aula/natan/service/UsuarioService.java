package io.spring.aula.natan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listaUsuario(){
		return usuarioRepository.findAll();
	}

	public List<Usuario> listaUsuario(Usuario usuario){
		usuarioRepository.save(usuario);
		return usuarioRepository.findAll();
	}

}
