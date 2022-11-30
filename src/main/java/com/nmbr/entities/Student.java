package com.nmbr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")

public class Student {

	@Column(name = "student_name")
	private String student_name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int student_id;
	public Student(String student_name, int student_id) {
		super();
		this.student_name = student_name;
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	@Override
	public String toString() {
		return "Student [student_name=" + student_name + ", student_id=" + student_id + "]";
	}
	
	
	
}
