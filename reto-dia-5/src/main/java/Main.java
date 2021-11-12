import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String string1 = "[1,2,3,4,5]";
        String string2 = "1,2,3,4,5";
        String string3 = "[a,b,c,d,e]";
        String string4 = "[1 2 3 4 5]";

        ArrayList<String> strings = new ArrayList<>(Arrays.asList(string1, string2, string3, string4));
        printStringtoArray(strings);
    }

    private static void printStringtoArray(ArrayList<String> strings) {
        for (String string : strings) {
            System.out.println("\nString: \"" + string + "\"");
            Integer[] integerArray = Util.stringToArray(string);
            if (integerArray != null) {
                System.out.println("Array de enteros: " + Arrays.toString(integerArray));
            } else {
                System.out.println("No se ha podido crear el Array");
            }
        }
    }
}
