public interface Integrable {
    double apply(double x);

    default double integral(double a, double b, double epsilon) {
        double sum = 0.0;
        int n = (int) ((b - a) / epsilon);
        for (int i = 0; i < n; i++) {
            double x = a + i * epsilon;
            sum += apply(x);
        }
        return sum * epsilon;
    }
}
