public class Main {
    static private void processAbstractClass() {
        abstractClass.Function f1 = new abstractClass.Function1();
        abstractClass.Function f2 = new abstractClass.Function2();

        double step = 0.1;
        double start = -10;
        double end = 10;

        System.out.println("Minimum of abstractClass.Function 1: " + abstractClass.MinimumFinder.findMinimum(f1, start, end, step));
        System.out.println("Minimum of abstractClass.Function 2: " + abstractClass.MinimumFinder.findMinimum(f2, start, end, step));
    }

    static private void processInterfaceSeparateClasses() {
        interfaceSeparateClasses.Function f1 = new interfaceSeparateClasses.Function1();
        interfaceSeparateClasses.Function f2 = new interfaceSeparateClasses.Function2();

        double step = 0.1;
        double start = -10;
        double end = 10;

        System.out.println("Minimum of interfaceSeparateClasses.Function 1: " + interfaceSeparateClasses.MinimumFinder.findMinimum(f1, start, end, step));
        System.out.println("Minimum of interfaceSeparateClasses.Function 2: " + interfaceSeparateClasses.MinimumFinder.findMinimum(f2, start, end, step));
    }

    static private void processInterfaceAnonymousClasses() {
        double step = 0.1;
        double start = -10;
        double end = 10;

        interfaceAnonymousClasses.Function f1 = new interfaceAnonymousClasses.Function() {
            @Override
            public double evaluate(double x) {
                return x * x - 4 * x + 4;
            }
        };

        interfaceAnonymousClasses.Function f2 = new interfaceAnonymousClasses.Function() {
            @Override
            public double evaluate(double x) {
                return Math.sin(x) + x;
            }
        };

        System.out.println("Minimum of interfaceAnonymousClasses.Function 1: " + interfaceAnonymousClasses.MinimumFinder.findMinimum(f1, start, end, step));
        System.out.println("Minimum of interfaceAnonymousClasses.Function 2: " + interfaceAnonymousClasses.MinimumFinder.findMinimum(f2, start, end, step));
    }

    static private void processLambdaExpressions() {
        double step = 0.1;
        double start = -10;
        double end = 10;

        lambdaExpressions.Function f1 = (x) -> x * x - 4 * x + 4;
        lambdaExpressions.Function f2 = (x) -> Math.sin(x) + x;

        System.out.println("Minimum of lambdaExpressions.Function 1: " + lambdaExpressions.MinimumFinder.findMinimum(f1, start, end, step));
        System.out.println("Minimum of lambdaExpressions.Function 2: " + lambdaExpressions.MinimumFinder.findMinimum(f2, start, end, step));
    }

    public static double functionRef1(double x) {
        return x * x - 4 * x + 4;
    }

    public static double functionRef2(double x) {
        return Math.sin(x) + x;
    }

    static private void processMethodReferences() {
        double step = 0.1;
        double start = -10;
        double end = 10;

        methodReferences.Function f1 = Main::functionRef1;
        methodReferences.Function f2 = Main::functionRef2;

        System.out.println("Minimum of  methodReferences.Function 1: " +  methodReferences.MinimumFinder.findMinimum(f1, start, end, step));
        System.out.println("Minimum of  methodReferences.Function 2: " +  methodReferences.MinimumFinder.findMinimum(f2, start, end, step));
    }

    public static void main(String[] args) {
        processAbstractClass();
        processInterfaceSeparateClasses();
        processInterfaceAnonymousClasses();
        processLambdaExpressions();
        processMethodReferences();
    }
}