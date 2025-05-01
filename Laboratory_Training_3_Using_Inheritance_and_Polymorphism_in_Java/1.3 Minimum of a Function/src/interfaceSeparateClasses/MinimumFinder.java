package interfaceSeparateClasses;

public class MinimumFinder {
    public static double findMinimum(Function function, double start, double end, double step) {
        double min = function.evaluate(start);
        double minX = start;
        for (double x = start; x <= end; x += step) {
            double value = function.evaluate(x);
            if (value < min) {
                min = value;
                minX = x;
            }
        }
        return min;
    }
}