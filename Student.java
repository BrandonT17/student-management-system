import java.util.ArrayList;
import java.util.Map; 

public class Student {

    // instance variables
    private final String name; 
    private final int studentID; // cannot be modified
    private double overallGrade;
    private Map<Assignment, Double> assignments; 
    // all of the student's assignments. Double is the individual score

    // constructor to create new student 
    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
        // to store the students assignments. empty at first
        this.assignments = new Map<>();
    }

    // functions for the student class
    public String getName() {
        return this.name; 
    }

    public int getID() {
        return this.studentID;
    }

    public double getGrade() {
        return this.overallGrade; 
    }

    public void setGrade(double grade) {
        this.overallGrade = grade; 
    }

    // to be used with addAssignment in Course 
    public void addAssignment(Assignment assignment, Double score) {
        assignments.put(assignment, score);
    }
}
