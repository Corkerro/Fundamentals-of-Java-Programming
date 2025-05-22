public class Main {
    public static void main(String[] args) {
        Month.printAllMonths();
        System.out.println();

        Month current = Month.MAY;

        System.out.println("Testing month: " + current.getName());
        System.out.println("Days: " + current.getDays());
        System.out.println("Season: " + current.getSeason());
        System.out.println("Previous month: " + current.previous().getName());
        System.out.println("Next month: " + current.next().getName());
        System.out.println();

        Month december = Month.DECEMBER;
        System.out.println("Testing December transitions:");
        System.out.println("Next after December: " + december.next().getName());
        System.out.println("Previous before January: " + Month.JANUARY.previous().getName());
    }
}