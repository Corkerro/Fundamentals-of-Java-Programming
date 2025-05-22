public enum Month {
    JANUARY("January", 31),
    FEBRUARY("February", 28),
    MARCH("March", 31),
    APRIL("April", 30),
    MAY("May", 31),
    JUNE("June", 30),
    JULY("July", 31),
    AUGUST("August", 31),
    SEPTEMBER("September", 30),
    OCTOBER("October", 31),
    NOVEMBER("November", 30),
    DECEMBER("December", 31);

    private final String name;
    private final int days;

    Month(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public Month next() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    public Month previous() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
    }

    public String getSeason() {
        return switch (this) {
            case DECEMBER, JANUARY, FEBRUARY -> "Winter";
            case MARCH, APRIL, MAY -> "Spring";
            case JUNE, JULY, AUGUST -> "Summer";
            case SEPTEMBER, OCTOBER, NOVEMBER -> "Autumn";
        };
    }

    public static void printAllMonths() {
        for (Month month : values()) {
            System.out.printf("%-9s - %d days%n", month.getName(), month.getDays());
        }
    }
}