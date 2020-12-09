package com.spring.ovs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ovs.dtos.Admin;
import com.spring.ovs.service.AdminService;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class AdminController {
	Logger log = LoggerFactory.getLogger(AdminController.class);
		@GetMapping("/hi")
		public String hi() {
			return "Hi!";
		}
		@Autowired
		private AdminService adminService;
		


	@GetMapping("/admindetails")
	/*
     * @Author:Gowthami
     * 
     * @Method:getAdmins()
     * 
     * Return type:String
     * 
     * @Parameter: admin
     * 
     * @description: This method gets all the admins list.
     */
	public @ResponseBody List<Admin> getAdmins() 
	{ 
		
		List<Admin> admins = adminService.getAlladmins();
		
		return admins;
	}

	@GetMapping("/admindetails/{id}")
	/*
     * @Author:Gowthami
     * 
     * @Method:getAdminById()
     * 
     * Return type:integer
     * 
     * @Parameter:id
     * 
     * @description: This method allows you to get the admin by id if you enter existing Id,that admin details will be visible or if the given Id doesnot exist, it will throw an exception "Admin could not be accessed because id is null".
     */
	public @ResponseBody  Admin getAdminById(@PathVariable Long id) 
	{
		
		return adminService.getAdminById(id);
	}

	@PostMapping("/admindetails")
	/*
     * @Author:Gowthami
     * 
     * @Method:addAdmin()
     * 
     * Return type:admin
     * 
     * @Parameter:admin
     * 
     * @description: This method allows you to add the admin, if you enter existing details, you can not add and it throws an exception "Admin could not be added".
     */
	public @ResponseBody Admin addAdmin(@RequestBody Admin admin) 
	{
		return adminService.addAdmin(admin);
	}

	@PutMapping("/admindetails/{id}")
	/*
     * @Author:Gowthami
     * 
     * @Method:updateAdmin()
     * 
     * Return type:integer
     * 
     * @Parameter:id
     * 
     * @description: This method allows you to update the admin by id if you enter existing Id,that admin id will be visible or if the given Id doesnot exist, it canoot be updated and will throw an exception "Admin could not be updated".
     */
	public @ResponseBody Admin updateAdmin(@PathVariable Long id,@RequestBody Admin admin) 
	{
		
		return adminService.updateAdmin(id,admin);
	}

	@DeleteMapping("/admindetails/{id}")
	/*
     * @Author:Gowthami
     * 
     * @Method:removeAdmin()
     * 
     * Return type:integer
     * 
     * @Parameter:id
     * 
     * @description: This method allows you to delete the admin by id ,if you enter existing Id.
     */
	public @ResponseBody  String removeAdmin(@PathVariable Long id) 
	{
		return adminService.removeAdmin(id);
	}


	}


