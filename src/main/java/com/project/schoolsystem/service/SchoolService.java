package com.project.schoolsystem.service;



import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.School;

public interface SchoolService {
	public void addSchoolDetails(School School);
	public School readSchoolDetails();
}
