package L4Q2;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private Double score;
    private String firstName;
    private String lastName;

    //Constructors
    public Student() {
        score = 100.0;
        firstName = "Ryan";
        lastName = "Huang";
    }

    public Student(String first, String last, Double points) {
        firstName = first;
        lastName = last;
        score = points;
    }

    //Getter Methods
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Overrides toSting to proper formatting
    @Override
    public String toString() {
        return String.format("  %s %s: %.2f", firstName, lastName, score);
    }

    //Overrides compareTo and ranks them accordingly
    @Override
    public int compareTo(Student o) {
        int ranking = 0;
        if(this.score < o.score)
            ranking = 1;
        else if(this.score > o.score)
            ranking = -1;
        else
            ranking = 0;
        return ranking;
    }
}