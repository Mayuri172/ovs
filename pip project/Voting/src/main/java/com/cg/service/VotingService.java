package com.cg.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.cg.entity.Voting;

public interface VotingService {

	public CompletableFuture<String> addVote(Voting voting);
	public List<Voting> getElectionResults();

}
