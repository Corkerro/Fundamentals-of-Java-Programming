package abstractClass;

public class Function2 extends Function {
    @Override
    public double evaluate(double x) {
        return Math.sin(x) + x;
    }
}