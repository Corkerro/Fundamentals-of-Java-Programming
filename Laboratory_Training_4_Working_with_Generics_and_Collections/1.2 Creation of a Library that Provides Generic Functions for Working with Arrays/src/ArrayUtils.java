import java.util.Arrays;

public class ArrayUtils {

    public static <T> void swapGroups(T[] array, int start1, int start2, int length) {
        for (int i = 0; i < length; i++) {
            T temp = array[start1 + i];
            array[start1 + i] = array[start2 + i];
            array[start2 + i] = temp;
        }
    }

    public static <T> void swapNeighborPairs(T[] array) {
        for (int i = 0; i < array.length - 1; i += 2) {
            T temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }
    }

    public static <T> T[] replaceGroup(T[] array, int startIndex, T[] replacement) {
        T[] newArray = Arrays.copyOf(array, array.length);
        System.arraycopy(replacement, 0, newArray, startIndex, replacement.length);
        return newArray;
    }
}
