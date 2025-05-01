public class Main {
    public static void main(String[] args) {
        AbstractArrayOfPoints[] arrays = {
                new ArrayOfPoints2D(3),
                new ArrayOfPoints1D(3)
        };

        for (AbstractArrayOfPoints array : arrays) {
            System.out.println("== " + array.getClass().getSimpleName() + " ==");

            array.setPoint(0, 1, 5);
            array.setPoint(1, -2, 2);
            array.setPoint(2, 3, -1);

            System.out.println("Before sort:");
            printPoints(array);

            array.sortByY();

            System.out.println("After sort by Y:");
            printPoints(array);
            System.out.println();
        }
    }

    private static void printPoints(AbstractArrayOfPoints array) {
        for (int i = 0; i < array.getSize(); i++) {
            System.out.printf("Point %d: (%.2f, %.2f)%n", i, array.getX(i), array.getY(i));
        }
    }
}
