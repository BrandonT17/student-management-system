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
        this.courses = new ArrayList<>();
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

    public void setGrade() {
        if (assignments.isEmpty()) {
            grade = 100.0; // default grade
        }
        double totalScore = 0.0;
        double maxScore = 0.0;
        for (Map.Entry<Assignment, Double> entry : assignments.entrySet()) {
            totalScore += entry.getValue();
            maxScore += entry.getKey().getMaxScore();
        }
        if (maxScore == 0) {
            grade = 100.0;
        } else {
            grade = (totalScore / maxScore) * 100.0;
        }
    }

    // to be used with addAssignment in Course 
    public void addAssignment(Assignment assignment, Double score) {
        assignments.put(assignment, score);
        setGrade();
    }

    // grade assignments
    public void scoreAssignment(Assignment assignment, Double score) {
        if (assignments.containsKey(assignment)) {
            assignments.put(assignment, score);
            setGrade();
        } else {
            System.out.println("> Assignment not found for this student.");
        }
    }

    public double getAssignmentScore(Assignment assignment) {
        return assignments.getOrDefault(assignment, 0.0);
    }

    public void printAssignments () {
        for (Map.Entry<Assignment, Double> entry : assignments.entrySet()) {
            Assignment assignment = entry.getKey();
            double score = entry.getValue();
            System.out.println("* (" + assignment.getCourse().getID().toUpperCase() + ") " + assignment.getName() + " : " + score + "/" + assignment.getMaxScore());
            // (CS261) HW1 : 17.5/20 pts
        }
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    @Override
    public String toString() {
        return name.toUpperCase() + " (" + studentID + ")";
    }
}
