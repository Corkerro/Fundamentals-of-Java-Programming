package arrays.array;
import arrays.NumberHelper;
import arrays.Settings;
import java.util.Arrays;

/**
 * Class representing a 2D array that can be generated, sorted, and transposed.
 * It handles the array creation, printing, sorting, and transposition of rows or columns based on settings.
 */
public class ArrayArrays {
    private static Settings settings;
    private static int col;
    private static int row;
    private int[][] array;

    /**
     * Constructor to initialize the ArrayArrays object with provided settings.
     *
     * @param settings Settings to control array size and behavior.
     */
    public ArrayArrays(Settings settings) {
        ArrayArrays.settings = settings;
        col = settings.getCol();
        row = settings.getRow();
    }

    /**
     * Generates a 2D array based on the row and column settings, with random values.
     */
    public void generateArray() {
        array = new int[row][];
        Arrays.setAll(array, i -> fillRow());
    }

    /**
     * @return The number of rows.
     */
    public int getRow() {
        return col;
    }

    /**
     * @return The number of columns.
     */
    public int getCol() {
        return row;
    }

    /**
     * @return The 2D array.
     */
    public int[][] getArray() {
        return array;
    }

    /**
     * Prints the 2D array in a human-readable format.
     */
    public void printArray() {
        System.out.println(Arrays.deepToString(array));
    }

    /**
     * Sorts each row of the 2D array using Arrays.sort.
     * If necessary, transposes the array before and after sorting.
     */
    public void sortArray() {
        if (isTranspose()) {
            transposeArray();
        }
        Arrays.setAll(array, i -> {
            int[] sortedRow = Arrays.copyOf(array[i], array[i].length);
            Arrays.sort(sortedRow);
            return sortedRow;
        });

        if (isTranspose()) {
            transposeArray();
        }
    }

    /**
     * Checks if the array needs to be transposed based on the settings.
     *
     * @return True if the array should be transposed, false otherwise.
     */
    private boolean isTranspose() {
        return settings.getStringsArraySetting() == Settings.StringsArraySettings.MINIMUM_COL_ITEM
                || settings.getStringsArraySetting() == Settings.StringsArraySettings.MAXIMUM_COL_ITEM;
    }

    /**
     * Transposes the 2D array (rows become columns and vice versa).
     */
    private void transposeArray() {
        int[][] transposed = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transposed[j][i] = array[i][j];
            }
        }

        int tempCol = col;
        col = row;
        row = tempCol;

        array = transposed;
    }

    /**
     * Fills a row with random numbers based on the settings.
     *
     * @return A row of random numbers.
     */
    private int[] fillRow() {
        int[] result = new int[col];
        Arrays.setAll(result, i -> NumberHelper.generateNumber(settings));
        return result;
    }
}
