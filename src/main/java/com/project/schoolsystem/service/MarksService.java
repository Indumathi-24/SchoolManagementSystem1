package com.project.schoolsystem.service;

import java.util.List;
import com.project.schoolsystem.model.Marks;

public interface MarksService {
	public void addMarksDetails(Marks marks);

	public List<Marks> readAllMarksDetails();

	public Marks readMarksDetailsByStudentRollNo();

	public void updateMarksDetails();

	public void deleteMarksDetails();

}
