package com.spring.ovs.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.VotedList;
import com.spring.ovs.exceptions.VoterNotFoundException;

import com.spring.ovs.repository.VotedListRepository;




@Service
public class VotedListService {

	@Autowired
	private VotedListRepository vlRepo;
	
	/*
	 * This is the method for adding VotedList and if we give the existing ID and execute it then
	 * in ResponseBody it will show zero and in console it prints "The VotedList with Id already exists....Give another value".
	 */

	public int addVotedListDetails(VotedList votedList)
	{
		if(vlRepo.existsById(votedList.getId()))
		{
			System.out.println("The VotedList with Id already exists....Give another value");
		     return 0;
		}
		else
		{
		   return vlRepo.save(votedList).getId();
		}
			 
	}
	 
	
	/*
	    * This method is used to view the VotedList List. 
	 */
	
	public List<VotedList> getVotedList()
	 {
	 
		System.out.println("VotedList...");
		return vlRepo.findAll();
	 }
	
	
	/*
	 * This is the method for Update VotedListDetails and if we give the existing ID and execute it then
	 * in ResponseBody it will show zero and in console it prints "updated votedlist details successfully".
	 * 
	 * else if the given Id does not exist it will throw an Exception that
	 *  "No votedList present with the given Id to Update...Please enter valid Id to update".
	 */
    public VotedList updateVotedListDetails(int id, VotedList votedList) throws VoterNotFoundException
    {

	      Optional<VotedList> repvotedList = vlRepo.findById(id);

	        if (repvotedList.isPresent()) {

	        	VotedList votedListToBeUpdated = repvotedList.get();
		    votedListToBeUpdated.setId(votedList.getId());
		    votedListToBeUpdated.setPollingDateTime(votedList.getPollingDateTime());
		    votedListToBeUpdated.setSociety(votedList.getSociety());
		    votedListToBeUpdated.setVoter(votedList.getVoter());
		    votedListToBeUpdated.setCandidate(votedList.getCandidate());
		    
		   System.out.println("updated votedlist details successfully");
		    return vlRepo.save(votedListToBeUpdated);
	      }
	      else
	      {
				throw new VoterNotFoundException("No votedList present with the given Id to Update...Please enter valid Id to update");

	      }
      }
      
    /*
	 * This is the method for delete VotedList and if we give the existing ID and execute it then
	 * in ResponseBody it will show id and in console it prints "VotedList details are deleted Successfully"
	 * else if the given Id does not exist it will throw an Exception that "Enter valid Id to be deleted".
	 */
     public int deleteVotedList(int id) throws VoterNotFoundException
     {
    	 Optional<VotedList> repvotedList = vlRepo.findById(id);
    		 
    	  if(repvotedList.isPresent())
    	   {
    	      vlRepo.deleteById(id);
              System.out.println("VotedList details are deleted Successfully");
    		}
    	    else
    		{
    		    throw new VoterNotFoundException("Enter valid Id to be deleted");
    		}
		    return id;
      }
     
     /*
 	 * This is the method for view VotedListById and if we give the existing ID shows the Id details
 	 * 
 	 * else if the given Id does not exist it will throw an Exception that "Enter valid Id to view the votedlist details".
 	 */
    
	 public VotedList viewVotedListById(int id) throws VoterNotFoundException
	 {
	      Optional<VotedList> repvotedList = vlRepo.findById(id);
	      
	      if(repvotedList.isPresent())
	      {
			 return repvotedList.get();
		  }
	      else
	      {
  		    throw new VoterNotFoundException("Enter valid Id to view the votedlist details"); 
	      }
		
	 }
	 
	
}

