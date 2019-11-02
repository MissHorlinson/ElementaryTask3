import controller.TriangleController;
import model.Triangle;

import java.util.ArrayList;

public class Main {
    static ArrayList<Triangle> triangleList = new ArrayList<Triangle>();

    public static void main(String[] args) {
        while (true) {
            TriangleController controller = new TriangleController();
            controller.addToCollection(triangleList);
            if(!controller.shouldContinue()) {
                controller.showTriangleList(triangleList);
                break;
            }
        }
    }
}
