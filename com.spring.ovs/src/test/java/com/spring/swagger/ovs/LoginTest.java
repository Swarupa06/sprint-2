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

import com.spring.ovs.controllers.LoginController;
import com.spring.ovs.dtos.Login;
import com.spring.ovs.service.LoginService;


@ExtendWith(MockitoExtension.class)

public class LoginTest {
	@Mock
	LoginService loginService;
	@InjectMocks
	LoginController logincontroller;
	
	@Test
	public void testgetLoginById()
	{
		int id=1;
		Login login=new Login();
		Mockito.when(logincontroller.getLoginById(id)).thenReturn(login);
		assertEquals(login,logincontroller.getLoginById(id));
	}
	
	@Test
	public void testinsertLogin() {
		Login login=new Login();
		Mockito.when(logincontroller.insertLogin(login)).thenReturn(login);
		assertEquals(login,logincontroller.insertLogin(login));
	}
	
	@Test
	public void testupdateLogin() {
		Login login=new Login();
		Mockito.when(logincontroller.updateLogin(login)).thenReturn(login);
		assertEquals(login,logincontroller.updateLogin(login));
	}
	
	@Test
	public void testdeleteLogin() {
		int id=1;
		Mockito.when(logincontroller.deleteLogin(id)).thenReturn(id);
		assertEquals(id,logincontroller.deleteLogin(id));
	}
	
	@Test
	public void testgetAllLogin() {
		List<Login>loginlist=new ArrayList<Login>();
		Mockito.when(logincontroller.getAllLogin()).thenReturn(loginlist);
		assertEquals(loginlist,logincontroller.getAllLogin());
	}
}

