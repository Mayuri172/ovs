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

import com.cg.entity.Election;
import com.cg.repository.ElectionRepository;
import com.cg.service.ElectionServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
class ElectionApplicationTests {

	@MockBean
	ElectionRepository electionRepo;
	
	@InjectMocks
	ElectionServiceImpl electionService;
	
	Election election;
	Integer areaCode;
	List<Election> list;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testUpdateElection_Success() {
		//mock external calls
		Mockito.doReturn(election).when(electionRepo).save(Mockito.any(Election.class));
		 // invoke test method
		electionService.updateElection(election);
	}
	
	@Test
	public void testUpdateElection_Failure() {
		Mockito.doThrow(new IllegalArgumentException()).when(electionRepo).save(Mockito.any(Election.class));
		electionService.updateElection(election);	
	}
	
	@Test
	public void testAddElection_Success() {
		//mock external calls
		Mockito.doReturn(election).when(electionRepo).saveAndFlush(Mockito.any(Election.class));
		 // invoke test method
		electionService.addElection(election);
		
	}
	
	@Test
	public void testAddElection_Failure() {
		Mockito.doThrow(new IllegalArgumentException()).when(electionRepo).saveAndFlush(Mockito.any(Election.class));
		electionService.addElection(election);
	}
	
	@Test
	public void testDeleteElection_Success() {
		Mockito.doNothing().when(electionRepo).deleteById(areaCode);
		electionService.deleteElection(areaCode);
	}

	
	@Test
	public void testGetElection_Success() {
		Mockito.doReturn(list).when(electionRepo).findAll();
		electionService.viewElections();
	}
	/*
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteElection_Failure() {
		Mockito.doThrow(new IllegalArgumentException()).when(electionRepo).deleteById(areaCode);
		electionService.deleteElection(areaCode);
	}
	*/
	@Test
	public void testGetElection_Failure() {
		Mockito.doReturn(null).when(electionRepo).findAll();
		electionService.viewElections();
	}
	
}
