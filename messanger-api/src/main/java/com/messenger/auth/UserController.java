package com.messenger.auth;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.messenger.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 6000)
@RestController
public class UserController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User loginUser) throws ServletException {
		System.out.println("IN AUTH");
	    String jwtToken = "";

	    if (loginUser.getUserName() == null || loginUser.getPassword() == null) {
	        throw new ServletException("Please fill in username and password");
	    }

	    String email = loginUser.getUserName();
	    String password = loginUser.getPassword();
	    
	  //  User user = userService.findByEmail(email);
	    User user = new User();
	    user.setPassword("test");
	    user.setUserName("test");
	    
	    if (loginUser==null || !loginUser.getPassword().equals(user) || !loginUser.getPassword().equals(user)) {
	    	throw new ServletException("Invalid login. Please check your name and password.");
	    }

	    String pwd = user.getPassword();

	    jwtToken = Jwts.builder().setSubject(email).claim(user.getUserName(), user.getPassword()).setIssuedAt(new Date())
	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

	    return jwtToken;
	}
}
