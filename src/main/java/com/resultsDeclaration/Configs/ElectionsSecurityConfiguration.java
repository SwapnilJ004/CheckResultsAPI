package com.resultsDeclaration.Configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.resultsDeclaration.Services.CustomUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ElectionsSecurityConfiguration {

	private static final String USER = "USER";
	private static final String ADMIN = "ADMIN";

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authManagerBuilder.userDetailsService(customUserDetailsService)
				.passwordEncoder(passwordEncoder());

		return authManagerBuilder.build();
	}

	@Bean
	SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		http.cors().and().authorizeHttpRequests((req) -> req

				.requestMatchers("/results/**", "/swagger-ui.html", "/swagger-ui/**", "/swagger-ui/index.html", "/v3/api-docs/**").permitAll() // Allow
				.anyRequest().authenticated())
				.httpBasic(withDefaults())
				.formLogin(withDefaults());
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}