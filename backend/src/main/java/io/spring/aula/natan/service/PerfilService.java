package io.spring.aula.natan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.spring.aula.natan.entity.Perfil;
import io.spring.aula.natan.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;
	
	public List<Perfil> listaPerfil(){
		return perfilRepository.findAll();
	}
	
	public Page<Perfil> listaPaginada(int count, int page){
		Pageable pages = new PageRequest(page, count);
		return perfilRepository.findAll(pages);
	}	

	public Perfil salvarPerfil(Perfil usuario){
		return perfilRepository.save(usuario);
	}

	public void deletarPerfil(String id) {
		this.perfilRepository.delete(id);
	}

	public Perfil consultarPerfil(String id) {
		return this.perfilRepository.findOne(id);
	}
	
}
