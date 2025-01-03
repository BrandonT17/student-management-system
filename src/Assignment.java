public class Assignment {
    private String name; // name of the Assignment
    private int maxScore; // maximum score possible 
    private Course course; // course that the assignment belongs to 

    public Assignment (String name, int maxScore, Course course) {
        this.name = name;
        this.maxScore = maxScore; 
        this.course = course;
    }

    public Assignment (String name, int maxScore, String description) {
        this.name = name;
        this.maxScore = maxScore;
    }

    public String getName () {
        return name; 
    }

    public int getMaxScore () {
        return maxScore;
    }

    public void setMaxScore (int score) {
        this.maxScore = score; 
    }

    public Course getCourse() {
        return course;
    }
    
    public String toString() {
        return name.toUpperCase() + " (" + maxScore + " pts)";
        // EX: HW1 (20 pts)
    }
}
