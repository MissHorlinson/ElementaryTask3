package util;
import com.sun.istack.internal.Nullable;
import java.util.ArrayList;

public class Validator {

    public ArrayList<String> triangleParameters(String string) {
        ArrayList<String> params = new ArrayList<String>();
        String[] triangle = enterAndSplit(string);
        for (int i = 0; i < triangle.length; i++) {
            if (!isExist(triangle[i])) {
                params.add(triangle[i]);
            }
        }
        return params;
    }

    @Nullable
    public String[] enterAndSplit(String string) {
        if(!string.isEmpty()) {
            String[] triangleArray = string.replaceAll("\\s+", "").split(",");
            return triangleArray;
        } else {
            return null;
        }
    }

    public boolean isExist(String side) {
        return side.isEmpty();
    }

    public float toFloat(String side) {
        return Float.parseFloat(side);
    }

    public boolean isNumber(String str) {
        return str.matches("\\d+");
    }

    public boolean isSideCorrect(float a, float b, float c) {
        if(a <= 0 || b <=0 || c <= 0 ) {
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
