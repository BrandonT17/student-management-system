import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in); // global
    private static final Map<String, Course> courses = new HashMap<>();
    private static final Map<Integer, Student> students = new HashMap<>(); // store students (aside from courses)

    public static void main(String[] args) {
        while (true) { // Persistent menu loop
            displayMainMenu();
        }
    }

    // MAIN MENU
    public static void displayMainMenu() {
        System.out.print("\nMAIN MENU:\n1. Manage Students\n2. Manage Courses\n3. Generate Report\n4. Exit Program\nSelect an option (1-4): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manageStudentOptions();
                    break;
                case 2:
                    displayCourses();
                    manageCourseOptions();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close(); // Close Scanner
                    System.exit(0); // Terminate program
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // MANAGE STUDENTS
    public static void manageStudentOptions() {
        System.out.print("1. Add Student\n2. View Students\n3. Delete Student\n4. Go Back\nSelect an option (1-4): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // add student (create student)
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("\nEnter the student's ID (digits only): ");
                    int id = Integer.parseInt(scanner.nextLine());
                    // if the ID already exists
                    if (students.containsKey(id)) {
                        System.out.println("ID already exists.");
                    } else {
                        Student newStudent = new Student(name, id);
                        students.put(id, newStudent);
                        System.out.println("Student created successfuly. ");
                    }
                    break;
                case 2: // view students
                    if (students.isEmpty()) {
                        System.out.println("No students to view.");
                    } else {
                        students.forEach((key, value) -> 
                            System.out.println(value.toString())
                        );
                    }
                    break;
                case 3: // delete student
                    System.out.print("Enter the ID of the student you want to remove: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (!students.containsKey(id)) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.print("Are you sure you want to remove " + students.get(id).getName() + "? (y/n): ");
                        // y = yes, n = no
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            students.remove(id); // remove student from students map
                            System.out.println("Student " + id + " has been removed.");
                        } else {
                            System.out.println("No action.");
                        }
                        break;
                    }
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // MANAGE COURSES
    public static void manageCourseOptions() {
        System.out.print("1. Add Course\n2. View Courses\n3. Enroll Students\n4. Remove Course\n5. Go Back\nSelect an option (1-5): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createCourse();
                    break;
                case 2: 
                    if (courses.isEmpty()) {
                        System.out.println("No courses available.");
                        break;
                    } else {
                        displayCourses();
                        System.out.print("Enter course ID to access course info: ");
                        scanner.nextLine();
                    }
                    
                case 3:
                case 4:
                case 5:
                    break;
                default: 
                    System.out.println("Invalid choice. Please select a valid option.");
            } 
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    public static void createCourse() {
        System.out.print("Enter a course name (e.g. 'Data Structures'): ");
        String courseName = scanner.nextLine();
        System.out.print("Enter a course ID (e.g. 'CS301'): ");
        String courseID = scanner.nextLine();
        if (courses.containsKey(courseID)) {
            System.out.println("Course ID already exists.");
        } else {
            Course newCourse = new Course(courseID, courseName);
            courses.put(courseID, newCourse);
            System.out.println("Course created successfully.");
        }
    }

    public static void displayCourses() {
        System.out.println("Courses:");
        courses.forEach((key, value) -> {
        System.out.println(value);
        });
    }

    public static void displayAssignmentOptions() {

    }

    // GENERATE REPORTS
    
}

