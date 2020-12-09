package com.spring.ovs.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.ovs.dtos.RegisteredSocietyVoters;
import com.spring.ovs.exceptions.VoterNotFoundException;
import com.spring.ovs.repository.RegisteredSocietyVotersRepository;

@Service
public class RegisteredSocietyVotersService 
{
	@Autowired
	RegisteredSocietyVotersRepository rsvRepo;
	
	
	 public RegisteredSocietyVoters voterRegistration(RegisteredSocietyVoters voter)throws VoterNotFoundException {
		 return rsvRepo.save(voter);
		}
	 
	 /*
	  * This method used for updating the voter details, if id is existing we can update the details.
	  */
	 public RegisteredSocietyVoters updateRegisteredSocietyVotersDetails(int voterId,RegisteredSocietyVoters voter)throws VoterNotFoundException {
	     Optional<RegisteredSocietyVoters> rsvVoter=rsvRepo.findById(voterId);
	     if(rsvVoter.isPresent()) {
	    	 RegisteredSocietyVoters voterToBeUpdated=rsvVoter.get();
	    	 voterToBeUpdated.setFirstName(voter.getFirstName());
	    	 voterToBeUpdated.setLastName(voter.getLastName());
	    	 voterToBeUpdated.setPassword(voter.getPassword());
	    	 voterToBeUpdated.setGender(voter.getGender());
	    	 voterToBeUpdated.setEmailId(voter.getEmailId());
	    	 voterToBeUpdated.setAddress1(voter.getAddress1());
	    	 voterToBeUpdated.setAddress2(voter.getAddress2());
	    	 voterToBeUpdated.setDistrict(voter.getDistrict());
	    	 voterToBeUpdated.setMandal(voter.getMandal());
	    	 voterToBeUpdated.setMobileno(voter.getMobileno());
	    	 voterToBeUpdated.setPincode(voter.getPincode());
	    	 voterToBeUpdated.setReservationCategory(voter.getReservationCategory());
	    	 voterToBeUpdated.setVoterId(voter.getVoterId());
	    	 voterToBeUpdated.setVoterIdCardNo(voter.getVoterIdCardNo());
	    	 voterToBeUpdated.setSociety(voter.getSociety());
	     
		 return rsvRepo.save(voterToBeUpdated);
	 	}
	     else {
	    	 throw new VoterNotFoundException("No voter present with the given id to update");
	     }
	 }
	  
	 /*
	  * this method is used for deleting the voter by id, if id is existing, we can delete the voter.
	  */
	 public int deleteRegisteredSocietyVoter(int voterId)throws VoterNotFoundException {
		 {
			 Optional<RegisteredSocietyVoters> rsvVoter=rsvRepo.findById(voterId);
			 if(rsvVoter.isPresent()) {
		       	rsvRepo.deleteById(voterId);
		       	System.out.println("Voter details are deleted successfully");
			 }
			 else {
				 throw new VoterNotFoundException("Enter valid id to get deleted");
			 }
			 return voterId;
		 }
		 }
	 
	 /*
	  * this method is to view the VoterList.
	  */
		 	
	public  List<RegisteredSocietyVoters> viewRegisteredVoterList(){
	 {
		System.out.println("RegisteredSocietyVoters...");
	return rsvRepo.findAll();
	 }
	}
	 
	/*
	 * This method is used to search for voter by Id,if  id exists, we can see the details of voter by searching with Id.
	 */
	 public RegisteredSocietyVoters searchByVoterID(int voterId)throws VoterNotFoundException{
		 Optional<RegisteredSocietyVoters> rsvVoter=rsvRepo.findById(voterId);
		 if(rsvVoter.isPresent()){
			 return rsvRepo.findById(voterId).get();
		 }
		 else{
			 throw new VoterNotFoundException("Enter valid id to search the voter details");
		 }
	}
}

