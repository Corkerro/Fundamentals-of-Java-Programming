import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        String[] words = sentence.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");

        SortedSet<String> uniqueWords = new TreeSet<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }

        System.out.println("Unique words in alphabetical order:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        scanner.close();
    }
}