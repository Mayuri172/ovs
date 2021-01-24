package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Voter;

@Repository
public interface RegistrationRepo extends JpaRepository<Voter, Integer> {

	public boolean existsByAadharNo(Integer aadharNo); 
	public boolean existsByUserName(String userName); 
}
