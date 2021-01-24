package com.cg;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cg.entity.Nominations;
import com.cg.repository.NominationsRepository;
import com.cg.service.NominationsService;
import com.cg.service.NominationsServiceImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@SpringBootTest
class NominationsApplicationTests {

	
	@MockBean
	NominationsRepository nominationsRepository;
	
	@InjectMocks
	NominationsServiceImpl nominationservice;
	
	Nominations nominations;
	Integer nominationNo;
	List<Nominations> list;
	
	@Test
	void contextLoads() {
	}

	

	
	@Test
	public void testAddNominations_Success() {
		//mock external calls
		Mockito.doReturn(nominations).when(nominationsRepository).saveAndFlush(Mockito.any(Nominations.class));
		 // invoke test method
		nominationservice.addNominations(nominations);
		
	}
	
	@Test
	public void testAddNominations_Failure() {
		Mockito.doThrow(new IllegalArgumentException()).when(nominationsRepository).saveAndFlush(Mockito.any(Nominations.class));
		nominationservice.addNominations(nominations);
	}
	
	@Test
	public void testDeleteNominations_Success() {
		Mockito.doNothing().when(nominationsRepository).deleteById(nominationNo);
		nominationservice.deleteNominations(nominationNo);
	}

	
	@Test
	public void testGetNominations_Success() {
		Mockito.doReturn(list).when(nominationsRepository).findAll();
		nominationservice.viewNominations();
	}
	/*
	@Test
	public void testDeleteNominations_Failure() {
		Mockito.doThrow(new IllegalArgumentException()).when(nominationsRepository).deleteById(nominationNo);
		nominationservice.deleteNominations(nominationNo);
	}
	
	@Test
	public void testGetNominations_Failure() {
		Mockito.doThrow(new NoSuchElementException()).when(nominationsRepository).findAll();
		nominationservice.viewNominations();
	}
	*/
}
