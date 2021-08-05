package com.project.schoolsystem.model;

public class Marks {
	private Integer student_rollNo;
    private Integer tamil;
    private Integer english;
    private Integer maths;
    private Integer science;
    private Integer social_science;
    private Integer evs;
    public Marks() {
    	
    }
	public Integer getStudent_rollNo() {
		return student_rollNo;
	}
	public void setStudent_rollNo(Integer student_rollNo) {
		this.student_rollNo = student_rollNo;
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
	public Integer getSocial_science() {
		return social_science;
	}
	public void setSocial_science(Integer social_science) {
		this.social_science = social_science;
	}
	public Integer getEvs() {
		return evs;
	}
	public void setEvs(Integer evs) {
		this.evs = evs;
	}
	public Marks(Integer student_rollNo, Integer tamil, Integer english, Integer maths, Integer science,
			Integer social_science, Integer evs) {
		super();
		this.student_rollNo = student_rollNo;
		this.tamil = tamil;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.social_science = social_science;
		this.evs = evs;
	}
	@Override
	public String toString() {
		return "Marks [student_rollNo=" + student_rollNo + ", tamil=" + tamil + ", english=" + english + ", maths="
				+ maths + ", science=" + science + ", social_science=" + social_science + ", evs=" + evs + "]";
	}
    
	
}
