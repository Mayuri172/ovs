package com.cg.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="election")
public class Election {

	@Id
	@Column(name = "area_code")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer areaCode;
	
	@NotNull
	@Column(name = "start_datetime")
	private LocalDateTime startDatetime;
	
	@NotNull
	@Column(name = "end_datetime")
	private LocalDateTime endDatetime;
	
	
	
	@NotNull
	@Column(name= "place")
	private String place;



	public Election() {
		super();
	}



	public Election(@NotNull Integer areaCode, @NotNull LocalDateTime startDatetime, @NotNull LocalDateTime endDatetime,
			@NotNull String place) {
		super();
		this.areaCode = areaCode;
		this.startDatetime = startDatetime;
		this.endDatetime = endDatetime;
		this.place = place;
	}



	public Integer getAreaCode() {
		return areaCode;
	}



	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}



	public LocalDateTime getStartDatetime() {
		return startDatetime;
	}



	public void setStartDatetime(LocalDateTime startDatetime) {
		this.startDatetime = startDatetime;
	}



	public LocalDateTime getEndDatetime() {
		return endDatetime;
	}



	public void setEndDatetime(LocalDateTime endDatetime) {
		this.endDatetime = endDatetime;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	@Override
	public String toString() {
		return "Election [areaCode=" + areaCode + ", startDatetime=" + startDatetime + ", endDatetime=" + endDatetime
				+ ", place=" + place + "]";
	}
	
	
}
