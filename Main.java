import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in); // Make Scanner static (so i can use outside of main)
    private static final List<Course> courses = new ArrayList<>();    
    // MIGHT HAVE TO CHANGE TO A MAP FOR MORE EFFICIENT ACCESS + BETTER TIME COMPLEXITY 
    // private static final Map<String, Course> courses = new HashMap<>();
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
                    int id = scanner.nextInt();
                    // if the ID already exists
                    if (students.containsKey(id)) {
                        System.out.println("ID already exists.");
                    } else {
                        Student newStudent = new Student(name, id);
                        students.put(id, newStudent);
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
                    id = scanner.nextInt();
                    if (!students.containsKey(id)) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.print("Are you sure you want to remove " + students.get(id).getName() + "? (y/n): ");
                        // y = yes, n = no
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            students.remove(id); // remove student from students map
                            System.out.println("Student has been removed.");
                        } else {
                            System.out.println("No action.");
                        }
                        break;
                    }
                // case 5: // return to home MENU
                    
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // MANAGE COURSES
    public static void manageCourseOptions() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.print("Enter Course ID (e.g. 'CS301'): ");
            String input = scanner.nextLine();
            // IMPORTANT: HOW DO YOU ACCESS COURSE FROM COURSELIST? 
            for (Course course : courses) {
                if (course.getID().equalsIgnoreCase(input)) {
                    System.out.println("Course: " + course.getName());
                    System.out.println("1. View Students");
                    System.out.println("2. View Assignments");
                    System.out.println("3. View Course Info"); // display average grade and general info abt course
                    System.out.print("Select an option: ");
                   
                    try {
                        int choice = Integer.parseInt(scanner.nextLine()); 
                        switch(choice) {
                            case 1:
                                if (course.getNumStudents() == 0) {
                                    System.out.println("Class is empty.");
                                    // displayStudentOptions();
                                } else {
                                    course.getStudents(); 
                                    // displayStudentOptions();
                                }
                                break;
                            case 2:
                                if (course.getNumAssignments() == 0) {
                                    System.out.println("No assignments found.");
                                } else {
                                    course.getAssignments();
                                    displayAssignmentOptions();
                                }
                                break;
                            case 3:
                                System.out.println(course.toString() + "\n- # of Students Enrolled: " + course.getNumStudents() + "\n- # of Assignments: " + course.getNumAssignments() + "\n- Average Course Grade: " + course.getAverage() + "% (" + course.getAverageLetter() + ")");
                                break;
                            default:
                                System.out.println("Invalid choice. Please select a valid option.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                } else {
                    System.out.println("Course not found.");
                }
            }
        }
    }
   
    public static void createCourse() {
        System.out.print("Enter a course name (e.g., 'Languages & Automata'): ");
        String courseName = scanner.nextLine();
        System.out.print("Enter a course ID (e.g., 'CS301'): ");
        String courseID = scanner.nextLine();
        
        Course newCourse = new Course(courseID, courseName);
        courses.add(newCourse);
        // courses.add(courseName + " (" + courseID + ")");
        System.out.println("Course added successfully!");
    }

    public static void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Courses:");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i));
            }
        }
    } 
    public static void displayAssignmentOptions() {
    }

    // GENERATE REPORT 
}

