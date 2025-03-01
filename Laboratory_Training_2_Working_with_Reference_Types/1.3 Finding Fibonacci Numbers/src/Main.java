import java.util.Scanner;


/*
    Implement a function for computing of Fibonacci numbers (up to the 92nd integer) using an auxiliary
    array (static field). The function parameter should be Fibonacci number's index. The search for Fibonacci
    numbers is carried out according to the following rule:
            F(1) = F(2) = 1; F(n) = F(n - 2) + F(n - 1)

    At the first call, the array is filled until the required number. At subsequent calls, the number either
    returns from the array, or is calculated using the last two numbers stored in an array. Use the long
    type to represent numbers.

    Perform function testing for different values of numbers entered an arbitrary order.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Fibonacci numbers (separated by a space), for example: 10 20 30");

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            try {
                System.out.println("F(" + n + ") = " + FibonacciCalculator.calculateFib(n));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}