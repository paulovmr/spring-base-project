package com.baseproject.controller.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public LoginStatus getStatus() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null && !auth.getName().equals("anonymousUser")	&& auth.isAuthenticated()) {
			return new LoginStatus(true, auth.getName());
		} else {
			return new LoginStatus(false, null);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public LoginStatus login(@RequestParam("username") String username,
							 @RequestParam("password") String password) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		UserDetails details = myUserDetailsService.loadUserByUsername(username);
		token.setDetails(details);

		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			return new LoginStatus(auth.isAuthenticated(), auth.getName());
		} catch (BadCredentialsException e) {
			return new LoginStatus(false, username);
		}
	}

	public class LoginStatus {

		private final boolean loggedIn;
		private final String username;

		public LoginStatus(boolean loggedIn, String username) {
			this.loggedIn = loggedIn;
			this.username = username;
		}

		public boolean isLoggedIn() {
			return loggedIn;
		}

		public String getUsername() {
			return username;
		}
	}
}
