import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6};
        ArrayUtils.swapGroups(intArray, 0, 3, 3);
        System.out.println("Integer swapGroups: " + Arrays.toString(intArray));

        Integer[] intArray2 = {10, 20, 30, 40, 50};
        ArrayUtils.swapNeighborPairs(intArray2);
        System.out.println("Integer swapNeighborPairs: " + Arrays.toString(intArray2));

        Integer[] replacedIntArray = ArrayUtils.replaceGroup(intArray2, 1, new Integer[]{99, 88});
        System.out.println("Integer replaceGroup: " + Arrays.toString(replacedIntArray));

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        ArrayUtils.swapNeighborPairs(doubleArray);
        System.out.println("Double swapNeighborPairs: " + Arrays.toString(doubleArray));

        String[] strArray = {"A", "B", "C", "D", "E", "F"};
        ArrayUtils.swapGroups(strArray, 0, 3, 3);
        System.out.println("String swapGroups: " + Arrays.toString(strArray));

        String[] replacedStrArray = ArrayUtils.replaceGroup(strArray, 1, new String[]{"X", "Y", "Z"});
        System.out.println("String replaceGroup: " + Arrays.toString(replacedStrArray));
    }
}