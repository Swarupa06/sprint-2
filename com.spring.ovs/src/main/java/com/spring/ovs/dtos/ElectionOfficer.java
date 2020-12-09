package com.spring.ovs.dtos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="officer")
public class ElectionOfficer {
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "officerId",unique=true)
	private int officerId;
	
	
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
	@Column(name = "email_id",unique=true)
	private String emailId;
	
	
	@NotEmpty(message = "Password is required")
	@Column(name = "password")
	private String password;
	
	
	@NotEmpty(message = "Gender is required")
	@Pattern(regexp="^(?:Male|Female|Transgender)$")
	@Column(name = "gender")
	private String gender;
	
	
	@NotEmpty(message = "Mobile number is required")
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$")
	@Column(name = "mobile_no",unique=true)
	private String mobileno;
	
	
	@NotEmpty(message = "Address1 is required")
	//@Pattern(regexp="^[A-Z]{1}[a-z]{2,9}$")
	@Column(name = "address1")
	private String address1;
	
	
	@NotEmpty(message = "Address2 is required")
	@Column(name = "address2")
	private String address2;
	
	
	@NotEmpty(message = "District is required")
	@Column(name = "district")
	private String district;
	
	
	@NotNull(message = "Pincode is required")
	@Column(name = "pincode")
	private int pincode;
	
	
	public int getOfficerId()
	{
		return officerId;
	}
	public void setOfficerId(int officerId)
	{
		this.officerId = officerId;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getMobileno()
	{
		return mobileno;
	}
	public void setMobileno(String mobileno)
	{
		this.mobileno = mobileno;
	}
	public String getEmailId()
	{
		return emailId;
	}
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public String getAddress1()
	{
		return address1;
	}
	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}
	public String getAddress2()
	{
		return address2;
	}
	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}
	public String getDistrict()
	{
		return district;
	}
	public void setDistrict(String district) 
	{
		this.district = district;
	}
	public int getPincode()
	{
		return pincode;
	}
	public void setPincode(int pincode) 
	{
		this.pincode = pincode;
	}
	
	
	public ElectionOfficer() 
	{
		super();
	}
	
	public ElectionOfficer(String firstName, String lastName, String password, String gender, String mobileno,
			String emailId, String address1, String address2, String district, int pincode) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.district = district;
		this.pincode = pincode;
	}
	
	public ElectionOfficer(int officerId, String firstName, String lastName, String password, String gender,
			String mobileno, String emailId, String address1, String address2, String district, int pincode)
	{
		super();
		this.officerId = officerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.district = district;
		this.pincode = pincode;
	}
	


   @Override
   public String toString()
   {
	  return "ElectionOfficer [officerId=" + officerId + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", password=" + password + ", gender=" + gender + ", mobileno=" + mobileno + ", emailId=" + emailId
			+ ", address1=" + address1 + ", address2=" + address2 + ", district=" + district + ", pincode="
			+ pincode + "]";
   }
}

