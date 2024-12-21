import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in); // Make Scanner static
    private static final List<String> courses = new ArrayList<>(); // Store courses in a list

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

        courses.add(courseName + " (" + courseID + ")"); // Store course details in the list
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
            System.out.println("1. View Assignments\n2. View Students");

        }
    }
}

