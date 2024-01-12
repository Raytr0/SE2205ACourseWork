package L4Q1;

public class MyStudent {
    private String firstName;
    private Double score;
    //Constructors
    public MyStudent(){
        firstName = "Ryan";
        score = 100.0;
    }
    public MyStudent(String newFirst, Double newScore){
        firstName = newFirst;
        score = newScore;
    }
    //Getter methods
    public String getFirstName() {
        return firstName;
    }

    public double getScore() {
        return score;
    }
    //Overridden toString method to match output
    @Override
    public String toString(){
        return String.format("%s: %.2f",firstName, score);
    }
}
