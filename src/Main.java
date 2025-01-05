import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in); // global
    private static final Map<String, Course> courses = new HashMap<>();
    private static final Map<Integer, Student> students = new HashMap<>();
    
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
                case 1: // student menu
                    manageStudentOptions();
                    break;
                case 2: // course menu
                    manageCourseOptions();
                    break;
                case 3: // report menu
                    manageReportOptions();
                    break;
                case 4: // exit program
                    System.out.print("Are you sure you want to exit the program? (y/n): ");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("y")) {
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close(); // Close Scanner
                        System.exit(0); // Terminate program
                        break;
                    } else {
                        System.out.println("> No action.");
                    }
                    displayMainMenu();
                    break;
                default: // if input Invalid
                System.out.println("> Invalid choice. Please select a valid option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("> Invalid input. Please enter a number.");
        }
    }
    // MANAGE STUDENTS
    public static void manageStudentOptions() {
        System.out.print("----------------\nManage Students:\n----------------\n1. Add Student\n2. View All Students\n3. View Student Details\n4. Delete Student\n5. Go Back\nSelect an option (1-5): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // add student (create student)
                    System.out.println("------------\nAdd Student:\n------------");
                    System.out.print("Enter the student's name: ");
                    String name = scanner.nextLine().trim();

                    int id = 0; // Declare ID outside the loop for later use
                    boolean validID = false; // Flag to check for valid ID
                    while (!validID) {
                        System.out.print("Enter the student's 4-digit ID (i.e. '1234'): ");
                        try {
                            id = Integer.parseInt(scanner.nextLine());
                            if (id < 1000 || id > 9999) {
                                System.out.println("> Invalid input. Please enter a 4-digit number.");
                            } else if (students.containsKey(id)) {
                                System.out.println("> ID already exists.");
                            } else {
                                validID = true; // ID is valid, exit the loop
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("> Invalid input. Please enter a numeric 4-digit ID.");
                        }
                    }
                    Student newStudent = new Student(name, id);
                    students.put(id, newStudent);
                    System.out.println("> " + newStudent.toString() + " added successfully.");
                    pressAnyKey();
                    manageStudentOptions();
                    break;
                case 2: // view students
                    if (students.isEmpty()) { // if students is empty 
                        System.out.println("> No students to view.");
                        pressAnyKey(); 
                    } else { // list students
                        System.out.println("------------------\nView All Students:\n------------------");
                        students.forEach((key, value) -> 
                            System.out.println("* " + value.toString())
                        );
                        pressAnyKey();
                    }
                    manageStudentOptions();
                    break;
                case 3: // list students and prompt user to select one to view info
                    if (students.isEmpty()) {
                        System.out.println("---------------------\nView Student Details:\n---------------------> No students to view.");
                        pressAnyKey();
                    } else {
                        System.out.println("---------------------\nView Student Details:\n---------------------");
                        students.forEach((key, value) -> 
                            System.out.println("* " + value.toString())
                        );
                        
                        id = 0; // Declare the ID variable
                        validID = false; // Flag for valid ID
                        while (!validID) {
                            System.out.print("\nEnter the ID of the student you want to view: ");
                            try {
                                id = Integer.parseInt(scanner.nextLine());
                                if (!students.containsKey(id)) {
                                    System.out.println("> Student not found. Please try again.");
                                } else {
                                    validID = true; // Exit loop if the ID exists
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("> Invalid input. Please enter a numeric 4-digit ID.");
                            }
                        }

                        // Print student info once a valid ID is entered
                        System.out.println("----------------\nStudent Details:\n----------------");
                        System.out.println("Name:      " + students.get(id).getName().toUpperCase() + "\nStudentID: " + id + "\nGrades:");
                        students.get(id).printAssignments();
                        // System.out.println(students.get(id).printAssignments());
                    }
                    pressAnyKey();
                    manageStudentOptions(); 
                    break;
                case 4: // delete student
                    if (students.isEmpty()) {
                        System.out.println("---------------\nDelete Student:\n---------------\n> No students to remove.");
                        pressAnyKey();
                        manageStudentOptions();
                        break;
                    }
                    System.out.print("---------------\nDelete Student:\n---------------\nEnter the ID of the student you want to remove: ");
                    id = Integer.parseInt(scanner.nextLine());
                    if (!students.containsKey(id)) {
                        System.out.println("> Student not found.");
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
                case 5: // go back
                    break;
                default:
                    System.out.println("> Invalid choice. Please select a valid option.");
                        
            }
        } catch (NumberFormatException e) {
            System.out.println("> Invalid input. Please enter a number.");
            
        }
    }

    // MANAGE COURSES
    public static void manageCourseOptions() {
        System.out.print("---------------\nManage Courses:\n---------------\n1. Add Course\n2. Select Course\n3. View All Courses\n4. Remove Course\n5. Go Back\nSelect an option (1-5): ");
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
                        String courseID = scanner.nextLine().trim().toUpperCase();
                        // check if courseID (ignoring case) is in the map 
                        if (courses.containsKey(courseID)) {
                            Course currCourse = courses.get(courseID);
                            displayIndividualCourse(currCourse);
                            manageCourseOptions();
                        } else {
                            System.out.println("> Course not found.");
                            pressAnyKey();
                        }
                    }
                    break;
                case 3: // view all courses
                    if (courses.isEmpty()) {
                        System.out.println("> No courses available.");
                        pressAnyKey();
                        break;
                    } else {
                        displayCourses();
                    }
                    pressAnyKey();
                    manageCourseOptions();
                    break;
                case 4: // remove course
                    if (courses.isEmpty()) {
                        System.out.println("> No courses to remove.");
                        pressAnyKey();
                        break;
                    }
                    displayCourses();
                    System.out.print("Enter the ID of the class you want to remove: ");
                    String courseID = scanner.nextLine().trim().toUpperCase();
                    if (!courses.containsKey(courseID)) {
                        System.out.println("> Course not found.");
                    } else {
                        System.out.print("Are you sure you want to remove [" + courses.get(courseID).toString() + "]? (y/n): ");
                        // y = yes, n = no
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            courses.remove(courseID); // remove student from students map
                            System.out.println("> " + courseID.toUpperCase() + " has been removed.");
                        } else {
                            System.out.println("No action.");
                        }
                    }
                    manageCourseOptions();
                    break;
                case 5: // return to main menu 
                    break;
                default: 
                    System.out.println("> Invalid choice. Please select a valid option.");
                    manageCourseOptions();
                    break;
            } 
        } catch (NumberFormatException e) {
            System.out.println("> Invalid input. Please enter a number.");
        }
    }

    public static void createCourse() {
        System.out.print("Enter a course name (e.g. 'Data Structures'): ");
        String courseName = scanner.nextLine().trim();
        System.out.print("Enter a course ID (e.g. 'CS301'): ");
        String courseID = scanner.nextLine().trim().toUpperCase();
            courseID = courseID.replace(" ", ""); // to remove any possible spaces
        if (courses.containsKey(courseID)) {
            System.out.println("Course ID already exists.");
        } else {
            Course newCourse = new Course(courseID, courseName);
            courses.put(courseID, newCourse);
            System.out.println("> Course [" + newCourse.toString() + "] created successfully.");
        }
    }

    public static void displayCourses() {
        System.out.println("--------\nCourses:\n--------");
        courses.forEach((key, value) -> {
        System.out.println("* " + value.toString());
        });
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
                Assignment newAssignment = new Assignment(assignmentName, maxScore, currCourse);
                currCourse.addAssignment(newAssignment); 
            case 2: // view all the assignments for the course
                if (currCourse.getNumAssignments() == 0) {
                    System.out.println("No assignments found.");
                    manageAssignmentOptions(currCourse);
                    pressAnyKey();
                    break;
                }
                System.out.println("Assignments: ");
                List<Assignment> courseAssignments = currCourse.getAssignments();
                for (Assignment assignment : courseAssignments) {
                    System.out.println("* " + assignment.toString());
                }
                break;      
            case 3: // list assignment, ask which one they want to grade  
                if (currCourse.getNumAssignments() == 0) {
                    System.out.println("No assignments found. ");
                    pressAnyKey();
                    break;
                }
                System.out.println("------------\nAssignments:\n------------ ");
                // System.out.println(currCourse.getAssignments());
                courseAssignments = currCourse.getAssignments(); // array for easier access of elements
                int count = 1;
                for (Assignment assignment : courseAssignments) {
                    System.out.println(count + ". " + assignment.toString());
                    count++;
                }
                System.out.print("Select an assignment to grade (enter assignment number): ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > courseAssignments.size()) {
                    System.out.print("> Invalid choice. Please select a valid option.");
                    break;
                } else {
                    System.out.println("-----------------\nGrade Assignment:" + courseAssignments.get(choice-1) + "\n----------------- ");
                }
                
                // list all of the students with that assignment and show their current score, then allow user to select a student and assign a score for that assignment
                List<Student> courseStudents = currCourse.getStudents();
                for (Student student : courseStudents) {
                    System.out.println("* " + student.toString());
                }
                System.out.print("Select a student to grade (Enter Student ID): ");
                int studentID = Integer.parseInt(scanner.nextLine());
                if (!students.containsKey(studentID)) {
                    System.out.println("> Student not found.");
                    pressAnyKey();
                } else {
                    System.out.print("Enter the student's score: ");
                    double score = Double.parseDouble(scanner.nextLine());
                    students.get(studentID).scoreAssignment(courseAssignments.get(choice-1), score); 
                }
                break;
            default: 
                System.out.println("> Invalid choice. Please select a valid option.");
                break;
            }
        } catch (NumberFormatException e) {
            System.out.println("> Invalid input. Please enter a number.");
        }
    }

    public static void displayIndividualCourse(Course currCourse) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n-------\nCourse: [" + currCourse.toString() + "]\n-------");
            System.out.print("1. Enroll Student\n2. View Students\n3. Manage Assignments\n4. View Course Info\n5. Go Back\nSelect an option (1-5): ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: // Enroll student
                        System.out.print("Enter student ID: ");
                        int studentID = Integer.parseInt(scanner.nextLine());
                        if (!students.containsKey(studentID)) {
                            System.out.println("> Student not found.");
                        } else {
                            students.get(studentID).enrollInCourse(currCourse);
                            System.out.println("Student " + students.get(studentID).toString() + " added to " + currCourse.toString() + " successfully.");
                        }
                        // manageCourseOptions();
                        break;
                    case 2: // View students
                        System.out.println("Students enrolled in " + currCourse.getName() + ":");
                        List<Student> courseStudents = currCourse.getStudents();
                        for (Student student : courseStudents) {
                            System.out.println("* " + student.toString());
                        }
                        break;
                    case 3: // Manage assignments
                        manageAssignmentOptions(currCourse);                        
                        break;
                    case 4: // View course info
                         System.out.println("\n" + currCourse.toString());
                        System.out.println("# of Students Enrolled: " + currCourse.getNumStudents() + "\n# of Assignments: " + currCourse.getNumAssignments() + "\nAverage Course Grade: " + currCourse.getAverage());
                        pressAnyKey();
                        // manageCourseOptions();
                        break;
                    case 5: // Exit course
                        System.out.println("> Exiting course.");
                        pressAnyKey();
                        
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (true); // Keep looping until the user chooses to exit
    }

    // GENERATE REPORTS
    public static void manageReportOptions() {
        try { 
            System.out.print("---------------\nManage Reports:\n---------------\n1. Create Student Report\n2. Create Course Report\n3. Go Back\nSelect an option (1-3): ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: // create student report
                    System.out.print("Enter student ID to generate grade report: ");
                    int studentID = Integer.parseInt(scanner.nextLine());
                    if (!students.containsKey(studentID)) {
                        System.out.println("> Student not found.");
                        pressAnyKey();
                        manageReportOptions();
                    } else {

                    }
                    break;
                case 2: // create course report
                    System.out.print("Enter course ID to generate grade report (no spaces): ");
                    String courseID = scanner.nextLine();
                    if (!courses.containsKey(courseID.toLowerCase())) {
                        System.out.println("> Course not found.");
                        pressAnyKey();
                        manageReportOptions();
                    } else {
                        // generatecoursereport(courseID);
                    }
                    break;
                case 3: // go back
                    break;
                default: 
                    System.out.println("> Invalid choice. Please select a valid option.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("> Invalid input. Please enter a number.");
        }
    }
    
    public static void pressAnyKey() { 
        System.out.print("\nPress [ENTER] to continue...");
        scanner.nextLine();
    }
}

