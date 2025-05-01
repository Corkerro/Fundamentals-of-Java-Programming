public abstract class AbstractArrayOfPoints {
    public abstract int getSize();
    public abstract double getX(int index);
    public abstract double getY(int index);
    public abstract void setPoint(int index, double x, double y);
    public abstract void sortByY();
}
