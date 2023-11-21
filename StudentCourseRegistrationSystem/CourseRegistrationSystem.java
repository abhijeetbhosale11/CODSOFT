package StudentCourseRegistrationSystem;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    int id;
    String name;
    List<String> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

class CourseDatabase {
    List<Course> courses;

    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println("Code: " + course.code + ", Title: " + course.title + ", Capacity: " + course.capacity);
        }
    }
}

class StudentDatabase {
    List<Student> students;

    public StudentDatabase() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudentCourses(int studentId) {
        for (Student student : students) {
            if (student.id == studentId) {
                System.out.println("Student: " + student.name + ", Courses: " + student.registeredCourses);
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();

        // Add some example courses
        courseDatabase.addCourse(new Course("CS101", "Introduction to Java", "Basic Java Programming", 30, "Mon-Wed-Fri"));
        courseDatabase.addCourse(new Course("CS202", "Data Structures", "Fundamental Data Structures", 25, "Tue-Thu"));

        // Add some example students
        studentDatabase.addStudent(new Student(1, "John Doe"));
        studentDatabase.addStudent(new Student(2, "Jane Smith"));

        // Display available courses
        System.out.println("Available Courses:");
        courseDatabase.displayCourses();

        // Simulate student registration
        int studentId = getStudentId(scanner);

        // Add the course to the student's registered courses
        for (Student student : studentDatabase.students) {
            if (student.id == studentId) {
                student.registeredCourses.add(getCourseCode(scanner));
                break;
            }
        }

        // Display updated student courses
        studentDatabase.displayStudentCourses(studentId);
    }

    private static int getStudentId(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter student ID for registration: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for student ID.");
            }
        }
    }

    private static String getCourseCode(Scanner scanner) {
        System.out.print("Enter course code to register: ");
        return scanner.nextLine();
    }
}
