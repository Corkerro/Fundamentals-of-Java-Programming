import java.util.Comparator;

class TriangleAreaComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        return Double.compare(t2.getArea(), t1.getArea());
    }
}