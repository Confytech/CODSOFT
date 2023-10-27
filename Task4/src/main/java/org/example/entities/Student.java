package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public boolean registerForCourse(Course course) {
        if (course.enrollStudent(this)) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent(this);
            return true;
        }
        return false;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
}
