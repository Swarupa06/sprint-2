package com.spring.ovs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ovs.dtos.CooperativeSociety;

@Repository
public interface CooperativeSocietyRepository extends JpaRepository<CooperativeSociety,Integer> {
	

	List<CooperativeSociety> findAll();
	void deleteById(int officerId);
}
	
