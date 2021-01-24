package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.entity.User;
import com.cg.entity.Voter;
import com.cg.service.JwtUserDetailsService;
import com.cg.service.RegistrationServiceImpl;

@RestController
@CrossOrigin //(origins = "http://localhost:4200")
public class RegistrationController {
	
	
	@Autowired
	RegistrationServiceImpl service;
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello World!!";
	}
	

	@GetMapping("/user/{userName}")
	public User getUserDetails(@PathVariable String userName) {
		System.out.println("inside user");
		return service.getUserByName(userName);
//		UserDetails u = service.loadUserByUsername(userName);
//		System.out.println("got u");
//		return u;
	}
	
	//	http://localhost:4004/registerVoter
	@PostMapping("/registerVoter")
	public ResponseEntity<String> registerVoter(@RequestBody Voter voter)   {
		System.out.println("inside add ctrl");
		String result = service.registerVoter(voter);
		System.out.println(result);
		return new ResponseEntity<String>(result,HttpStatus.NOT_FOUND);
		///return result;
	}

	
	
	//		http://localhost:4004/updateVoterDetails/1
	@PutMapping("/updateVoterDetails/{voterId}")
	public String updateVoterDetails(@RequestBody Voter voter, @PathVariable Integer voterId) {
		String result = service.updateVoterDetails(voter);
		return result;
	}
	
	//	http://localhost:4004/voters
	@GetMapping("/voters")
	public List<Voter> getVotersList() {
		System.out.println("inside controller");
		return service.votersList();
	}
}
