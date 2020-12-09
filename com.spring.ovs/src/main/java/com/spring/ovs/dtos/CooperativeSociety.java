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
@Table(name="society")
public class CooperativeSociety {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="society_id",unique=true)
	private int societyId;
	
	@NotEmpty(message = "society Name is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "society_name")
 	private String societyName;
 	
	
	@NotEmpty(message = "headOfSociety is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "headof_society")
 	private String headOfSociety;
 	
	@NotEmpty(message = "Village is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "village")
 	private String village;
	
	@NotEmpty(message = "Mandal is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "mandal")
 	private String mandal;
	
	
	@NotEmpty(message = "District is required")
	@Pattern(regexp="^[A-Za-z]{3,}$")
	@Column(name = "district")
 	private String district;
	
	
	@NotEmpty(message = "Pincode is required")
	//@Pattern(regexp="[0-9]{5}")
	@Column(name = "pincode")
 	private String pincode;
 	
 	
	public int getSocietyId() {
		return societyId;
	}
	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}
	public String getSocietyName() {
		return societyName;
	}
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}
	public String getHeadOfSociety() {
		return headOfSociety;
	}
	public void setHeadOfSociety(String headOfSociety) {
		this.headOfSociety = headOfSociety;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getMandal() {
		return mandal;
	}
	public void setMandal(String mandal) {
		this.mandal = mandal;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
 	
	
	public CooperativeSociety() {
		   super();
	}
	public CooperativeSociety(int societyId,String societyName,String headOfSociety,String village,String mandal,String district,String pincode) {
		super();
		this.societyId=societyId;
		this.headOfSociety=headOfSociety;
		this.village=village;
		this.mandal=mandal;
		this.district=district;
		this.pincode=pincode;
	}
	public CooperativeSociety(String societyName,String headOfSociety,String village,String mandal,String district,String pincode){
		super();
	
		this.headOfSociety=headOfSociety;
		this.village=village;
		this.mandal=mandal;
		this.district=district;
		this.pincode=pincode;
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("CooperativeSociety{");
		sb.append("societyId:").append(societyId).append(",");
		sb.append("societyName:").append(societyName).append(",");
		sb.append("headOfSociety:").append(headOfSociety).append(",");
		sb.append("village:").append(village).append(",");
		sb.append("mandal:").append(mandal).append(",");
		sb.append("district:").append(district).append(",");
		sb.append("pincode:").append(pincode).append(",");
		sb.append("}");
		
		return sb.toString();
		
	}
	
	
}

 	

