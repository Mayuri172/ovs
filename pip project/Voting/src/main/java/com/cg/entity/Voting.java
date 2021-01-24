package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Voting {

	//@NotNull
	@Id
	@Column(name="nomination_no")
	private Integer nominationNo;
	/*
	@Id , unique = true
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	*/
	
	@NotNull
	@Column(name = "vote_count")
	private Integer voteCount;

	@NotNull
	@Column(name = "candidateName")
	private String candidateName;
	
	/*
	@OneToOne
    @MapsId
    @JoinColumn(name = "nomination_no")
    private Nominations nominations;
	*/
	
	public Voting() {
		super();
	}

	

	public Voting(Integer nominationNo, @NotNull Integer voteCount, @NotNull String candidateName) {
		super();
		this.nominationNo = nominationNo;
		this.voteCount = voteCount;
		this.candidateName = candidateName;
	}



	/*
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	*/
	public Integer getNominationNo() {
		return nominationNo;
	}

	public void setNominationNo(Integer nominationNo) {
		this.nominationNo = nominationNo;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}



	public String getCandidateName() {
		return candidateName;
	}



	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}



	@Override
	public String toString() {
		return "Voting [nominationNo=" + nominationNo + ", voteCount=" + voteCount + ", candidateName=" + candidateName
				+ "]";
	}



	

	


	
	
	
}
