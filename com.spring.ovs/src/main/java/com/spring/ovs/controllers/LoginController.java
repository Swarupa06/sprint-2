package com.spring.ovs.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ovs.dtos.Login;
import com.spring.ovs.service.LoginService;


@Controller

public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login/{id}")
	/*
     * @Author:Gowthami
     * 
     * @Method:getLoginById()
     * 
     * Return type:integer
     * 
     * @Parameter:id
     * 
     * @description: This method allows you to get the login by Id, if you enter existing Id, you can get the login details, if not exists it will throw an exception of "Login could not find".
     */
	public @ResponseBody Login getLoginById(@PathVariable Integer id)
	{
		return loginService.getLoginById(id);
		
	}
	@PostMapping("/login")
	/*
     * @Author:Gowthami
     * 
     * @Method:insertLogin()
     * 
     * Return type:String
     * 
     * @Parameter:Login
     * 
     * @description: This method allows you to insert the login , Login should match with respect to given validation,then login can be inserted. 
     */
	public @ResponseBody Login insertLogin(@RequestBody Login login)
	{
		return loginService.insertLogin(login);
	}
	@PutMapping("/login")
	/*
     * @Author:Gowthami
     * 
     * @Method:updateLogin()
     * 
     * Return type:String
     * 
     * @Parameter:login
     * 
     * @description: This method allows you to update the login by, if your login matches with the validation, login can be updated, if not it throw an exception of "Login not updated".
     */
	public @ResponseBody Login updateLogin(@RequestBody Login login)
	{
		return loginService.updateLogin(login);
		
	}
	
	@DeleteMapping("/login/{id}")
	/*
     * @Author:Gowthami
     * 
     * @Method:DeleteLogin()
     * 
     * Return type:integer
     * 
     * @Parameter:id
     * 
     * @description: This method allows you to delete the login by Id, if you enter existing Id, your login can be deleted, if not it throws an exception "Login cant delete". 
     */
	public @ResponseBody int deleteLogin(@PathVariable Integer id)
	{
		return loginService.deleteLoginbyId(id);
	}
	
	@GetMapping("/login")
	/*
     * @Author:Gowthami
     * 
     * @Method:getallLogin()
     * 
     * Return type:list
     * 
     * @Parameter:login
     * 
     * @description: This method allows you to list out all the logins. 
     */
	public @ResponseBody List<Login> getAllLogin()
	{
		List<Login> loginlist=loginService.getAllLogins();
		return loginlist;
	}
	
	
	
	
	
	
}
