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


import com.spring.ovs.controllers.VotedListController;
import com.spring.ovs.dtos.VotedList;
import com.spring.ovs.exceptions.VoterNotFoundException;
import com.spring.ovs.service.VotedListService;

@ExtendWith(MockitoExtension.class)
public class VotedListTest{
    
	@Mock
	VotedListService voServices;
	

	@InjectMocks
	VotedListController voController;

	
	@Test
	public void testAddVotedListDetails() 
	{
		VotedList votedList =new VotedList();
		int id = 1;
		Mockito.when(voController.addVotedListDetails(votedList)).thenReturn(id);
		assertEquals(id,voController.addVotedListDetails(votedList));
	 }
	
	 @Test
	  public void testGetAllVotedList()
	 {
	        List<VotedList> votedList=new ArrayList<VotedList>();
	       Mockito.when(voController.getAllVotedList()).thenReturn(votedList);
	        assertEquals(votedList,voController.getAllVotedList());

	  }
	 
	 @Test
	 public void testviewVotedListById() throws VoterNotFoundException
	 {
		 VotedList votedList=new VotedList();
		 
		 int id = 1;
		Mockito.when(voController.viewVotedListById(id)).thenReturn(votedList);
	     assertEquals(votedList,voController.viewVotedListById(id));
	 }
	 
	 @Test
	 public void testupdateVotedListDetails()throws VoterNotFoundException
	 {
			VotedList votedList=new VotedList();
			int id=1;
			Mockito.when(voController.updateVotedListDetails(id, votedList)).thenReturn(votedList);
		    assertEquals(votedList,voController.updateVotedListDetails(id, votedList));
	 }
	 

	 @Test
	 public void testdeleteVotedList() throws VoterNotFoundException
	 {
	 	
	 	int id = 1;
		Mockito.when(voController.deleteVotedList(id)).thenReturn(id);
	 	assertEquals(id,voController.deleteVotedList(id));
	 	
	 }
}
