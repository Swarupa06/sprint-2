package com.spring.ovs.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ovs.dtos.VotedList;
import com.spring.ovs.exceptions.VoterNotFoundException;
import com.spring.ovs.service.VotedListService;



@Controller
@RequestMapping("/ovs")
public class VotedListController{

	Logger log = LoggerFactory.getLogger(VotedListController.class);
	
	@Autowired
	private VotedListService voService;
	

	/*

	 * @Author      : Satya
	 * 
	 * @Method      : ListVotedList()
	 * 
	 * @Return type : VotedList
	 * 
	 * @Parameter   : votedList
	 * 
	 * @Description : This method is used to view the VotedList List, and it will be displayed in console like VotedLists....
	                  
	*/

@GetMapping(value = {"/" })
public @ResponseBody List<VotedList> getAllVotedList() 
{ 
	
	List<VotedList> votedList = voService.getVotedList();

	return votedList;
}



/*

 * @Author      : Satya
 * 
 * @Method      : viewVotedListById()
 * 
 * @Return type : Void
 * 
 * @Parameter   : id
 * 
 * @Description : This is the method for view the existing VotedListById details, if you enter the existing ID NominatedCandidates 
                  details with that ID will be displayed 
                  else if the given ID does not exist it will throw an Exception that "Enter valid Id to view the VotedList details".
*/
@GetMapping("/{id}")
public @ResponseBody  VotedList viewVotedListById(@PathVariable int id) throws VoterNotFoundException 
{
	
	return voService.viewVotedListById(id);
}


/*

 * @Author      : Satya
 * 
 * @Method      : addVotedList()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : votedList
 * 
 * @Description : This is the method for adding the existing NominatedCandidates details, if you enter the existing ID VotedList 
                  details with that ID will be adding and in console it prints "VotedList details are added Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be added".
*/
@PostMapping("/")
public @ResponseBody int addVotedListDetails(@RequestBody VotedList votedList) 
{
	return voService.addVotedListDetails(votedList);
}




/*

 * @Author      : Satya
 * 
 * @Method      : updateVotedList()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : id
 * 
 * @Description : This is the method for updating the existing VotedList details, if you enter the existing id VotedList 
                  details with that candidateID will be deleted and in console it prints "VotedList details are updated Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be updated".
*/
@PutMapping("/{id}")
public @ResponseBody VotedList updateVotedListDetails(@PathVariable int id,@RequestBody VotedList votedList) throws VoterNotFoundException 
{
	
	return voService.updateVotedListDetails(id,votedList);
}


/*

 * @Author      : Satya
 * 
 * @Method      : deleteVotedList()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : id
 * 
 * @Description : This is the method for deleting the existing VotedList details, if you enter the existing ID VotedList 
                  details with that ID will be deleted and in console it prints "VotedLists details are deleted Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be deleted".
*/


@DeleteMapping("/{id}")
public @ResponseBody int deleteVotedList(@PathVariable int id) throws VoterNotFoundException 
{
	return voService.deleteVotedList(id);
}


}
