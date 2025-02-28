package arrays;

/**
 * Class that holds the configuration settings for generating arrays and strings.
 */
public class Settings {
    private final int row;
    private final int col;
    private final int from;
    private final int to;
    private final char charToFill;
    private final RandomSettings randomSetting;
    private final StringsArraySettings stringsArraySetting;
    private final SortRule sortRule;

    /**
     * Enum that defines the possible settings for random number generation.
     */
    public enum RandomSettings {
        RANDOM_EVEN,
        RANDOM_ODD,
        RANDOM_POSITIVE
    }

    /**
     * Enum that defines the settings for selecting array items for string generation.
     */
    public enum StringsArraySettings {
        MINIMUM_ROW_ITEM,
        MAXIMUM_ROW_ITEM,
        MINIMUM_COL_ITEM,
        MAXIMUM_COL_ITEM
    }

    /**
     * Enum that defines the sorting rules for string arrays.
     */
    public enum SortRule {
        INCREASING_LENGTH,
        DECREASING_LENGTH,
        REVERSE_ALPHABET
    }

    /**
     * Constructs the Settings object with the specified parameters.
     *
     * @param row                 The number of rows.
     * @param col                 The number of columns.
     * @param from                The lower bound for number generation.
     * @param to                  The upper bound for number generation.
     * @param charToFill          The character to use for string generation.
     * @param randomSetting       The setting that controls random number generation.
     * @param stringsArraySetting The setting for string generation from array.
     * @param sortRule            The sorting rule for the string array.
     */
    public Settings(int row, int col, int from, int to, char charToFill,
                    RandomSettings randomSetting,
                    StringsArraySettings stringsArraySetting,
                    SortRule sortRule) {
        this.row = row;
        this.col = col;
        this.from = from;
        this.to = to;
        this.charToFill = charToFill;
        this.randomSetting = randomSetting;
        this.stringsArraySetting = stringsArraySetting;
        this.sortRule = sortRule;
    }

    /**
     * @return The upper bound.
     */
    public int getTo() {
        return to;
    }

    /**
     * @return The lower bound.
     */
    public int getFrom() {
        return from;
    }

    /**
     * @return The number of columns.
     */
    public int getCol() {
        return col;
    }

    /**
     * @return The number of rows.
     */
    public int getRow() {
        return row;
    }

    /**
     * @return The character to fill strings.
     */
    public char getCharToFill() {
        return charToFill;
    }

    /**
     * @return The random setting.
     */
    public RandomSettings getRandomSetting() {
        return randomSetting;
    }

    /**
     * @return The strings array setting.
     */
    public StringsArraySettings getStringsArraySetting() {
        return stringsArraySetting;
    }

    /**
     * @return The sort rule.
     */
    public SortRule getSortRule() {
        return sortRule;
    }
}
