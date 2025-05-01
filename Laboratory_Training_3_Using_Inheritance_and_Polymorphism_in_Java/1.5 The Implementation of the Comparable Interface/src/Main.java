import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = {
                new Circle(3.2),
                new Circle(1.5),
                new Circle(4.7),
                new Circle(2.0)
        };

        System.out.println("Before sorting:");
        for (Circle c : circles) {
            System.out.println(c);
        }

        Arrays.sort(circles);

        System.out.println("\nAfter sorting:");
        for (Circle c : circles) {
            System.out.println(c);
        }
    }
}
