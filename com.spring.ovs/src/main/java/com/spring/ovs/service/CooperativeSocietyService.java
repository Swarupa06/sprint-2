package com.spring.ovs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.CooperativeSociety;
import com.spring.ovs.exceptions.SocietyNotFoundException;
import com.spring.ovs.repository.CooperativeSocietyRepository;



@Service//class that provides business services.
public class CooperativeSocietyService {

	@Autowired
	private CooperativeSocietyRepository csRepository;

	/*
	  * This is the method for adding SocietyDetails and if we give the existing ID and execute it then
	  * in ResponseBody it will show zero and in console it prints "The Result with this ID already exists...Give another value".
	*/

	public int addSocietyDetails(CooperativeSociety society)
	{
		if(csRepository.existsById(society.getSocietyId()))
		{
		     return 0;
		}
		else
		{
		   return csRepository.save(society).getSocietyId();
		}
			 
	}
	/*
	 * This Method is used to update the CooperativeSociety details
	 */
	
    public CooperativeSociety updateSocietyDetails(int societyId,CooperativeSociety  society) throws SocietyNotFoundException
    {

	      Optional<CooperativeSociety> repSociety = csRepository.findById(societyId);

	        if (repSociety.isPresent()) {

	        	CooperativeSociety societyToBeUpdated = repSociety.get();
	        	societyToBeUpdated.setSocietyName(society.getSocietyName());
	        	societyToBeUpdated.setHeadOfSociety(society.getHeadOfSociety());
	        	societyToBeUpdated.setVillage(society.getVillage());
	        	societyToBeUpdated.setMandal(society.getMandal());
	        	
	        	societyToBeUpdated.setDistrict(society.getDistrict());
	        	societyToBeUpdated.setPincode(society.getPincode());
		 
		    return csRepository.save(societyToBeUpdated);
	      }
	      else
	      {
				throw new SocietyNotFoundException("No Society present with the given Id to Update...Please enter valid Id to update");

	      }
      }
    /*
	 * This Method is used to Delete the CooperativeSociety details with societyId
	 */
      
     public int deleteSociety(int societyId) throws SocietyNotFoundException
     {
    	 Optional<CooperativeSociety> repSociety = csRepository.findById(societyId);
    		 
    	  if(repSociety.isPresent())
    	   {
    	      csRepository.deleteById(societyId);
              System.out.println("Society details are deleted Successfully");
    		}
    	    else
    		{
    		    throw new SocietyNotFoundException("Enter valid Id to be deleted");
    		}
		    return societyId;
      }
     /*
 	 * This Method is used to viewSociety details of CooperativeSociety with respective societyId
 	 */
    
	 public CooperativeSociety viewSocietyById(int societyId) throws SocietyNotFoundException
	 {
	      Optional<CooperativeSociety> repSociety = csRepository.findById(societyId);
	      
	      if(repSociety.isPresent())
	      {
			 return repSociety.get();
		  }
	      else
	      {
  		    throw new SocietyNotFoundException("Enter valid Id to view the Society details"); 
	      }
		
	 }

	 /*
	    * This method is used to view the CooperativeSociety List. 
	 */
	 
	 
	 public List<CooperativeSociety> getAllCooperativeSocieties()
	 {
	 
		System.out.println("Cooperative Societies...");
		return csRepository.findAll();
	 }
}


