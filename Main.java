import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in); // Make Scanner static (so i can use outside of main)
    private static final List<Course> courses = new ArrayList<>(); // Store courses in a list
    // MIGHT HAVE TO CHANGE TO A MAP FOR MORE EFFICIENT ACCESS + BETTER TIME COMPLEXITY 

    public static void main(String[] args) {
        while (true) { // Persistent menu loop
            displayMenu();
        }
    }

    public static void displayMenu() {
        System.out.println("\nMAIN MENU:");
        System.out.println("1. Add Course");
        System.out.println("2. View Courses");
        System.out.println("3. Manage Courses");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
        
        try {
            int choice = Integer.parseInt(scanner.nextLine()); // Use nextLine to handle input correctly
            switch (choice) {
                case 1:
                    createCourse();
                    break;
                case 2:
                    displayCourses();
                    break;
                case 3:
                    // class management - ask for course ID and then it's gonna ask for option to displayCourses
                    manageCourseOptions();
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
                                    manageCourseOptions();
                                } else {
                                    course.getStudents(); 
                                }
                                break;
                            case 2:
                                
                                break;
                            case 3:
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
}

