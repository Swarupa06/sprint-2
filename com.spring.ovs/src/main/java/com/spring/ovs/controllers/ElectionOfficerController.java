package com.spring.ovs.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.spring.ovs.dtos.ElectionOfficer;
import com.spring.ovs.service.ElectionOfficerService;
import com.spring.ovs.exceptions.ElectionOfficerNotFoundException;
@CrossOrigin(origins = "http://localhost:3000")
//connect from postman as http://localhost:8080/officer/
@Controller
public class ElectionOfficerController
{
      
	  /*A Logger object is used to log messages for a specific system or application component.
	   *Loggers are normally named,using a hierarchical dot-separated namespace.
       */
	
	  Logger log = LoggerFactory.getLogger(ElectionOfficerController.class);
	
	  
	  @Autowired    //enables you to inject the object dependency implicitly. It internally uses setter injection.
	  private ElectionOfficerService eoService;
	
	
     /*
        * @Author      : Swarupa
        * 
        * @Method      : getAllElectionOfficers() 
        * 
        * @Return type : ElectionOfficer
        * 
        * @Description : This method is used to get all the existing Election officers Details.
     */

	
	  @GetMapping("/officer" )
      public @ResponseBody List<ElectionOfficer> getAllElectionOfficers() 
      { 
	
	    List<ElectionOfficer> officer = eoService.getAllElectionOfficers();

	    return officer;
      }
    
    
     /*
        * @Author      : Swarupa
        * 
        * @Method      : viewElectionOfficerById()
        * 
        * @Parameter   : officerId
        * 
        * @Return type : ElectionOfficer
        * 
        * @Description : This method is used to view the particular Election officer details with the entered ID.
     */

    
	 @GetMapping("/officer/{officerId}")
     public @ResponseBody  ElectionOfficer viewElectionOfficerById(@PathVariable int officerId) throws ElectionOfficerNotFoundException 
     {
	
	    return eoService.viewElectionOfficerById(officerId);
     }
     
     
     /*
        * @Author      : Swarupa
        * 
        * @Method      : addElectionOfficerDetails()
        * 
        * @Parameter   : officerId
        * 
        * @Return type : Integer
        * 
        * @Description : This is the method for adding Election officer details.
      */


    
	 @PostMapping("/officer")
     public @ResponseBody int addElectionOfficerDetails(@RequestBody @Valid ElectionOfficer officer) 
     {
	   return eoService.addElectionOfficerDetails(officer);
     }
     
     
     /*
        * @Author      : Swarupa
        * 
        * @Method      : updateElectionOfficerDetails()
        * 
        * @Parameter   : officerId,officer
        * 
        * @Return type : Integer
        *   
        * @Description : This is the method for Updating the existing Election officer details. 
      */
    
     
	   @PutMapping("/officer/{officerId}")
       public @ResponseBody ElectionOfficer updateElectionOfficerDetails(@PathVariable int officerId,@RequestBody @Valid ElectionOfficer officer) throws ElectionOfficerNotFoundException 
       {
	
	      return eoService.updateElectionOfficerDetails(officerId,officer);
       }
       
      /*
        * @Author      : Swarupa
        * 
        * @Method      : deleteElectionOfficer()
        * 
        * @Parameter   : officerId
        * 
        * @Return type : Integer
        * 
        * @Description : This is the method for deleting the existing Election officer details.
      */

	   @DeleteMapping("/officer/{officerId}")
       public @ResponseBody int deleteElectionOfficer(@PathVariable int officerId) throws ElectionOfficerNotFoundException 
      {
	    return eoService.deleteElectionOfficer(officerId);
      }

}
