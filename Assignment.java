public class Assignment {
    private String name; // name of the Assignment
    private int maxScore; // maximum score possible 
    private String description; 

    public Assignment (String name, int maxScore) {
        this.name = name;
        this.maxScore = maxScore; 
    }

    public Assignment (String name, int maxScore, String description) {
        this.name = name;
        this.maxScore = maxScore;
        this.description = description;
    }

    public String getName () {
        return name; 
    }

    public int getMaxScore () {
        return maxscore;
    }

    public void getDescription () {
        return description;
    }

    public void setMaxScore (int score) {
        this.maxScore = score; 
    }

    public void setDescription (String des) {
        this.description = des; 
    }

    public String toString() {
        return name + " (" + maxScore + " points): " + description; 
    }

    // perhaps add a function to print all assignment details (for the particular student)
}
