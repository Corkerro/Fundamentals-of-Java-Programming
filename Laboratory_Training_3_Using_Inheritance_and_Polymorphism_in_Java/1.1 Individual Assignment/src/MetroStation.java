/**
 * Abstract class representing a metro station with a name and year of opening.
 */
public abstract class MetroStation {
    private String name;
    private int yearOpened;

    /**
     * Constructs a MetroStation with the given name and year.
     *
     * @param name        name of the station
     * @param yearOpened  year the station was opened
     */
    public MetroStation(String name, int yearOpened) {
        this.name = name;
        this.yearOpened = yearOpened;
    }

    /**
     * Gets the name of the metro station.
     *
     * @return station name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the year the station was opened.
     *
     * @return year of opening
     */
    public int getYearOpened() {
        return yearOpened;
    }

    /**
     * Returns an array of Hour entries for this station.
     *
     * @return array of Hour objects
     */
    public abstract Hour[] getHours();

    /**
     * Adds an Hour entry to the station.
     *
     * @param hour the Hour to add
     */
    public abstract void addHour(Hour hour);

    /**
     * Checks equality based on name and year.
     *
     * @param o object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetroStation)) return false;
        MetroStation that = (MetroStation) o;
        return yearOpened == that.yearOpened && name.equals(that.name);
    }

    /**
     * Returns a hash code based on name and year.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return name.hashCode() * 31 + yearOpened;
    }
}
