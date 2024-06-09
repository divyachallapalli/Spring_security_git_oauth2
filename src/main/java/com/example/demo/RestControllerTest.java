package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTest {
	
	List<String> userList= new ArrayList<>();

	@GetMapping(path = "/doGitHubAuth")
	public String doGitHubAuth(OAuth2AuthenticationToken token) {
		return "Received Token "+ token.getName();
	}
	
	
}
