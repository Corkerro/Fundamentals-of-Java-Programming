import java.util.ArrayList;
import java.util.List;

/**
 * Metro station implementation using ArrayList.
 */
public class MetroStationArrayList extends MetroStation {
    private List<Hour> hours;

    public MetroStationArrayList(String name, int yearOpened) {
        super(name, yearOpened);
        this.hours = new ArrayList<>();
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
