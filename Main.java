import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
    
        displayMenu();

    }

    public static void displayMenu () {

        Scanner scanner = new Scanner(System.in);
        int choice; 
        System.out.println("\nMAIN MENU:\n");
        System.out.println("1. Add Course\n2. View Courses");
        
        System.out.println("Select an option: ");
        choice = Scanner.nextInt();
        if (choice == 1) {
            createCourse(); 
        } else {
            displayCourses();
        }

        scanner.close();
    }

    public static void createCourse () {
        System.out.println("Enter a course name: (Ex: 'Languages & Automata') ");
        System.out.println("Enter a course ID: (Ex: 'CS301')");
    }

    public static void displayCourses () {
        System.out.println("");
    }

}


