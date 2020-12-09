package com.spring.ovs.service;


import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.ElectionResult;
import com.spring.ovs.dtos.NominatedCandidates;
import com.spring.ovs.repository.ElectionResultRepository;


@Service
public class ElectionResultService {
    
	@Autowired
	ElectionResultRepository erRepo;
	
	/*
	  * This is the method for adding Election Result.
	*/

	
	public int addElectionResult(ElectionResult result)
	{
		if(erRepo.existsById(result.getId()))
		{
			System.out.println("The Result with this Id already exists...Give another value");
		     return 0;
		}
		else
		{
		   return erRepo.save(result).getId();
		}
	}
	
	 /*
	    * This method is used to view the Election Result List. 
	 */
	
	public List<ElectionResult> viewElectionResultList()
	{
	 
		System.out.println("Election Results...");
		return erRepo.findAll();
	}
	
	/* 
	   * This method is used to get the Candidate wise result in the Election. 
	*/
	
	public ElectionResult viewCandidatewiseResult(int id)
	{
		
		return erRepo.findById(id).get();	
		
	}
	
	/* 
	   * This method is used to view the Voting percentage in the Election result. 
	*/
	
	
	public double viewVotingPercentage()
	{
		
		return erRepo.viewVotingPercentage();	
		
	}
	
	/* 
	   * This method is used to view the particular Candidate voting percentage by giving the Candidate ID. 
	*/
	
	
	public double viewCandidateVotingPercent(int candidateId)
	{
		
		return erRepo.viewCandidateVotingPercent(candidateId);	
		
	}
	
	/* 
	   * This method is used to display the Voting statistics in Election result.
	*/
	
	
	public void displayVotingStatistics()
	{
		
		erRepo.displayVotingStatistics();
		
	}
	
	/* 
	   * This method is used to view the Highest voting percent candidate or Lowest voting percent candidate in the Election result. 
	*/
	
	
	public  NominatedCandidates viewHighestOrLowestVotingPercentCandidate(boolean H)
	{
		
		System.out.println("Enter the character H to view the Highest voting percentage candidate or It will display the Lowest voting percentage candidate");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		sc.nextBoolean();
		if (H==true)
		{	
		 return erRepo.viewHighestVotingPercentCandidate();
	    }
		else
		{
			return erRepo.viewLowestVotingPercentCandidate();
		}
	}
	
	/* 
	   * This method is used to view the Invalid votes in the Election result.
	*/
	
		
	public int viewInvalidVotes()
	{
		
		return erRepo.viewInvalidVotes();
		
	}
	
	/* 
	   * This method is used to view the Candidate wise Invalid votes list in the Election result.
	*/
	
	
	public  List<NominatedCandidates> candidatewiseInvalidVotesList()
	{
		
		return erRepo.candidatewiseInvalidVotesList();
		
	}
	
	/* 
	   * This method is used to display the Polling result in the Election.
	*/
	
	
	public void displayPollingResult()
	{
		
		erRepo.displayPollingResult();
		
	}

	
	
}
