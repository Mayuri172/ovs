package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Election;
import com.cg.service.ElectionServiceImpl;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ElectionController {

	@Autowired
	ElectionServiceImpl service;
	
	//	http://localhost:4001/addElection

	@PostMapping(path= "/addElection" , consumes = "application/json", produces = "application/json")
	public String addElection(@RequestBody Election election)   {
		System.out.println("inside add ctrl");
		String result = service.addElection(election);
		System.out.println(result);
		return result;
	}

	
	//		http://localhost:4001/deleteElection/1
	@DeleteMapping("/deleteElection/{areaCode}")
	public String deleteElection(@PathVariable Integer areaCode) {
		System.out.println("inside ctrl");
		String result = service.deleteElection(areaCode);
		System.out.println("after result");
		return result;
	}
	
	//		http://localhost:4001/updateElection/1
	@PutMapping("/updateElection/{areaCode}")
	public String updateElection(@RequestBody Election election, @PathVariable Integer areaCode) {
		String result = service.updateElection(election);
		return result;
	}
	
	//	http://localhost:4001/elections
	@GetMapping("/elections")
	public List<Election> viewElections() {
		System.out.println("inside view controller");
		return service.viewElections();
	}
	
	//		http://localhost:4001/electionById/1
	@GetMapping("/electionById/{areaCode}")
	public Election getElectionById (@PathVariable Integer areaCode) {
		return service.getElectionById(areaCode);
	}
}
