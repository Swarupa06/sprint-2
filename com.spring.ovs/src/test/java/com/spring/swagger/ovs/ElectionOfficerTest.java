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

import com.spring.ovs.controllers.ElectionOfficerController;
import com.spring.ovs.dtos.ElectionOfficer;
import com.spring.ovs.service.ElectionOfficerService;
import com.spring.ovs.exceptions.ElectionOfficerNotFoundException;




@ExtendWith(MockitoExtension.class)
public class ElectionOfficerTest
{
    
	@Mock
	ElectionOfficerService eoService;
	

	@InjectMocks
	ElectionOfficerController eoController;

	@Test
	public void testAddElectionOfficerDetails() 
	{
		 ElectionOfficer officer =new ElectionOfficer();
		int officerId = 1;
		Mockito.when(eoService.addElectionOfficerDetails(officer)).thenReturn(officerId);
		assertEquals(officerId,eoController.addElectionOfficerDetails(officer));
	 }
	
	 @Test
	 public void testGetAllElectionOfficers()
     {
	     List<ElectionOfficer> officer=new ArrayList<ElectionOfficer>();
	     Mockito.when(eoService.getAllElectionOfficers()).thenReturn(officer);
	     assertEquals(officer,eoController.getAllElectionOfficers());

	  }
	 
	 @Test
	 public void testElectionOfficerById() throws ElectionOfficerNotFoundException
	 {
		 ElectionOfficer officer=new ElectionOfficer();
		 int officerId = 1;
		Mockito.when(eoService.viewElectionOfficerById(officerId)).thenReturn(officer);
	     assertEquals(officer,eoController.viewElectionOfficerById(officerId)); 
	 }
	 
	 @Test
	 public void testUpdateElectionOfficerDetails()throws ElectionOfficerNotFoundException
	 {
		 ElectionOfficer officer=new ElectionOfficer();
		int officerId = 1;
		Mockito.when(eoService.updateElectionOfficerDetails(officerId, officer)).thenReturn(officer);
		assertEquals(officer,eoController.updateElectionOfficerDetails(officerId, officer));

	 }
	 
	 @Test
	 public void testDeleteElectionOfficer() throws ElectionOfficerNotFoundException
	 {
	 	
	 	int officerId = 1;
		Mockito.when(eoService.deleteElectionOfficer(officerId)).thenReturn(officerId);
	 	assertEquals(officerId,eoController.deleteElectionOfficer(officerId));
	 	
	 }
}





