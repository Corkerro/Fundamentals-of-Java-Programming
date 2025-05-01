public class TrapezoidIntegrator implements Integrable {
    private final Integrable function;

    public TrapezoidIntegrator(Integrable function) {
        this.function = function;
    }

    @Override
    public double apply(double x) {
        return function.apply(x);
    }

    @Override
    public double integral(double a, double b, double epsilon) {
        double sum = 0.0;
        int n = (int) ((b - a) / epsilon);
        for (int i = 0; i < n; i++) {
            double x0 = a + i * epsilon;
            double x1 = x0 + epsilon;
            sum += (function.apply(x0) + function.apply(x1)) / 2;
        }
        return sum * epsilon;
    }
}
