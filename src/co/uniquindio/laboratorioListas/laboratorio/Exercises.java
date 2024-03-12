package co.uniquindio.laboratorioListas.laboratorio;


import co.uniquindio.laboratorioListas.listas.*;
import co.uniquindio.laboratorioListas.model.People;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Exercises {

    public static void main(String args[]) {

        LinkedList<Integer> numberList = new LinkedList<>();
        numberList.addLast(1);
        numberList.addLast(2);
        numberList.addLast(3);
        numberList.addLast(4);
        numberList.addLast(5);

        LinkedList<Integer> numberList2 = new LinkedList<>();
        numberList2.addLast(6);
        numberList2.addLast(7);
        numberList2.addLast(8);
        numberList2.addLast(9);
        numberList2.addLast(10);

        //The simple linked list with numbers is shown in the console
        System.out.println("Numbers List: ");
        numberList.printList();

        //The simple linked list with numbers is shown in the console
        System.out.println("Numbers List 2: ");
        numberList2.printList();

        LinkedList<People> peopleList = new LinkedList<>();
        // Adding people to the list
        peopleList.addFirst(new People("John", "Doe", "12345"));
        peopleList.addFirst(new People("Jane", "Doe", "5678"));
        peopleList.addFirst(new People("Alice", "Smith", "987654"));
        peopleList.addFirst(new People("Bob", "Johnson", "123456789"));

        // Printing the list
        System.out.println("People List:");
        peopleList.printList();

        //Initialize a doubly linked list
        DoubleLinkedList<String> doublyList = new DoubleLinkedList<>();

        // Adding some values to the list
        doublyList.addLast("Apple");
        doublyList.addLast("Banana");
        doublyList.addLast("Orange");

        DoubleLinkedList<People> peopleDoublyList = new DoubleLinkedList<>();

        // Adding some people to the list
        People person1 = new People("John", "Doe", "1234567890");
        People person2 = new People("Jane", "Smith", "097654321");
        People person3 = new People("Alice", "Johnson", "1357924680");

        peopleDoublyList.addLast(person1);
        peopleDoublyList.addLast(person2);
        peopleDoublyList.addLast(person3);

        // Printing the double list of people
        System.out.println("Doubly List of people:");
        peopleList.printList();

        // Printing the list
        System.out.println("The doubly linked list is: ");
        doublyList.printList();

        //1. Get the numbers in the odd positions of a simple linked list of numbers
        System.out.println(" ");
        System.out.println("1. Get the numbers in the odd positions of a simple linked list of numbers");
        ArrayList<Integer> result = returnValuePosOdd(numberList);
        System.out.println("Numbers in odd positions: " + result);

        //2. Obtain the list of people who have an ID with an even number of numbers from a simple linked list of people.
        System.out.println(" ");
        System.out.println("2. Obtain the list of people who have an ID with an even number of numbers from a simple linked list of people.");
        ArrayList<People> result2 = getPeopleWithEvenID(peopleList);
        System.out.println("People with even identification: " + result2);

        //3. Remove even numbers from a simple linked list
        System.out.println(" ");
        System.out.println("3. Remove even numbers from a simple linked list");
        removeEvenNumbers(numberList);
        System.out.println("Number List after removing even numbers: ");
        numberList.printList();
        //Add again numbers removed & more
        numberList.addLast(2);
        numberList.addLast(4);
        numberList.addLast(6);
        numberList.addLast(9);
        numberList.addLast(12);
        System.out.println("The new number list is: ");
        numberList.printList();

        //4. Write a method that returns a linked list with the odd values of a list of numbers.
        System.out.println(" ");
        System.out.println("4. Write a method that returns a linked list with the odd values of a list of numbers");
        LinkedList<Integer> result4 = returnOddValues(numberList);
        System.out.println("Odd values form number list are: ");
        result4.printList();

        //5. Write a method that returns the number of times a value is repeated in a linked list.
        // Value to count
        System.out.println(" ");
        System.out.println("5. Write a method that returns the number of times a value is repeated in a linked list.");
        int var = 3;
        int result5 = returnAppearances(var, numberList);
        System.out.println("The appearances of the value " + var + " are: " + result5);

        //6. Write the printBackward() method of a doubly linked list.
        System.out.println(" ");
        System.out.println("6. Write the printBackward() method of a doubly linked list.");
        printBackward(doublyList);

        //7. Write the Iterator for a doubly linked list.
        System.out.println(" ");
        System.out.println("7. Write the Iterator for a doubly linked list.");
        System.out.println("Test for the doubly list iterator:");
        testDoublyListIterator(doublyList);

        //8. Obtain the list of people who have an ID with even number of elements from a list double linked of people.
        System.out.println(" ");
        System.out.println("8. Obtain the list of people who have an ID with even number of elements from a list double linked of people.");
        System.out.println("The people with even number of digits on their ID of the doybly linked list is: ");
        ArrayList<People> result8 = getPeopleEvenID(peopleDoublyList);
        System.out.println(result8);

        //9. Write the insert and search method of a circular list
        System.out.println(" ");
        System.out.println("9. Write the insert and search method of a circular list.");
        circularLinkedListMethodsTest();

        //10. Write a method that allows “concatenating” two simple linked lists, the method must
        //receive as parameters two objects of type List, join them and return a list that contains
        //to both.
        System.out.println(" ");
        System.out.println("10. Write a method that allows “concatenating” two simple linked lists, the method must\n" +
                "receive as parameters two objects of type List, join them and return a list that contains\n" +
                "to both.");
        System.out.println("The actual number list is: ");
        numberList.printList();
        System.out.println("The actual number list 2 is: ");
        numberList2.printList();
        concatLinkedList(numberList, numberList2);
        System.out.println("The final number list is: ");
        numberList.printList();

        //11. Represent a polynomial of degree n as a linked list, where each node contains the coefficient and the exponent of the nth term.
        //After representing the polynomial, write a method that allows evaluating the polynomial for a given value of x.
        System.out.println(" ");
        System.out.println("Printing the polynomial:");
        testPolynomialLinkedList();
        System.out.println();

        //12. Write a program that calculates the mean and standard deviation of a set of N real numbers
        System.out.println("Solution 12:");
        LinkedList<Double> linkedList = Exercises.createLinkedListFromFile("src/resources/values.txt");
        linkedList.printList();
        System.out.println("The mean is: " + getMean());
        System.out.println("The standard deviation is: " + getStandartDeviation());

        /*
        //13. Do a recurse method to find the maximum distance between a key value of a linkedlist with custom node declaration given by the lab.
        //The method is in the class LinkedList
         */
        System.out.println();
        //Create a linked list to find the maximum distance bet ween a key value.
        LinkedList.List maximumDistanceList = new LinkedList.List();
        //Add values to the list. Added in the same order as in the lab guide.
        maximumDistanceList.add(9);
        maximumDistanceList.add(4);
        maximumDistanceList.add(6);
        maximumDistanceList.add(8);
        maximumDistanceList.add(4);
        maximumDistanceList.add(5);
        maximumDistanceList.add(4);
        maximumDistanceList.add(4);

        //Test the maxDistance method.
        int key = 4;
        int maxDistance = maximumDistanceList.maxDistanceBetweenKeys(key);
        System.out.println("The maximum distance between the key value " + key + " is: " + maxDistance);
    }

    //1. Get the numbers in the odd positions of a simple linked list of numbers
    public static ArrayList<Integer> returnValuePosOdd(LinkedList<Integer> list) {
        //A list is created to store the values of the odd positions of the linked list
        ArrayList<Integer> posOdds = new ArrayList<Integer>();
        //Index for position reference
        int i = 0;
        //Instance of iterator for traveling the list
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            //If the index is odd, the value of the node is added to the list
            if (i % 2 == 1) {
                posOdds.add(list.getNodeValue(i));
            }
            iterator.next();
            i++;
        }
        return posOdds;
    }

    //2. Obtain the list of people who have an ID with an even number of numbers from a simple linked list of people.
    public static ArrayList<People> getPeopleWithEvenID(LinkedList<People> list) {
        //Initialize an ArrayList that contains the People that have even ID
        ArrayList<People> peopleList = new ArrayList<People>();
        //Instance of iterator for traveling the list
        Iterator<People> iterator = list.iterator();
        while (iterator.hasNext()) {
            //Get the Persona in the Node
            People p = iterator.next();
            //If amount of digits of the Person is an even number, it´s added to the popleList
            if (p.isIdentificationEven()) {
                peopleList.add(p);
            }
        }
        return peopleList;
    }

    //3. Remove even numbers from a simple linked list
    public static void removeEvenNumbers(LinkedList<Integer> list) {
        //Index for position reference
        //Instance of iterator for traveling the list
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            //Get the Node value
            int v = iterator.next();
            //If the Node value is an even number, it´s removed form the list
            if (v % 2 == 0) {
                list.delete(v);
            }
        }
    }

    //4. Write a method that returns a linked list with the odd values of a list of numbers.
    public static LinkedList<Integer> returnOddValues(LinkedList<Integer> numberList) {
        //Create an instance of a linked list, where the odd values are deposited
        LinkedList<Integer> oddList = new LinkedList<>();
        //Index for oddlist position reference
        int j = 0;
        //Instance of iterator for traveling the list
        Iterator<Integer> iterator = numberList.iterator();
        while (iterator.hasNext()) {
            //Get the value from de node on i position
            int v = iterator.next();
            //If the Node value is an odd number, it´s added to the linked list
            if (v % 2 != 0) {
                oddList.add(v, j);
                j++;
            }
        }
        return oddList;
    }

    //5. Write a method that returns the number of times a value is repeated in a linked list.
    public static <T extends Comparable<T>> int returnAppearances(T value, LinkedList<T> list) {
        return list.countAppearances(value);
    }

    //6. Write the printBackward() method of a doubly linked list.
    public static <T extends Comparable<T>> void printBackward(DoubleLinkedList<T> list) {
        System.out.println("The double linked list printed in backwards is:");
        list.printBackward();
    }

    //7. Write the Iterator for a doubly linked list.
    //The Iterator is writen in the DoubleLinkedList class
    //This is a test for the iterator
    public static <T extends Comparable<T>> void testDoublyListIterator(DoubleLinkedList<T> list) {
        for (T t : list) {
            System.out.print("Elemento: " + t + " ");
        }
    }

    //8. Obtain the list of people who have an ID with even number of elements from a list double linked of people.
    public static ArrayList<People> getPeopleEvenID(DoubleLinkedList<People> list) {
        //Initialize an instance of a list, that will contain the people with even number of digits in their ID
        ArrayList<People> evenID = new ArrayList<People>();
        //Instance of the list iterator for traveling the list
        Iterator<People> iterator = list.iterator();
        while (iterator.hasNext()) {
            //Get the value of the node
            People p = iterator.next();
            //Verification - if the person has even ID is added to the final list
            if (p.isIdentificationEven()) {
                evenID.add(p);
            }
        }
        return evenID;
    }

    //9. Write the insert and search method of a circular list
    // Method for insert on CircularLinkedList on class CircularLinkedList
    // Method for search on CircularLinkedList on class CircularLinkedList
    // Method for testing
    public static void circularLinkedListMethodsTest() {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        // Add elements to the circular linked list
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        //Test for insert method
        list.insert(4, 2);

        //Print the list
        list.printList();

        //Test for search method
        int p = list.search(4);
        System.out.println("The position of the value: " + "4" + " is: " + p);
    }

    //10. Write a method that allows “concatenating” two simple linked lists, the method must
    //receive as parameters two objects of type List, join them and return a list that contains
    //to both.
    public static <T extends Comparable<T>> void concatLinkedList(LinkedList<T> list1, LinkedList<T> list2) {
        list1.concat(list2);
    }

    //12. Write a program that calculates the mean and standard deviation of a set of N real numbers
    /**
     * Gets the mean of n values
     * @return
     */
    public static double getMean() {
        LinkedList<Double> linkedList = createLinkedListFromFile("src/resources/values.txt");
        double sum = 0;
        int count = 0;
        Iterator<Double> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
            count++;
        }
        return sum / count;
    }

    /**
     * Gets the standart deviation
     * @return
     */
    public static double getStandartDeviation() {
        LinkedList<Double> linkedList = createLinkedListFromFile("src/resources/values.txt");
        double mean = getMean();
        double sumOfSquaredDifferences = 0;
        int count = 0;
        Iterator<Double> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            double value = iterator.next();
            sumOfSquaredDifferences += Math.pow(value - mean, 2);
            count++;
        }
        double variance = sumOfSquaredDifferences / (count - 1);
        return Math.sqrt(variance);
    }

    /**
     * Creates a linkedList for de Numbers of the files
     * @param fileName
     * @return
     */
    public static LinkedList<Double> createLinkedListFromFile(String fileName) {
        LinkedList<Double> linkedList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double value = Double.parseDouble(line);
                linkedList.addLast(value);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return linkedList;
    }

    //Test the PolynomialLinkedList class for Problem 11, this is a class that will be invoked to the main.
    public static void testPolynomialLinkedList(){

        //Create a polynomial list, the polynomial comes from the class PolynomialLinkedList in LinkedList package.
        LinkedList.PolynomialLinkedList<Integer> polynomial = new LinkedList.PolynomialLinkedList<>();

        //Few polynomial terms are added. They organize in the list by the exponent value. If there are two terms with the same exponent, the coefficients are not added.
        polynomial.addPolinomiumTerm(5,2);
        polynomial.addPolinomiumTerm(3,1);
        polynomial.addPolinomiumTerm(2,0);
        polynomial.addPolinomiumTerm(4,3);

        //Print the polynomial
        polynomial.printPolynomial();

        //Print the value table of the polynomial.
        polynomial.printValueTable();
    }
}
