import java.io.*;
import java.util.Arrays;

/**
 * Utility class for file operations including text and binary file handling.
 */
public class FileOperations {

    /**
     * Writes MetroStation data to a text file.
     *
     * @param station The MetroStation to write
     * @param filename The name of the text file
     * @throws IOException If an I/O error occurs
     */
    public static void writeToTextFile(MetroStation station, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Station Name: " + station.getName());
            writer.println("Year Opened: " + station.getYearOpened());
            writer.println("Hours Data:");

            for (Hour hour : station.getHours()) {
                writer.printf("%d|%s%n", hour.getNumberOfPassengers(), hour.getComment());
            }
        }
    }

    /**
     * Reads MetroStation data from a text file.
     *
     * @param filename The name of the text file
     * @return A MetroStationArrayList with the read data
     * @throws IOException If an I/O error occurs or file format is invalid
     */
    public static MetroStationArrayList readFromTextFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // Read station info
            String nameLine = reader.readLine();
            String yearLine = reader.readLine();
            String headerLine = reader.readLine();

            if (nameLine == null || yearLine == null || headerLine == null) {
                throw new IOException("Invalid file format");
            }

            String name = nameLine.substring("Station Name: ".length());
            int year = Integer.parseInt(yearLine.substring("Year Opened: ".length()));

            MetroStationArrayList station = new MetroStationArrayList(name, year);

            // Read hours data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2);
                if (parts.length != 2) {
                    throw new IOException("Invalid hour data format");
                }
                int passengers = Integer.parseInt(parts[0]);
                String comment = parts[1];
                station.addHour(new Hour(passengers, comment));
            }

            return station;
        } catch (NumberFormatException e) {
            throw new IOException("Invalid number format in file", e);
        }
    }

    /**
     * Writes MetroStation data to a binary file.
     *
     * @param station The MetroStation to write
     * @param filename The name of the binary file
     * @throws IOException If an I/O error occurs
     */
    public static void writeToBinaryFile(MetroStation station, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            // Write station info
            oos.writeUTF(station.getName());
            oos.writeInt(station.getYearOpened());

            // Write hours
            Hour[] hours = station.getHours();
            oos.writeInt(hours.length);
            for (Hour hour : hours) {
                oos.writeInt(hour.getNumberOfPassengers());
                oos.writeUTF(hour.getComment());
            }
        }
    }

    /**
     * Reads MetroStation data from a binary file.
     *
     * @param filename The name of the binary file
     * @return A MetroStationArrayList with the read data
     * @throws IOException If an I/O error occurs or file format is invalid
     * @throws ClassNotFoundException If class of a serialized object cannot be found
     */
    public static MetroStationArrayList readFromBinaryFile(String filename)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            String name = ois.readUTF();
            int year = ois.readInt();

            MetroStationArrayList station = new MetroStationArrayList(name, year);

            int hourCount = ois.readInt();
            for (int i = 0; i < hourCount; i++) {
                int passengers = ois.readInt();
                String comment = ois.readUTF();
                station.addHour(new Hour(passengers, comment));
            }

            return station;
        }
    }
}