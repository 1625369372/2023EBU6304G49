import controller.CourseController;
import view.GPAView;

public class GPACalculator {
    public static void main(String[] args) {
        CourseController controller = new CourseController();
        new GPAView(controller);
    }
}
