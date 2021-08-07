package com.project.schoolsystem.dao;

import java.util.List;
import com.project.schoolsystem.model.Teacher;

public interface TeacherDAO {
	public void addTeacherDetails(Teacher teacher);

	public List<Teacher> readAllTeacherDetails();

	public Teacher readTeacherDetailsById();

	public void updateTeacherDetails();

	public void deleteTeacherDetails();

	public void getSubjectMarks();
}
