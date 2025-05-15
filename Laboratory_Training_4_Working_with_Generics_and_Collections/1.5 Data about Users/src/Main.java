import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add user");
            System.out.println("2. Show all users");
            System.out.println("3. Show users with password longer than 6 characters");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    if (users.containsKey(username)) {
                        System.out.println("Username already exists!");
                        break;
                    }
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    users.put(username, password);
                    System.out.println("User added.");
                }
                case 2 -> {
                    if (users.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        System.out.println("All users:");
                        for (Map.Entry<String, String> entry : users.entrySet()) {
                            System.out.println("Username: " + entry.getKey() + " | Password: " + entry.getValue());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Users with password length > 6:");
                    boolean found = false;
                    for (Map.Entry<String, String> entry : users.entrySet()) {
                        if (entry.getValue().length() > 6) {
                            System.out.println("Username: " + entry.getKey() + " | Password: " + entry.getValue());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No such users.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
