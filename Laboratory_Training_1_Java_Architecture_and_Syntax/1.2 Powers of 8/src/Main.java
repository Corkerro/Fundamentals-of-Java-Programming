import console.operations.InputReader;

/*
    Read integer value of n (from 1 to 10) and display powers of 8 from 1 to n.
    Implement two approaches: using arithmetic and bitwise operations.
 */

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        int n ;
        while (true) {
            System.out.print("Enter a number between 0 and 10: ");
            n = reader.readInt(true);

            if (n < 0 || n > 10) {
                System.err.println("Invalid input. Please enter a number between 0 and 10.");
            } else break;
        }

        int arithmeticPower = 1;
        for (int i = 0; i < n; i++) {
            arithmeticPower *= 8;
        }

        int bitwisePower = 1;
        for (int i = 0; i < n; i++) {
            bitwisePower = bitwisePower << 3;
        }

        System.out.println("The result of the arithmetic power is: " + arithmeticPower);
        System.out.println("The result of the bitwise power is: " + bitwisePower);

    }
}