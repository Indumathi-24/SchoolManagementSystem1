package com.project.schoolsystem.dao;

import java.util.List;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Marks;

public interface MarksDAO {
	public void addMarksDetails(Marks Marks);

	public List<Marks> readAllMarksDetails();

	public Marks readMarksDetailsByStudentRollNo();

	public void updateMarksDetails() throws InvalidRollNoException, InvalidUserChoiceException;

	public void deleteMarksDetails() throws InvalidRollNoException;
}
