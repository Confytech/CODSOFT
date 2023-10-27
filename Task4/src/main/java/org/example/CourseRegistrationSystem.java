package org.example;

import org.example.entities.Course;
import org.example.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        // Sample courses
        Course course1 = new Course("CSC101", "Introduction to Programming", "Basic programming concepts", 30, "Mon/Wed 9:00 AM");
        Course course2 = new Course("MAT201", "Calculus I", "Fundamental calculus topics", 25, "Tue/Thu 10:30 AM");
        courses.add(course1);
        courses.add(course2);

        // Sample students
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        students.add(student1);
        students.add(student2);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Course Registration System");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableCourses(courses);
                    break;
                case 2:
                    registerForCourse(student1, courses);
                    break;
                case 3:
                    dropCourse(student1, courses);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void displayAvailableCourses(List<Course> courses) {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + course.getAvailableSlots());
            System.out.println();
        }
    }

    private static void registerForCourse(Student student, List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course code you want to register for: ");
        String courseCode = scanner.nextLine();

        Course selectedCourse = findCourseByCode(courseCode, courses);
        if (selectedCourse != null) {
            if (student.registerForCourse(selectedCourse)) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Registration failed. Course is full.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void dropCourse(Student student, List<Course> courses) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course code you want to drop: ");
        String courseCode = scanner.nextLine();

        Course selectedCourse = findCourseByCode(courseCode, student.getRegisteredCourses());
        if (selectedCourse != null) {
            if (student.dropCourse(selectedCourse)) {
                System.out.println("Course dropped successfully.");
            } else {
                System.out.println("Course drop failed.");
            }
        } else {
            System.out.println("Course not found in your registered courses.");
        }
    }

    private static Course findCourseByCode(String courseCode, List<Course> courses) {
        for (Course course : courses) {
            if (course.getCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }
}