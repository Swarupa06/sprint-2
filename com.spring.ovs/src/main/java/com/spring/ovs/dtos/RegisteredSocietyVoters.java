

package com.spring.ovs.dtos;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reg_society")
public class RegisteredSocietyVoters {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="voterId")
	private int voterId;
	
	@Column(name = "voterIdCardNo")
	private String voterIdCardNo;
	
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "password")
	private String password;
	
	@Column(name="reservationCategory")
	private String reservationCategory;
	
	@Column(name = "mobileno")
	private String mobileno;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "address2")
	private String address2;
	
	@Column(name="mandal")
	private String mandal;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "pincode")
	private int pincode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="societyId")
	private CooperativeSociety society;
	


	@Column(name="castedVote")
	private boolean castedVote;
	
	

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public String getVoterIdCardNo() {
		return voterIdCardNo;
	}

	public void setVoterIdCardNo(String voterIdCardNo) {
		this.voterIdCardNo = voterIdCardNo;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReservationCategory() {
		return reservationCategory;
	}

	public void setReservationCategory(String reservationCategory) {
		this.reservationCategory = reservationCategory;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
    
	
	public CooperativeSociety getSociety() {
		return society;
	}

	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}

	public boolean isCastedVote() {
		return castedVote;
	}

	public void setCastedVote(boolean castedVote) {
		this.castedVote = castedVote;
	}

	public RegisteredSocietyVoters() {
		super();
	}
	public RegisteredSocietyVoters(int voterId, String voterIdCardNo, String firstName, String lastName, String gender,
			String password, String reservationCategory, String mobileno, String emailId, String address1,
			String address2, String mandal, String district, int pincode, CooperativeSociety society,
			boolean castedVote) {
		super();
		this.voterId = voterId;
		this.voterIdCardNo = voterIdCardNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.reservationCategory = reservationCategory;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
		this.society = society;
		this.castedVote = castedVote;
	}


	public RegisteredSocietyVoters(String voterIdCardNo, String firstName, String lastName, String gender,
			String password, String reservationCategory, String mobileno, String emailId, String address1,
			String address2, String mandal, String district, int pincode, CooperativeSociety society,
			boolean castedVote) {
		super();
		this.voterIdCardNo = voterIdCardNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.reservationCategory = reservationCategory;
		this.mobileno = mobileno;
		this.emailId = emailId;
		this.address1 = address1;
		this.address2 = address2;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
		this.society = society;
		this.castedVote = castedVote;
	}

	@Override
	public String toString() {
		return "RegisteredSocietyVoters [voterId=" + voterId + ", voterIdCardNo=" + voterIdCardNo + ", firstName="
				+ firstName + ", lastName=" + lastName + ", gender=" + gender + ", password=" + password
				+ ", reservationCategory=" + reservationCategory + ", mobileno=" + mobileno + ", emailId=" + emailId
				+ ", address1=" + address1 + ", address2=" + address2 + ", mandal=" + mandal + ", district=" + district
				+ ", pincode=" + pincode + ", society=" + society + ", castedVote=" + castedVote + "]";
	}

	
	}


















































