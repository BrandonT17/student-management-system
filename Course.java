import java.util.ArrayList;
import java.util.List;

public class Course {
    
    private String courseName; // ex: "Calculus II"  
    private String courseID; // ex: "MATH 123"
    private List<Student> students; // student list
    private List<Assignment> assignments; // all of the assignments 
    private double classAvg; // average score of the class - must be calculated with setAverage() 

    // constructor to create a new course 
    public Course (String courseID, String courseName) {
        this.courseName = courseName; 
        this.courseID = courseID;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
        this.classAvg = 0.0;
    }

    // return class average 
    double total = 0.0; 
    public double getAverage () {
        for (Student student : students) {
            total = total + student.getGrade(); 
        }
        classAvg = total / students.size(); 
        return classAvg; 
    } 

    public char getAverageLetter () {
        if (classAvg >= 90.0) {
            return 'A';
        } else if (classAvg >= 80.0) {
            return 'B';
        } else if (classAvg >= 70.0) {
            return 'C';
        } else if (classAvg >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    public void addStudent (Student student) {
        students.add(student);
    }

    // search for ID and delete student with that ID
    // return false is student not found 
    public boolean removeStudent (int studentID) {
        for (Student student : students) {
            if (student.getID() == studentID) {
                students.remove(student);
                return true;
            }
        }
        return false; 
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


