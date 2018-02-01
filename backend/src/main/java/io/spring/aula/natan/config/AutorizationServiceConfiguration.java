package io.spring.aula.natan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import io.spring.aula.natan.service.MyUserDetailService;

@Configuration
@EnableAuthorizationServer
public class AutorizationServiceConfiguration extends AuthorizationServerConfigurerAdapter {

	public static final String REST_SERVICE_ID = "restservice";

	private TokenStore tokenStore = new InMemoryTokenStore();
	
	@Autowired
	private MyUserDetailService userDetailsService;
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
		.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService)
		;
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("mobile")
			.authorizedGrantTypes("password","authorization_code", "refresh_token").scopes("bar", "read", "write")
			.refreshTokenValiditySeconds(86000)
			.accessTokenValiditySeconds(30)
			.resourceIds(REST_SERVICE_ID)
			.secret("123")
		;
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setTokenStore(tokenStore);
		return tokenServices;
	}
}
