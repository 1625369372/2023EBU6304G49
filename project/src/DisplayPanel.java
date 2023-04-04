
import javax.swing.*;

public class DisplayPanel extends JScrollPane {
    private JTextArea displayArea;

    public DisplayPanel(StudentTrackerController controller) {
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        setViewportView(displayArea);

        controller.setDisplayArea(displayArea);
    }
}
