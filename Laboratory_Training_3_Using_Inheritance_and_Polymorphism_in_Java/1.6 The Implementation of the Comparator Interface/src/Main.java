import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Triangle[] triangles = {
                new Triangle(3, 4, 5),
                new Triangle(6, 6, 6),
                new Triangle(7, 10, 5)
        };

        Arrays.sort(triangles, new TriangleAreaComparator());

        for (Triangle t : triangles) {
            System.out.println(t);
        }
    }
}