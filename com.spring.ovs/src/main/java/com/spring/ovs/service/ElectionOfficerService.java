package com.spring.ovs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.ElectionOfficer;
import com.spring.ovs.repository.ElectionOfficerRepository;
import com.spring.ovs.exceptions.ElectionOfficerNotFoundException;


@Service
public class ElectionOfficerService {

	@Autowired
	private ElectionOfficerRepository elRepo;
	
	
	/*
	  * This is the method for adding Election officer details.
	 */

	public int addElectionOfficerDetails(ElectionOfficer officer)
	{
		if(elRepo.existsById(officer.getOfficerId()))
		{
			System.out.println("The Officer with this Id already exists...Give another value");
		     return 0;
		}
		else
		{
		   return elRepo.save(officer).getOfficerId();
		}
			 
	}
	
	
	 /*
	   * This is the method for Updating the existing Election officer details. 
	 */
	
	
    public ElectionOfficer updateElectionOfficerDetails(int officerId, ElectionOfficer officer) throws ElectionOfficerNotFoundException
    {

	      Optional<ElectionOfficer> repOfficer = elRepo.findById(officerId);

	        if (repOfficer.isPresent()) {

		    ElectionOfficer officerToBeUpdated = repOfficer.get();
		    officerToBeUpdated.setFirstName(officer.getFirstName());
		    officerToBeUpdated.setLastName(officer.getLastName());
		    officerToBeUpdated.setPassword(officer.getPassword());
		    officerToBeUpdated.setGender(officer.getGender());
		    officerToBeUpdated.setMobileno(officer.getMobileno());
		    officerToBeUpdated.setEmailId(officer.getEmailId());
		    officerToBeUpdated.setAddress1(officer.getAddress1());
		    officerToBeUpdated.setAddress2(officer.getAddress2());
		    officerToBeUpdated.setDistrict(officer.getDistrict());
		    officerToBeUpdated.setPincode(officer.getPincode());
		 
		    return elRepo.save(officerToBeUpdated);
	      }
	      else
	      {
				throw new ElectionOfficerNotFoundException("No Officer present with the given Id to Update...Please enter valid Id to update");

	      }
      }
    
      
     /*
        * This is the method for deleting the existing Election officer details.
     */
    
    
     public int deleteElectionOfficer(int officerId) throws ElectionOfficerNotFoundException
     {
    	 Optional<ElectionOfficer> repOfficer = elRepo.findById(officerId);
    		 
    	  if(repOfficer.isPresent())
    	   {
    	      elRepo.deleteById(officerId);
              System.out.println("Officer details are deleted Successfully");
    		}
    	    else
    		{
    		    throw new ElectionOfficerNotFoundException("Enter valid Id to be deleted");
    		}
		    return officerId;
      }
     
     /*
        * This method is used to view the particular Election officer details with the entered ID.
      */
    
	 public ElectionOfficer viewElectionOfficerById(int officerId) throws ElectionOfficerNotFoundException
	 {
	      Optional<ElectionOfficer> repOfficer = elRepo.findById(officerId);
	      
	      if(repOfficer.isPresent())
	      {
			 return repOfficer.get();
		  }
	      else
	      {
  		    throw new ElectionOfficerNotFoundException("Enter valid Id to view the Officer details"); 
	      }
		
	 }
	 
	 /*
	    * This method is used to get all the existing Election officers Details.
	  */
	 
	 public List<ElectionOfficer> getAllElectionOfficers()
	 {
	 
		System.out.println("Election Officers...");
		return elRepo.findAll();
	 }
}
