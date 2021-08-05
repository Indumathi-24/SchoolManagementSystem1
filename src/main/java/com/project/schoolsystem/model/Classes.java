package com.project.schoolsystem.model;

public class Classes {
    private String standard;
    private String section;
    private Integer classes_roomNo;
    public Classes() {
    	
    }
	public Classes(String standard, String section, Integer classes_roomNo) {
		super();
		this.standard = standard;
		this.section = section;
		this.classes_roomNo = classes_roomNo;
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
	public Integer getClasses_roomNo() {
		return classes_roomNo;
	}
	public void setClasses_roomNo(Integer classes_roomNo) {
		this.classes_roomNo = classes_roomNo;
	}
	@Override
	public String toString() {
		return "Classes [standard=" + standard + ", section=" + section + ", classes_roomNo=" + classes_roomNo + "]";
	}
    
}
