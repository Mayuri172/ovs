package com.cg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Voting;
import com.cg.service.VotingServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VotingController {

	@Autowired
	VotingServiceImpl service;
	
	//	http://localhost:4003/addVote
	@PostMapping("/addVote")
	//@HystrixCommand(fallbackMethod = "voteNotAdded")
	public CompletableFuture<String> addVote(@RequestBody Voting voting)   {
		System.out.println("inside add ctrl");
		CompletableFuture<String> result = service.addVote(voting);
		System.out.println(result);
		return result;
	}
	
		//	http://localhost:4003/getResults
	@GetMapping("/getResults")
	@HystrixCommand(fallbackMethod = "resultsNotFound")
	public List<Voting> getElectionResults(){
		return service.getElectionResults();
		 
	}
	
	
	public String voteNotAdded(@RequestBody Voting voting) {
		
		return "Vote not added";
	}
	
	
	public List<Voting> resultsNotFound() {
		List<Voting> list= new ArrayList<>();
		Voting b = new Voting(0, 0, null);
		list.add(b);
		return list;
	}
}
