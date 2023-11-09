package com.triveous.ecommerce.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	@Autowired
	userDetailsService usrService;
	
	@Autowired
	JwtAuthFilter jwtFilter;
	
	@Bean 
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		http
			.csrf(csrf->csrf.disable())
			.cors(cors->{
				cors.configurationSource(request->{
					CorsConfiguration corsConfiguration = new CorsConfiguration();
					corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
					return corsConfiguration;
				});
			})
			.authorizeHttpRequests(auth->{
				auth.requestMatchers("/api/auth/**").permitAll();
				auth.requestMatchers("/api/product/**").permitAll();
				auth.anyRequest().authenticated();
			})
			.sessionManagement(session->{
				session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			});
		http.authenticationProvider(this.authenticationProvider());
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	@Bean public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(usrService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}
}
