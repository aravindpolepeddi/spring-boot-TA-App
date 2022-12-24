package com.example.pojo;


import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="studenttable")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name="USER_ID")
	private int User_ID;
	
	@Column(name="NU_ID")
	private int NU_ID;
	
	@Column(name="TA_ID")
	private int ta_id;
	
	public int getTa_id() {
		return ta_id;
	}

	public void setTa_id(int ta_id) {
		this.ta_id = ta_id;
	}

	public int getNU_ID() {
		return NU_ID;
	}

	public void setNU_ID(int nU_ID) {
		NU_ID = nU_ID;
	}

//	public Set<TACodeReview> getCodereviewlist() {
//		return codereviewlist;
//	}
//
//	public void setCodereviewlist(Set<TACodeReview> codereviewlist) {
//		this.codereviewlist = codereviewlist;
//	}


	@Basic
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Basic
	@Column(name="LAST_NAME")
	private String lastname;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="STUDENT_ID")
//	private Set<TACodeReview> codereviewlist = new HashSet<>();
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
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


	public Student() {
		
	}
	
	
	
}
