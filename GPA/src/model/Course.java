package model;

public class Course {
    private String name;
    private String type;
    private double score;
    private double credit;

    public Course(String name, String type, double score, double credit) {
        this.name = name;
        this.type = type;
        this.score = score;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getScore() {
        return score;
    }

    public double getCredit() {
        return credit;
    }

    // Assuming X is the score, calculate the GPA for this course
    public double calculateGPA() {
        double X = this.score;
        if (X < 60) {
            return 0;
        } else {
            return 4 - 3 * Math.pow((100 - X), 2) / 1600;
        }
    }
}
