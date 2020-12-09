package com.spring.ovs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ovs.dtos.User;
import com.spring.ovs.exceptions.UserNotFoundException;
import com.spring.ovs.repository.UserRepository;


@Service//class that provides business services.
public class UserService {

	@Autowired
	private UserRepository urRepository;
	

	/*
	  * This is the method for Registering User and if we give the existing ID and execute it then
	  * in ResponseBody it will show zero and in console it prints "The Result with this ID already exists...Give another value".
	*/

	public int registerUser(User user)
	{
		if(urRepository.existsById(user.getUserId()))
		{
		     return 0;
		}
		else
		{
		   return urRepository.save(user).getUserId();
		}
			 
	}
	/*
	 * This Method is used to update the user details
	 */
	
    public User updateUser(int userId, User user) throws UserNotFoundException
    {

	      Optional<User> repUser = urRepository.findById(userId);

	        if (repUser.isPresent()) {

		    User userToBeUpdated = repUser.get();
		    userToBeUpdated.setPassword(user.getPassword());
		    userToBeUpdated.setFirstName(user.getFirstName());
		    userToBeUpdated.setLastName(user.getLastName());
		    userToBeUpdated.setEmail(user.getEmail());
		    userToBeUpdated.setContactno(user.getContactno());
		   
		    return urRepository.save(userToBeUpdated);
	      }
	      else
	      {
				throw new UserNotFoundException("No User present with the given Id to Update...Please enter valid Id to update");

	      }
      }
    /*
     * This method is used to delete the user with respective given userId
     */
      
     public int deleteUser(int userId) throws UserNotFoundException
     {
    	 Optional<User> repUser = urRepository.findById(userId);
    		 
    	  if(repUser.isPresent())
    	   {
    	      urRepository.deleteById(userId);
              System.out.println("User details are deleted Successfully");
    		}
    	    else
    		{
    		    throw new UserNotFoundException("Enter valid Id to be deleted");
    		}
		    return userId;
      }
     
     /* 
	   * This method is used to get the Userdetails with respective  given userId. 
	*/
    
	 public User findByUserId(int userId) throws UserNotFoundException
	 {
	      Optional<User> repUser = urRepository.findById(userId);
	      
	      if(repUser.isPresent())
	      {
			 return repUser.get();
		  }
	      else
	      {
  		    throw new UserNotFoundException("Enter valid Id to view the User details"); 
	      }
		
	 }
	 

	 /*
	    * This method is used to view the User List. 
	 */
	 
	 public List<User> getAllUsers()
	 {
	 
		System.out.println("Users...");
		return urRepository.findAll();
	 }
	 
	 public User loginValidate(String email, String password) {
			List<User> l1= urRepository.findAll();
			for(User u:l1) {
				if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				   return u;
				}
				
			}
			return null;
		}
}







