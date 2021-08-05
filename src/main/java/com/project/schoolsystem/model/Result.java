package com.project.schoolsystem.model;

public class Result {
	private Integer student_rollNo;
	private Integer teacher_id;
	private Integer subjects_id;

	public Result() {

	}

	public Integer getStudent_rollNo() {
		return student_rollNo;
	}

	public void setStudent_rollNo(Integer student_rollNo) {
		this.student_rollNo = student_rollNo;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Integer getSubjects_id() {
		return subjects_id;
	}

	public void setSubjects_id(Integer subjects_id) {
		this.subjects_id = subjects_id;
	}

	@Override
	public String toString() {
		return "Result [student_rollNo=" + student_rollNo + ", teacher_id=" + teacher_id + ", subjects_id="
				+ subjects_id + "]";
	}

	public Result(Integer student_rollNo, Integer teacher_id, Integer subjects_id) {
		super();
		this.student_rollNo = student_rollNo;
		this.teacher_id = teacher_id;
		this.subjects_id = subjects_id;
	}

}
