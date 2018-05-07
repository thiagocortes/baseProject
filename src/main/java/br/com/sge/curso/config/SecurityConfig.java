package br.com.sge.curso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/controller/**").authenticated()
			.antMatchers(HttpMethod.PUT, "/controller/**").authenticated()
			.antMatchers(HttpMethod.DELETE, "/controller/**").authenticated()
			.anyRequest().permitAll().and().httpBasic().and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
