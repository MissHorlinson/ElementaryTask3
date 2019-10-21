package controller;
import util.*;
import model.*;
import service.*;
import java.util.ArrayList;
import java.util.Collections;

public class TriangleController {
    private Input           input = new Input();
    private Output          output = new Output();
    private TriangleService service = new TriangleService();
    private Validator       validator = new Validator();
    private TriangleModel   model;

    public TriangleController() {}

    public void addToCollection(ArrayList<TriangleModel> triangleList) {
        TriangleModel newTriangle = createTriangle(enterAndSplit());
        triangleList.add(newTriangle);
    }

    public String[] enterAndSplit() {
        output.startInfo();
        return validator.enterAndSplit(input.getString());
    }

    public TriangleModel createTriangle(String[] triangleArray) {
        output.newTriangle();
        float sideA = validator.toFloat(triangleArray[1]);
        float sideB = validator.toFloat(triangleArray[2]);
        float sideC = validator.toFloat(triangleArray[3]);

        if(triangleArray.length == 4 && validator.isSideCorrect(sideA, sideB, sideC)) {
            return isTriangleExist(triangleArray[0], sideA, sideB, sideC);
        } else {
            output.triangleCreateError();
            return null;
        }
    }

    public TriangleModel isTriangleExist(String name, float sideA, float sideB, float sideC) {
        if(validator.isSuchTriangleExist(sideA, sideB, sideC)) {
            model = new TriangleModel(name, sideA, sideB, sideC);
            service.triangleArea(model);
            return model;
        } else {
            output.wrongSides();
            return null;
            }
    }

    public void showTriangleList(ArrayList<TriangleModel> triangleList) {
        output.triangleList(service.sortCollection(triangleList));
    }

    public boolean shouldContinue() {
        output.shouldContinue();
        return validator.continueRequest(input.getString());
    }

}
