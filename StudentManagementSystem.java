package main;
import java.io.*;
import java.util.*;


public class StudentManagementSystem {
	   private List<Student> students;

	    public StudentManagementSystem() {
	        students = new ArrayList<>();
	    }

	    public void addStudent(Student student) {
	        students.add(student);
	    }

	    public void listStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No students found.");
	        } else {
	            for (Student student : students) {
	                System.out.println(student);
	            }
	        }
	    }

	    public void saveToFile(String fileName) throws IOException {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            for (Student student : students) {
	                writer.write(student.getName() + "," + student.getAge() + "," + student.getStudentId());
	                writer.newLine();
	            }
	        }
	    }

	    public void loadFromFile(String fileName) throws IOException {
	        students.clear();
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    String name = parts[0];
	                    int age = Integer.parseInt(parts[1]);
	                    String studentId = parts[2];
	                    students.add(new Student(name, age, studentId));
	                }
	            }
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  StudentManagementSystem sms = new StudentManagementSystem();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n--- Student Management System ---");
	            System.out.println("1. Add Student");
	            System.out.println("2. List Students");
	            System.out.println("3. Save to File");
	            System.out.println("4. Load from File");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter age: ");
	                    int age = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter student ID: ");
	                    String studentId = scanner.nextLine();
	                    sms.addStudent(new Student(name, age, studentId));
	                    break;
	                case 2:
	                    sms.listStudents();
	                    break;
	                case 3:
	                    System.out.print("Enter file name to save: ");
	                    String saveFileName = scanner.nextLine();
	                    try {
	                        sms.saveToFile(saveFileName);
	                        System.out.println("Students saved to file.");
	                    } catch (IOException e) {
	                        System.out.println("Error saving to file: " + e.getMessage());
	                    }
	                    break;
	                case 4:
	                    System.out.print("Enter file name to load: ");
	                    String loadFileName = scanner.nextLine();
	                    try {
	                        sms.loadFromFile(loadFileName);
	                        System.out.println("Students loaded from file.");
	                    } catch (IOException e) {
	                        System.out.println("Error loading from file: " + e.getMessage());
	                    }
	                    break;
	                case 5:
	                    System.out.println("Exiting... Goodbye!");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option. Try again.");
	            }
	        }
	    }
	
	}

