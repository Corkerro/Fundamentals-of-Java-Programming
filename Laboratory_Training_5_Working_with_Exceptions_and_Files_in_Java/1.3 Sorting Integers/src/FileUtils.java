import java.io.*;
import java.util.*;

public class FileUtils {
    public static List<Integer> readNumbersFromFile(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        }
        return numbers;
    }

    public static void sortAndSave(List<Integer> numbers, Comparator<Integer> comparator, String filename)
            throws IOException {
        numbers.sort(comparator);
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Integer num : numbers) {
                writer.print(num + " ");
            }
        }
    }
}