public class Main {
    public static void main (String[] args) {
    
        // testing
        Course course1 = new Course("CS 301", "Languages & Automata"); 
        Student student1 = new Student("James", 1234);
        System.out.println(student1.toString());
        Assignment a1 = new Assignment("HW 1", 20);
        Assignment a2 = new Assignment("QUIZ 1", 40);
        student1.addAssignment(a1, 18.0);
        student1.addAssignment(a2, 39.0);
        student1.printAssignments();
        course1.addStudent(student1);
        course1.getStudents();
    }
}
