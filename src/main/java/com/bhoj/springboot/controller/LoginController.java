package com.bhoj.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@CrossOrigin
@RequestMapping(value = "/auth/login")
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

	@PostMapping(value = "/createLoginDetails")
	public ResponseEntity<?> createLoginDetails(@RequestBody LoginDTO loginDto) {
		Login login = loginRepository.save(new Login(loginDto));
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}

	@GetMapping(value = "/authenticate")
	public ResponseEntity<?> authenticate(@RequestParam(value ="userName", required=true) String userName,
			@RequestParam(value ="password", required=true) String password) {
		Login loginDetail = loginRepository.findByUserNameAndPassword(userName, password);
		return new ResponseEntity<Login>(loginDetail, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getLoginDetails")
	public ResponseEntity<?> getLoginDetails() {
		List<Login> loginDetails = loginRepository.findAll();
		return new ResponseEntity<List<Login>>(loginDetails, HttpStatus.OK);
	}

}
