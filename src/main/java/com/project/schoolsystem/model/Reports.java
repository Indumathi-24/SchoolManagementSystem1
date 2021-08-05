package com.project.schoolsystem.model;

public class Reports {
	private Integer subject_id;
	private Integer teacher_id;
	private String date;
	private String topic;

	public Reports() {

	}

	public Integer getSubjects_id() {
		return subject_id;
	}

	public void setSubjects_id(Integer subject_id) {
		this.subject_id = subject_id;
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

	public Reports(Integer subject_id, Integer teacher_id, String date, String topic) {
		super();
		this.subject_id = subject_id;
		this.teacher_id = teacher_id;
		this.date = date;
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Report [subject_id=" + subject_id + ", teacher_id=" + teacher_id + ", date=" + date + ", topic=" + topic
				+ "]";
	}

}
