import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class StudentTrackerGUI {
    private StudentTrackerController controller;

    public StudentTrackerGUI() {
        controller = new StudentTrackerController();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("学生学习记录和跟踪");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 600);

        InputPanel inputPanel = new InputPanel(controller);
        frame.add(inputPanel, BorderLayout.WEST);

        DisplayPanel displayPanel = new DisplayPanel(controller);
        frame.add(displayPanel, BorderLayout.CENTER);

        // 设置背景图片
        try {
            URL backgroundUrl = new URL("https://example.com/background.jpg");
            ImageIcon backgroundImage = new ImageIcon(backgroundUrl);
            JLabel backgroundLabel = new JLabel(backgroundImage);
            frame.setContentPane(backgroundLabel);
            frame.setLayout(new BorderLayout());
            frame.add(inputPanel, BorderLayout.WEST);
            frame.add(displayPanel, BorderLayout.CENTER);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "无法加载背景图片。");
        }

        frame.setVisible(true);
    }
}
