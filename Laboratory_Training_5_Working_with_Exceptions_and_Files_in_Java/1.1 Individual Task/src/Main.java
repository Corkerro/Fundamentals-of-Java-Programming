import java.io.IOException;
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

        // Demonstrate file operations
        try {
            // Text file operations
            String textFilename = "station_data.txt";
            System.out.println("\nWriting to text file: " + textFilename);
            FileOperations.writeToTextFile(stationArrayList, textFilename);

            System.out.println("Reading from text file: " + textFilename);
            MetroStation readFromText = FileOperations.readFromTextFile(textFilename);
            System.out.println("\n--- Station read from text file ---");
            printHours(readFromText.getHours());

            // Binary file operations
            String binaryFilename = "station_data.bin";
            System.out.println("\nWriting to binary file: " + binaryFilename);
            FileOperations.writeToBinaryFile(stationArrayList, binaryFilename);

            System.out.println("Reading from binary file: " + binaryFilename);
            MetroStation readFromBinary = FileOperations.readFromBinaryFile(binaryFilename);
            System.out.println("\n--- Station read from binary file ---");
            printHours(readFromBinary.getHours());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during file operations: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printHours(Hour[] hours) {
        for (Hour h : hours) {
            System.out.println("Passengers: " + h.getNumberOfPassengers()
                    + ", Comment: " + h.getComment());
        }
    }
}