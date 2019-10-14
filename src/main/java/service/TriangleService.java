package service;
import model.TriangleModel;

public class TriangleService {

    public void triangleArea(TriangleModel triangleModel) {
        float a = triangleModel.getSideA();
        float b = triangleModel.getSideB();
        float c = triangleModel.getSideC();

        double p = (a + b + c) / 2;
        triangleModel.setS(Math.sqrt(p*(p - a)*(p - b)*(p - c)));
    }
}
