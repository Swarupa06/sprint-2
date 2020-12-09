package com.spring.ovs.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.ovs.dtos.ElectionResult;
import com.spring.ovs.dtos.NominatedCandidates;

@Repository
public interface ElectionResultRepository extends JpaRepository<ElectionResult,Integer> {
	

	List<ElectionResult> findAll();
	
	@Query("select er.totalPollingPercentage from ElectionResult er")
	public double viewVotingPercentage();
	
	@Query("select er.candidateVotesPercentage from ElectionResult er, NominatedCandidates nc where er.id = nc.candidateId")
	public double viewCandidateVotingPercent(int candidateId);

	@Query("select er.coop_SocietyName,er.totalSocietyVotes,er.totalCandidateVotes,er.totalPolledVotes,er.candidateVotesPercentage,er.totalPollingPercentage,er.result from ElectionResult er")
	public void displayVotingStatistics();
	
	@Query("select MAX(er.candidateVotesPercentage) from ElectionResult er")
	public  NominatedCandidates viewHighestVotingPercentCandidate();
	
	@Query("select MIN(er.candidateVotesPercentage) from ElectionResult er")
	public  NominatedCandidates viewLowestVotingPercentCandidate();
	
	@Query("select COUNT(er.id) from ElectionResult er GROUP BY er.id HAVING COUNT(er.id)>1")
	public int viewInvalidVotes();
	
	@Query("select COUNT(er.candidate) from ElectionResult er,NominatedCandidates nc where er.id = nc.candidateId GROUP BY er.candidate HAVING COUNT(er.candidate)>1")
	public  List<NominatedCandidates> candidatewiseInvalidVotesList();
	
	@Query("select er.result from ElectionResult er")
	public void displayPollingResult();
	
	
	

}

