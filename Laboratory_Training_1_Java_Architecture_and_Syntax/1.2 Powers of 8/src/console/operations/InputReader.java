package console.operations;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine(boolean isLoop) {
        return readPattern(".*", "Invalid input. Please enter a valid input.", isLoop);
    }

    public int readInt(boolean isLoop) {
        return readNumber("int", "Invalid number. Please enter a valid number (int):", isLoop).intValue();
    }

    public double readDouble(boolean isLoop) {
        return readNumber("double", "Invalid number. Please enter a valid number (double):", isLoop).doubleValue();
    }

    public float readFloat(boolean isLoop) {
        return readNumber("float", "Invalid number. Please enter a valid number (float):", isLoop).floatValue();
    }

    public short readShort(boolean isLoop) {
        return readNumber("short", "Invalid number. Please enter a valid number (short):", isLoop).shortValue();
    }

    public long readLong(boolean isLoop) {
        return readNumber("long", "Invalid number. Please enter a valid number (long):", isLoop).longValue();
    }

    public byte readByte(boolean isLoop) {
        return readNumber("byte", "Invalid number. Please enter a valid number (byte):", isLoop).byteValue();
    }

    public boolean readBoolean(boolean isLoop) {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("yes") || input.equals("y")) return true;
            if (input.equals("false") || input.equals("no") || input.equals("n")) return false;
            if (isLoop) System.err.println("Invalid input. Enter 'yes' or 'no':");
            else {
                System.err.println("Invalid input. Program will exit.");
                System.exit(1);
            }
        }
    }

    public char readChar(boolean isLoop) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.length() == 1) return input.charAt(0);
            if (isLoop) System.err.println("Invalid input. Enter a single character:");
            else {
                System.err.println("Invalid input. Program will exit.");
                System.exit(1);
            }
        }
    }

    public String readEmail(boolean isLoop) {
        return readPattern("^[\\w.-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,}$", "Invalid email. Try again:", isLoop);
    }

    public String readPhoneNumber(boolean isLoop) {
        return readPattern("^\\+?[0-9]{10,15}$", "Invalid phone number. Try again:", isLoop);
    }

    private String readPattern(String regex, String errorMessage, boolean isLoop) {
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            String input = scanner.nextLine().trim();
            if (pattern.matcher(input).matches()) return input;
            if (isLoop) System.err.println(errorMessage);
            else {
                System.err.println(errorMessage + " Program will exit.");
                System.exit(1);
            }
        }
    }


    private Number readNumber(String type, String errorMessage, boolean isLoop) {
        while (true) {
            if (scanner.hasNext()) {
                try {
                    switch (type) {
                        case "int": return scanner.nextInt();
                        case "double": return scanner.nextDouble();
                        case "float": return scanner.nextFloat();
                        case "short": return scanner.nextShort();
                        case "long": return scanner.nextLong();
                        case "byte": return scanner.nextByte();
                    }
                } catch (Exception ignored) {}
            }
            scanner.nextLine();
            if (isLoop) System.err.println(errorMessage);
            else {
                System.err.println(errorMessage + " Program will exit.");
                System.exit(1);
            }
        }
    }
}
