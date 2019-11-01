package com.intech.spring.controller.student.bean;

import java.io.Serializable;

public class AddStudentRequestBean implements Serializable {

	private static final long serialVersionUID = 124688157820489273L;

	private String name;

	private int marks;

	private String mobile;

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
