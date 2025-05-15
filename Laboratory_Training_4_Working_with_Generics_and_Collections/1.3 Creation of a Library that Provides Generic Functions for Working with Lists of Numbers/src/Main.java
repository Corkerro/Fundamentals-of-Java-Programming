import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 0, -3, 5, -1);
        List<Double> doubleList = Arrays.asList(2.5, -1.2, 0.0, 3.4, -9.8);
        List<Float> floatList = Arrays.asList(1.1f, 2.2f, -3.3f, 0.0f);

        System.out.println("Integer List:");
        testList(intList);

        System.out.println("\nDouble List:");
        testList(doubleList);

        System.out.println("\nFloat List:");
        testList(floatList);
    }

    private static <T extends Number> void testList(List<T> list) {
        System.out.println("List: " + list);
        System.out.println("Index of first zero: " + NumberListUtils.indexOfFirstZero(list));
        System.out.println("Count of negatives: " + NumberListUtils.countNegatives(list));
        System.out.println("Last negative: " + NumberListUtils.lastNegative(list));
    }
}