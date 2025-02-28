package arrays.array;
import arrays.Settings;
import java.util.Arrays;

/**
 * Class that handles a string array generated from a 2D integer array.
 * Each string is generated based on the minimum or maximum value from the 2D array, repeated based on certain settings.
 */
public class StringArrays {
    private final String[] str;
    private static Settings settings;

    /**
     * Constructor that initializes the StringArrays object.
     * It generates strings based on a 2D array and settings.
     *
     * @param array    The ArrayArrays object containing the 2D array.
     * @param settings The settings that determine how the strings are generated.
     */
    public StringArrays(ArrayArrays array, Settings settings) {
        array.sortArray();
        StringArrays.settings = settings;
        str = new String[array.getRow()];
        Arrays.setAll(str, i -> String.valueOf(settings.getCharToFill()).repeat(numberOfRepeats(i, array.getArray())));
    }

    /**
     * @return The array of strings.
     */
    public String[] getStrings() {
        return str;
    }

    /**
     * Prints the string array in a human-readable format.
     */
    public void printStrings() {
        System.out.println(Arrays.deepToString(str));
    }

    /**
     * Sorts the strings based on the sorting rule from the settings.
     */
    public void sortStrings() {
        Arrays.sort(str, this::sort);
    }

    /**
     * The comparison logic for sorting the strings based on the settings.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return The comparison result.
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
     * Determines the number of repetitions for a string based on the array values and settings.
     *
     * @param i     The row index.
     * @param array The 2D array.
     * @return The number of repetitions.
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
