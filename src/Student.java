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

    /*public char getLetterGrade(Course course) { // calculate letter grade for a course
        double average = course.getAverage();
        if (average >= 90.0) {
            return 'A';
        } else if (average >= 80.0) {
            return 'B';
        } else if (average >= 70.0) {
            return 'C';
        } else if (average >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }*/

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

    public List<Course> getCourses() { // return all of a student's courses
        return courses;
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

    // additional functions
    public double getGradeForCourse(Course course) {
    if (!courses.contains(course)) {
        return 0.0;  // Return 0.0 if the student is not enrolled in the course
    }
    // You can modify this logic based on how you store grades for each course
    return grade;
}

public char getLetterGradeForCourse(Course course) {
    double grade = getGradeForCourse(course);
    if (grade >= 90.0) return 'A';
    if (grade >= 80.0) return 'B';
    if (grade >= 70.0) return 'C';
    if (grade >= 60.0) return 'D';
    return 'F';
}

}
