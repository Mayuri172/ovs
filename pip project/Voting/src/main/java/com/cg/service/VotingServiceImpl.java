package com.cg.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.cg.entity.Voting;
import com.cg.repository.VotingRepository;

@Transactional
@Service
public class VotingServiceImpl implements VotingService {

	@Autowired
	VotingRepository repo;
	
	
	/*
	@Override
	public String addVote(Voting voting) {
		System.out.println("inside addVote service");
		
		Integer nId= voting.getNominationNo();
		if(repo.existsById(nId)) {
			System.out.println("inside if");
			Voting v = repo.findById(voting.getNominationNo()).get();
			Integer vote = v.getVoteCount();
			vote= vote+1;
			voting.setVoteCount(vote);
			repo.save(voting);
		}
		else {
			voting.setVoteCount(1);
			repo.saveAndFlush(voting);
		}
		
		System.out.println("retured to sevice");
		return "Voted successfully";
	}
*/

	@Override
	@Async
	 public CompletableFuture<String> addVote(Voting voting) {
		System.out.println("inside addVote service");
		
		Integer nId= voting.getNominationNo();
		if(repo.existsById(nId)) {
			System.out.println("inside if");
			Voting v = repo.findById(voting.getNominationNo()).get();
			Integer vote = v.getVoteCount();
			vote= vote+1;
			voting.setVoteCount(vote);
			repo.save(voting);
		}
		else {
			voting.setVoteCount(1);
			repo.saveAndFlush(voting);
		}
		
		System.out.println("retured to sevice");
		String s = "Voted successfully";
		return CompletableFuture.completedFuture(s);
	}
	
	

	@Override
	public List<Voting> getElectionResults() {
		return repo.findAll();
		 
	}





}
