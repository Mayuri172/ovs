package com.cg.service;

import java.util.List;

import com.cg.entity.Nominations;


public interface NominationsService {

	public String addNominations(Nominations nominations);
	public String deleteNominations(Integer nominationNo);
	public List<Nominations> viewNominations();
}
