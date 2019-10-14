package util;

import model.TriangleModel;

import java.util.ArrayList;
import java.util.Collections;

public class Output {

    public void startInfo() {
        System.out.println("Enter the name and sides of the triangle, separated by comma");
    }

    public void newTriangle() {
        System.out.println("Creating new triangle");
    }

    public void wrongSides() {
        System.out.println("Triangle with such sides can`t exist");
    }

    public void triangleCreateError() {
        System.out.println("Error! Please, enter right parameters");
    }

    public void shouldContinue() {
        System.out.println("Enter y - yes, if you want to continue ?");
    }

    public void triangleList(ArrayList<TriangleModel> triangleList) {
        System.out.println("================ Triangle list: ================");
        //Collections.sort(triangleList, Collections.reverseOrder());
        for (TriangleModel triangle : triangleList) {
            System.out.println(triangle);
        }
    }
}

