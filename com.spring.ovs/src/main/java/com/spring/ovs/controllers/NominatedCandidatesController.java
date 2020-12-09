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

import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.exceptions.NominatedCandidateNotFoundException;
import com.spring.ovs.service.NominatedCandidatesService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

public class NominatedCandidatesController{

	Logger log = LoggerFactory.getLogger(ElectionOfficerController.class);
	
	@Autowired
	private NominatedCandidatesService noService;
	
	/*

	 * @Author      : Satya
	 * 
	 * @Method      : ListNominatedCandidates()
	 * 
	 * @Return type : NominatedCandidates
	 * 
	 * @Parameter   : candidateId
	 * 
	 * @Description : This method is used to view the NominatedCandidates List, and it will be displayed in console like NominatedCandidates....
	                  
	*/

@GetMapping("/candidate" )
public @ResponseBody List<NominatedCandidates> getAllNominatedCandidates() 
{ 
	
	List<NominatedCandidates> candidate = noService.getAllNominatedCandidates();

	return candidate;
}


/*

 * @Author      : Satya
 * 
 * @Method      : viewNominatedCandidatesById()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : candidateId
 * 
 * @Description : This is the method for view the existing NominatedcandidatesById details, if you enter the existing ID NominatedCandidates 
                  details with that ID will be displayed 
                  else if the given ID does not exist it will throw an Exception that "Enter valid Id to view the NominatedCandidates details".
*/
@GetMapping("/candidate/{candidateId}")
public @ResponseBody  NominatedCandidates viewNominatedCandidatesById(@PathVariable int candidateId) throws NominatedCandidateNotFoundException 
{
	
	return noService.viewNominatedCandidatesById(candidateId);
}

/*

 * @Author      : Satya
 * 
 * @Method      : addNominatedCandidates()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : candidate
 * 
 * @Description : This is the method for adding the existing NominatedCandidates details, if you enter the existing ID NominatedCandidates 
                  details with that ID will be adding and in console it prints "NominatedCandidates details are added Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be added".
*/

@PostMapping("/candidate")
public @ResponseBody int addNominatedCandidatesDetails(@RequestBody NominatedCandidates candidate) 
{
	return noService.addNominatedCandidatesDetails(candidate);
}


/*

 * @Author      : Satya
 * 
 * @Method      : updateNominatedCandidates()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : candidateId
 * 
 * @Description : This is the method for updating the existing NominatedCandidates details, if you enter the existing candidateID NominatedCandidates 
                  details with that candidateID will be deleted and in console it prints "NominatedCandidates details are updated Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be updated".
*/
@PutMapping("/candidate/{candidateId}")
public @ResponseBody NominatedCandidates updateNominatedCandidatesDetails(@PathVariable int candidateId,@RequestBody NominatedCandidates candidate) throws NominatedCandidateNotFoundException 
{
	
	return noService.updateNominatedCandidatesDetails(candidateId,candidate);
}

/*

 * @Author      : Satya
 * 
 * @Method      : deleteNominatedCandidates()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : candidateId
 * 
 * @Description : This is the method for deleting the existing NominatedCandidates details, if you enter the existing ID NominatedCandidates 
                  details with that ID will be deleted and in console it prints "NominatedCandidates details are deleted Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be deleted".
*/

@DeleteMapping("/candidate/{candidateId}")
public @ResponseBody int deleteNominatedCandidates(@PathVariable int candidateId) throws NominatedCandidateNotFoundException 
{
	return noService.deleteNominatedCandidates(candidateId);
}


}