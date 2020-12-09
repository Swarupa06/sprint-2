package com.spring.ovs.controllers;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ovs.dtos.CooperativeSociety;
import com.spring.ovs.exceptions.SocietyNotFoundException;
import com.spring.ovs.service.CooperativeSocietyService;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class CooperativeSocietyController{

	Logger log = LoggerFactory.getLogger(CooperativeSocietyController.class);
	
	@Autowired
	private CooperativeSocietyService csService;
	
	/*

	 * @Author      : Sirisha
	 * 
	 * @Method      : ListCooperativeSocieties()
	 * 
	 * @Return type : Void
	 * 
	 * @Parameter   : societyId
	 * 
	 * @Description : This method is used to view the CooperativeSocieties List.
	                  
	*/

@GetMapping("/society")
public @ResponseBody List<CooperativeSociety> getAllCooperativeSocieties() 
{ 
	
	List<CooperativeSociety> society = csService.getAllCooperativeSocieties();

	return society;
}


/*

 * @Author      : Sirisha
 * 
 * @Method      : viewSocietyById()
 * 
 * @Return type : Void
 * 
 * @Parameter   : societyId
 * 
 * @Description : This is the method for Find the existing CooperativeSociety  details, if you enter the existing ID CooperativeSociety  
                  details with that ID will be displayed 
                  else if the given ID does not exist it will throw an Exception that "Enter valid Id to view the Society details".
*/

@GetMapping("/society/{societyId}")
public @ResponseBody CooperativeSociety viewSocietyById(@PathVariable int societyId) throws SocietyNotFoundException 
{
	
	return csService.viewSocietyById(societyId);
}


/*

 * @Author      : Sirisha
 * 
 * @Method      : addSocietyDetails()
 * 
 * @Return type : integer
 * 
 * @Parameter   : societyId
 * 
 * @Description : This is the method for adding SocietyDetails and if we give the existing ID and execute it then
	  in ResponseBody it will show zero and in console it prints "The Result with this ID already exists...Give another value".
*/

@PostMapping("/society")
public @ResponseBody int addSocietyDetails(@RequestBody CooperativeSociety society) 
{
	return csService.addSocietyDetails(society);
}


/*

 * @Author      : Sirisha
 * 
 * @Method      : updateSocietyDetails()
 * 
 * @Return type : void
 * 
 * @Parameter   : societyId
 * 
 * @Description : This is the method for Update the existing CooperativeSociety details, if you enter the existing ID CooperativeSociety 
                  details with that ID will be Updated and in console it prints " society details are Updated Successfully"
                  else if the given ID does not exist it will throw an Exception that "No Society present with the given Id to Update...Please enter valid Id to update"
*/

@PutMapping("/society/{societyId}")
public @ResponseBody CooperativeSociety updateSocietyDetails(@PathVariable int societyId,@RequestBody CooperativeSociety society) throws SocietyNotFoundException 
{
	
	return csService.updateSocietyDetails(societyId,society);
}

/*

 * @Author      : Sirisha
 * 
 * @Method      : updateSocietyDetails()
 * 
 * @Return type : int
 * 
 * @Parameter   : societyId
 * 
 * @Description : This is the method for delete the existing CooperativeSociety details, if you enter the existing ID CooperativeSociety 
                  details with that ID will be Updated and in console it prints " society details are Deleted Successfully"
                  else if the given ID does not exist it will throw an Exception that "No Society present with the given Id to Update...Please enter valid Id to delete"
*/


@DeleteMapping("/society/{societyId}")
public @ResponseBody int deleteSociety(@PathVariable int societyId) throws SocietyNotFoundException 
{
	return csService.deleteSociety(societyId);
}


}




