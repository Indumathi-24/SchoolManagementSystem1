package com.project.schoolsystem.dao;

import java.util.List;
import com.project.schoolsystem.model.Marks;

public interface MarksDAO {
	public void addMarksDetails(Marks marks);

	public List<Marks> readAllMarksDetails();

	public Marks readMarksDetailsByStudentRollNo();

	public void updateMarksDetails();

	public void deleteMarksDetails();

	public void totalMarksByStudentRollNo();
}
