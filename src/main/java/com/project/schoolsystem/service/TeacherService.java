package com.project.schoolsystem.service;

import java.util.List;

import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Teacher;

public interface TeacherService {
	public void addTeacherDetails(Teacher teacher);

	public List<Teacher> readAllTeacherDetails();

	public Teacher readTeacherDetailsById();

	public void updateTeacherDetails() throws InvalidRollNoException, InvalidUserChoiceException;

	public void deleteTeacherDetails() throws InvalidRollNoException;
}
