package arrays.loops;
import arrays.Settings;
import java.util.Arrays;

/**
 * Class that creates an array of strings from a 2D integer array, where each string is generated
 * based on a specific pattern of the integer array, and can be sorted according to specified rules.
 */
public class StringLoops {
    private final String[] str;
    private static Settings settings;

    /**
     * Constructs the StringLoops object by sorting the integer array and then generating a string array.
     *
     * @param array    The ArrayLoops object which contains the 2D integer array.
     * @param settings The settings that control the behavior of string generation and sorting.
     */
    public StringLoops(ArrayLoops array, Settings settings) {
        array.sortArray();
        StringLoops.settings = settings;
        str = new String[array.getRow()];
        Arrays.setAll(str, i -> String.valueOf(settings.getCharToFill()).repeat(numberOfRepeats(i, array.getArray())));
    }

    /**
     * @return The string array.
     */
    public String[] getStrings() {
        return str;
    }

    /**
     * Prints the string array in a readable format.
     */
    public void printStrings() {
        System.out.println(Arrays.deepToString(str));
    }

    /**
     * Sorts the string array based on the specified sorting rule from the settings.
     */
    public void sortStrings() {
        Arrays.sort(str, this::sort);
    }

    /**
     * Custom comparator for sorting strings based on the specified rule.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return The result of the comparison.
     */
    private int sort(String s1, String s2) {
        return switch (settings.getSortRule()) {
            case INCREASING_LENGTH -> Integer.compare(s1.length(), s2.length());
            case DECREASING_LENGTH -> Integer.compare(s2.length(), s1.length());
            case REVERSE_ALPHABET -> s2.compareTo(s1);
            default -> throw new IllegalArgumentException("Unsupported SortSettings");
        };
    }

    /**
     * Determines the number of repetitions for each string based on the integer array and settings.
     *
     * @param i     The index of the row.
     * @param array The 2D integer array.
     * @return The number of times the character should be repeated.
     */
    private int numberOfRepeats(int i, int[][] array) {
        return switch (settings.getStringsArraySetting()) {
            case MAXIMUM_ROW_ITEM -> array[i][settings.getCol() - 1];
            case MINIMUM_ROW_ITEM -> array[i][0];
            case MAXIMUM_COL_ITEM -> array[settings.getRow() - 1][i];
            case MINIMUM_COL_ITEM -> array[0][i];
            default -> throw new IllegalArgumentException("Unsupported StringsArraySetting");
        };
    }
}
