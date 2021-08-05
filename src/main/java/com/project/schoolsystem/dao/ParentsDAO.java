package com.project.schoolsystem.dao;

import java.util.List;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Parents;

public interface ParentsDAO {
	public void addParentsDetails(Parents parents);

	public List<Parents> readAllParentsDetails();

	public Parents readParentsDetailsByStudentRollNo();

	public void updateParentsDetails() throws InvalidRollNoException, InvalidUserChoiceException;

	public void deleteParentsDetails() throws InvalidRollNoException;
}
