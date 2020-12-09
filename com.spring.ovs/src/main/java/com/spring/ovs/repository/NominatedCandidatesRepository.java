package com.spring.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ovs.dtos.NominatedCandidates;

public interface NominatedCandidatesRepository extends JpaRepository<NominatedCandidates,Integer>
{
	
}
