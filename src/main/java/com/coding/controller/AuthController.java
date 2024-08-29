package com.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.dto.LoginRequest;
import com.coding.dto.Response;
import com.coding.entity.User;
import com.coding.service.interfac.IUserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

	@Autowired
	private IUserService userService;
	
	 @PostMapping("/register")
	    public ResponseEntity<Response> register(@RequestBody User user) {
	        Response response = userService.register(user);
	        return ResponseEntity.status(response.getStatusCode()).body(response);
	    }
	
	  @PostMapping("/login")
	    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
	        Response response = userService.login(loginRequest);
	        return ResponseEntity.status(response.getStatusCode()).body(response);
	    }
}
