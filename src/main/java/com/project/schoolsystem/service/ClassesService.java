package com.project.schoolsystem.service;

import java.util.List;
import com.project.schoolsystem.model.Classes;

public interface ClassesService {
	public void addClassesDetails(Classes classes);

	public List<Classes> readAllClassesDetails();

	public Classes readClassesDetailsByRoomNo();

	public void updateClassesDetails();

	public void deleteClassesDetails();
}
