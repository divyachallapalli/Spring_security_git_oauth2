package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth) ->
			auth.requestMatchers("/doGitHubAuth").authenticated()
			.anyRequest().permitAll()
			
		)
		//This is code configuration.instead we can use properties as well
		.oauth2Login(oauth -> oauth.clientRegistrationRepository(new InMemoryClientRegistrationRepository(getRegistrations())));
		
		return http.build();
	}
	
	private ClientRegistration getRegistrations() {
		return CommonOAuth2Provider.GITHUB.getBuilder("GitHub")
		          .clientId("Ov23liBbsUpu83Xc48xW").clientSecret("dfa4678860579543e4076e2e63ca4aac64b9cf77").build();
	}
	

}
