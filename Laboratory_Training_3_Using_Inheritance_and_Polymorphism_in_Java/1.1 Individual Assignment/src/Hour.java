/**
 * Represents a time period (hour) with the number of passengers and a comment.
 */
public class Hour implements Comparable<Hour> {
    private int numberOfPassengers;
    private String comment;

    /**
     * Constructs an Hour with specified number of passengers and a comment.
     *
     * @param numberOfPassengers number of passengers during the hour
     * @param comment            description or comment about this hour
     */
    public Hour(int numberOfPassengers, String comment) {
        this.numberOfPassengers = numberOfPassengers;
        this.comment = comment;
    }

    /**
     * Returns the number of passengers.
     *
     * @return number of passengers
     */
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * Sets the number of passengers.
     *
     * @param numberOfPassengers new number of passengers
     */
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    /**
     * Returns the comment.
     *
     * @return comment string
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment.
     *
     * @param comment new comment string
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the number of words in the comment.
     *
     * @return number of words
     */
    public int getWordCount() {
        return comment.trim().isEmpty() ? 0 : comment.trim().split("\\s+").length;
    }

    /**
     * Compares this Hour with another by number of passengers (descending).
     *
     * @param other the other Hour object to compare to
     * @return comparison result
     */
    @Override
    public int compareTo(Hour other) {
        return Integer.compare(other.numberOfPassengers, this.numberOfPassengers);
    }

    /**
     * Checks equality based on passengers and comment.
     *
     * @param o the object to compare with
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hour)) return false;
        Hour hour = (Hour) o;
        return numberOfPassengers == hour.numberOfPassengers && comment.equals(hour.comment);
    }

    /**
     * Returns hash code based on passengers and comment.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(numberOfPassengers, comment);
    }
}
