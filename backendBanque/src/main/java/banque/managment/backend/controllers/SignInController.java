package banque.managment.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import banque.managment.backend.config.security.jwt.JwtUtils;
import banque.managment.backend.controllers.response.SignInResponse;
import banque.managment.backend.controllres.requests.SignInRequest;

@RestController
@RequestMapping("/api/auth")
public class SignInController {
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/sign-in")
	public ResponseEntity<SignInResponse> SignIn (@RequestBody SignInRequest request ){
    
      
        Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		SignInResponse response = new SignInResponse() ;
		response.setToken(jwt);
		  return ResponseEntity.ok(response);
}}
