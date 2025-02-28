package arrays.loops;
import arrays.NumberHelper;
import arrays.Settings;

/**
 * Class that represents a 2D array generated using loops, which can be sorted using the quicksort algorithm.
 * It supports array creation, printing, sorting, and transposition based on the settings.
 */
public class ArrayLoops {
    private static Settings settings;
    private static int col;
    private static int row;
    private int[][] array;

    /**
     * Constructs the ArrayLoops object with the specified settings.
     *
     * @param settings The settings that determine the array's size and behavior.
     */
    public ArrayLoops(Settings settings) {
        ArrayLoops.settings = settings;
        col = settings.getCol();
        row = settings.getRow();
    }

    /**
     * Generates the 2D array with random values based on the provided settings.
     */
    public void generateArray() {
        array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = NumberHelper.generateNumber(settings);
            }
        }
    }

    /**
     * @return The 2D array.
     */
    public int[][] getArray() {
        return array;
    }

    /**
     * Sorts each row of the array using the quicksort algorithm.
     * If necessary, transposes the array before and after sorting.
     */
    public void sortArray() {
        if (isTranspose()) {
            transposeArray();
        }

        for (int i = 0; i < array.length; i++) {
            quickSort(array[i], 0, array[i].length - 1);
        }

        if (isTranspose()) {
            transposeArray();
        }
    }

    /**
     * Prints the 2D array in a readable format.
     */
    public void printArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < array.length; i++) {
            sb.append("[");
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
                if (j < array[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        System.out.println(sb);
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
     * Transposes the array (flips rows and columns).
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
     * Performs the quicksort algorithm on a given array.
     *
     * @param array The array to sort.
     * @param low The starting index of the array.
     * @param high The ending index of the array.
     */
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array for quicksort by selecting a pivot and rearranging elements.
     *
     * @param array The array to partition.
     * @param low The starting index.
     * @param high The ending index.
     * @return The index of the pivot.
     */
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /**
     * Checks if the array should be transposed based on the current settings.
     *
     * @return True if the array should be transposed; otherwise false.
     */
    private boolean isTranspose() {
        return settings.getStringsArraySetting() == Settings.StringsArraySettings.MINIMUM_COL_ITEM
                || settings.getStringsArraySetting() == Settings.StringsArraySettings.MAXIMUM_COL_ITEM;
    }
}
