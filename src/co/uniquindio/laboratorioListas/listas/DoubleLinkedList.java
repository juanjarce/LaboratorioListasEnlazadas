package co.uniquindio.laboratorioListas.listas;
import java.util.Iterator;

class DoubleNode<T> {
    T value;
    DoubleNode<T> previous;
    DoubleNode<T> next;

    // Constructor
    public DoubleNode(T value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}

public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    // Constructor
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to add an element at the beginning of the list
    public void addFirst(T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to add an element at the end of the list
    public void addLast(T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    // Method to add an element at a specific position
    public void add(T value, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Position out of range");
        }
        if (position == 0) {
            addFirst(value);
        } else if (position == size) {
            addLast(value);
        } else {
            DoubleNode<T> newNode = new DoubleNode<>(value);
            DoubleNode<T> current = getNode(position - 1);
            newNode.next = current.next;
            current.next.previous = newNode;
            current.next = newNode;
            newNode.previous = current;
            size++;
        }
    }

    // Method to get the value of a node at a specific position
    public T getNodeValue(int position) {
        return getNode(position).value;
    }

    // Method to get the node at a specific position
    private DoubleNode<T> getNode(int position) {
        if (!isValidIndex(position)) {
            throw new IndexOutOfBoundsException("Position out of range");
        }
        DoubleNode<T> current;
        if (position < size / 2) {
            current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > position; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    // Method to get the position of a node given its value
    public int getNodePosition(T value) {
        DoubleNode<T> current = head;
        int position = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    // Method to check if an index is valid
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to delete the first node of the list
    public void deleteFirst() {
        if (!isEmpty()) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
            size--;
        }
    }

    // Method to delete the last node of the list
    public void deleteLast() {
        if (!isEmpty()) {
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            size--;
        }
    }

    // Method to delete a node given its value
    public void delete(T value) {
        DoubleNode<T> current = head;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }
        if (current != null) {
            if (current.previous != null) {
                current.previous.next = current.next;
            } else {
                head = current.next;
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            } else {
                tail = current.previous;
            }
            size--;
        }
    }

    // Method to modify the value of a node at a specific position
    public void modifyNode(int position, T newValue) {
        getNode(position).value = newValue;
    }

    // Method to sort the list using the bubble sort algorithm
    public void sortList() {
        if (size <= 1) {
            return; // Cannot sort a list with 0 or 1 elements
        }

        boolean swapped;
        do {
            swapped = false;
            DoubleNode<T> current = head;
            while (current.next != null) {
                if (current.value.compareTo(current.next.value) > 0) {
                    swapNodes(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    // Auxiliary method to swap two nodes in the list
    private void swapNodes(DoubleNode<T> node1, DoubleNode<T> node2) {
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    // Method to print the list
    public void printList() {
        DoubleNode<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to clear the entire list
    public void clearList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Method to invert a doubly linked list
    private void invertDoublyLinkedList() {
        if (size > 1) {
            int index = 0;
            invertDoublyLinkedListRecursive(head, index);
        } else {
            System.out.println("The doubly linked list cannot be inverted");
        }
    }

    private void invertDoublyLinkedListRecursive(DoubleNode<T> current, int index) {
        if (index == (size - 1)) {
            // Swap the links
            DoubleNode<T> temp = tail.previous;
            tail.previous = tail.next;
            tail.next = temp;

            // Set it as the head of the list
            DoubleNode<T> tempLimits = head;
            head = tail;
            tail = head;
        } else {
            invertDoublyLinkedListRecursive(current.next, index + 1);
            // Swap the links
            DoubleNode<T> temp = current.previous;
            current.previous = current.next;
            current.next = temp;
        }
    }

    // Implementation of the iterator method of the Iterable interface
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private DoubleNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    public static void main(String[] args) {
        DoubleLinkedList<Double> list = new DoubleLinkedList<>();
        list.addFirst(100.0);
        list.addLast(25.0);
        list.add(352.0, 1);

        System.out.println("Iterating over the list...");
        Iterator<Double> iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        System.out.println(" ");
        System.out.println("List:");
        list.printList();

//        System.out.println(" ");
//        System.out.println("Sorted List:");
//        list.sortList();
//        list.printList();

//        System.out.println(" ");
//        System.out.println("Inverted List:");
//        list.invertDoublyLinkedList();
//        list.printList();

        list.deleteFirst();
        list.deleteLast();
        list.delete(25.0);

        System.out.println("List after deleting some nodes:");
        list.printList();

        list.modifyNode(0, 5.0);

        System.out.println("List after modifying the node at position 0:");
        list.printList();

        System.out.println("Size of the list: " + list.size);
    }
}


