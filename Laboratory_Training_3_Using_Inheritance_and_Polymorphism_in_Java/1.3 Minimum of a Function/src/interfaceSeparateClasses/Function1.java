package interfaceSeparateClasses;

public class Function1 implements Function {
    @Override
    public double evaluate(double x) {
        return x * x - 4 * x + 4;
    }
}