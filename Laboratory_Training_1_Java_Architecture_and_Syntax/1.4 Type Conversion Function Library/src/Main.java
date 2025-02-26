import lb1.boolconvert.BooleanConverter;

/*
    Create a class with static functions to convert an argument of type boolean
    to an integer value (0 or 1) and vice versa (zero is false, non-zero value is true).
    Demonstrate the invocation of functions by calling them from another class created
    in another package. Apply normal and static import.
 */

public class Main {
    public static void main(String[] args) {
        int boolToInt = BooleanConverter.toInt(true);
        boolean intToBool = BooleanConverter.toBool(1);

        System.out.printf("boolToInt: %d\nintToBool: %b\n", boolToInt, intToBool);
    }
}
