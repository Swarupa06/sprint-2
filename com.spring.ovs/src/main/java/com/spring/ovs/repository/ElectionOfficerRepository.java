package com.spring.ovs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ovs.dtos.ElectionOfficer;

@Repository
public interface ElectionOfficerRepository extends JpaRepository<ElectionOfficer,Integer> {
	

	List<ElectionOfficer> findAll();
	void deleteById(int officerId);
	
	
	

}
