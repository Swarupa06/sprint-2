package com.spring.swagger.ovs;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.ovs.controllers.NominatedCandidatesController;

import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.exceptions.NominatedCandidateNotFoundException;
import com.spring.ovs.service.NominatedCandidatesService;


@ExtendWith(MockitoExtension.class)
public class NominatedCandidatesTest

{
    
	@Mock
	NominatedCandidatesService noServices;
	

	@InjectMocks
	NominatedCandidatesController noController;

	@Test
	public void testAddNominatedCandidatesDetails() 
	{
		NominatedCandidates candidate =new NominatedCandidates();
		int candidateId = 1;
		Mockito.when(noController.addNominatedCandidatesDetails(candidate)).thenReturn(candidateId);
		assertEquals(candidateId,noController.addNominatedCandidatesDetails(candidate));
	 }
	
	 @Test
	 public void testGetAllNominatedCandidates()
     {
	     List<NominatedCandidates> candidate=new ArrayList<NominatedCandidates>();
	     Mockito.when(noController.getAllNominatedCandidates()).thenReturn(candidate);
	     assertEquals(candidate,noController.getAllNominatedCandidates());

	  }
	 
	 @Test
	 public void testNominatedCandidatesById() throws NominatedCandidateNotFoundException
	 {
		 NominatedCandidates candidate=new NominatedCandidates();
		 int candidateId = 1;
		Mockito.when(noController.viewNominatedCandidatesById(candidateId)).thenReturn(candidate);
	     assertEquals(candidate,noController.viewNominatedCandidatesById(candidateId)); 
	 }
	 
	 @Test
	 public void testUpdateNominatedCandidatesDetails()throws NominatedCandidateNotFoundException
	 {
		 NominatedCandidates candidate=new NominatedCandidates();
		int candidateId = 1;
		Mockito.when(noController.updateNominatedCandidatesDetails(candidateId, candidate)).thenReturn(candidate);
		assertEquals(candidate,noController.updateNominatedCandidatesDetails(candidateId, candidate));

	 }
	 
	 @Test
	 public void testDeleteNominatedCandidates() throws NominatedCandidateNotFoundException
	 {
	 	
	 	int candidateId = 1;
		Mockito.when(noController.deleteNominatedCandidates(candidateId)).thenReturn(candidateId);
	 	assertEquals(candidateId,noController.deleteNominatedCandidates(candidateId));
	 	
	 }
}


