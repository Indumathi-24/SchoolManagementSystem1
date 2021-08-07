package com.project.schoolsystem.service;

import java.util.List;

import com.project.schoolsystem.model.Subjects;

public interface SubjectsService {
	public void addSubjectsDetails(Subjects subjects);

	public List<Subjects> readAllSubjectsDetails();

	public Subjects readSubjectsDetailsBySubjectId();

	public void updateSubjectsDetails();

	public void deleteSubjectsDetails();
}
