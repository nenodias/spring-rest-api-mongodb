package io.spring.aula.natan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourcesServerConfiguration extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(AutorizationServiceConfiguration.REST_SERVICE_ID);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.and().authorizeRequests()
			.antMatchers("/perfil/**").hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.GET,"/usuario/**").hasAnyRole("ADMIN")
			.anyRequest().denyAll()
		;
	}
	
}
