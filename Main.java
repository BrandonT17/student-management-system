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
        System.out.print("1. Add Course\n2. View Course\n3. Enroll Students\n4. Remove Course\n5. Go Back\nSelect an option (1-5): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // add course
                    createCourse();
                    break;
                case 2: // view course
                    if (courses.isEmpty()) {
                        System.out.println("No courses available.");
                        break;
                    } else {
                        System.out.println("My Courses:\n----------");
                        displayCourses();
                        System.out.print("Enter course ID to access course info (no spaces): ");
                        String courseID = scanner.nextLine();
                        // check if courseID (ignoring case) is in the map 
                        if (courses.containsKey(courseID.toLowerCase())) {
                            Course currCourse = courses.get(courseID);
                            System.out.println("Course: " + currCourse.getName());
                            System.out.println("1. View Students\n2. View Assignments\n3. View Course Info\nSelect an option (1-3): ");
                            try {
                                choice = Integer.parseInt(scanner.nextLine());
                                switch (choice) {
                                    case 1: // display all the students in the course
                                        currCourse.getStudents();
                                    case 2: // view all the assignments for the course 
                                        currCourse.getAssignments();
                                    case 3: // view course details 
                                        System.out.println(currCourse.toString());
                                        System.out.println("# of Students Enrolled: " + currCourse.getNumStudents() + "\n# of Assignments: " + currCourse.getNumAssignments() + "\nAverage Course Grade: " + currCourse.getAverage());
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please select a valid option.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                            }
                        }
                    }
                    
                case 3: // enroll student into a course
                    System.out.print("Enter student ID: ");
                    int studentID = Integer.parseInt(scanner.nextLine());
                    if (!students.containsKey(studentID)) {
                        System.out.println("Student not found.");
                    } else {
                        displayCourses();
                        System.out.print("Enter the ID of the class you want to add " + students.get(studentID).getName() + " to: ");
                        String courseID = scanner.nextLine();
                        if (courses.containsKey(courseID.toLowerCase())) {
                             courses.get(courseID).addStudent(students.get(studentID));
                        } else {
                            System.out.println("Class not found.");
                        }
                    }
                case 4: // remove course
                    System.out.print("Enter the ID of the class you want to remove: ");
                    String courseID = scanner.nextLine();
                    if (!courses.containsKey(courseID)) {
                        System.out.println("Course not found.");
                    } else {
                        System.out.print("Are you sure you want to remove " + courses.get(courseID).getName() + "? (y/n): ");
                        // y = yes, n = no
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            courses.remove(courseID); // remove student from students map
                            System.out.println(courseID + " has been removed.");
                        } else {
                            System.out.println("No action.");
                        }
                    }
                    break;
                case 5: // return to main menu 
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

