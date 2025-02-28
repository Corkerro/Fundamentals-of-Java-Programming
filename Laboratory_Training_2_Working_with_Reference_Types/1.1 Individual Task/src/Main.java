import arrays.Settings;
import arrays.array.ArrayArrays;
import arrays.array.StringArrays;
import arrays.loops.ArrayLoops;
import arrays.loops.StringLoops;

/*
    Fill in a two-dimensional array of integers by random positive values according to the rule given in the table.
    Fill in a one-dimensional array of strings by repeating of a certain character by the number of times specified
    in the table. Sort the array of strings according to the rule specified in the table.

        Size of a two-dimensional array: 4x3
        The rule of filling a two-dimensional array: random even number between 0 and 24
        Number of items in array of strings: the number of rows of an array of numbers
        The length of a single string in the array: minimum row item
        Criterion of sorting array of strings: by decreasing the length

    Display the resulting array of strings.
    To implement two approaches: traditional, built on cycles and working with individual items and through the
    functions of the Arrays class (without cycles). Do not use streams and Arrays.stream() method.
 */

/**
 * Main class for running the Individual Task with arrays and sorting.
 * This class initializes the settings and demonstrates functionality of the ArrayArrays and StringArrays classes.
 */
public class Main {
    private static final int row = 4;
    private static final int col = 3;
    private static final int from = 0;
    private static final int to = 24;
    private static final char charToFill = 'N';

    /**
     * The main method which runs the program.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Settings settings = new Settings(row, col, from, to, charToFill,
                Settings.RandomSettings.RANDOM_EVEN,
                Settings.StringsArraySettings.MINIMUM_ROW_ITEM,
                Settings.SortRule.DECREASING_LENGTH);

        System.out.println("Individual Task");
        System.out.println("Variant 11");

        System.out.println("\n\nWith Arrays class:");

        ArrayArrays arrayArrays = new ArrayArrays(settings);
        arrayArrays.generateArray();
        arrayArrays.printArray();

        StringArrays stringArrays = new StringArrays(arrayArrays, settings);
        arrayArrays.printArray();
        stringArrays.printStrings();
        stringArrays.sortStrings();
        stringArrays.printStrings();

        System.out.println("\n\nWith loops:");
        ArrayLoops arrayLoops = new ArrayLoops(settings);
        arrayLoops.generateArray();
        arrayLoops.printArray();

        StringLoops stringLoops = new StringLoops(arrayLoops, settings);
        arrayArrays.printArray();
        stringLoops.printStrings();
        stringLoops.sortStrings();
        stringLoops.printStrings();
    }
}