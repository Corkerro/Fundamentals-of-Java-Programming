public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.addLast("Alice");
        list.addLast("Bob");
        list.addFirst("Zara");

        System.out.println("Forward:");
        list.printForward();

        System.out.println("Backward:");
        list.printBackward();

        list.remove("Bob");
        System.out.println("After removing 'Bob':");
        list.printForward();

        System.out.println("Size: " + list.size());
    }
}
