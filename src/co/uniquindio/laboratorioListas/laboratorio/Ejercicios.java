package co.uniquindio.laboratorioListas.laboratorio;


import co.uniquindio.laboratorioListas.listas.ListaEnlazada;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicios {

    public static void main(String args[]) {

        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
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
    public static ArrayList<Integer> devolverValorPosImpares(ListaEnlazada<Integer> lista) {
        ArrayList<Integer> posImpares = new ArrayList<Integer>();
        int i = 0;
        Iterator<Integer> iterator = lista.iterator();
        while (iterator.hasNext()){
            if(i%2==1){
                posImpares.add(lista.obtenerValorNodo(i));
            }
            iterator.next();
            i++;
        }
        return posImpares;
    }

}
