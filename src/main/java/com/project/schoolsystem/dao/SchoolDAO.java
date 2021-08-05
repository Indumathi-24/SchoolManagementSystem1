package com.project.schoolsystem.dao;

import java.util.List;

import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.School;

public interface SchoolDAO {
	public void addSchoolDetails(School school);
	public School readSchoolDetails();
}
