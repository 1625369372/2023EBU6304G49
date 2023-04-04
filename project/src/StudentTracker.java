public class StudentTracker {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            StudentTrackerGUI studentTrackerGUI = new StudentTrackerGUI();
            studentTrackerGUI.createAndShowGUI();
        });
    }
}
