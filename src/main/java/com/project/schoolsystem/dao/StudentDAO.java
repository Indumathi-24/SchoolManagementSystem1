package com.project.schoolsystem.dao;

import java.util.List;

import com.project.schoolsystem.model.Student;

public interface StudentDAO {
	public void addStudentDetails(Student student);

	public List<Student> readAllStudentDetails();

	public Student readStudentDetailsById();

	public void updateStudentDetails();

	public void deleteStudentDetails();

	public void studentParentsDetails();
}
