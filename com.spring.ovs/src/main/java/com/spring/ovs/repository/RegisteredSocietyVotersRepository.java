package com.spring.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ovs.dtos.RegisteredSocietyVoters;
@Repository
public interface RegisteredSocietyVotersRepository extends JpaRepository< RegisteredSocietyVoters,Integer>{

	



}

