package controller;
import com.sun.istack.internal.Nullable;
import util.*;
import model.*;
import service.*;
import java.util.ArrayList;

public class TriangleController {

    private Input           input = new Input();
    private Output          output = new Output();
    private Validator       validator = new Validator();
    private TriangleService service = new TriangleService();
    private Triangle        model;

    public void addToCollection(ArrayList<Triangle> triangleList) {
        Triangle newTriangle = getTriangleParameters(enterParameters());
        if (newTriangle != null) {
            triangleList.add(newTriangle);
        }
    }

    public ArrayList<String> enterParameters() {
        output.startInfo();
        return validator.triangleParameters(input.getString());
    }

    public Triangle getTriangleParameters(ArrayList<String> triangleArray) {
        output.newTriangle();
        if (triangleArray.size() >= 4) {
            if (getSides(triangleArray).size() >= 3) {
                return createTriangle(triangleArray.get(0), getSides(triangleArray));
            } else {
                output.wrongData();
                return null;
            }
        } else {
            output.notAllParameters();
            return null;
        }
    }

    public ArrayList<Float> getSides(ArrayList<String> triangleArray) {
        ArrayList<Float> sides = new ArrayList<Float>();
        for (int i = 1; i < triangleArray.size(); i++) {
            if (validator.isNumber(triangleArray.get(i))) {
                sides.add(validator.toFloat(triangleArray.get(i)));
            } else {
                break;
            }
        }
        return sides;
    }

    @Nullable
    public Triangle createTriangle(String name, ArrayList<Float> sides) {
            float sideA = sides.get(0);
            float sideB = sides.get(1);
            float sideC = sides.get(2);
            if (validator.isSideCorrect(sideA, sideB, sideC)) {
                return isTriangleExist(name, sideA, sideB, sideC);
            } else {
                output.triangleCreateError();
                return null;
            }
    }

    @Nullable
    public Triangle isTriangleExist(String name, float sideA, float sideB, float sideC) {
        if (validator.isSuchTriangleExist(sideA, sideB, sideC)) {
            model = new Triangle(name, sideA, sideB, sideC);
            service.triangleArea(model);
            return model;
        } else {
            output.wrongSides();
            return null;
        }
    }

    public void showTriangleList(ArrayList<Triangle> triangleList) {
        output.triangleList(service.sortCollection(triangleList));
    }

    public boolean shouldContinue() {
        output.shouldContinue();
        return validator.continueRequest(input.getString());
    }

}
