package com.lhu.SpringSecurityJdbc.service;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		System.out.println("authProvider Entered");
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setUserDetailsService(userDetailsService);
	    //daoAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	    daoAuthProvider.setPasswordEncoder(new BCryptPasswordEncoder());
	    System.out.println("authProvider "+daoAuthProvider.toString());
	    return daoAuthProvider;
		
	}
*/
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.jdbcAuthentication()
		        .dataSource(dataSource)
				.withUser(
						User.withUsername("user").password("pass").roles("USER")
				).withUser(
						User.withUsername("user").password("pass").roles("USER")
				);
				*/
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
				antMatchers("/admin").hasRole("ADMIN").
				antMatchers("/admin").hasAnyRole("ADMIN","USER").
				antMatchers("/").permitAll().
				and().formLogin();		
	}
	@Bean 
	public PasswordEncoder getPasswordEncorder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
   
}
