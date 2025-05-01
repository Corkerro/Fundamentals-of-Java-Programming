public class ArrayOfPoints2D extends AbstractArrayOfPoints {
    private final double[][] points;

    public ArrayOfPoints2D(int size) {
        this.points = new double[size][2];
    }

    @Override
    public int getSize() {
        return points.length;
    }

    @Override
    public double getX(int index) {
        return points[index][0];
    }

    @Override
    public double getY(int index) {
        return points[index][1];
    }

    @Override
    public void setPoint(int index, double x, double y) {
        points[index][0] = x;
        points[index][1] = y;
    }

    @Override
    public void sortByY() {
        java.util.Arrays.sort(points, java.util.Comparator.comparingDouble(a -> a[1]));
    }
}
