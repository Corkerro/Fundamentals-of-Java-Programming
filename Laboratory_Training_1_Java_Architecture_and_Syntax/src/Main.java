import console.operations.InputReader;

/*

Create a console Java application that calculates values of a function on a given range.
The necessary source data (interval boundaries and step of argument increasing) should be read from keyboard.

Program should contain reading data from keyboard and main loop, in which the following
activities are performed:
    - calculating the function choosing one of branches, depending on the value of the argument
    - output to the console argument and result at each step
    - increase value of the argument by the size of the step and go to the next calculation, if necessary.

Program should contain the single class with two static functions:
    - a separate static function to calculate the value of y depending on the value of the argument x;
    - the main() method, which contains the reading the source data, as well as the cycle of calculating
      the function and output the values of x and y.

Particular function is given in the individual task according to your own index in the group students list
(index of variant). Define the constant n with the final modifier. Use the printf() function for formatted output.

 */

public class Main {
    private static final int N = 9;
    private static final InputReader reader = new InputReader();

    public static void main(String[] args) {
        double start, end, step;

        System.out.println("\n" +
                "███████╗██╗░░██╗███████╗██████╗░░█████╗░██╗░██████╗███████╗  ░░███╗░░\n" +
                "██╔════╝╚██╗██╔╝██╔════╝██╔══██╗██╔══██╗██║██╔════╝██╔════╝  ░████║░░\n" +
                "█████╗░░░╚███╔╝░█████╗░░██████╔╝██║░░╚═╝██║╚█████╗░█████╗░░  ██╔██║░░\n" +
                "██╔══╝░░░██╔██╗░██╔══╝░░██╔══██╗██║░░██╗██║░╚═══██╗██╔══╝░░  ╚═╝██║░░\n" +
                "███████╗██╔╝╚██╗███████╗██║░░██║╚█████╔╝██║██████╔╝███████╗  ███████╗\n" +
                "╚══════╝╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝░╚════╝░╚═╝╚═════╝░╚══════╝  ╚══════╝\n" +
                "\n" +
                "██╗░░░██╗░█████╗░██████╗░██╗░█████╗░███╗░░██╗████████╗  ░░███╗░░░░███╗░░\n" +
                "██║░░░██║██╔══██╗██╔══██╗██║██╔══██╗████╗░██║╚══██╔══╝  ░████║░░░████║░░\n" +
                "╚██╗░██╔╝███████║██████╔╝██║███████║██╔██╗██║░░░██║░░░  ██╔██║░░██╔██║░░\n" +
                "░╚████╔╝░██╔══██║██╔══██╗██║██╔══██║██║╚████║░░░██║░░░  ╚═╝██║░░╚═╝██║░░\n" +
                "░░╚██╔╝░░██║░░██║██║░░██║██║██║░░██║██║░╚███║░░░██║░░░  ███████╗███████╗\n" +
                "░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═╝╚═╝░░╚═╝╚═╝░░╚══╝░░░╚═╝░░░  ╚══════╝╚══════╝\n\n");
        System.out.print("Do you want to fill automatically? (yes/no): ");

        boolean isAuto = reader.readBoolean(true);

        if (isAuto) {
            start = -5;
            end = 5;
            step = 0.1;
        } else {
            while (true) {
                System.out.println("Enter start: ");
                start = reader.readDouble(true);

                System.out.println("Enter end: ");
                end = reader.readDouble(true);

                System.out.println("Enter step: ");
                step = reader.readDouble(true);

                if (validateValues(start, end, step)) {
                    break;
                }
            }
        }

        System.out.printf("%10s%15s\n", "x", "y");
        for (double x = start; x <= end; x += step) {
            double y = calculateY(x);
            System.out.printf("%10.3f%15.5f\n", x, y);
        }

    }

    public static boolean validateValues(double start, double end, double step) {
        if (step > 0 && start > end) {
            System.err.println("If step > 0 start can't be less then end");
            return false;
        }
        System.out.println(1);

        if (step < 0 && start < end) {
            System.err.println("If step < 0 start can't be bigger then end");
            return false;
        }
        System.out.println(2);

        if (step == 0.0) {
            System.err.println("Step can't be 0");
            return false;
        }
        System.out.println(3);

        return true;
    }

    public static double calculateY(double x) {
        if (x < 3) {
            return 3 * Math.cos(x - 3) + 2 * x;
        } else {
            double y = 0;
            for (int k = 1; k <= N; k++) {
                y += Math.exp(-k * (x - 3));
            }
            return y;
        }
    }
}