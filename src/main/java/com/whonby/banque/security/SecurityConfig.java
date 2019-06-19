package com.whonby.banque.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.*;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
  @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 /* auth.inMemoryAuthentication()
      .withUser("user").password("{noop}123456").roles("USER")
      .and()
      .withUser("admin").password("{noop}password").roles("ADMIN","USER");*/
	  auth.jdbcAuthentication()
	       .dataSource(dataSource)
	       .usersByUsernameQuery("SELECT username as principal, password as credentials,active FROM users where username=?")
	       .authoritiesByUsernameQuery("SELECT username as principal, role_id as role FROM users, users_roles where users.id=users_roles.user_id and username=?")
	       .rolePrefix("ROLE_")
	       .passwordEncoder(new Md4PasswordEncoder());
}
  
  @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/operations","/consulterCompter").hasRole("USER");
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	}
}
