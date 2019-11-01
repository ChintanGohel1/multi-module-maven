package com.intech.spring.controller.student.bean;

import java.io.Serializable;

public class StudentBean implements Serializable {

	private static final long serialVersionUID = -4456580234914608806L;

	private int id;

	private String name;

	private int marks;

	private String mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
