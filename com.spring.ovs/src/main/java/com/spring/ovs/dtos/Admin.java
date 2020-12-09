package com.spring.ovs.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="admindetails")
public class Admin {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	Long id;
	
//	@NotEmpty(message = "First name is required")
//	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name="admin_name")
	String adminName;
	
	//@NotEmpty(message = "Mobile number is required")
	//@Pattern(regexp="^[6-9]{1}[0-9]{9}$")
	@Column(name="contact_no")
	int contactNumber;
	
//	@NotEmpty(message = "Email Id is required")
//	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9]{2,}@[a-z]{5}.com$",message="Email address is invalid")
	@Column(name="Email")
	String email;
	
	@Column(name="Password")
	String password;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Admin() {
		super();
	}
	
	public Admin(String adminName, int contactNumber, String email) {
		super();
		this.adminName = adminName;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	public Admin(String adminName, int contactNumber, String email, String password) {
		super();
		this.adminName = adminName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Admin{");
		sb.append("id:").append(id).append(",");
		sb.append("adminName:").append(adminName).append(",");
		sb.append("contactNumber:").append(contactNumber).append(",");
		sb.append("email:").append(email).append(",");
		sb.append("password:").append(password).append(",");
		sb.append("}");
		return sb.toString();
	}
}
	

