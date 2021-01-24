package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Election;
import com.cg.repository.ElectionRepository;

@Service
public class ElectionServiceImpl implements ElectionService{

	@Autowired
	ElectionRepository repo;
	
	
	@Override
	public String addElection(Election election) {
		System.out.println("inside service");
		repo.saveAndFlush(election);
		System.out.println("retured to sevice");
		return "election added successfully";
	}

	@Override
	public String deleteElection(Integer areaCode) {
		try {
			System.out.println("inside ser");
			repo.deleteById(areaCode);
			System.out.println("after");
			return "election deleted successfully";
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public String updateElection(Election election) {
		try {
			repo.save(election);
			System.out.println(election);
			return "Updated successfully";
		}
		catch(IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public List<Election> viewElections() {
		System.out.println("inside service");
		return repo.findAll();
	}

	@Override
	public Election getElectionById(Integer areaCode) {
		return repo.findById(areaCode).get();
		 
	}

}
