import java.util.ArrayList; 

public class Course () {
    
    private String courseID; // ex: "CS 301"  
    private ArrayList<Student> students = new ArrayList<>(); // student list
    private double classAvg; // average score of the class - must be calculated with setAverage() 

    // constructor to create a new course 
    public Course (String courseID) {
        this.courseID = courseID; 
    }

    // calculate class average;
    public void calculateAverage() {
        
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

    // print out all of the students 
    /*public String getStudents () {
        for () {
        }
    }*/
}


