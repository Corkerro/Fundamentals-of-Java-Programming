public class ArrayOfPoints1D extends AbstractArrayOfPoints {
    private final double[] points;

    public ArrayOfPoints1D(int size) {
        this.points = new double[size * 2];
    }

    @Override
    public int getSize() {
        return points.length / 2;
    }

    @Override
    public double getX(int index) {
        return points[2 * index];
    }

    @Override
    public double getY(int index) {
        return points[2 * index + 1];
    }

    @Override
    public void setPoint(int index, double x, double y) {
        points[2 * index] = x;
        points[2 * index + 1] = y;
    }

    @Override
    public void sortByY() {
        int size = getSize();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (getY(j) > getY(j + 1)) {
                    double x1 = getX(j), y1 = getY(j);
                    double x2 = getX(j + 1), y2 = getY(j + 1);
                    setPoint(j, x2, y2);
                    setPoint(j + 1, x1, y1);
                }
            }
        }
    }
}
