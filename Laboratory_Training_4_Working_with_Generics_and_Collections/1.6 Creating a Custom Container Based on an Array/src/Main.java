public class Main {
    public static void main(String[] args) {
        MyArrayContainer<String> names = new MyArrayContainer<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("All names: " + names);

        names.remove(1);
        System.out.println("After removing index 1: " + names);

        System.out.println("Element at index 1: " + names.get(1));
        System.out.println("Current size: " + names.size());

        MyArrayContainer<Integer> numbers = new MyArrayContainer<>();
        for (int i = 0; i < 15; i++) {
            numbers.add(i);
        }
        System.out.println("Numbers: " + numbers);
    }
}
