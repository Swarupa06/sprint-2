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

import com.spring.ovs.controllers.CooperativeSocietyController;
import com.spring.ovs.dtos.CooperativeSociety;
import com.spring.ovs.exceptions.SocietyNotFoundException;
import com.spring.ovs.service.CooperativeSocietyService;





@ExtendWith(MockitoExtension.class)
public class CooperativeSocietyTest
{
    
	@Mock
	CooperativeSocietyService csServices;
	

	@InjectMocks
	CooperativeSocietyController csController;

	@Test
	public void testAddElectionOfficerDetails() 
	{
		CooperativeSociety society =new CooperativeSociety();
		int societyId = 1;
		Mockito.when(csController.addSocietyDetails(society)).thenReturn(societyId);
		assertEquals(societyId,csController.addSocietyDetails(society));
	 }
	
	 @Test
	 public void testGetAllCooperativeSocieties()
     {
	     List<CooperativeSociety> society=new ArrayList<CooperativeSociety>();
	     Mockito.when(csController.getAllCooperativeSocieties()).thenReturn(society);
	     assertEquals(society,csController.getAllCooperativeSocieties());

	  }
	 
	 @Test
	 public void testfindSocietyById() throws SocietyNotFoundException
	 {
		 CooperativeSociety society=new CooperativeSociety();
		 int societyId = 1;
		Mockito.when(csController.viewSocietyById(societyId)).thenReturn(society);
	     assertEquals(society,csController.viewSocietyById(societyId)); 
	 }
	 
	 @Test
	 public void testUpdateSocietyDetails()throws SocietyNotFoundException
	 {
		 CooperativeSociety society=new CooperativeSociety();
		int societyId = 1;
		Mockito.when(csController.updateSocietyDetails(societyId, society)).thenReturn(society);
		assertEquals(society,csController.updateSocietyDetails(societyId, society));

	 }
	 
	 @Test
	 public void testDeleteSociety() throws SocietyNotFoundException
	 {
	 	
	 	int societyId = 1;
		Mockito.when(csController.deleteSociety(societyId)).thenReturn(societyId);
	 	assertEquals(societyId,csController.deleteSociety(societyId));
	 	
	 }
}





