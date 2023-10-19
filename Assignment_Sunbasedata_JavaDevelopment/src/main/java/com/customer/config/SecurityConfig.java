package com.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.security.auth.message.config.AuthConfigProvider;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails userDetails = User.builder()
		.username("test@sunbasedata.com")
		.password(this.passwordEncoder().encode("Test@123"))
		.build();
		return new InMemoryUserDetailsManager(userDetails) ;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(this.passwordEncoder());
		provider.setUserDetailsService(this.userDetailsService());
		return provider;
	}
	
	@Bean
	public SecurityFilterChain getConfigure(HttpSecurity http) throws Exception {
		http
			.csrf(c->c.disable())
			.cors(cors->cors.disable())
			.authorizeHttpRequests()
			.requestMatchers("/customers/**").authenticated()
			.requestMatchers("/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/loginform")
			.defaultSuccessUrl("/customers")
			.loginProcessingUrl("/dologin");
		http.authenticationProvider(this.authProvider());
		return http.build();
	
	}
}









