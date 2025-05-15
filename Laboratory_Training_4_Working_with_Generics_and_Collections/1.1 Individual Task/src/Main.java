import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Hour[] hours = {
                new Hour(50, "Busy day, lots of people"),
                new Hour(30, "Few passengers"),
                new Hour(70, "Very crowded, long wait")
        };

        MetroStation stationArrayList = new MetroStationArrayList("ArrayListStation", 2000);
        MetroStation stationSortedByPassengers = new MetroStationSortedSet("SortedSetStationPassengers", 2005,
                Comparator.comparingInt(Hour::getNumberOfPassengers));
        MetroStation stationSortedByCommentLength = new MetroStationSortedSet("SortedSetStationComment", 2010,
                new CommentLengthComparator());

        for (Hour h : hours) {
            stationArrayList.addHour(h);
            stationSortedByPassengers.addHour(h);
            stationSortedByCommentLength.addHour(h);
        }

        System.out.println("\n--- ArrayList Station ---");
        printHours(stationArrayList.getHours());

        System.out.println("\n--- SortedSet by Passengers ---");
        printHours(stationSortedByPassengers.getHours());

        System.out.println("\n--- SortedSet by Comment Length ---");
        printHours(stationSortedByCommentLength.getHours());
    }

    private static void printHours(Hour[] hours) {
        for (Hour h : hours) {
            System.out.println("Passengers: " + h.getNumberOfPassengers()
                    + ", Comment: " + h.getComment());
        }
    }
}
