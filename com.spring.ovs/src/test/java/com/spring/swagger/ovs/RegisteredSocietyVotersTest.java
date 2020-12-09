package com.spring.swagger.ovs;

import static org.junit.Assert.assertEquals;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.ovs.controllers.RegisteredSocietyVotersController;
import com.spring.ovs.dtos.RegisteredSocietyVoters;
import com.spring.ovs.exceptions.VoterNotFoundException;
import com.spring.ovs.service.RegisteredSocietyVotersService;

@ExtendWith(MockitoExtension.class)
 public class RegisteredSocietyVotersTest {
@Mock
RegisteredSocietyVotersService rsvService;
@InjectMocks
RegisteredSocietyVotersController rsvController;

@Test
public  void voterRegistration() throws VoterNotFoundException
{
	RegisteredSocietyVoters voter=new RegisteredSocietyVoters();
	Mockito.when(rsvController.voterRegistration(voter)).thenReturn(voter);
	assertEquals(voter,rsvController.voterRegistration(voter));
}

@Test
public void testupdateRegisteredSocietyVotersDetails()throws VoterNotFoundException
{
	RegisteredSocietyVoters voter=new RegisteredSocietyVoters();
	int voterId=1;
	Mockito.when(rsvController.updateRegisteredSocietyVotersDetails(voterId, voter)).thenReturn(voter);
assertEquals(voter,rsvController.updateRegisteredSocietyVotersDetails(voterId, voter));

}

@Test
public void testdeleteRegisteredSocietyVoter()throws VoterNotFoundException
{
	
	int voterId=1;
	Mockito.when(rsvController.deleteRegisteredSocietyVoter(voterId)).thenReturn(voterId);
	assertEquals(voterId,rsvController.deleteRegisteredSocietyVoter(voterId));
	
}

@Test
public void testviewRegisteredVoterList()
{
	List<RegisteredSocietyVoters> voter =new ArrayList<RegisteredSocietyVoters>();
	Mockito.when(rsvController.viewRegisteredVoterList()).thenReturn(voter);
	assertEquals(voter,rsvController.viewRegisteredVoterList());
}

@Test
public void testsearchByVoterID()throws VoterNotFoundException
{
	RegisteredSocietyVoters voter=new RegisteredSocietyVoters();
	int voterId=1;
	Mockito.when(rsvController.searchByVoterID(voterId)).thenReturn(voter);
	assertEquals(voter,rsvController.searchByVoterID(voterId));
	
}

}
