import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Metro station implementation using SortedSet.
 */
public class MetroStationSortedSet extends MetroStation {
    private SortedSet<Hour> hours;

    public MetroStationSortedSet(String name, int yearOpened, Comparator<Hour> comparator) {
        super(name, yearOpened);
        this.hours = new TreeSet<>(comparator);
    }

    @Override
    public void addHour(Hour hour) {
        hours.add(hour);
    }

    @Override
    public Hour[] getHours() {
        return hours.toArray(new Hour[0]);
    }
}
