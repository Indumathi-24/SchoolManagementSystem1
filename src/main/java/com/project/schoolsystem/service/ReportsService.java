package com.project.schoolsystem.service;

import java.util.List;

import com.project.schoolsystem.exceptions.InvalidIdException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Reports;

public interface ReportsService {
	public void addReportsDetails(Reports Reports);

	public List<Reports> readAllReportsDetails();

	public Reports readReportsDetailsById();

	public void updateReportsDetails() throws InvalidIdException, InvalidUserChoiceException;

	public void deleteReportsDetails() throws InvalidIdException;
}
