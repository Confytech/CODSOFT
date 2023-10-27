package org.example.entities;

import org.example.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, int rollNumber, String grade) {
        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
