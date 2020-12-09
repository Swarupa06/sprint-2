package com.spring.ovs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ovs.dtos.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	

	List<Admin> findAll();
	void deleteById(Long id);

}