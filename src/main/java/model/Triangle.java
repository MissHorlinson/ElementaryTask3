package model;

public class Triangle implements Comparable {

    private String name;
    private float sideA;
    private float sideB;
    private float sideC;
    private double S;

    public Triangle() { }

    public Triangle(String name, float sideA, float sideB, float sideC) {
        this.name = name;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public String getName() { return name; }

    public float getSideA() { return sideA; }

    public float getSideB() { return sideB; }

    public float getSideC() { return sideC; }

    public double getS() { return S; }

    public void setName(String name) { this.name = name; }

    public void setSideA(float sideA) { this.sideA = sideA; }

    public void setSideB(float sideB) { this.sideB = sideB; }

    public void setSideC(float sideC) { this.sideC = sideC; }

    public void setS(double s) { S = s; }

    @Override
    public int compareTo(Object o) {
        Triangle triangle = (Triangle)o;
        if(this.getS() < triangle.getS()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "[" + this.getName() + "]:" + this.getS() + " cm";
    }
}
