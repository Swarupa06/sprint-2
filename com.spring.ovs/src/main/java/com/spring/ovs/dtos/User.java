package com.spring.ovs.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="userdetails")
public class User{
	


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id",unique=true)
	private int userId;
	
	@NotEmpty(message = "Password is required")
	//@Pattern(regexp="^(?=.[A-Za-z])(?=.\\d)[A-Za-z\\d]{8,}$")
	//@Pattern(regexp="[a-zA-Z]{5,}@&{1}")
	@Column(name = "password")
 	private String password;
 	

	@NotEmpty(message = "First name is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "first_name")
 	private String firstName;
 	
	@NotEmpty(message = "Last name is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "last_name")
 	private String lastName;
	
	@NotEmpty(message = "Email Id is required")
	@Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9]{2,}@[a-z]{5}.com$",message="Email address is invalid")
	@Column(name = "email",unique=true)
 	private String email;
	
	@NotEmpty(message = "Contact number is required")
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$")
	@Column(name = "contact_no",unique=true)
 	private String contactno;
 	
 	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public User() {
		   super();
	}
	public User(int userId,String password,String firstName,String lastName,String email,String contactno) {
		super();
		this.userId=userId;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.contactno=contactno;
	}
	
	public User(String password,String firstName,String lastName,String email,String contactno) {
		super();
	
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.contactno=contactno;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("User{");
		sb.append("userId:").append(userId).append(",");
		sb.append("password:").append(password).append(",");
		sb.append("firstName:").append(firstName).append(",");
		sb.append("lastName:").append(lastName).append(",");
		sb.append("email:").append(email).append(",");
		sb.append("contactno:").append(contactno).append(",");
		sb.append("}");
		
		return sb.toString();
		
	}
	
	
}
