package com.project.schoolsystem.model;

public class Teacher {
	private Integer teacher_id;
	private String teacher_name;
	private String teacher_address;
	private String teacher_dob;
	private String teacher_standard;
	private String teacher_designation;
	private Integer classes_roomNo;
    private Integer school_id;
	public Teacher() {
		
	}
	
	public Teacher(Integer teacher_id, String teacher_name, String teacher_address, String teacher_dob,
			String teacher_standard, String teacher_designation, Integer classes_roomNo, Integer school_id) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_address = teacher_address;
		this.teacher_dob = teacher_dob;
		this.teacher_standard = teacher_standard;
		this.teacher_designation = teacher_designation;
		this.classes_roomNo = classes_roomNo;
		this.school_id = school_id;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_address() {
		return teacher_address;
	}
	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}
	public String getTeacher_dob() {
		return teacher_dob;
	}
	public void setTeacher_dob(String teacher_dob) {
		this.teacher_dob = teacher_dob;
	}
	public String getTeacher_standard() {
		return teacher_standard;
	}
	public void setTeacher_standard(String teacher_standard) {
		this.teacher_standard = teacher_standard;
	}
	public String getTeacher_designation() {
		return teacher_designation;
	}
	public void setTeacher_designation(String teacher_designation) {
		this.teacher_designation = teacher_designation;
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
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", teacher_address="
				+ teacher_address + ", teacher_dob=" + teacher_dob + ", teacher_standard=" + teacher_standard
				+ ", teacher_designation=" + teacher_designation + ", classes_roomNo=" + classes_roomNo + ", school_id="
				+ school_id + "]";
	}
	
}
