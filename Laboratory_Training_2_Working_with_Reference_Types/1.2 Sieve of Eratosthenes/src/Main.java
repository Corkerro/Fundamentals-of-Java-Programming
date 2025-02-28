/*
    Fill an array of 300 elements with consecutive positive integer numbers. Replace all non-prime numbers
    with some negative value. To do this, consistently exclude all numbers that are divisors of other numbers.
    Print all remaining positive values (prime numbers).

    Do not use division and getting the remainder of the division in the program.
 */

public class Main {
    static final int to = 300;
    public static void main(String[] args) {
        SieveOfEratosthenes s = new SieveOfEratosthenes(to);
        System.out.println("Started array:");
        s.printArray();
        s.process();

        System.out.println("Only odds");
        s.printArray();
    }
}