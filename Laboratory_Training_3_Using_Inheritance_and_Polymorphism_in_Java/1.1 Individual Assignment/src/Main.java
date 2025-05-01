import java.util.Arrays;

/**
 * Demonstrates usage of MetroStation, Hour, and custom comparators.
 */
public class Main {
    public static void main(String[] args) {
        Hour[] hours = {
                new Hour(50, "Busy day, lots of people"),
                new Hour(30, "Few passengers"),
                new Hour(70, "Very crowded, long wait")
        };

        MetroStation station1 = new MetroStationArray("Central", 1995, 10);
        MetroStation station2 = new MetroStationLinkedList("North", 2001);

        for (Hour h : hours) {
            station1.addHour(h);
            station2.addHour(h);
        }

        System.out.println("=== Station: " + station1.getName() + " ===");
        System.out.println("Total passengers: " + totalPassengers(station1));
        printMinPassengerHour(station1);
        printMaxWordsCommentHour(station1);

        System.out.println("\nSorted by number of passengers (desc):");
        Hour[] sortedByPassengers = station1.getHours();
        Arrays.sort(sortedByPassengers);
        printHours(sortedByPassengers);

        System.out.println("\nSorted by comment length (desc):");
        Hour[] sortedByCommentLength = station1.getHours();
        Arrays.sort(sortedByCommentLength, new CommentLengthComparator());
        printHours(sortedByCommentLength);
    }

    /**
     * Calculates the total number of passengers at the station.
     *
     * @param station metro station
     * @return total passenger count
     */
    private static int totalPassengers(MetroStation station) {
        return Arrays.stream(station.getHours())
                .mapToInt(Hour::getNumberOfPassengers)
                .sum();
    }

    /**
     * Finds and prints the hour with the minimum number of passengers.
     *
     * @param station metro station
     */
    private static void printMinPassengerHour(MetroStation station) {
        Hour min = Arrays.stream(station.getHours())
                .min((a, b) -> Integer.compare(a.getNumberOfPassengers(), b.getNumberOfPassengers()))
                .orElse(null);
        if (min != null) {
            System.out.println("Min passengers: " + min.getNumberOfPassengers());
        }
    }

    /**
     * Finds and prints the comment of the hour with the most words.
     *
     * @param station metro station
     */
    private static void printMaxWordsCommentHour(MetroStation station) {
        Hour max = Arrays.stream(station.getHours())
                .max((a, b) -> Integer.compare(a.getWordCount(), b.getWordCount()))
                .orElse(null);
        if (max != null) {
            System.out.println("Max words in comment: " + max.getComment());
        }
    }

    /**
     * Prints the list of Hour objects.
     *
     * @param hours array of Hour
     */
    private static void printHours(Hour[] hours) {
        for (Hour h : hours) {
            System.out.println("Passengers: " + h.getNumberOfPassengers()
                    + ", Comment: " + h.getComment());
        }
    }
}
