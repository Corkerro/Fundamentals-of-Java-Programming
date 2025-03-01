public class FibonacciCalculator {
    private static final int MAX_INDEX = 92;
    private static final long[] fibCache = new long[MAX_INDEX + 1];

    static {
        fibCache[1] = 1;
        fibCache[2] = 1;
    }

    public static long calculateFib(int n) {
        if (n < 1 || n > MAX_INDEX) {
            throw new IllegalArgumentException("The number must be from 1 to " + MAX_INDEX);
        }

        if (fibCache[n] != 0) {
            return fibCache[n];
        }

        for (int i = 3; i <= n; i++) {
            if (fibCache[i] == 0) {
                fibCache[i] = fibCache[i - 1] + fibCache[i - 2];
            }
        }
        return fibCache[n];
    }
}
