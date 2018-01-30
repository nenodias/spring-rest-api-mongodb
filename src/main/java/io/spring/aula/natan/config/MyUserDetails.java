package io.spring.aula.natan.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.spring.aula.natan.entity.Usuario;

public class MyUserDetails extends Usuario implements UserDetails{

	private static final long serialVersionUID = -5656690943145599260L;
	
	public MyUserDetails() {
		
	}

	public MyUserDetails(Usuario usuario) {
		this.setNome(usuario.getNome());
		this.setEmail(usuario.getEmail());
		this.setSenha(usuario.getSenha());
		this.setPerfis(usuario.getPerfis());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getPerfis();
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
