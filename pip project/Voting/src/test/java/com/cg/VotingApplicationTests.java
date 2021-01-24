package com.cg;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Voting;
import com.cg.repository.VotingRepository;
import com.cg.service.VotingServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
class VotingApplicationTests {

	@MockBean
	VotingRepository votingrepo;
	
	@InjectMocks
	VotingServiceImpl votingService;
	
	Voting voting;
	List<Voting> list;
	boolean b;
	Integer id;
	@Test
	void contextLoads() {
	}
	

	/*
	@Test
	public void testAddVoting_Success() {
		//mock external calls
		Mockito.doReturn(b).when(votingrepo).existsById(id);
		Mockito.doReturn(voting).when(votingrepo).findById(id);
		Mockito.doReturn(voting).when(votingrepo).saveAndFlush(Mockito.any(Voting.class));
		Mockito.doReturn(voting).when(votingrepo).save(Mockito.any(Voting.class));
		 // invoke test method
		votingService.addVote(voting);
		
	}
	*/
	/*
	@Test
	public void testAddVoting_Failure() {
		Mockito.doThrow(new IllegalArgumentException()).when(votingrepo).saveAndFlush(Mockito.any(Voting.class));
		votingService.addVote(voting);
	}
	*/
	

	
	@Test
	public void testGetElectionResult_Success() {
		Mockito.doReturn(list).when(votingrepo).findAll();
		votingService.getElectionResults();
	}
	/*
	@Test
	public void testDeleteElection_Failure() {
		Mockito.doThrow(new IllegalArgumentException()).when(electionRepo).deleteById(areaCode);
		electionService.deleteElection(areaCode);
	}
	
	
	}
	*/

}
