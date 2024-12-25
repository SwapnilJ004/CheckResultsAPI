package Configs;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfigs {

	@Bean
	PasswordEncoder encoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
		http.cors().and().authorizeHttpRequests(
//						(req) -> req.requestMatchers("/login", "/register", "/forgotpwd","/swagger-ui/**","/swagger-ui.html","/v3/api-docs/**").permitAll()
						(req) -> req.requestMatchers("results/**", "/swagger-ui/**" ,"/swagger-ui.html","/v3/api-docs/**").permitAll()

								.anyRequest().authenticated()) // Authenticate all other requests

				.httpBasic(withDefaults());// Enable HTTP Basic Authentication
				 // Enable form-based login
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}
	
	 @Bean
	  AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
}
