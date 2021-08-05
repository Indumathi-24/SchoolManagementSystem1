package com.project.schoolsystem.model;

public class Teacher {
	private Integer teacherId;
	private String teacherName;
	private String teacherAddress;
	private String teacherDob;
	private String teacherStandard;
	private String teacherDesignation;
	private Integer classesRoomNo;
	private Integer schoolId;

	public Teacher() {

	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherDob() {
		return teacherDob;
	}

	public void setTeacherDob(String teacherDob) {
		this.teacherDob = teacherDob;
	}

	public String getTeacherStandard() {
		return teacherStandard;
	}

	public void setTeacherStandard(String teacherStandard) {
		this.teacherStandard = teacherStandard;
	}

	public String getTeacherDesignation() {
		return teacherDesignation;
	}

	public void setTeacherDesignation(String teacherDesignation) {
		this.teacherDesignation = teacherDesignation;
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
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherAddress=" + teacherAddress
				+ ", teacherDob=" + teacherDob + ", teacherStandard=" + teacherStandard + ", teacherDesignation="
				+ teacherDesignation + ", classesRoomNo=" + classesRoomNo + ", schoolId=" + schoolId + "]";
	}

	public Teacher(Integer teacherId, String teacherName, String teacherAddress, String teacherDob,
			String teacherStandard, String teacherDesignation, Integer classesRoomNo, Integer schoolId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherAddress = teacherAddress;
		this.teacherDob = teacherDob;
		this.teacherStandard = teacherStandard;
		this.teacherDesignation = teacherDesignation;
		this.classesRoomNo = classesRoomNo;
		this.schoolId = schoolId;
	}

	
}
