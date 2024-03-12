package co.uniquindio.laboratorioListas.listas;

import java.util.Iterator;

class Node<T> {
    T value;
    Node<T> next;

    // Constructor
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}

//Class to represent a term of a polinomium. Made for problem 12.
class PolynomialTerm <T extends Comparable<T>> {
    T coefficient;
    T exponent;
    PolynomialTerm<T> next;

    // Constructor
    public PolynomialTerm(T coefficient, T exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }

    @Override
    public String toString() {
        if ((Integer)exponent == 0) {
            return coefficient.toString();
        }
        if ((Integer)exponent == 1) {
            return coefficient + "x";
        }
        return coefficient + "x^" + exponent;
    }
}

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    Node<T> head;

    // Constructor
    public LinkedList() {
        this.head = null;
    }

    // Method to add an element at the end of the list
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to add an element at the beginning of the list
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
    }

    // Method to add an element at a specific position
    public void add(T value, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to get the value of a node at a specific position
    public T getNodeValue(int position) {
        Node<T> current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range");
            return null; // Default value to indicate error
        }
        return current.value;
    }

    // Method to get the node at a specific position
    public Node<T> getNode(int position) {
        Node<T> current = head;
        for (int i = 0; i < position && current != null; i++) {
            current = current.next;
        }
        return current;
    }

    // Method to get the position of a node given its value
    public int getNodePosition(T value) {
        int position = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Default value to indicate not found
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to delete the first node of the list
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // Method to delete the last node of the list
    public void deleteLast() {
        if (head == null || head.next == null) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    // Method to delete a node given its value
    public void delete(T value) {
        if (head == null) {
            return;
        }
        if (head.value.equals(value)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Method to modify the value of a node at a specific position
    public void modifyNode(int position, T newValue) {
        Node<T> node = getNode(position);
        if (node != null) {
            node.value = newValue;
        } else {
            System.out.println("Position out of range");
        }
    }

    // Method to sort the list using the insertion sort algorithm
    public void sortList() {
        if (head == null || head.next == null) {
            return; // The list is already sorted or empty
        }

        Node<T> currentNode = head.next;
        while (currentNode != null) {
            T currentValue = currentNode.value;
            Node<T> previousNode = head;
            Node<T> iteratorNode = head;

            while (iteratorNode != currentNode) {
                if (currentValue.compareTo(iteratorNode.value) < 0) {
                    // If the current value is less than the value of the current node, swap them
                    T temp = iteratorNode.value;
                    iteratorNode.value = currentValue;
                    currentValue = temp;
                }
                iteratorNode = iteratorNode.next;
            }

            currentNode.value = currentValue;
            currentNode = currentNode.next;
        }
    }

    // Method to print the list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to delete the entire list
    public void deleteList() {
        head = null;
    }

    // Method to check if an index is valid
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size();
    }

    // Method to get the size of the list
    private int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Method to reverse a linked list
    private void reverseLinkedList() {
        if (head == null || head.next == null) {
            System.out.println("The list cannot be reversed");
        } else {
            reverseRecursive(head, null);
        }
    }

    // Method to reverse a linked list recursively
    private void reverseRecursive(Node<T> current, Node<T> previous) {
        if (current.next == null) {
            head = current;
            head.next = previous;
        } else {
            reverseRecursive(current.next, current);
            current.next = previous;
        }
    }

    // Method to traverse a linked list recursively
    public void traverseRecursive(Node node) {
        // Check if the current node is not null
        if (node != null) {
            // Print the value of the current node
            System.out.print(node.value + " ");
            // Recursively call the method with the next node
            traverseRecursive(node.next);
        }
    }



    // Implementation of the iterator method of the Iterable interface
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

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


    // Class to represent a polinomium as a linked list. Made for problem 12.
    public static class PolynomialLinkedList<T extends Comparable<T>> extends LinkedList<T> {
        PolynomialTerm<T> head;

        public PolynomialLinkedList() {
            this.head = null;
        }


        //Methods of problem 12. Adding a polinomiun of grade n as a simple linked list, where each node has the coefficient and the exponent of the term.

        //Method to add a term to the polinomium at the end of the list.
        public void addPolinomiumTerm(T coefficient, T exponent) {
            PolynomialTerm<T> newTerm = new PolynomialTerm<>(coefficient, exponent);

            if(head==null) {
                head = newTerm;
            }
            else {
                PolynomialTerm<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newTerm;
            }
        }

        //Method to sort the polinomium in descending order of the exponents.
        public void sortPolynomial() {
            if (head == null || head.next == null) {
                return; // The list is already sorted or empty
            }

            PolynomialTerm<T> current = head;
            while (current != null) {
                PolynomialTerm<T> next = current.next;
                while (next != null) {
                    if ((Integer)current.exponent < (Integer)next.exponent) {
                        // Swap coefficients
                        T tempCoefficient = current.coefficient;
                        current.coefficient = next.coefficient;
                        next.coefficient = tempCoefficient;

                        // Swap exponents
                        T tempExponent = current.exponent;
                        current.exponent = next.exponent;
                        next.exponent = tempExponent;
                    }
                    next = next.next;
                }
                current = current.next;
            }
        }

        //Method to print the value table of the polinomium for x values from 0 to 5 with a step of 0.5.
        public void printValueTable() {
            System.out.println("x\t\ty");
            for (double x = 0; x <= 5; x += 0.5) {
                double y = 0;
                PolynomialTerm<T> current = head;
                while (current != null) {
                    y += (Integer)current.coefficient * Math.pow(x, (Integer)current.exponent);
                    current = current.next;
                }
                System.out.println(x + "\t\t" + y);
            }
        }

        //Method to print the polinomium sorted in descending order of the exponents.
        public void printPolynomial() {
            sortPolynomial();
            PolynomialTerm<T> current = head;
            while (current != null) {
                System.out.print(current + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Methods for Laboratory

    //Method for counting the appearances of a value on a linked list
    public int countAppearances(T value) {
        //Iniatilize a counter
        int count = 0;
        //Instance of iterator for traveling the list
        Node n = head;
        while(n!=null){
            // Get the element on the list
            T v = (T) n.value;
            // Comparation for knowing if the values are the same
            if(v.equals(value)) count++;
            n = n.next;
        }
        return count;
    }

    //Method for cancatin a linked list to the main linked list
    public void concat(LinkedList<T> list2) {
        Node<T> current = list2.head;
        while (current != null){
            this.addLast(current.value);
            current = current.next;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Main
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(5);
        list.addLast(10);
        list.addLast(15);
        list.addLast(20);
        list.addFirst(1);
        list.add(100, 2);

        System.out.println("Current list:");
        list.printList();

//        System.out.println("Sorted list:");
//        list.sortList();
//        list.printList();

        // Reverse the linked list
//        System.out.println("The reversed list is:");
//        list.reverseLinkedList();
//        list.printList();

        System.out.println("Value of the node at position 3: " + list.getNodeValue(3));
        System.out.println("Position of the node with value 10: " + list.getNodePosition(10));

        list.deleteFirst();
        list.deleteLast();
        list.delete(15);

        System.out.println("List after deleting some nodes:");
        list.printList();

        list.modifyNode(2, 200);

        System.out.println("List after modifying the node at position 2:");
        list.printList();

        System.out.println("Size of the list: " + list.size());

        System.out.println("Iterating over the list:");
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


        // Display the current linked list
        System.out.println("The current linked list is:");
        list.printList();

        // Reverse the linked list
        System.out.println("The reversed list is:");
        list.reverseLinkedList();
        list.printList();

    }

}
