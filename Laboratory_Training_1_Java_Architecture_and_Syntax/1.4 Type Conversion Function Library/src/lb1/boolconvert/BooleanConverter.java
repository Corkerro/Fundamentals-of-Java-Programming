package lb1.boolconvert;

public class BooleanConverter {
    public static int toInt(boolean bool) {
        return bool? 1 : 0;
    }

    public static boolean toBool(int i) {
        return switch (i) {
            case 1 -> true;
            case 0 -> false;
            default -> throw new IllegalArgumentException("Input must be 0 or 1");
        };
    }
}
