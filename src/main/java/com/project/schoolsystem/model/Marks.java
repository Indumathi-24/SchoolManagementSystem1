package com.project.schoolsystem.model;

public class Marks {
	private Integer studentRollNo;
	private Integer tamil;
	private Integer english;
	private Integer maths;
	private Integer science;
	private Integer socialScience;
	private Integer evs;

	public Marks() {

	}

	public Integer getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(Integer studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public Integer getTamil() {
		return tamil;
	}

	public void setTamil(Integer tamil) {
		this.tamil = tamil;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getScience() {
		return science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

	public Integer getSocialScience() {
		return socialScience;
	}

	public void setSocialScience(Integer socialScience) {
		this.socialScience = socialScience;
	}

	public Integer getEvs() {
		return evs;
	}

	public void setEvs(Integer evs) {
		this.evs = evs;
	}

	@Override
	public String toString() {
		return "Marks [studentRollNo=" + studentRollNo + ", tamil=" + tamil + ", english=" + english + ", maths="
				+ maths + ", science=" + science + ", socialScience=" + socialScience + ", evs=" + evs + "]";
	}

	public Marks(Integer studentRollNo, Integer tamil, Integer english, Integer maths, Integer science,
			Integer socialScience, Integer evs) {
		super();
		this.studentRollNo = studentRollNo;
		this.tamil = tamil;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.socialScience = socialScience;
		this.evs = evs;
	}

}
