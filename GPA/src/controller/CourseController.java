package controller;

import model.Course;

import java.io.*;
import java.util.*;

public class CourseController {
    private List<Course> courses;

    public CourseController() {
        courses = new ArrayList<>();
        loadCourses();
    }

    private void loadCourses() {
        try {
            BufferedReader scoreReader = new BufferedReader(new FileReader("src/scores.txt"));
            BufferedReader creditReader = new BufferedReader(new FileReader("src/credits.txt"));
            BufferedReader courseReader = new BufferedReader(new FileReader("src/courses.txt"));

            String scoreLine, creditLine, courseLine;
            while ((scoreLine = scoreReader.readLine()) != null &&
                    (creditLine = creditReader.readLine()) != null &&
                    (courseLine = courseReader.readLine()) != null) {
                String[] courseInfo = courseLine.split(",");
                double score = Double.parseDouble(scoreLine);
                double credit = Double.parseDouble(creditLine);
                courses.add(new Course(courseInfo[0], courseInfo[1], score, credit));
            }

            scoreReader.close();
            creditReader.close();
            courseReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calculate the GPA based on all courses
    public double calculateOverallGPA() {
        double totalScore = 0;
        double totalCredit = 0;
        for (Course course : courses) {
            totalScore += course.calculateGPA() * course.getCredit();
            totalCredit += course.getCredit();
        }
        return totalCredit == 0 ? 0 : totalScore / totalCredit;
    }

    // Calculate the GPA based on all courses
    /*public double calculateOverallGPA() {
        double totalScore = 0;
        double totalCredit = 0;
        for (Course course : courses) {
            double courseGpa = course.calculateGPA();
            double courseCredit = course.getCredit();
            System.out.println("Course: " + course.getName() + ", GPA: " + courseGpa + ", Credit: " + courseCredit);
            totalScore += courseGpa * courseCredit;
            totalCredit += courseCredit;
        }
        double overallGpa = totalCredit == 0 ? 0 : totalScore / totalCredit;
        System.out.println("Overall GPA: " + overallGpa);
        return overallGpa;
    }*/


    // Calculate the GPA for the courses needed for studying abroad
    public double calculateAbroadGPA() {
        double totalScore = 0;
        double totalCredit = 0;
        for (Course course : courses) {
            if ("elective".equals(course.getType()) || "major".equals(course.getType())) {
                totalScore += course.calculateGPA() * course.getCredit();
                totalCredit += course.getCredit();
            }
        }
        return totalCredit == 0 ? 0 : totalScore / totalCredit;
    }

    // Calculate the GPA for the major courses only
    public double calculateMajorGPA() {
        double totalScore = 0;
        double totalCredit = 0;
        for (Course course : courses) {
            if ("major".equals(course.getType())) {
                totalScore += course.calculateGPA() * course.getCredit();
                totalCredit += course.getCredit();
            }
        }
        return totalCredit == 0 ? 0 : totalScore / totalCredit;
    }


}

