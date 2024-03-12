package co.uniquindio.laboratorioListas.listas;
import java.util.Iterator;

public class CircularLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private int size;

    // Constructor
    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to add an element at the beginning of the list
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            newNode.next = newNode; // Makes the next of the new node point to itself
            head = newNode; // Head points to the new node
        } else {
            newNode.next = head.next; // Sets the next of the new node as the next of the head
            head.next = newNode; // Sets the next of the head as the new node
        }
        size++;
    }

    // Method to add an element at the end of the list
    public void addLast(T value) {
        addFirst(value); // Simply call addFirst as we are adding to the end of a circular list
        head = head.next; // Moves the head to the newly added node
    }

    // Method to add an element at a specific position
    public void add(T value, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == size) {
            addLast(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // Method to get the value of a node at a specific position
    public T getNodeValue(int position) {
        if (!isValidIndex(position)) {
            System.out.println("Invalid position");
            return null;
        }
        Node<T> current = head.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.value;
    }

    // Method to get the node at a specific position
    public Node<T> getNode(int position) {
        if (!isValidIndex(position)) {
            System.out.println("Invalid position");
            return null;
        }
        Node<T> current = head.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    // Method to get the position of a node given its value
    public int getNodePosition(T value) {
        int position = 0;
        Node<T> current = head.next;
        while (current != head) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Indicates that the value was not found
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to delete the first node of the list
    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        head.next = head.next.next;
        size--;
    }

    // Method to delete the last node of the list
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head.next;
        while (current.next != head) {
            current = current.next;
        }
        current.next = head.next;
        head = current;
        size--;
    }

    // Method to delete a node given its value
    public void delete(T value) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head.next;
        Node<T> previous = head;
        while (current != head) {
            if (current.value.equals(value)) {
                previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Value not found");
    }

    // Method to modify the value of a node at a specific position
    public void modifyNode(int position, T newValue) {
        if (!isValidIndex(position)) {
            System.out.println("Invalid position");
            return;
        }
        Node<T> current = head.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        current.value = newValue;
    }

    // Method to sort the list
    public void sortList() {
        if (isEmpty() || size == 1) {
            return; // List is already sorted or empty
        }
        for (int i = 0; i < size - 1; i++) {
            Node<T> current = head.next;
            for (int j = 0; j < size - 1 - i; j++) {
                if (current.value.compareTo(current.next.value) > 0) {
                    T temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                }
                current = current.next;
            }
        }
    }

    // Method to print the list
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head.next;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head.next);
        System.out.println();
    }

    // Method to delete the entire list
    public void deleteList() {
        head.next = null;
        size = 0;
    }

    // Method to check if an index is valid
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    // Implementation of the iterator method of the Iterable interface
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head.next;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                count++;
                return value;
            }
        };
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Methods for Laboratory

    // Method (insert)
    public void insert(T value, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == size) {
            addLast(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // Method (search)
    // Return the position of the node
    // If the node isn't on the list returns -1
    public int search(T value) {
        int position = 0;
        Node<T> current = head.next;
        while (current != head) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Indicates that the value was not found
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Main

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        // Test adding at the beginning
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        // Should print: 3 2 1
        System.out.println("List after adding at the beginning:");
        list.printList();

        // Test adding at the end
        list.addLast(4);
        list.addLast(5);
        // Should print: 3 2 1 4 5
        System.out.println("List after adding at the end:");
        list.printList();

        // Test adding at a specific position
        list.add(6, 2);
        // Should print: 3 2 6 1 4 5
        System.out.println("List after adding at position 2:");
        list.printList();

        // Test getting the value of a node at a specific position
        System.out.println("Value of the node at position 3: " + list.getNodeValue(3));

        // Test getting the node at a specific position
        System.out.println("Node at position 2: " + list.getNode(2).value);

        // Test getting the position of a node given its value
        System.out.println("Position of the node with value 6: " + list.getNodePosition(6));

        // Test checking if the list is empty
        System.out.println("Is the list empty? " + list.isEmpty());

        // Test deleting the first node of the list
        list.deleteFirst();
        // Should print: 2 6 1 4 5
        System.out.println("List after deleting the first node:");
        list.printList();

        // Test deleting the last node of the list
        list.deleteLast();
        // Should print: 2 6 1 4
        System.out.println("List after deleting the last node:");
        list.printList();

        // Test deleting a node given its value
        list.delete(1);
        // Should print: 2 6 4
        System.out.println("List after deleting the node with value 1:");
        list.printList();

        // Test modifying the value of a node at a specific position
        list.modifyNode(1, 10);
        // Should print: 2 10 4
        System.out.println("List after modifying the node at position 1:");
        list.printList();

        // Test sorting the list
        list.addFirst(7);
        list.addFirst(3);
        list.sortList();
        // Should print: 2 3 4 7 10
        System.out.println("List after sorting:");
        list.printList();

        // Test using iterator
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("Element: "+iterator.next());
        }
    }
}


