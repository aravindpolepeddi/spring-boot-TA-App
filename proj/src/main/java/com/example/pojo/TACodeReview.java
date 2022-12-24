package com.example.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="TACodeReview")
public class TACodeReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Basic
	@Column(name="ASSIGNMENT_NUM")
	private int Assignment_num;
	
	@Basic
	@Column(name="STUDENT_ID")
	private int student_id;
	
	@Basic
	@Column(name="TA_ID")
	private int ta_id;
	
	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getTa_id() {
		return ta_id;
	}

	public void setTa_id(int ta_id) {
		this.ta_id = ta_id;
	}

	@Basic
	@Column(name="STUDENT_CODE_REVIEW_DATE")
	private Date studentcodereviewdate;
	
	@Basic
	@Column(name="STUDENT_MARKS")
	private int student_marks;
	
	public Date getStudentcodereviewdate() {
		return studentcodereviewdate;
	}

	public void setStudentcodereviewdate(Date studentcodereviewdate) {
		this.studentcodereviewdate = studentcodereviewdate;
	}

	public int getStudent_marks() {
		return student_marks;
	}

	public void setStudent_marks(int student_marks) {
		this.student_marks = student_marks;
	}

	public String getTa_remarks() {
		return ta_remarks;
	}

	public void setTa_remarks(String ta_remarks) {
		this.ta_remarks = ta_remarks;
	}

	public String getStudent_concerns() {
		return student_concerns;
	}

	public void setStudent_concerns(String student_concerns) {
		this.student_concerns = student_concerns;
	}

	public Date getStudentcodereviewstart() {
		return studentcodereviewstart;
	}

	public void setStudentcodereviewstart(Date studentcodereviewstart) {
		this.studentcodereviewstart = studentcodereviewstart;
	}

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}

	@Basic
	@Column(name="TA_REMARKS")
	private String ta_remarks;
	
	@Basic
	@Column(name="STUDENT_CONCERNS")
	private String student_concerns;
	
	@Basic
	@Column(name="STUDENT_CODE_REVIEW_START")
	private Date studentcodereviewstart;
	
//	@ManyToOne
//	private TA ta;
//	
//	@ManyToOne
//	private Student student;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAssignment_num() {
		return Assignment_num;
	}

	public void setAssignment_num(int assignment_num) {
		Assignment_num = assignment_num;
	}

//	public TA getTa() {
//		return ta;
//	}
//
//	public void setTa(TA ta) {
//		this.ta = ta;
//	}
	
}
