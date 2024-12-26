import java.util.ArrayList;
import java.util.List;
import java.util.Map; 
import java.util.HashMap;

public class Student {

    // instance variables
    private final String name; 
    private final int studentID; 
    private double grade;
    private Map<Assignment, Double> assignments; // assn -> score
    private List<Course> courses; // all of the courses the student is enrolled in    
    // constructor to create new student 
    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
        this.grade = 100.0; // initial grade is 100.0
        this.assignments = new HashMap<>();

    }

    // functions for the student class
    public String getName() {
        return this.name; 
    }

    public int getID() {
        return this.studentID;
    }

    public double getGrade() {
        return this.grade; 
    }

    public char getLetterGrade() {
        if (grade >= 90.0) {
            return 'A';
        } else if (grade >= 80.0) {
            return 'B';
        } else if (grade >= 70.0) {
            return 'C';
        } else if (grade >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void setGrade(double grade) {
        this.grade = grade; 
    }

    // to be used with addAssignment in Course 
    public void addAssignment(Assignment assignment, Double score) {
        assignments.put(assignment, score);
    }

    public void printAssignments () {
        for (Map.Entry<Assignment, Double> entry : assignments.entrySet()) {
            System.out.println(entry.getKey().getName() + ", " + entry.getValue());
        }
    } 

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + studentID;
    }
}
