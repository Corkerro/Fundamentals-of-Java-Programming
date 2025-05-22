/**
 * Implementation of MetroStation using a linked list to store Hour objects.
 */
public class MetroStationLinkedList extends MetroStation {
    private Node head;

    /**
     * Internal class representing a node in the linked list.
     */
    private static class Node {
        Hour hour;
        Node next;

        Node(Hour hour) {
            this.hour = hour;
        }
    }

    /**
     * Constructs a MetroStationLinkedList with specified name and year.
     *
     * @param name        name of the station
     * @param yearOpened  year the station was opened
     */
    public MetroStationLinkedList(String name, int yearOpened) {
        super(name, yearOpened);
    }

    /**
     * Adds an Hour object to the end of the linked list.
     *
     * @param hour the Hour to add
     */
    @Override
    public void addHour(Hour hour) {
        Node newNode = new Node(hour);
        if (head == null) {
            head = newNode;
        } else {
            Node tmp = head;
            while (tmp.next != null)
                tmp = tmp.next;
            tmp.next = newNode;
        }
    }

    /**
     * Converts the linked list to an array of Hour objects.
     *
     * @return array of Hour objects
     */
    @Override
    public Hour[] getHours() {
        int size = 0;
        Node tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        Hour[] result = new Hour[size];
        tmp = head;
        int index = 0;
        while (tmp != null) {
            result[index++] = tmp.hour;
            tmp = tmp.next;
        }

        return result;
    }
}
