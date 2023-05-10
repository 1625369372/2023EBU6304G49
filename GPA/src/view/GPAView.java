package view;

import controller.CourseController;

import javax.swing.*;
import java.awt.*;

public class GPAView {
    private CourseController controller;

    public GPAView(CourseController controller) {
        this.controller = controller;
        createView();
    }

    private void createView() {
        JFrame frame = new JFrame("GPA Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Format the GPA values to keep only two decimal places
        String overallGPA = String.format("%.2f", controller.calculateOverallGPA());
        String abroadGPA = String.format("%.2f", controller.calculateAbroadGPA());
        String majorGPA = String.format("%.2f", controller.calculateMajorGPA());

        JLabel overallGpaLabel = new JLabel("Overall GPA: " + overallGPA);
        JLabel abroadGpaLabel = new JLabel("Abroad GPA: " + abroadGPA);
        JLabel majorGpaLabel = new JLabel("Major GPA: " + majorGPA);

        panel.add(overallGpaLabel);
        panel.add(abroadGpaLabel);
        panel.add(majorGpaLabel);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
