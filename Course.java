import java.util.ArrayList;
import java.util.List;

public class Course {
    
    private String courseName; // ex: "calculus ii"  
    private String courseID; // ex: "math 123"
    private List<Student> students; // student list
    private List<Assignment> assignments;     
   
    // constructor to create a new course 
    public Course (String courseID, String courseName) {
        this.courseID = courseID; 
        this.courseName = courseName;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    
    public boolean removeStudent(int studentID) {
        return students.removeIf(student -> student.getID() == studentID);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
        for (Student student : students) {
            student.addAssignment(assignment, 0.0); // Initialize with a score of 0
        }
    }

    public double getAverage() {
        if (students.isEmpty()) return 0.0; // Prevent division by zero
        double total = 0.0;
        for (Student student : students) {
            total += student.getGrade(); // Use the student's grade
        }
        return total / students.size(); // Return the average
    }

    public char getAverageLetter() {
        double average = getAverage();
        if (average >= 90.0) return 'A';
        if (average >= 80.0) return 'B';
        if (average >= 70.0) return 'C';
        if (average >= 60.0) return 'D';
        return 'F';
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " (" + courseID + ")";
    }
}


