package com.spring.swagger.ovs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.ovs.controllers.UserController;
import com.spring.ovs.dtos.User;
import com.spring.ovs.exceptions.UserNotFoundException;
import com.spring.ovs.service.UserService;





@ExtendWith(MockitoExtension.class)
public class UserTest
{
    
	@Mock
	UserService urServices;
	

	@InjectMocks
	UserController urController;

	@Test
	public void testregisterUser() 
	{
		 User user =new User();
		int userId = 1;
		Mockito.when(urController.registerUser(user)).thenReturn(userId);
		assertEquals(userId,urController.registerUser(user));
	 }
	
	 @Test
	 public void testGetAllUsers()
     {
	     List<User> user=new ArrayList<User>();
	     Mockito.when(urController.getAllUsers()).thenReturn(user);
	     assertEquals(user,urController.getAllUsers());

	  }
	 
	 @Test
	 public void tesUserById() throws UserNotFoundException
	 {
		 User user=new User();
		 int userId = 1;
		Mockito.when(urController.findByUserId(userId)).thenReturn(user);
	     assertEquals(user,urController.findByUserId(userId)); 
	 }
	 
	 @Test
	 public void testUpdateUser()throws UserNotFoundException
	 {
		 User user=new User();
		int userId = 1;
		Mockito.when(urController.updateUser(userId, user)).thenReturn(user);
		assertEquals(user,urController.updateUser(userId, user));

	 }
	 
	 @Test
	 public void testDeleteUser() throws UserNotFoundException
	 {
	 	
	 	int userId = 1;
		Mockito.when(urController.deleteUser(userId)).thenReturn(userId);
	 	assertEquals(userId,urController.deleteUser(userId));
	 	
	 }
}






