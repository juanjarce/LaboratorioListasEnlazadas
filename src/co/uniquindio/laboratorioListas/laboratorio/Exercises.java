package co.uniquindio.laboratorioListas.laboratorio;


import co.uniquindio.laboratorioListas.listas.LinkedList;
import co.uniquindio.laboratorioListas.model.People;

import java.util.ArrayList;
import java.util.Iterator;

public class Exercises {

    public static void main(String args[]) {

        LinkedList<Integer> numberList = new LinkedList<>();
        numberList.addLast(1);
        numberList.addLast(2);
        numberList.addLast(3);
        numberList.addLast(4);
        numberList.addLast(5);

        //The simple linked list with numbers is shown in the console
        System.out.println("Numbers List: ");
        numberList.printList();

        LinkedList<People> peopleList = new LinkedList<>();
        // Adding people to the list
        peopleList.addFirst(new People("John", "Doe", "12345"));
        peopleList.addFirst(new People("Jane", "Doe", "5678"));
        peopleList.addFirst(new People("Alice", "Smith", "987654"));
        peopleList.addFirst(new People("Bob", "Johnson", "123456789"));

        // Printing the list
        System.out.println("People List:");
        peopleList.printList();

        //1. Get the numbers in the odd positions of a simple linked list of numbers
        ArrayList<Integer> result = returnValuePosOdd(numberList);
        System.out.println("Numbers in odd positions: " + result);

        //2. Obtain the list of people who have an ID with an even number of numbers from a simple linked list of people.
        ArrayList<People> result2 = getPeopleWithEvenID(peopleList);
        System.out.println("People with even identification: "+result2);

        //3. Remove even numbers from a simple linked list
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
        LinkedList<Integer> result4 = returnOddValues(numberList);
        System.out.println("Odd values form number list are: ");
        result4.printList();

        //5. Write a method that returns the number of times a value is repeated in a linked list.
        // Value to count
        int var = 3;
        int result5 = returnAppearances(var, numberList);
        System.out.println("The appearances of the value "+var+" are: "+result5);
    }

    //1. Get the numbers in the odd positions of a simple linked list of numbers
    public static ArrayList<Integer> returnValuePosOdd(LinkedList<Integer> list) {
        //A list is created to store the values of the odd positions of the linked list
        ArrayList<Integer> posOdds = new ArrayList<Integer>();
        //Index for position reference
        int i = 0;
        //Instance of iterator for traveling the list
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            //If the index is odd, the value of the node is added to the list
            if(i%2==1){
                posOdds.add(list.getNodeValue(i));
            }
            iterator.next();
            i++;
        }
        return posOdds;
    }

    //2. Obtain the list of people who have an ID with an even number of numbers from a simple linked list of people.
    public static ArrayList<People> getPeopleWithEvenID(LinkedList<People> list){
        //Initialize an ArrayList that contains the People that have even ID
        ArrayList<People> peopleList = new ArrayList<People>();
        //Instance of iterator for traveling the list
        Iterator<People> iterator = list.iterator();
        while (iterator.hasNext()){
            //Get the Persona in the Node
            People p = iterator.next();
            //If amount of digits of the Person is a even number, it´s added to the popleList
            if(p.isIdentificationEven()){
                peopleList.add(p);
            }
        }
        return peopleList;
    }

    //3. Remove even numbers from a simple linked list
    public static void removeEvenNumbers(LinkedList<Integer> list){
        //Index for position reference
        //Instance of iterator for traveling the list
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            //Get the Node value
            int v = iterator.next();
            //If the Node value is a even number, it´s removed form the list
            if(v%2==0){
                list.delete(v);
            }
        }
    }

    //4. Write a method that returns a linked list with the odd values of a list of numbers.
    public static LinkedList<Integer> returnOddValues(LinkedList<Integer> numberList){
        //Create a instance of a linked list, where the odd values are deposited
        LinkedList<Integer> oddList = new LinkedList<>();
        //Index for oddlist position reference
        int j = 0;
        //Instance of iterator for traveling the list
        Iterator<Integer> iterator = numberList.iterator();
        while (iterator.hasNext()){
            //Get the value from de node on i position
            int v = iterator.next();
            //If the Node value is an odd number, it´s added to the linked list
            if(v%2!=0){
               oddList.add(v, j);
               j++;
            }
        }
        return oddList;
    }

    //5. Write a method that returns the number of times a value is repeated in a linked list.
    public static <T extends Comparable<T>> int returnAppearances(T value, LinkedList<T> list){
        return list.countAppearances(value);
    }
}
