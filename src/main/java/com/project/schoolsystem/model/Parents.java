package com.project.schoolsystem.model;

public class Parents {
	private String fatherName;
	private String motherName;
	private Integer studentRollNo;

	public Parents(String fatherName, String motherName, Integer studentRollNo) {
		super();
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.studentRollNo = studentRollNo;
	}

	@Override
	public String toString() {
		return "Parents [fatherName=" + fatherName + ", motherName=" + motherName + ", studentRollNo=" + studentRollNo
				+ "]";
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Integer getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(Integer studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public Parents() {

	}

}
