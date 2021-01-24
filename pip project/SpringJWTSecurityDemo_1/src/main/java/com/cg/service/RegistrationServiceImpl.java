package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.cg.config.WebSecurityConfig;
import com.cg.entity.User;
import com.cg.entity.Voter;
import com.cg.repo.UserRepository;
import com.cg.repo.RegistrationRepo;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	UserRepository repo;

	@Autowired
	RegistrationRepo registrationRepo;
	
	@Autowired
	WebSecurityConfig config;
	
	public User getUserByName(String userName) {
		try {
			return repo.findByUserName(userName).get();
		}
		catch(IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}
	
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	
	@Override
	public String registerVoter(Voter voter) {
		
		
		Integer aadhar = voter.getAadharNo();
		String username =voter.getUserName();
		String password = voter.getPassword();
		
		String pass = hashPassword(password);
		
		voter.setPassword(pass);
		
		if(registrationRepo.existsByAadharNo(aadhar)) {
			return "Voter with aadhar no already registered";
		}
		else {
			if(registrationRepo.existsByUserName(username)) {
				return "Username already in use. Choose a new one.";
			}
			else {
				registrationRepo.saveAndFlush(voter);
				User user = new User(voter.getVoterId(), username, pass, true, "ROLE_USER");
				repo.saveAndFlush(user);
				return "Registration successful";
			}

		}
			
	}

	@Override
	public String updateVoterDetails(Voter voter) {
		try {
			registrationRepo.save(voter);
			System.out.println(voter);
			return "Updated successfully";
		}
		catch(IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public List<Voter> votersList() {
		System.out.println("inside service");
		return registrationRepo.findAll();
	}
	
	
}
