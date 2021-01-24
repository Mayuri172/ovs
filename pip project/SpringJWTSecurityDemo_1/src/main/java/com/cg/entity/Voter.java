package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Voter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="voter_id")
	private Integer voterId;
	
	@NotNull
	@Column(name="name")
	private String name;

	@NotNull
	@Column(name="dob")
	private LocalDate dob;
	
	@NotNull
	@Column(name="place")
	private String place;
	
	@NotNull
	@Column(name="sex")
	private String sex;
	
	@NotNull
	@Column(name ="aadhar_no", unique = true)
	private Integer aadharNo;
	
	@NotNull
	@Column(name="user_name", unique = true)
	private String userName;
	
	
	@NotNull
	@Column(name="password")
	private String password;

	@NotNull
	@Column(name="email")
	private String email;

	@NotNull
	@Column(name="mobile_no")
	private Long mobileNo;
	
	

	public Voter(Integer voterId, @NotNull String name, @NotNull LocalDate dob, @NotNull String place,
			@NotNull String sex, @NotNull Integer aadharNo, @NotNull String userName, @NotNull String password,
			@NotNull String email, @NotNull Long mobileNo) {
		super();
		this.voterId = voterId;
		this.name = name;
		this.dob = dob;
		this.place = place;
		this.sex = sex;
		this.aadharNo = aadharNo;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
	}



	public Voter() {
		super();
	}


	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public Integer getVoterId() {
		return voterId;
	}


	public void setVoterId(Integer voterId) {
		this.voterId = voterId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Integer getAadharNo() {
		return aadharNo;
	}


	public void setAadharNo(Integer aadharNo) {
		this.aadharNo = aadharNo;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}



	@Override
	public String toString() {
		return "Voter [voterId=" + voterId + ", name=" + name + ", dob=" + dob + ", place=" + place + ", sex=" + sex
				+ ", aadharNo=" + aadharNo + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", mobileNo=" + mobileNo + "]";
	}

	
	
	
}
