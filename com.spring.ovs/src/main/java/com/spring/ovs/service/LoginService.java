package com.spring.ovs.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.Login;
import com.spring.ovs.exceptions.InvalidOperation;
import com.spring.ovs.repository.LoginRepository;

@Service
public class LoginService {
@Autowired
private LoginRepository loginRepo;

/*
 * This method used for getting the login details by id , if id is existing we can get its details the details.
 */
public Login getLoginById(Integer id) throws InvalidOperation {
	try {
		return loginRepo.findById(id).get();
	}
	catch(InvalidOperation e) {
		System.out.println("Login could not find");
		e.printStackTrace();
		return null;
	}
}

/*
 * This method used for inserting the logins, if login do not match with the validation, login cannot be updated.
 */
public Login insertLogin(Login login) throws InvalidOperation{
	try {
		System.out.println("Login added");
		return loginRepo.save(login);
	}
	catch(InvalidOperation e)
	{
		System.out.println("Login cant be inserted");
		e.printStackTrace();
		return null;
	}

}

/*
 * This method used for updating the Login details, if Login matches validation, can update the details.
 */
public Login updateLogin(Login login) throws InvalidOperation {
	try{
		System.out.println("login updated");
		return loginRepo.save(login);
	}
	catch(InvalidOperation e)
	{
		System.out.println("Login cant be updated");
		e.printStackTrace();
		return null;
	}
	}

/*
 * This method used for deleting the login by id, if id is existing we can delete the login.
 */
public int deleteLoginbyId(Integer id)throws InvalidOperation {
	try {
		  loginRepo.deleteById(id);
		return id;
	}
	catch(InvalidOperation ie)
	{
		throw new InvalidOperation("Login not deleted");
	}

}

/*
 * This method used for view all the login details.
 */
public List<Login> getAllLogins() {
	List<Login> loginlist=new ArrayList<Login>();
	loginRepo.findAll().forEach(login->loginlist.add(login));
	return loginlist;
}

}

