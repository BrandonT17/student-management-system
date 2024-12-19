import java.util.ArrayList;

public class Student {

    // instance variables
    private String name; 
    private int studentID;
    private double overallGrade;
    // all of the student's assignments 
    
    // constructor to create new student 
    public Student(String name, int studentID) {
        this.name = name;
        this.studentID = studentID;
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

    public void setName(String name) {
        this.name = name; 
    }

    public void setID(int id) {
        this.studentID = id; 
    }
}
