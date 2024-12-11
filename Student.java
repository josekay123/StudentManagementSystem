package main;

public class Student extends Person {
    private String studentId;

    // Constructor
    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student ID: " + studentId;
    }
}