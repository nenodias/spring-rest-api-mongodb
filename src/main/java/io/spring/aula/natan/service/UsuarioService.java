package io.spring.aula.natan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Usuario> listaPaginada(int count, int page){
		Pageable pages = new PageRequest(page, count);
		return usuarioRepository.findAll(pages);
	}
	
	public List<Usuario> buscaPorNome(String nome){
		return usuarioRepository.findByNomeLikeIgnoreCase(nome);
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
