import java.util.Arrays;

/**
 * Implementation of MetroStation using an array to store Hour objects.
 */
public class MetroStationArray extends MetroStation {
    private Hour[] hours;
    private int count;

    /**
     * Constructs a MetroStationArray with specified name, year, and capacity.
     *
     * @param name        name of the station
     * @param yearOpened  year the station was opened
     * @param size        initial capacity of the hour array
     */
    public MetroStationArray(String name, int yearOpened, int size) {
        super(name, yearOpened);
        this.hours = new Hour[size];
        this.count = 0;
    }

    /**
     * Adds an Hour object to the array.
     *
     * @param hour the Hour to add
     */
    @Override
    public void addHour(Hour hour) {
        if (count < hours.length) {
            hours[count++] = hour;
        }
    }

    /**
     * Returns a trimmed array of all added Hour objects.
     *
     * @return array of Hour objects
     */
    @Override
    public Hour[] getHours() {
        return Arrays.copyOf(hours, count);
    }
}
