package com.cg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="nominations")
public class Nominations {
	
	@NotNull
	@Column(name="name")
	private String name;

	@NotNull
	@Column(name="age")
	@Min(25)
	private Integer age;
	
	@NotNull
	@Column(name="place")
	private String place;
	
	@NotNull
	@Column(name="sex")
	private String sex;
	
	@NotNull
	@Max(10)
	@Column(name="criminal_record")
	private Integer criminalRecord;
	
	@NotNull
	@Column(name="party_name")
	private String partyName;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nomination_no")
	private Integer nominationNo;

	/*
	 @OneToOne(mappedBy = "nominations", cascade = CascadeType.ALL)
	    @PrimaryKeyJoinColumn
	    private Voting voting;
	    
	*/
	
	public Nominations(String name, @Min(25) Integer age, String place, String sex, @Max(10) Integer criminalRecord,
			String partyName, Integer nominationNo) {
		super();
		this.name = name;
		this.age = age;
		this.place = place;
		this.sex = sex;
		this.criminalRecord = criminalRecord;
		this.partyName = partyName;
		this.nominationNo = nominationNo;
	}

	public Nominations() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Integer getCriminalRecord() {
		return criminalRecord;
	}

	public void setCriminalRecord(Integer criminalRecord) {
		this.criminalRecord = criminalRecord;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public Integer getNominationNo() {
		return nominationNo;
	}

	public void setNominationNo(Integer nominationNo) {
		this.nominationNo = nominationNo;
	}

	@Override
	public String toString() {
		return "Nominations [name=" + name + ", age=" + age + ", place=" + place + ", sex=" + sex + ", criminalRecord="
				+ criminalRecord + ", partyName=" + partyName + ", nominationNo=" + nominationNo + "]";
	}
	
	
}
