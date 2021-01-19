package mycalculator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nazar Ahmed Awad
 */
public class org {

    static String[] op = {"+", "-", "/", "*", ".", "+/-"};

    public static float result = 0.0f;

    //this method for exceute the operator
    public static void operation(ArrayList<Object> arr) {
        try {
            float f = 0.0f;
            float num1 = 0.0f;
            float num2 = 0.0f;
            int i = 0;
            while (i < arr.size()) {
                switch (arr.get(i).toString()) {
                    case "+":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 + num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                    case "-":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 - num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                    case "*":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 * num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                    case "/":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 / num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                }
                i++;
            }

            result = (float) arr.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //overload method use it for exceute the operator with Priority
    public static void operation(ArrayList<Object> arr, boolean pro) {
        try {
            float f = 0.0f;
            float num1 = 0.0f;
            float num2 = 0.0f;
            int i = 0;
            while (i < arr.size()) {
                switch (arr.get(i).toString()) {
                    case "*":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 * num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                    case "/":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 / num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                }
                i++;
            }

            f = 0.0f;
            num1 = 0.0f;
            num2 = 0.0f;
            i = 0;
            while (i < arr.size()) {
                switch (arr.get(i).toString()) {
                    case "+":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 + num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                    case "-":
                        num1 = Float.parseFloat(arr.get(i - 1).toString());
                        num2 = Float.parseFloat(arr.get(i + 1).toString());
                        f = num1 - num2;
                        arr.set(i - 1, f);
                        arr.remove(i);
                        arr.remove(i);
                        i = 0;
                        break;
                }
                i++;
            }
            result = (float) arr.get(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //this method for combine the integer, double and float numbers in new array
    //use it before send main array to operation method
    public static void reBuild(ArrayList<Object> arr, boolean pro) {
        ArrayList<Object> arr2 = new ArrayList<Object>();
        String num = "";
        int i = 0;
        while (i < arr.size()) {
            if (IsInteger(arr.get(i).toString()) || IsDouble(arr.get(i).toString())) {
                num = num + arr.get(i).toString();
            } else if (arr.get(i).toString().equals(".")) {
                num = num + arr.get(i).toString();
            } else {
                arr2.add(num);
                num = "";
                if (i < arr.size()) {
                    arr2.add(arr.get(i));
                }
            }
            i++;
            if (i == arr.size()) {
                arr2.add(num);
            }
        }
        if (pro) {
            operation(arr2, pro);
        } else {
            operation(arr2);
        }
    }

    //method for check integer value
    static boolean IsInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    //method for check double value
    static boolean IsDouble(String value) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    //it is work as validation when press buttons
    static boolean checkInput(ArrayList<Object> arr, String value) {
        if (arr.isEmpty() && Arrays.asList(op).contains(value)) {
            return false;
        } else if (Arrays.asList(op).contains(value) && Arrays.asList(op).contains(arr.get(arr.size()-1)))
        {
            return false;
        }
        else {
            return true;
        }
    }

}
