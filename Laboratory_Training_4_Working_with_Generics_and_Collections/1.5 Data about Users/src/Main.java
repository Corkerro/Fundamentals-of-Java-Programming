import java.util.*;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add user\n2. View all users\n3. Search by name\n4. Sort by name\n5. Sort by age\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addUser();
                case 2 -> viewUsers();
                case 3 -> searchByName();
                case 4 -> sortByName();
                case 5 -> sortByAge();
                case 6 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addUser() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        users.add(new User(id, name, email, age));
        System.out.println("User added successfully.");
    }

    private static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void searchByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (User user : users) {
            if (user.getName().toLowerCase().contains(name)) {
                System.out.println(user);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No user found with that name.");
        }
    }

    private static void sortByName() {
        users.sort(Comparator.comparing(User::getName));
        System.out.println("Users sorted by name:");
        viewUsers();
    }

    private static void sortByAge() {
        users.sort(Comparator.comparingInt(User::getAge));
        System.out.println("Users sorted by age:");
        viewUsers();
    }
}
