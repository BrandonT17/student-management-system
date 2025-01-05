import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportGenerator {
    
    // Generate a report for an individual student
    public void generateStudentReport(int studentID, Map<Integer, Student> students, Map<String, Course> courses) {
        Student student = students.get(studentID);
        if (student == null) {
            System.out.println("> Student not found.");
            return;
        }

        String filePath = "student-report-" + studentID + ".csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Student ID, Name, Course ID, Course Name, Grade, Letter Grade\n");

            // Iterate over the courses the student is enrolled in
            for (Course course : student.getCourses()) {
                double grade = student.getGradeForCourse(course); // Get the student's grade for the course
                char letterGrade = student.getLetterGradeForCourse(course); // Get letter grade for the course
                
                writer.append(student.getID() + ", " + student.getName() + ", " +
                    course.getID() + ", " + course.getName() + ", " +
                    grade + ", " + letterGrade + "\n");
            }

            System.out.println("Student report generated: " + filePath);
        } catch (IOException e) {
            System.out.println("> Error writing to file: " + e.getMessage());
        }
    }

    // Generate a report for a specific course
    public void generateCourseReport(String courseID, Map<Integer, Student> students, Map<String, Course> courses) {
        Course course = courses.get(courseID);
        if (course == null) {
            System.out.println("> Course not found.");
            return;
        }

        String filePath = "course-report-" + courseID + ".csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Student ID, Name, Course ID, Course Name, Grade, Letter Grade\n");

            // Iterate over the students enrolled in the course
            for (Student student : course.getStudents()) {
                double grade = student.getGradeForCourse(course); // Get the student's grade for the course
                char letterGrade = student.getLetterGradeForCourse(course); // Get letter grade for the course
                
                writer.append(student.getID() + ", " + student.getName() + ", " +
                    course.getID() + ", " + course.getName() + ", " +
                    grade + ", " + letterGrade + "\n");
            }

            System.out.println("Course report generated: " + filePath);
        } catch (IOException e) {
            System.out.println("> Error writing to file: " + e.getMessage());
        }
    }
}

