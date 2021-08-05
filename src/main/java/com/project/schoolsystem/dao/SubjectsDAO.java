package com.project.schoolsystem.dao;

import java.util.List;

import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Subjects;

public interface SubjectsDAO {
	public void addSubjectsDetails(Subjects subjects);

	public List<Subjects> readAllSubjectsDetails();

	public Subjects readSubjectsDetailsBySubjectId();

	public void updateSubjectsDetails() throws InvalidIdException, InvalidUserChoiceException;

	public void deleteSubjectsDetails() throws InvalidIdException;
}
