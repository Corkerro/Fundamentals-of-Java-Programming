package interfaceSeparateClasses;

public class Function2 implements Function {
    @Override
    public double evaluate(double x) {
        return Math.sin(x) + x;
    }
}
