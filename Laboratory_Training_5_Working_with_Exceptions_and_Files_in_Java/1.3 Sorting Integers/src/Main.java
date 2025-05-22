import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = FileUtils.readNumbersFromFile("input.txt");

            FileUtils.sortAndSave(numbers, new DescendingComparator(), "descending.txt");
            FileUtils.sortAndSave(numbers, new SumOfDigitsComparator(), "sum_of_digits.txt");

            System.out.println("Sorting completed successfully!");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}