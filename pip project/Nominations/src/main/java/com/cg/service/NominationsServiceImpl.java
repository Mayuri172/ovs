package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Nominations;
import com.cg.repository.NominationsRepository;

@Service
public class NominationsServiceImpl implements NominationsService {

	@Autowired
	NominationsRepository repo;
	
	
	@Override
	public String addNominations(Nominations nominations) {
		System.out.println("inside service");
		repo.saveAndFlush(nominations);
		System.out.println("retured to sevice");
		return "Nomination added successfully";
	}

	@Override
	public String deleteNominations(Integer nominationNo) {
		System.out.println("inside ser");
		repo.deleteById(nominationNo);
		System.out.println("after");
		return "Nomination deleted successfully";
	}

	@Override
	public List<Nominations> viewNominations() {
		System.out.println("inside service");
		return repo.findAll();
	}

}
