package service;
import model.Triangle;
import java.util.*;

public class TriangleService {

    public void triangleArea(Triangle triangleModel) {
        float a = triangleModel.getSideA();
        float b = triangleModel.getSideB();
        float c = triangleModel.getSideC();
        double p = (a + b + c) / 2;
        triangleModel.setS(Math.sqrt(p*(p - a)*(p - b)*(p - c)));
    }

    public ArrayList sortCollection(ArrayList<Triangle> triangleList) {
        Collections.sort(triangleList, Collections.reverseOrder());
        return triangleList;
    }
}
