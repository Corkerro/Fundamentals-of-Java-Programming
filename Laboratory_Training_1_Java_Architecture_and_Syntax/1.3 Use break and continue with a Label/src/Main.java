import console.operations.InputReader;

/*
    Enter the values of x and n, calculate and display the result of the expression:
            y = (n-1)П(i=1) (n)Σ(j=0) (i / (j + x))

    If i is equal to j + x, go to the next step of the external cycle without multiplying by
    the intermediate result. To proceed to the next step, use continue with a label.
    If the denominator at any iteration is 0, exit both loops with an error message. To exit, use
    break with a label.
 */

public class Main {
    public static InputReader reader = new InputReader();

    public static void main(String[] args) {
        System.out.println("Enter int x: ");
        int x = reader.readInt(true);

        System.out.println("Enter int n: ");
        int n = reader.readInt(true);

        double y = 1;
        boolean isError = false;

        outOfLoop:
        for (int i = 1; i <= n - 1; i++) {
            double sum = 0;
            for (int j = 0; j <= n; j++) {
                if (i == j + x) continue outOfLoop;
                if (j + x == 0) {
                    System.err.println("Cannot divide by zero.");
                    isError = true;
                    break outOfLoop;
                }

                sum += (double) i / (j + x);
            }
            y *= sum;
        }
        if (!isError) System.out.printf("y = %f", y);
    }
}
