public class Assignment {
    String name; // name of the Assignment
    int studentScore; // what did the individual student get
    int maxScore; // maximum score possible on the assignment 
    // the student class will contain the individual score 
    String description; // (optional) description for the assignment
    

    public void Assignment (String name, int maxScore) {
        this.name = name;
        this.maxScore = maxScore; 
    }

    public void Assignment (String name, int maxScore, String des) {
        this.name = name;
        this.maxScore = maxScore;
        this.description = des;
    }

    public void changeName (String name) {
        this.name = name;
    }

    public void changeMaxScore (int score) {
        this.maxScore = score; 
    }

    public void changeStudentScore () {
    }

    public void setDescription (String des) {
        this.description = des; 
    }

    public String getName () {
        return this.name; 
    }

    public int getMaxScore () {
        return this.maxScore;
    }

    public String getDescription () {
        return this.description; 
    }
}
