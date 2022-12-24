package com.example.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import org.springframework.stereotype.Component;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="TAtable")
public class TA {
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name="USER_ID")
	private int UserID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Basic
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Basic
	@Column(name="LAST_NAME")
	private String lastname;

	public Date getCodereviewdate() {
		return codereviewdate;
	}

	public void setCodereviewdate(Date codereviewdate) {
		this.codereviewdate = codereviewdate;
	}

	public int getCodereviewperiod() {
		return codereviewperiod;
	}

	public void setCodereviewperiod(int codereviewperiod) {
		this.codereviewperiod = codereviewperiod;
	}

	public Date getCodereviewstart() {
		return codereviewstart;
	}

	public void setCodereviewstart(Date codereviewstart) {
		this.codereviewstart = codereviewstart;
	}

	public Date getCodereviewend() {
		return codereviewend;
	}

	public void setCodereviewend(Date codereviewend) {
		this.codereviewend = codereviewend;
	}

//	public Set<TACodeReview> getCodereviewlist() {
//		return codereviewlist;
//	}
//
//	public void setCodereviewlist(Set<TACodeReview> codereviewlist) {
//		this.codereviewlist = codereviewlist;
//	}


	
	@Basic
	@Column(name="CODE_REVIEW_DATE")
	private Date codereviewdate;
	
	@Basic
	@Column(name="CODE_REVIEW_PERIOD")
	private int codereviewperiod;
	
	@Basic
	@Column(name="CODE_REVIEW_START")
	private Date codereviewstart;
	
	@Basic
	@Column(name="CODE_REVIEW_END")
	private Date codereviewend;
	
	@Basic
	private int assignment_num;
	
//	@OneToMany(mappedBy="ta")
//	private Set<TACodeReview> codereviewlist = new HashSet<>();


	public int getAssignment_num() {
		return assignment_num;
	}

	public void setAssignment_num(int assignment_num) {
		this.assignment_num = assignment_num;
	}

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="TA_ID")
//	private Set<TACodeReview> codereviewlist = new HashSet<>();
	
	public TA() {
		
	}

	


}
