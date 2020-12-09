package com.spring.ovs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.spring.ovs.dtos.ElectionResult;
import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.service.ElectionResultService;

//connect from postman as http://localhost:8080/results/
@Controller
public class ElectionResultController
{ 
	
	/*A Logger object is used to log messages for a specific system or application component.
	   *Loggers are normally named,using a hierarchical dot-separated namespace.
     */
   
    Logger log = LoggerFactory.getLogger(ElectionResultController.class);
    
	
	@Autowired   //enables you to inject the object dependency implicitly. It internally uses setter injection.
	private ElectionResultService erService;
	
	   /*
           * @Author      : Swarupa
           * 
           * @Method      : viewElectionResultList()
           * 
           * @Return type : ElectionResult
           * 
           * @Description : This method is used to view the Election Result List. 
       */
	
	
	    @GetMapping("/results")
	    public @ResponseBody List<ElectionResult> viewElectionResultList() 
	    { 
	    	return erService.viewElectionResultList();
	    }
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : addElectionResult()
	        * 
	        * @Parameter   : result
	        * 
	        * @Return type : Integer
	        * 
	        * @Description : This is the method for adding Election Result.
	    */
	    
	 
	    @PostMapping("/results")
	    public @ResponseBody int addElectionResult(@RequestBody @Valid ElectionResult result) 
	    {
		     return erService.addElectionResult(result);
	    }
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : viewCandidatewiseResult()
	        * 
	        * @Parameter   : id
	        * 
	        * @Return type : ElectionResult
	        * 
	        * @Description : This method is used to get the Candidate wise result in the Election. 
	    */
	    
	 
	    @GetMapping("/results/{id}")
	    public @ResponseBody ElectionResult viewCandidatewiseResult(@PathVariable("id") int id)
	    {
		   return erService.viewCandidatewiseResult(id);
	    }
	    

	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : viewVotingPercentage()
	        * 
	        * @Return type : DoubleA
	        * 
	        * @Description : This method is used to view the Voting percentage in the Election result.  
	    */
	    
	
	    @GetMapping("/results/{totalPollingPercentage}")
	    public @ResponseBody double viewVotingPercentage()
	    {
		   return erService.viewVotingPercentage();
		}
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : viewVotingCandidatePercent()
	        * 
	        * @Parameter   : candidateId
	        * 
	        * @Return type : Double
	        * 
	        * @Description : This method is used to view the particular Candidate voting percentage by giving the Candidate ID. 
	         
	    */
	    
	
	    @GetMapping("/results/{viewCandidateVotingPercent}")
	    public @ResponseBody  double viewCandidateVotingPercent(int candidateId)
	    {
		  return erService.viewCandidateVotingPercent(candidateId);
	    }
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : displayVotingStatistics()
	        * 
	        * @Return type : Void
	        * 
	        * @Description : This method is used to display the Voting statistics in Election result.
	    */
	    
	
	    @GetMapping("/results/displayVotingStatistics")
	    public @ResponseBody  void displayVotingStatistics()
	    {
		  erService.displayVotingStatistics();
	    }
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : viewHighestOrLowestVotingPercentCandidate()
	        * 
	        * @Parameter   : H
	        * 
	        * @Return type : NominatedCandidates
	        * 
	        * @Description : This method is used to view the Highest voting percent candidate or Lowest voting percent candidate in the Election result.      
	    */
	
	    
	    @GetMapping("/results/viewHighestVotingPercentCandidate/")
	    public @ResponseBody  NominatedCandidates viewHighestOrLowestVotingPercentCandidate(boolean H)
	    {
		  if (H==true)
		  {	
		    return erService.viewHighestOrLowestVotingPercentCandidate(H);
		  }
		return null;
		  
	    }
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : viewInvalidVotes()
	        * 
	        * @Return type : Integer
	        * 
	        * @Description : This method is used to view the Invalid votes in the Election result.
	    */
	    
	
	    @GetMapping("/results/{viewInvalidVotes}")
	    public @ResponseBody int viewInvalidVotes()
	    {
		  return erService.viewInvalidVotes();
	    }
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : candidatewiseInvalidVotesList()
	        * 
	        * @Return type : NominatedCandidates
	        * 
	        * @Description : This method is used to view the Candidate wise Invalid votes list in the Election result.
	    */
	    
	
	    @GetMapping("/results/{candidatewiseInvalidVotesList}")
	    public @ResponseBody List<NominatedCandidates> candidatewiseInvalidVotesList()
	    {
		  return erService.candidatewiseInvalidVotesList();
	    }
	    
	    
	    /*
	        * @Author      : Swarupa
	        * 
	        * @Method      : displayPollingResult()
	        * 
	        * @Return type : Void
	        * 
	        * @Description : This method is used to display the Polling result in the Election.
	    */
	    
	
	    @GetMapping("/results/{result}")
	    public @ResponseBody void displayPollingResult()
	    {
		  erService.displayPollingResult();
	    }
		
}
