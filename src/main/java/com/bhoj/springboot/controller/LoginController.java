package com.bhoj.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhoj.springboot.domain.Login;
import com.bhoj.springboot.dto.LoginDTO;
import com.bhoj.springboot.repository.LoginRepository;

/**
 * Login Controller class
 * 
 * @author Bhoj Sao
 *
 */
@RestController
@RequestMapping(value = "/auth/login")
public class LoginController {

	@Autowired
	private LoginRepository LoginRepository;

	@PostMapping(value = "/createLoginDetails")
	public ResponseEntity<?> createLoginDetails(@RequestBody LoginDTO loginDto) {
		Login login = LoginRepository.save(new Login(loginDto));
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}

	@PostMapping(value = "/validate")
	public ResponseEntity<?> validate(@RequestBody LoginDTO loginDto) {
		Login login = LoginRepository.save(new Login(loginDto));
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}

}
