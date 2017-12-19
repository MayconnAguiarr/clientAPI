package com.api.client.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("maycon")
		.password("aguiar")
		.roles("USER");
	}

	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/h2-console/**").permitAll()// permiti acesso sem autenticação
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // permiti os navegadores acessar a API sem requisição
		.anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}
}
