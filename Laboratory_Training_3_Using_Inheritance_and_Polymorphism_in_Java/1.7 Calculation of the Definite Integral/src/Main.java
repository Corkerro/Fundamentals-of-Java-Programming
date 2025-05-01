public class Main {
    public static void main(String[] args) {
        Integrable sinFunction = Math::sin;
        Integrable logFunction = Math::log;

        double a = 1;
        double b = 5;
        double epsilon = 0.001;

        // Rectangle method
        double sinRect = sinFunction.integral(a, b, epsilon);
        double logRect = logFunction.integral(a, b, epsilon);

        // Trapezoid method
        TrapezoidIntegrator sinTrap = new TrapezoidIntegrator(sinFunction);
        TrapezoidIntegrator logTrap = new TrapezoidIntegrator(logFunction);

        double sinTrapezoid = sinTrap.integral(a, b, epsilon);
        double logTrapezoid = logTrap.integral(a, b, epsilon);

        System.out.printf("Integral sin(x) from %.1f to %.1f:%n", a, b);
        System.out.printf("Rectangle: %.6f%n", sinRect);
        System.out.printf("Trapezoid: %.6f%n%n", sinTrapezoid);

        System.out.printf("Integral ln(x) from %.1f to %.1f:%n", a, b);
        System.out.printf("Rectangle: %.6f%n", logRect);
        System.out.printf("Trapezoid: %.6f%n", logTrapezoid);
    }
}
