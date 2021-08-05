package com.project.schoolsystem.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.schoolsystem.controller.StudentController;
import com.project.schoolsystem.exceptions.InvalidRollNoException;
import com.project.schoolsystem.exceptions.InvalidUserChoiceException;
import com.project.schoolsystem.model.Student;

public class StudentApplication {
	public static void addStudent() throws InvalidRollNoException {
		System.out.println("Enter the number of Students");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("Adding Students Details");
		for (int i = 0; i < number; i++) {
			Student student = new Student();
			System.out.print("Enter roll No:");
			int rollNo = sc.nextInt();
			sc.nextLine();
			if (rollNo < 1) {
				throw new InvalidRollNoException("Roll NO is Invalid");
			}
			System.out.print("Enter name:");
			String name = sc.nextLine();
			System.out.print("Enter address:");
			String address = sc.nextLine();
			System.out.print("Enter dob:");
			String dob = sc.nextLine();
			System.out.print("Enter standard:");
			String standard = sc.nextLine();
			System.out.print("Enter room No:");
			int roomNo = sc.nextInt();
			System.out.print("Enter school id:");
			int id = sc.nextInt();
			student.setStudentRollNo(rollNo);
			student.setStudentName(name);
			student.setStudentDob(dob);
			student.setStudentAddress(address);
			student.setStudentStandard(standard);
			student.setClassesRoomNo(roomNo);
			student.setSchoolId(id);
			studentController.addStudentDetails(student);
		}
		System.out.println("Case 1: Adding Students Details is Completed");
	}

	static StudentController studentController = new StudentController();

	static Logger logger = Logger.getLogger("StudentApplication.class");

	public static void main(String args[]) throws InvalidUserChoiceException {

		logger.info("In Student Application");
		while (true) {
			System.out.println("====== Student Application======");
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
				try {
					addStudent();
				} catch (InvalidRollNoException e) {
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				System.out.println("Enter choice of retrieval");
				Student student = new Student();
				List<Student> studentList = new ArrayList<Student>();
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					System.out.println("Reading All Student Details");
					studentList = studentController.readAllStudentDetails();
					for (Student s : studentList) {
						System.out.println(s);
					}
					System.out.println("Case 2: Reading Students Details is Completed");
					break;
				}
				case 2: {
					System.out.println("Reading Student Details");
					student = studentController.readStudentDetailsById();
					System.out.println(student);
					System.out.println("Case 2: Reading Student Details is Completed");
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("Updating Students Details");
				try {
					studentController.updateStudentDetails();
				} catch (InvalidRollNoException | InvalidUserChoiceException e) {
					logger.info(e.getMessage());
				}
				System.out.println("Case 3: Updating Students Details is Completed");
				break;
			}
			case 4: {
				System.out.println("Deleting Student Details");
				try {
					studentController.deleteStudentDetails();
				} catch (InvalidRollNoException e) {
					e.printStackTrace();
				}
				System.out.println("Case 4: Deleting Students Details is Completed");
				break;
			}
			default:
				throw new InvalidUserChoiceException("User Choice is Invalid");
			}

		}
	}
}
