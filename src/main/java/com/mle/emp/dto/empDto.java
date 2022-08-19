package com.mle.emp.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor


public class empDto {
	
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


	private Integer emp_id;
	
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	private String email;
	private String gender;
	
	private String date_of_birth;
	private long  mobile;
	private long aadhar;
	private String pan_no;
	private String address;
	private String blood_group;
	//private String joining_date;
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

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
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


	private String joining_date;
	private String bank_name;
	private long account_no;
	private String ifsc_code;
	private String designation;
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	
	
	
	
}
