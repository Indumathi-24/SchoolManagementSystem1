package com.project.schoolsystem.service;

import com.project.schoolsystem.model.School;

public interface SchoolService {
	public void addSchoolDetails(School school);

	public School readSchoolDetails();
}
