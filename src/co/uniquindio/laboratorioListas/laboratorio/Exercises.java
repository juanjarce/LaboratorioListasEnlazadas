package co.uniquindio.laboratorioListas.laboratorio;


import co.uniquindio.laboratorioListas.listas.LinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class Exercises {

    public static void main(String args[]) {

        LinkedList<Integer> lista = new LinkedList<>();
        lista.agregarFinal(1);
        lista.agregarFinal(2);
        lista.agregarFinal(3);
        lista.agregarFinal(4);
        lista.agregarFinal(5);

        //Se muestra la lista enlazada simple con numeros en consola
        System.out.println("Lista Simple: ");
        lista.imprimirLista();

        //1. Obtener los números de las posiciones impares de una lista enlazada simple de números
        ArrayList<Integer> resultado = devolverValorPosImpares(lista);
        System.out.println("Números en posiciones impares: " + resultado);

    }

    //1. Obtener los números de las posiciones impares de una lista enlazada simple de números
    public static ArrayList<Integer> devolverValorPosImpares(LinkedList<Integer> lista) {
        //Se crea una lista para almacenar los valores de las posiciones impares de la lista enlazada
        ArrayList<Integer> posImpares = new ArrayList<Integer>();
        //Indice para referencia de posicion
        int i = 0;
        //Se crea una instancia del iterador para recorrer la lista
        Iterator<Integer> iterator = lista.iterator();
        while (iterator.hasNext()){
            //Si el indice es impar se añade el valor del nodo a la lista
            if(i%2==1){
                posImpares.add(lista.obtenerValorNodo(i));
            }
            iterator.next();
            i++;
        }
        return posImpares;
    }

    //2. Obtener la lista de personas tengan cédula con cantidad de números par de una lista enlazada simple de personas.
}
