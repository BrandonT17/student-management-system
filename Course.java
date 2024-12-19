import java.util.ArrayList;
import java.util.List;

public class Course () {
    
    private String courseName; // ex: "Calculus II"  
    private String courseID; // ex: "MATH 123"
    private List<Student> students; // student list
    private List<Assignment> assignments; // all of the assignments in this course 
    private double classAvg; // average score of the class - must be calculated with setAverage() 

    // constructor to create a new course 
    public Course (String courseID, String courseName) {
        this.courseName = courseName; 
        this.courseID = courseID;
    }

    // return class average 
    double total = 0.0; 
    public double getAverage () {
        for (student : students) {
            total += student.getGrade(); 
        }
        classAvg = total / students.size(); 
    } 
    
    public void addStudent (Student student) {
        students.add(student);
    }

    public void addAssignment (Assignment assignment) {
        assignments.add(assignment);
        for (Student student : students) {
            student.addAssignment(assignment, 0.0);
        }
    }

    // print out all of the students (retrn list for now, but later on implement it to print out formatted string)
    public List<Student> getStudents () {
        return students;
    }
}


