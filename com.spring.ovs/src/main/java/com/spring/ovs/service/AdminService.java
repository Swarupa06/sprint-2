package com.spring.ovs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.ovs.dtos.Admin;
import com.spring.ovs.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepo;

	/*
	 * This method is used to list all the admins.
	 */
	public List<Admin> getAlladmins() {
		System.out.println("Admins...");
		return adminRepo.findAll();
	}

	/*
	 * this method is used to get the admin details by giving Id,if Id is existing, we will get the details.
	 */
	public Admin getAdminById(Long id) throws IllegalArgumentException  {
		   
        try {
        	System.out.println("Admin accessed");
            return adminRepo.findById(id).get();
        } catch (IllegalArgumentException e) {
            System.out.println("Admin could not be accessed because id is null");
            e.printStackTrace();
            return null;
        }
}

	/*
	 * This method is used to add admin, if admin is existing we cannot add the admin with the same details.
	 */

public Admin addAdmin(Admin admin) throws IllegalArgumentException  {
	try {
		System.out.println("Admin Added");
		
		return adminRepo.save(admin);
		}
		catch(IllegalArgumentException e)
		{
		    System.out.println("Admin could not be added");
			e.printStackTrace();
		    return null;
		}
}


/*
 * This method is used to update the admin by Id, if Id is existing, we can update the admin details.
 */
public Admin updateAdmin(Long id, Admin admin) throws IllegalArgumentException  {
	System.out.println("Admin updated.");
	try
      {  
	Optional<Admin> repAdmin = adminRepo.findById(id);

	if (repAdmin.isPresent()) {

		Admin adminToBeUpdated = repAdmin.get();
		adminToBeUpdated.setContactNumber(admin.getContactNumber());
		adminToBeUpdated.setEmail(admin.getEmail());
		adminToBeUpdated.setPassword(admin.getPassword());
		System.out.println("Admin Updated");

		return adminRepo.save(adminToBeUpdated);

	}
   }
	catch(IllegalArgumentException e)
	{
	    System.out.println("Admin could not be updated");
		e.printStackTrace();
	    return null;
	}
return admin;
}

/*
 * This method is used to delete the admin by Id,if Id is existing, the admin can be removed.
 */
public String removeAdmin(Long adminId) {
	System.out.println("Admin removed.");
	adminRepo.deleteById(adminId);
	return "Admin deleted Sucessfully";
}
}

