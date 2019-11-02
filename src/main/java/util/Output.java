package util;
import model.Triangle;
import java.util.ArrayList;

public class Output {

    public void startInfo() {
        System.out.println("Enter the name and sides of the triangle, separated by comma");
    }

    public void newTriangle() {
        System.out.println("Trying create triangle...");
    }

    public void notAllParameters() {
        System.out.println("You didn`t enter all parameters");
    }

    public void wrongData() {
        System.out.println("Not valid data");
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

    public void triangleList(ArrayList<Triangle> triangleList) {
        System.out.println("================ Triangle list: ================");
        for (Triangle triangle : triangleList) {
            System.out.println(triangle);
        }
    }
}

