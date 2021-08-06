package com.project.schoolsystem.model;

import java.util.Objects;

public class Classes {
	private String standard;
	private String section;
	private Integer classesRoomNo;

	public Classes() {

	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Integer getClassesRoomNo() {
		return classesRoomNo;
	}

	public void setClassesRoomNo(Integer classesRoomNo) {
		this.classesRoomNo = classesRoomNo;
	}

	@Override
	public String toString() {
		return "Classes [standard=" + standard + ", section=" + section + ", classesRoomNo=" + classesRoomNo + "]";
	}

	public Classes(String standard, String section, Integer classesRoomNo) {
		super();
		this.standard = standard;
		this.section = section;
		this.classesRoomNo = classesRoomNo;
	}

	
	
}
