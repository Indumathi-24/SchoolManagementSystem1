package com.project.schoolsystem.dao;

import com.project.schoolsystem.model.School;

public interface SchoolDAO {
	public void addSchoolDetails(School school);

	public School readSchoolDetails();
}
