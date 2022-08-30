package com.mle.emp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import org.apache.el.parser.AstFalse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(uniqueConstraints = @UniqueConstraint(name="uc_email",columnNames = ("email")))
public class Employee {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer emp_id;
	
	@Column(nullable = false, length=100)
	private String password;

	
	//	(cascade=CascadeType.ALL)
	
			
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	//@UniqueConstraint(columnNames =  "email" )
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String gender;
	
	@JsonFormat(pattern = "dd-mm-yyyy",shape = Shape.STRING)
	@Column(name = "date_of_birth")
	private String date_of_birth;
	
	@Column(name = "mobile")
	private long mobile;
	
	@Column(name = "aadhar")
//@NotNull(message="Adhar should not ne Null")
	private long aadhar;
	@Column(name = "pan_no")
	private String pan_no;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "joining_date")
	private String joining_date;
	
	@Column(name = "account_no")
	private long account_no;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name = "ifsc_code")
	private String ifsc_code;
	
	
	
	@Column(name = "bank_name")
	private String bank_name;
	
	@Column(name="blood_group")
	private String blood_group;
	
	
//	@Column(name = "image_name")
//	private String image_name;
//
//	@Column(name = "type")
//	private String type;
//
//	@Column(name = "image", unique = false, nullable = false, length = 100000)
//	private byte[] image;

	public String getBlood_group() {
		return blood_group;
	}



	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}



	public Integer getEmp_id() {
		return emp_id;
	}



	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
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



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getDate_of_birth() {
		return date_of_birth;
	}



	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}



	public long getMobile() {
		return mobile;
	}



	public void setMobile(long mobile) {
		this.mobile = mobile;
	}



	public long getAadhar() {
		return aadhar;
	}



	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}



	public String getPan_no() {
		return pan_no;
	}



	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getJoining_date() {
		return joining_date;
	}



	public void setJoning_date(String joning_date) {
		this.joining_date = joning_date;
	}



	public long getAccount_no() {
		return account_no;
	}



	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}



	public String getIfsc_code() {
		return ifsc_code;
	}



	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}



	public String getBank_name() {
		return bank_name;
	}



	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	




	
	
	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}


	@OneToOne
	private User user;


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	


	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", password=" + password + ",  firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", date_of_birth="
				+ date_of_birth + ", mobile=" + mobile + ", aadhar=" + aadhar + ", pan_no=" + pan_no + ", address="
				+ address + ", joining_date=" + joining_date + ", account_no=" + account_no + ", designation="
				+ designation + ", ifsc_code=" + ifsc_code + ", bank_name=" + bank_name + ", blood_group=" + blood_group
				+ "]";
	}

//	private String image;
//
//	public String getImage() {
//		return image;
//	}
//
//
//
//	public void setImage(String image) {
//		this.image = image;
//	}





	
	
//	@Lob
//	private byte[] profile_photo;
	
	
	
	
	

}
