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

	public Usuario salvarUsuario(Usuario usuario){
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuario(String id) {
		this.usuarioRepository.delete(id);
	}

	public Usuario consultarUsuario(String id) {
		return this.usuarioRepository.findOne(id);
	}

}
