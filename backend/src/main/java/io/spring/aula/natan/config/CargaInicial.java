package io.spring.aula.natan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import io.spring.aula.natan.entity.Perfil;
import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.repository.PerfilRepository;
import io.spring.aula.natan.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent e) {
		List<Perfil> perfils = perfilRepository.findAll();
		
		if(perfils.isEmpty()) {
			perfilRepository.save(new Perfil("ROLE_ADMIN"));
			
			Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");
			perfils = new ArrayList<>();
			perfils.add(perfil);
			
			usuarioRepository.save(new Usuario("Administrador", perfils, "admin", "123"));
		}
	}
	
}
