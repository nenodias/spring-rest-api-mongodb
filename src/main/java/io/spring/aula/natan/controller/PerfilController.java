package io.spring.aula.natan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.aula.natan.entity.Perfil;
import io.spring.aula.natan.service.PerfilService;

@RestController
public class PerfilController {

	@Autowired
	PerfilService perfilService;
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public List<Perfil> listUsuario(){
		return this.perfilService.listaPerfil();
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public Perfil getById(@PathVariable String id){
		return this.perfilService.consultarPerfil(id);
	}
	
	@RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
	public Page<Perfil> listaPaginada(@PathVariable int page, @PathVariable int count){
		return this.perfilService.listaPaginada(count, page);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public Perfil salvar(@RequestBody Perfil usuario){
		return this.perfilService.salvarPerfil(usuario);
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.PUT)
	public Perfil editar(@RequestBody Perfil usuario){
		return this.perfilService.salvarPerfil(usuario);
	}
	
	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable String id){
		this.perfilService.deletarPerfil(id);
	}
}
