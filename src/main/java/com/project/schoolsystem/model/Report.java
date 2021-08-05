package com.project.schoolsystem.model;

public class Report {
    private Integer student_rollNo;
    private Integer teacher_id;
    private String date;
    private String topic;
    public Report() {
    	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Report(Integer student_rollNo, Integer teacher_id, String date, String topic) {
		super();
		this.student_rollNo = student_rollNo;
		this.teacher_id = teacher_id;
		this.date = date;
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "Report [student_rollNo=" + student_rollNo + ", teacher_id=" + teacher_id + ", date=" + date + ", topic="
				+ topic + "]";
	}
    
}
