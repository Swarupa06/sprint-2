package com.spring.swagger.ovs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.ovs.controllers.AdminController;
import com.spring.ovs.dtos.Admin;
import com.spring.ovs.service.AdminService;

@ExtendWith(MockitoExtension.class)
public class AdminTest {
	@Mock
	AdminService adminService;
	@InjectMocks
	AdminController aController;
	
	@Test
	public void testgetAdmins() {
		List<Admin> admin=new ArrayList<Admin>();
		Mockito.when(aController.getAdmins()).thenReturn(admin);
		assertEquals(admin,aController.getAdmins());
	}
	
	@Test
	public void testgetAdminById() {
		Admin admin=new Admin();
		Long id=(long) 1;
		Mockito.when(aController.getAdminById(id)).thenReturn(admin);
		assertEquals(admin,aController.getAdminById(id));
	}
	
	@Test
	public void testaddAdmin() {
		Admin admin=new Admin();
		Mockito.when(aController.addAdmin(admin)).thenReturn(admin);
		assertEquals(admin,aController.addAdmin(admin));
	}
	
	@Test
	public void testupdateAdmin() {
		Admin admin=new Admin();
		Long id=(long) 1;
		Mockito.when(aController.updateAdmin(id, admin)).thenReturn(admin);
		assertEquals(admin,aController.updateAdmin(id, admin));
	}
	
	
	
}

