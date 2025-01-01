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
        System.out.print("\n----------\nMAIN MENU:\n----------\n1. Manage Students\n2. Manage Courses\n3. Generate Report\n4. Exit Program\nSelect an option (1-4): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    manageStudentOptions();
                    break;
                case 2:
                    /*if (courses.size() != 0) {
                        displayCourses();
                    }*/
                    manageCourseOptions();
                    break;
                case 3:
                    manageReportOptions();
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
        System.out.print("----------------\nManage Students:\n----------------\n1. Add Student\n2. View Students\n3. Delete Student\n4. Go Back\nSelect an option (1-4): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // add student (create student)
                    System.out.println("------------\nAdd Student:\n------------");
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the student's ID (digits only): ");
                    int id = Integer.parseInt(scanner.nextLine());
                    // if the ID already exists
                    if (students.containsKey(id)) {
                        System.out.println("> ID already exists.");
                    } else {
                        Student newStudent = new Student(name, id);
                        students.put(id, newStudent);
                        System.out.println("> " + newStudent.toString() + " added successfuly. ");
                    }
                    pressAnyKey();
                    manageStudentOptions();
                    break;
                case 2: // view students
                    if (students.isEmpty()) {
                        System.out.println("> No students to view.");
                        pressAnyKey(); 
                    } else {
                        System.out.println("---------\nStudents:\n---------");
                        students.forEach((key, value) -> 
                            System.out.println("* " + value.toString())
                        );
                        pressAnyKey();
                    }
                    manageStudentOptions();
                    break;
                case 3: // delete student
                    if (students.isEmpty()) {
                        System.out.println("> No students to remove.");
                        pressAnyKey();
                        manageStudentOptions();
                        break;
                    }
                    System.out.print("Enter the ID of the student you want to remove: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (!students.containsKey(id)) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.print("Are you sure you want to remove " + students.get(id).getName().toUpperCase() + "? (y/n): ");
                        // y = yes, n = no
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            students.remove(id); // remove student from students map
                            System.out.println("> Student " + id + " has been removed.");
                        } else {
                            System.out.println("> No action.");
                        }
                        manageStudentOptions();
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
        System.out.print("---------------\nManage Courses:\n---------------\n1. Add Course\n2. View Course\n3. Remove Course\n4. Go Back\nSelect an option (1-4): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // add course
                    createCourse();
                    manageCourseOptions();
                    break;
                case 2: // view course
                    if (courses.isEmpty()) {
                        System.out.println("> No courses available.");
                        pressAnyKey();
                        manageCourseOptions();
                        break;
                    } else {
                        // System.out.println("Courses:\n----------");
                        displayCourses();
                        System.out.print("Enter course ID to access course info (no spaces): ");
                        String courseID = scanner.nextLine();
                        // check if courseID (ignoring case) is in the map 
                        if (courses.containsKey(courseID.toLowerCase())) {
                            Course currCourse = courses.get(courseID);
                            System.out.println("\n-------\nCourse: [" + currCourse.toString() + "]\n-------");
                            System.out.print("1. Enroll Student\n2. View Students\n3. Manage Assignments\n4. View Course Info\nSelect an option (1-4): ");
                            try {
                                choice = Integer.parseInt(scanner.nextLine());
                                switch (choice) {
                                    case 1: // enroll student
                                        System.out.print("Enter student ID: ");
                                        int studentID = Integer.parseInt(scanner.nextLine());
                                        if (!students.containsKey(studentID)) {
                                            System.out.println("Student not found.");
                                        } else {
                                            currCourse.addStudent(students.get(studentID));
                                            System.out.println("Student " + students.get(studentID).toString() + " added to " + currCourse.toString() + " successfully.");
                                        }
                                        break;
                                    case 2: // display all the students in the course
                                        System.out.println("Students enrolled in " + currCourse.getName());
                                        System.out.println(currCourse.getStudents());
                                        /*students.forEach((key, value) -> 
                                            System.out.println(value.toString())
                                        );*/
                                        // System.out.println(currCourse.getStudents());
                                        break;
                                    case 3:
                                        manageAssignmentOptions(currCourse);
                                        break;
                                    case 4: // view course details 
                                        System.out.println(currCourse.toString());
                                        System.out.println("# of Students Enrolled: " + currCourse.getNumStudents() + "\n# of Assignments: " + currCourse.getNumAssignments() + "\nAverage Course Grade: " + currCourse.getAverage());
                                        pressAnyKey();
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please select a valid option.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a number.");
                            }
                        }
                    }
                    break;

                case 3: // remove course
                    if (courses.isEmpty()) {
                        System.out.println("> No courses to remove.");
                        pressAnyKey();
                        break;
                    }
                    displayCourses();
                    System.out.print("Enter the ID of the class you want to remove: ");
                    String courseID = scanner.nextLine();
                    if (!courses.containsKey(courseID)) {
                        System.out.println("Course not found.");
                    } else {
                        System.out.print("Are you sure you want to remove [" + courses.get(courseID).toString() + "]? (y/n): ");
                        // y = yes, n = no
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            courses.remove(courseID); // remove student from students map
                            System.out.println(courseID.toUpperCase() + " has been removed.");
                        } else {
                            System.out.println("No action.");
                        }
                    }
                    manageCourseOptions();
                    break;
                case 4: // return to main menu 
                    break;
                default: 
                    System.out.println("Invalid choice. Please select a valid option.");
                    manageCourseOptions();
                    break;
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
            courseID = courseID.replace(" ", ""); // to remove any possible spaces
        if (courses.containsKey(courseID)) {
            System.out.println("Course ID already exists.");
        } else {
            Course newCourse = new Course(courseID, courseName);
            courses.put(courseID, newCourse);
            System.out.println("Course created successfully.");
        }
    }

    public static void displayCourses() {
        System.out.println("\nCourses:\n--------");
        courses.forEach((key, value) -> {
        System.out.println(value.toString());
        });
        System.out.println("--------\n");
    }

    public static void manageAssignmentOptions(Course currCourse) { // pass currCourse as a parameter so we know where to add assignment and who's students to access ofc
        try {
            System.out.print("-------------------\nManage Assignments:\n--------------------\n1. Add Assignment\n2. View Assignments\n3. Grade Assignments\nSelect an option (1-3): ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
            case 1: // add assignment to the course
                System.out.print("Enter a name for the assignment: ");
                String assignmentName = scanner.nextLine();
                System.out.print("How many points is this assignment worth?: ");
                int maxScore = Integer.parseInt(scanner.nextLine());
                Assignment newAssignment = new Assignment(assignmentName, maxScore);
                currCourse.addAssignment(newAssignment);
                                        
            case 2: // view all the assignments for the course
                System.out.println("Assignments: ");
                System.out.print(currCourse.getAssignments());
                break;      
                case 3: // list assignment, ask which one they want to grade  
            default: 
                System.out.println("Invalid choice. Please select a valid option.");
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // GENERATE REPORTS
    public static void manageReportOptions() {
        System.out.print("---------------\nManage Reports:\n---------------\n1. Create Student Report\n2. Create Course Report\n3. Access Previous Reports\nSelect an option (1-3): ");
    }
    
    public static void pressAnyKey() { 
        System.out.print("\nPress [ENTER] to continue...");
        scanner.nextLine();
    }
}

