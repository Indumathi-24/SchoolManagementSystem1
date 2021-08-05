package com.project.schoolsystem.model;

public class Student {
	private Integer studentRollNo;
	private String studentName;
	private String studentAddress;
	private String studentDob;
	private String studentStandard;
	private Integer classesRoomNo;
	private Integer schoolId;
	public Student() {
		
	}
	public Integer getStudentRollNo() {
		return studentRollNo;
	}
	public void setStudentRollNo(Integer studentRollNo) {
		this.studentRollNo = studentRollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentDob() {
		return studentDob;
	}
	public void setStudentDob(String studentDob) {
		this.studentDob = studentDob;
	}
	public String getStudentStandard() {
		return studentStandard;
	}
	public void setStudentStandard(String studentStandard) {
		this.studentStandard = studentStandard;
	}
	public Integer getClassesRoomNo() {
		return classesRoomNo;
	}
	public void setClassesRoomNo(Integer classesRoomNo) {
		this.classesRoomNo = classesRoomNo;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	@Override
	public String toString() {
		return "Student [studentRollNo=" + studentRollNo + ", studentName=" + studentName + ", studentAddress="
				+ studentAddress + ", studentDob=" + studentDob + ", studentStandard=" + studentStandard
				+ ", classesRoomNo=" + classesRoomNo + ", schoolId=" + schoolId + "]";
	}
	public Student(Integer studentRollNo, String studentName, String studentAddress, String studentDob,
			String studentStandard, Integer classesRoomNo, Integer schoolId) {
		super();
		this.studentRollNo = studentRollNo;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentDob = studentDob;
		this.studentStandard = studentStandard;
		this.classesRoomNo = classesRoomNo;
		this.schoolId = schoolId;
	}

	
}
