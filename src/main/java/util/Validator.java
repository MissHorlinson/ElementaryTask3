package util;

public class Validator {
    private Input input = new Input();

    public String[] enterAndSplit(String string) {
        if(!string.isEmpty()) {
            String[] triangleArray = string.replaceAll("\\s+", "").split(",");
            return triangleArray;
        } else {
            return null;
        }
    }

    public float toFloat(String side) {
        return Float.parseFloat(side);
    }

    public boolean isSideCorrect(float a, float b, float c) {
        if(a <= 0 || b <=0 || c <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSuchTriangleExist(float a, float b, float c) {
        if((a + b) > c && (c + a) > b && (b + c) > a) {
            return true;
        } else {
            return false;
        }
    }

    public boolean continueRequest(String answer) {
        answer = answer.toUpperCase();
        if(answer.equals("Y") || answer.equals("YES"))
            return true;
        else
            return false;
    }
}
