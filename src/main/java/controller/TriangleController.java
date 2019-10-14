package controller;

import util.*;
import model.*;
import service.*;
import java.util.ArrayList;
import java.util.Collections;


public class TriangleController {
    private Input input = new Input();
    private Output output = new Output();
    private TriangleModel model;
    private TriangleService service = new TriangleService();
    private Validator validator = new Validator();

    public TriangleController() {}

    public void addToCollection(ArrayList<TriangleModel> triangleList) {
        TriangleModel newTriangle = createTriangle(enterAndSplit());
        triangleList.add(newTriangle);
    }

    public TriangleModel createTriangle(String[] triangleArray) {
        output.newTriangle();
        float sideA = validator.toFloat(triangleArray[1]);
        float sideB = validator.toFloat(triangleArray[2]);
        float sideC = validator.toFloat(triangleArray[3]);

        if(triangleArray.length == 4 && validator.isSideCorrect(sideA, sideB, sideC)) {
            if(validator.isSuchTriangleExist(sideA, sideB, sideC)) {
            model = new TriangleModel(triangleArray[0], sideA, sideB, sideC);
            service.triangleArea(model);
            return model;
            } else {
                output.wrongSides();
                return null;
            }
        } else {
            output.triangleCreateError();
            return null;
        }
    }

    public String[] enterAndSplit() {
        output.startInfo();
        return validator.enterAndSplit(input.getString());
    }

    public void sortCollection(ArrayList<TriangleModel> triangleList) {
        Collections.sort(triangleList, Collections.reverseOrder());
        output.triangleList(triangleList);
        /*for (TriangleModel triangle : triangleList) {
            System.out.println(triangle);
        }*/
    }

    public boolean shouldContinue() {
        output.shouldContinue();
        return validator.continueRequest(input.getString());
    }

}
