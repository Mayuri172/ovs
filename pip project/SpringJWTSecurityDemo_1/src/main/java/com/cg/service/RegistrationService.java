package com.cg.service;

import java.util.List;

import com.cg.entity.Voter;


public interface RegistrationService {

	public String registerVoter(Voter voter);
	
	public String updateVoterDetails(Voter voter);
	public List<Voter> votersList();
}
