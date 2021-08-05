package com.project.schoolsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.TeacherController;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Teacher;

public class TeacherApplication {
	public static void addTeacher() throws InvalidRollNoException {
		System.out.println("Enter the number of Teachers");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Adding Teachers Details");
		for (int i = 0; i < number; i++) {
			Teacher teacher = new Teacher();
			System.out.print("Enter roll No:");
			int rollNo = sc.nextInt();
			sc.nextLine();
			if (rollNo < 1) {
				throw new InvalidRollNoException("Roll NO is Invalid");
			}
			System.out.print("Enter roll No:");
			String name = sc.nextLine();
			System.out.print("Enter name:");
			String address = sc.nextLine();
			System.out.print("Enter dob:");
			String dob = sc.nextLine();
			System.out.print("Enter standard:");
			String standard = sc.nextLine();
			System.out.print("Enter designation:");
			String designation = sc.nextLine();
			System.out.print("Enter room No:");
			int roomNo = sc.nextInt();
			System.out.print("Enter id:");
			int id = sc.nextInt();
			teacher.setTeacherId(rollNo);
			teacher.setTeacherName(name);
			teacher.setTeacherDob(dob);
			teacher.setTeacherAddress(address);
			teacher.setTeacherStandard(standard);
			teacher.setTeacherDesignation(designation);
			teacher.setClassesRoomNo(roomNo);
			teacher.setSchoolId(id);
			teacherController.addTeacherDetails(teacher);
		}
		System.out.println("Case 1: Adding Teachers Details is Completed");
	}

	static TeacherController teacherController = new TeacherController();

	 static Logger logger=Logger.getLogger("SchoolManagementTeacherApplication.class");
	public static void main(String args[]) throws InvalidRollNoException, InvalidUserChoiceException {
		logger.info("In Teacher Application");
		while (true) {
			System.out.println("======Teacher Application======");
			System.out.println("0.======Exit======");
			System.out.println("1.======Insertion======");
			System.out.println("2.======Retrieval======");
			System.out.println("3.======Updation======");
			System.out.println("4.======Deletion======");
			System.out.println("Enter your choice");
			Scanner scanner = new Scanner(System.in);
			int userChoice = scanner.nextInt();
			switch (userChoice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				addTeacher();
				break;
			}

			case 2: {
				System.out.println("Enter choice of retrieval");
				Teacher teacher = new Teacher();
				List<Teacher> teacherList = new ArrayList<Teacher>();
				Scanner sn = new Scanner(System.in);
				int choice = sn.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Reading All Teacher Details");
					teacherList = teacherController.readAllTeacherDetails();
					for (Teacher s : teacherList) {
						System.out.println(s);
					}
					System.out.println("Case 2: Reading Teachers Details is Completed");
					break;
				}
				case 2: {
					System.out.println("Reading Teacher Details");
					teacher = teacherController.readTeacherDetailsById();
					System.out.println(teacher);
					System.out.println("Case 2: Reading Teacher Details is Completed");
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Updating Teachers Details");
				teacherController.updateTeacherDetails();
				System.out.println("Case 3: Updating teachers Details is Completed");
				break;
			}
			case 4: {
				System.out.println("Deleting Teachers Details");
				teacherController.deleteTeacherDetails();
				System.out.println("Case 4: Deleting Teachers Details is Completed");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
