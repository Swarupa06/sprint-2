package com.spring.ovs.controllers;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ovs.dtos.User;
import com.spring.ovs.exceptions.UserNotFoundException;
import com.spring.ovs.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/userdetails")
public class UserController{

	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService urService;
	

/*

 * @Author      : Sirisha
 * 
 * @Method      : ListUser()
 * 
 * @Return type : Void
 * 
 * @Parameter   : userId
 * 
 * @Description : This method is used to view the User List, and it will be displayed in console like Users....
                  
*/


@GetMapping(value = {"/" })
public @ResponseBody List<User> getAllUsers() 
{ 
	
	List<User> user = urService.getAllUsers();

	return user;
}

/*

 * @Author      : Sirisha
 * 
 * @Method      : FindByUserId()
 * 
 * @Return type : Void
 * 
 * @Parameter   : userId
 * 
 * @Description : This is the method for Find the existing User details, if you enter the existing ID User 
                  details with that ID will be displayed 
                  else if the given ID does not exist it will throw an Exception that "Enter valid Id to view the User details".
*/


@GetMapping("/{userId}")
public @ResponseBody  User findByUserId(@PathVariable int userId) throws UserNotFoundException 
{
	
	return urService.findByUserId(userId);
}
/*

 * @Author      : Sirisha
 * 
 * @Method      : registerUser()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : userId
 * 
 * @Description : This is the method for registering the  User details and if we give the existing ID and execute it then in ResponseBody it will show Zero and in console it prints "The user with this ID already exixts....Give another ID,
 * if you give proper id then console displays user registered successfully.
*/



@PostMapping("/register")
public @ResponseBody int registerUser(@RequestBody User user) 
{
	return urService.registerUser(user);
}

/*

 * @Author      : Sirisha
 * 
 * @Method      : updateUser()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : userId
 * 
 * @Description : This is the method for Update the existing User details, if you enter the existing ID User 
                  details with that ID will be Updated and in console it prints "User details are Updated Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be updated".
*/


@PutMapping("/updateDetails/{userId}")
public @ResponseBody User updateUser(@PathVariable int userId,@RequestBody  User user) throws UserNotFoundException 
{
	
	return urService.updateUser(userId,user);
}

/*

 * @Author      : Sirisha
 * 
 * @Method      : deleteUser()
 * 
 * @Return type : Integer
 * 
 * @Parameter   : userId
 * 
 * @Description : This is the method for deleting the existing User details, if you enter the existing ID User 
                  details with that ID will be deleted and in console it prints "User details are deleted Successfully"
                  else if the given ID does not exist it will throw an Exception that "Enter valid ID to be deleted".
*/

@DeleteMapping("/Delete/{userId}")
public @ResponseBody int deleteUser(@PathVariable int userId) throws UserNotFoundException 
{
	return urService.deleteUser(userId);
}




@GetMapping("/LoginValidation/{email}/{password}")
public @ResponseBody User loginValidate(@PathVariable String email, @PathVariable String password) {
	
	return urService.loginValidate(email, password);
}

}


