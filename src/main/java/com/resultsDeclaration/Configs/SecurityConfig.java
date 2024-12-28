package com.resultsDeclaration.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfig {
	public static final String[] PUBLIC_URLS = {
			"/api/v1/auth/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**",
			"/v3/api-docs/swagger-config"
	};
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF
            .cors().and() // Enable CORS
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(
                    "/results/**", 
                    "/swagger-ui/index.html"
                ).permitAll()
                .requestMatchers(
            		PUBLIC_URLS
        		).permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
