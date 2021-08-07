package com.project.schoolsystem.model;

public class School {
	private Integer schoolId;
	private String schoolName;
	private String schoolAddress;

	public School() {

	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress + "]";
	}

	public School(Integer schoolId, String schoolName, String schoolAddress) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
	}

}
