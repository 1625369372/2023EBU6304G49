import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel extends JPanel implements ActionListener {
    private StudentTrackerController controller;
    private JTextField moduleField;
    private JTextField skillsField;
    private JTextField scoreField;
    private JTextField achievementField;
    private JTextField responsibilityField;
    private JButton addButton;
    private JButton exportButton;
    private JButton importButton;

    public InputPanel(StudentTrackerController controller) {
        this.controller = controller;
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("模块："));
        moduleField = new JTextField();
        add(moduleField);

        add(new JLabel("技能："));
        skillsField = new JTextField();
        add(skillsField);

        add(new JLabel("分数："));
        scoreField = new JTextField();
        add(scoreField);

        add(new JLabel("成就："));
        achievementField = new JTextField();
        add(achievementField);

        add(new JLabel("职责："));
        responsibilityField = new JTextField();
        add(responsibilityField);

        addButton = new JButton("添加");
        addButton.setIcon(new ImageIcon("resources/add.png"));
        add(addButton);
        addButton.addActionListener(this);

        exportButton = new JButton("导出");
        exportButton.setIcon(new ImageIcon("resources/export.png"));
        add(exportButton);
        exportButton.addActionListener(this);

        importButton = new JButton("导入");
        importButton.setIcon(new ImageIcon("resources/import.png"));
        add(importButton);
        importButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            controller.addData(
                    moduleField.getText().trim(),
                    skillsField.getText().trim(),
                    scoreField.getText().trim(),
                    achievementField.getText().trim(),
                    responsibilityField.getText().trim()
            );
            moduleField.setText("");
            skillsField.setText("");
            scoreField.setText("");
            achievementField.setText("");
            responsibilityField.setText("");
        } else if (e.getSource() == exportButton) {
            controller.exportData();
        } else if (e.getSource() == importButton) {
            controller.importData();
        }
    }
}

