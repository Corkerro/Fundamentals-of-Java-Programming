public class DoublyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> prev, next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public boolean remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;

                if (current.next != null)
                    current.next.prev = current.prev;
                else
                    tail = current.prev;

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
