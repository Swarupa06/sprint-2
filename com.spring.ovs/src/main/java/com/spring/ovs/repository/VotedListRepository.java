package com.spring.ovs.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ovs.dtos.VotedList;



@Repository
public interface VotedListRepository extends JpaRepository<VotedList,Integer> {
	

	List<VotedList> findAll();
	void deleteById(int id);
	
	
	
	

}
