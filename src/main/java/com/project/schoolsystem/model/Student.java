package com.project.schoolsystem.model;

public class Student {
	private Integer student_rollNo;
    private String student_name;
    private String student_address;
    private String student_dob;
    private String student_standard;
    private Integer classes_roomNo;
    private Integer school_id;
    public Student() {
    	
    }
    
	public Student(Integer student_rollNo, String student_name, String student_address, String student_dob,
			String student_standard, Integer classes_roomNo, Integer school_id) {
		super();
		this.student_rollNo = student_rollNo;
		this.student_name = student_name;
		this.student_address = student_address;
		this.student_dob = student_dob;
		this.student_standard = student_standard;
		this.classes_roomNo = classes_roomNo;
		this.school_id = school_id;
	}

	public Integer getStudent_rollNo() {
		return student_rollNo;
	}
	public void setStudent_rollNo(Integer student_rollNo) {
		this.student_rollNo = student_rollNo;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	public String getStudent_dob() {
		return student_dob;
	}
	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}
	public String getStudent_standard() {
		return student_standard;
	}
	public void setStudent_standard(String student_standard) {
		this.student_standard = student_standard;
	}
	public Integer getClasses_roomNo() {
		return classes_roomNo;
	}
	public void setClasses_roomNo(Integer classes_roomNo) {
		this.classes_roomNo = classes_roomNo;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	@Override
	public String toString() {
		return "Student [student_rollNo=" + student_rollNo + ", student_name=" + student_name + ", student_address="
				+ student_address + ", student_dob=" + student_dob + ", student_standard=" + student_standard
				+ ", classes_roomNo=" + classes_roomNo + ", school_id=" + school_id + "]";
	}
	
	
}
