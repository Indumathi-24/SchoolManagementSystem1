package com.project.schoolsystem.model;

public class Parents {
  private String father_name;
  private String mother_name;
  private Integer student_rollNo;
  public Parents() {
	  
  }
public Parents(String father_name, String mother_name, Integer student_rollNo) {
	super();
	this.father_name = father_name;
	this.mother_name = mother_name;
	this.student_rollNo = student_rollNo;
}

public String getFather_name() {
	return father_name;
}
public void setFather_name(String father_name) {
	this.father_name = father_name;
}
public String getMother_name() {
	return mother_name;
}
public void setMother_name(String mother_name) {
	this.mother_name = mother_name;
}
public Integer getStudent_rollNo() {
	return student_rollNo;
}
public void setStudent_rollNo(Integer student_rollNo) {
	this.student_rollNo = student_rollNo;
}
@Override
public String toString() {
	return "Parents [father_name=" + father_name + ", mother_name=" + mother_name + ", student_rollNo=" + student_rollNo
			+ "]";
}
 
}
