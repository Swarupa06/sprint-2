package com.spring.ovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ovs.dtos.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {

}
