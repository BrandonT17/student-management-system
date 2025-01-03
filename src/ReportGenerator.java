import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

// class to generate reports
public class ReportGenerator {
    public void generateStudentReport(int studentID, Map<Integer, Student> students, Map<String, Course> courses) {
        Student student = students.get(studentID);
        if (student == null) {
            System.out.println("> Student not found.");
            return;
        }

        String filePath = "student-report-" + studentID + ".csv";

        try (FileWriter w = new FileWriter(filePath)) {
            w.append("Student ID, Name, Course ID, Course Name, Grade\n");
        } catch (IOException e) {
            System.out.println("> Error writing to file: " + e.getMessage());
        }
    }
    public void generateCourseReport(int courseID) {
    
    }
}

