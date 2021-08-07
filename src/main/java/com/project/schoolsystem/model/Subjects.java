package com.project.schoolsystem.model;

public class Subjects {
	private Integer subjectId;
	private String subjectName;

	public Subjects() {

	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subjects [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}

	public Subjects(Integer subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}

}
