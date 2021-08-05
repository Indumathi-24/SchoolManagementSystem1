package com.project.schoolsystem.model;

public class School {
	private Integer school_id;
	private String school_name;
    private String school_address;
    public School() {
    	
    }
	public School(Integer school_id, String school_name, String school_address) {
		super();
		this.school_id = school_id;
		this.school_name = school_name;
		this.school_address = school_address;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getSchool_address() {
		return school_address;
	}
	public void setSchool_address(String school_address) {
		this.school_address = school_address;
	}
	@Override
	public String toString() {
		return "School [school_id=" + school_id + ", school_name=" + school_name + ", school_address=" + school_address
				+ "]";
	}
    
}
