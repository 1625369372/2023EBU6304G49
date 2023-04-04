import javax.swing.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StudentTrackerController {
    private ArrayList<String> modules;
    private ArrayList<String> skills;
    private ArrayList<Double> scores;
    private ArrayList<String> achievements;
    private ArrayList<String> responsibilities;

    private JTextArea displayArea;

    public StudentTrackerController() {
        modules = new ArrayList<>();
        skills = new ArrayList<>();
        scores = new ArrayList<>();
        achievements = new ArrayList<>();
        responsibilities = new ArrayList<>();
    }

    public void setDisplayArea(JTextArea displayArea) {
        this.displayArea = displayArea;
    }

    public void addData(String module, String skill, String scoreText, String achievement, String responsibility) {
        if (!module.isEmpty()) {
            modules.add(module);
        }

        if (!skill.isEmpty()) {
            skills.add(skill);
        }

        if (!scoreText.isEmpty()) {
            try {
                double score = Double.parseDouble(scoreText);
                scores.add(score);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "分数输入无效，请输入数字。");
            }
        }

        if (!achievement.isEmpty()) {
            achievements.add(achievement);
        }

        if (!responsibility.isEmpty()) {
            responsibilities.add(responsibility);
        }

        updateDisplay();
    }

    private void updateDisplay() {
        StringBuilder sb = new StringBuilder();

        sb.append("模块:\n");
        for (String module : modules) {
            sb.append(module).append("\n");
        }

        sb.append("\n技能:\n");
        for (String skill : skills) {
            sb.append(skill).append("\n");
        }

        sb.append("\n分数:\n");
        double sum = 0;
        for (Double score : scores) {
            sb.append(score).append("\n");
            sum += score;
        }
        if (!scores.isEmpty()) {
            sb.append("\n平均分: ").append(sum / scores.size());
        }

        sb.append("\n\n成就:\n");
        for (String achievement : achievements) {
            sb.append(achievement).append("\n");
        }

        sb.append("\n职责:\n");
        for (String responsibility : responsibilities) {
            sb.append(responsibility).append("\n");
        }

        displayArea.setText(sb.toString());
    }

    public void exportData() {
        try {
            Files.write(Paths.get("modules.txt"), modules, StandardCharsets.UTF_8);
            Files.write(Paths.get("skills.txt"), skills, StandardCharsets.UTF_8);
            Files.write(Paths.get("scores.txt"), scores.stream().map(String::valueOf).collect(Collectors.toList()), StandardCharsets.UTF_8);
            Files.write(Paths.get("achievements.txt"), achievements, StandardCharsets.UTF_8);
            Files.write(Paths.get("responsibilities.txt"), responsibilities, StandardCharsets.UTF_8);
                    JOptionPane.showMessageDialog(null, "数据已导出。");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "导出数据时发生错误。");
        }
    }

    public void importData() {
        try {
            modules = new ArrayList<>(Files.readAllLines(Paths.get("modules.txt"), StandardCharsets.UTF_8));
            skills = new ArrayList<>(Files.readAllLines(Paths.get("skills.txt"), StandardCharsets.UTF_8));
            scores = Files.readAllLines(Paths.get("scores.txt"), StandardCharsets.UTF_8).stream().map(Double::valueOf).collect(Collectors.toCollection(ArrayList::new));
            achievements = new ArrayList<>(Files.readAllLines(Paths.get("achievements.txt"), StandardCharsets.UTF_8));
            responsibilities = new ArrayList<>(Files.readAllLines(Paths.get("responsibilities.txt"), StandardCharsets.UTF_8));

            updateDisplay();
            JOptionPane.showMessageDialog(null, "数据已导入。");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "导入数据时发生错误。");
        }
    }
}