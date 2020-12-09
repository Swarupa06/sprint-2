package com.spring.ovs.controllers;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.ovs.dtos.RegisteredSocietyVoters;

import com.spring.ovs.exceptions.VoterNotFoundException;
import com.spring.ovs.service.RegisteredSocietyVotersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegisteredSocietyVotersController
{
 
   Logger log = LoggerFactory.getLogger(RegisteredSocietyVotersController.class);
	
	@Autowired
	private RegisteredSocietyVotersService rsvService;
	
	@PostMapping("/reg_society")
    public @ResponseBody RegisteredSocietyVoters voterRegistration(@RequestBody RegisteredSocietyVoters voter) throws VoterNotFoundException 
{
return rsvService.voterRegistration(voter);
}

    @PutMapping("/reg_society/{voterId}")
    /*
     * @Author:Gowthami
     * 
     * @Method:updateVoterDetails()
     * 
     * Return type:integer
     * 
     * @Parameter: voter,voterId
     * 
     * @description: This method allows to update the voter details if you enter existing Id,that Id will be updated or if the given Id doesnot exist, it will throw an exception "No voter present to update".
     */
    public @ResponseBody RegisteredSocietyVoters updateRegisteredSocietyVotersDetails(@PathVariable("voterId") int voterId,RegisteredSocietyVoters voter) throws VoterNotFoundException 
    {
    	
    	return rsvService.updateRegisteredSocietyVotersDetails(voterId, voter);
    }
    
    @DeleteMapping("/reg_society/{voterId}")
    /*
     * @Author:Gowthami
     * 
     * @Method:deleteVoter()
     * 
     * Return type:integer
     * 
     * @Parameter: voterId
     * 
     * @description: This method allows to delete the voter  if you enter existing Id,that Id will be deleted or if the given Id does not exist, it will throw an exception "Enter valid id to delete".
     */
    public @ResponseBody int deleteRegisteredSocietyVoter(@PathVariable("voterId") int voterId) throws VoterNotFoundException 
    {
	  return rsvService.deleteRegisteredSocietyVoter(voterId);
    }
    
    @GetMapping("/reg_society" )
    /*
     * @Author:Gowthami
     * 
     * @Method:viewRegisteredVoterList()
     * 
     * Return type:List
     * 
     * @Parameter: list
     * 
     * @description: This method allows to view the voter details if you enter existing voter,that voter details will be visible.
     */
    public @ResponseBody List<RegisteredSocietyVoters> viewRegisteredVoterList() 
    { 
    	return rsvService.viewRegisteredVoterList();
    }
    
    @GetMapping("/reg_society/{voterId}")
    /*
     * @Author:Gowthami
     * 
     * @Method:searchByVoterID()
     * 
     * Return type:integer
     * 
     * @Parameter: voterId
     * 
     * @description: This method allows to search the voter id ,if you enter existing Id,that voter details can be viewed or if the given Id doesnot exist, it will throw an exception "Enter valid id to search the voter details".
     */
    public @ResponseBody RegisteredSocietyVoters searchByVoterID(@PathVariable("voterId") int voterId) throws VoterNotFoundException 
    {
    	
	   return rsvService.searchByVoterID(voterId);
	  
    }
    
    }




