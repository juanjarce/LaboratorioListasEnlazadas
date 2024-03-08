package co.uniquindio.laboratorioListas.laboratorio;


import co.uniquindio.laboratorioListas.listas.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class Exercises {

    public static void main(String args[]) {

        LinkedList<Integer> lista = new LinkedList<>();
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);

        //The simple linked list with numbers is shown in the console
        System.out.println("Linked List: ");
        lista.printList();

        //1. Get the numbers in the odd positions of a simple linked list of numbers
        ArrayList<Integer> result = returnValuePosOdd(lista);
        System.out.println("Numbers in odd positions: " + result);

    }

    //1. Get the numbers in the odd positions of a simple linked list of numbers
    public static ArrayList<Integer> returnValuePosOdd(LinkedList<Integer> list) {
        //A list is created to store the values ​​of the odd positions of the linked list
        ArrayList<Integer> posImpares = new ArrayList<Integer>();
        //Index for position reference
        int i = 0;
        //Instance of iterator for traveling the list
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            //If the index is odd, the value of the node is added to the list
            if(i%2==1){
                posImpares.add(list.getNodeValue(i));
            }
            iterator.next();
            i++;
        }
        return posImpares;
    }

    //2. Obtain the list of people who have an ID with an even number of numbers from a simple linked list of people.
}
