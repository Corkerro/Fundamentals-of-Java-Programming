import java.util.Comparator;

/**
 * Comparator for comparing Hour objects by the length of their comments in descending order.
 */
public class CommentLengthComparator implements Comparator<Hour> {
    /**
     * Compares two Hour objects based on the length of their comments.
     *
     * @param h1 the first Hour to compare
     * @param h2 the second Hour to compare
     * @return a negative integer, zero, or a positive integer as the second comment is longer than,
     *         equal to, or shorter than the first
     */
    @Override
    public int compare(Hour h1, Hour h2) {
        return Integer.compare(h2.getComment().length(), h1.getComment().length()); // DESC
    }
}
