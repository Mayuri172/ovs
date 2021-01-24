package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Nominations;
import com.cg.service.NominationsServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
//@CrossOrigin(origins = "*",allowCredentials = "true")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/api")
public class NominationsController {
	
	@Autowired
	NominationsServiceImpl service;
	
	//	http://localhost:4002/addNomination
	@PostMapping(path = "/addNomination" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
//	@HystrixCommand(fallbackMethod = "nominationsNotAdded")
	public String addNominations(@RequestBody Nominations nominations)   {
		System.out.println("inside add ctrl");
		System.out.println(nominations);
		String result = service.addNominations(nominations);
		System.out.println(result);
		return result;
	}

	//		http://localhost:4002/deleteNomination/2
	@DeleteMapping("/deleteNomination/{nominationNo}")
	@HystrixCommand(fallbackMethod = "nominationsNotDeleted")
	public String deleteNominations(@PathVariable Integer nominationNo) {
		System.out.println("inside ctrl");
		String result = service.deleteNominations(nominationNo);
		System.out.println("after result");
		return result;
	}
	
		//	http://localhost:4002/Nominations
	@GetMapping("/Nominations")
	@HystrixCommand(fallbackMethod = "noNominationsFound")
	public List<Nominations> viewNominations() {
		System.out.println("inside controller");
		return service.viewNominations();
	}
	
	
	
	
//	public String nominationsNotAdded(@RequestBody Nominations nominations) {
//		return "Nominations not added";
//	}
//	
	public String nominationsNotDeleted (Integer eventNo) {
		return "Nominations not deleted";
	}
	
	public List<Nominations> noNominationsFound () {
		List<Nominations> list= new ArrayList<>();
		Nominations b = new Nominations(null, 0,null, null, 0, null, 0);
		list.add(b);
		return list;
	}
}
