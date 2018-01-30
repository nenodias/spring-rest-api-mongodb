package io.spring.aula.natan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<Usuario> listUsuario(){
		return this.usuarioService.listaUsuario();
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public Usuario getById(@PathVariable String id){
		return this.usuarioService.consultarUsuario(id);
	}
	
	@RequestMapping(value = "/usuario/{page}/{count}", method = RequestMethod.GET)
	public Page<Usuario> listaPaginada(@PathVariable int page, @PathVariable int count){
		return this.usuarioService.listaPaginada(count, page);
	}
	
	@RequestMapping(value = "/usuario/{nome}/nome", method = RequestMethod.GET)
	public List<Usuario> listaPaginada(@PathVariable String nome){
		return this.usuarioService.buscaPorNome(nome);
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public Usuario listUsuario(@RequestBody Usuario usuario){
		return this.usuarioService.salvarUsuario(usuario);
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public Usuario editarUsuario(@RequestBody Usuario usuario){
		return this.usuarioService.salvarUsuario(usuario);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public void deletarUsuario(@PathVariable String id){
		this.usuarioService.deletarUsuario(id);
	}
}
