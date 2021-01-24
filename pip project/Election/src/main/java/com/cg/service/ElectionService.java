package com.cg.service;

import java.util.List;

import com.cg.entity.Election;

public interface ElectionService {
	public String addElection(Election election);
	public String deleteElection(Integer EventNo);
	public String updateElection(Election election);
	public List<Election> viewElections();
	public Election getElectionById(Integer areaCode);
}
