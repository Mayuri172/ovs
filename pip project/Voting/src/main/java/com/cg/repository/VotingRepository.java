package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Voting;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Integer> {

	
	//public Integer noOfVotes(Integer nominationNo);
	//@Query(select nominationNo from voting )
	//public Boolean findByNominationNo(Integer nominationNo);
}
