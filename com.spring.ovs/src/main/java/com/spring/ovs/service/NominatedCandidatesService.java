package com.spring.ovs.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.exceptions.NominatedCandidateNotFoundException;

import com.spring.ovs.repository.NominatedCandidatesRepository;



@Service
public class NominatedCandidatesService {

	@Autowired
	private NominatedCandidatesRepository nlRepo;
	
	
	/*
	 * This is the method for adding NominatedCandidates and if we give the existing ID and execute it then
	 * in ResponseBody it will show zero and in console it prints "The NominatedCandidates with Id already exists....Give another value".
	 */
	public int addNominatedCandidatesDetails(NominatedCandidates candidate)
	{
		if(nlRepo.existsById(candidate.getCandidateId()))
		{  
			System.out.println("The NominatedCandidates with Id already exists....Give another value");
		     return 0;
		}
		else
		{
		   return nlRepo.save(candidate).getCandidateId();
		}
			 
	}
	
	/*
	 * This is the method for Update NominatedCandidates and if we give the existing ID and execute it then
	 * in ResponseBody it will show zero and in console it prints "updated nominatedCandidates details successfully".
	 * 
	 * else if the given Id does not exist it will throw an Exception that
	 *  "No candidate present with the given Id to Update...Please enter valid Id to update".
	 */
	
    public NominatedCandidates updateNominatedCandidatesDetails(int candidateId, NominatedCandidates candidate) throws NominatedCandidateNotFoundException
    {

	      Optional<NominatedCandidates> repCandidate = nlRepo.findById(candidateId);

	        if (repCandidate.isPresent()) {

	        	NominatedCandidates candidateToBeUpdated = repCandidate.get();
		    candidateToBeUpdated.setNominationFormNo(candidate.getNominationFormNo());
		    candidateToBeUpdated.setSociety_Voter(candidate.getSociety_Voter());
		    
		    System.out.println("updated nominatedCandidates details successfully");
		    return nlRepo.save(candidateToBeUpdated);
	      }
	      else
	      {
				throw new NominatedCandidateNotFoundException("No candidate present with the given Id to Update...Please enter valid Id to update");

	      }
      }
    
    
    /*
	 * This is the method for delete NominatedCandidates and if we give the existing ID and execute it then
	 * in ResponseBody it will show id and in console it prints "candidate details are deleted Successfully"
	 * else if the given Id does not exist it will throw an Exception that "Enter valid Id to be deleted".
	 */
      
     public int deleteNominatedCandidates(int candidateId) throws NominatedCandidateNotFoundException
     {
    	 Optional<NominatedCandidates> repCandidate = nlRepo.findById(candidateId);
    		 
    	  if(repCandidate.isPresent())
    	   {
    	      nlRepo.deleteById(candidateId);
              System.out.println("candidate details are deleted Successfully");
    		}
    	    else
    		{
    		    throw new NominatedCandidateNotFoundException("Enter valid Id to be deleted");
    		}
		    return candidateId;
      }
    
     /*
  	 * This is the method for view NominatedCandidatesById and if we give the existing ID shows the Id details
  	 * 
  	 * else if the given Id does not exist it will throw an Exception that "Enter valid Id to view the candidate details".
  	 */
	 public NominatedCandidates viewNominatedCandidatesById(int candidateId) throws NominatedCandidateNotFoundException
	 {
	      Optional<NominatedCandidates> repCandidate = nlRepo.findById(candidateId);
	      
	      if(repCandidate.isPresent())
	      {
			 return repCandidate.get();
		  }
	      else
	      {
  		    throw new NominatedCandidateNotFoundException("Enter valid Id to view the candidate details"); 
	      }
		
	 }
	 /*
	    * This method is used to view the NominatedCandidates List
	 */
	 public List<NominatedCandidates> getAllNominatedCandidates()
	 {
	 
		System.out.println("NominatedCandidates...");
		return nlRepo.findAll();
	 }
}