import controller.TriangleController;
import model.TriangleModel;

import java.util.ArrayList;

public class Main {
    static ArrayList<TriangleModel> triangleList = new ArrayList<TriangleModel>();

    public static void main(String[] args) {
        while (true) {
            TriangleController controller = new TriangleController();
            controller.addToCollection(triangleList);
            //controller.sortCollection(triangleList);
            if(!controller.shouldContinue()) {
                controller.sortCollection(triangleList);
                break;
            }
        }
    }
}
