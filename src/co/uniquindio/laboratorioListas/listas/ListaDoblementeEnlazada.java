package co.uniquindio.laboratorioListas.listas;
import java.util.Iterator;

import java.util.Iterator;

class NodoDoble<T> {
    T valor;
    NodoDoble<T> anterior;
    NodoDoble<T> siguiente;

    // Constructor
    public NodoDoble(T valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }
}

public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    private int size;

    // Constructor
    public ListaDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarInicio(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
        size++;
    }

    // Método para agregar un elemento al final de la lista
    public void agregarFinal(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
        size++;
    }

    // Método para agregar un elemento en una posición específica
    public void agregar(T valor, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        if (posicion == 0) {
            agregarInicio(valor);
        } else if (posicion == size) {
            agregarFinal(valor);
        } else {
            NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
            NodoDoble<T> actual = obtenerNodo(posicion - 1);
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente.anterior = nuevoNodo;
            actual.siguiente = nuevoNodo;
            nuevoNodo.anterior = actual;
            size++;
        }
    }

    // Método para obtener el valor de un nodo en una posición específica
    public T obtenerValorNodo(int posicion) {
        return obtenerNodo(posicion).valor;
    }

    // Método para obtener el nodo en una posición específica
    private NodoDoble<T> obtenerNodo(int posicion) {
        if (!indiceValido(posicion)) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        NodoDoble<T> actual;
        if (posicion < size / 2) {
            actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.siguiente;
            }
        } else {
            actual = cola;
            for (int i = size - 1; i > posicion; i--) {
                actual = actual.anterior;
            }
        }
        return actual;
    }

    // Método para obtener la posición de un nodo dado su valor
    public int obtenerPosicionNodo(T valor) {
        NodoDoble<T> actual = cabeza;
        int posicion = 0;
        while (actual != null) {
            if (actual.valor.equals(valor)) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1;
    }

    // Método para verificar si un índice es válido
    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < size;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return size == 0;
    }

    // Método para eliminar el primer nodo de la lista
    public void eliminarPrimero() {
        if (!estaVacia()) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            } else {
                cola = null;
            }
            size--;
        }
    }

    // Método para eliminar el último nodo de la lista
    public void eliminarUltimo() {
        if (!estaVacia()) {
            cola = cola.anterior;
            if (cola != null) {
                cola.siguiente = null;
            } else {
                cabeza = null;
            }
            size--;
        }
    }

    // Método para eliminar un nodo dado su valor
    public void eliminar(T valor) {
        NodoDoble<T> actual = cabeza;
        while (actual != null && !actual.valor.equals(valor)) {
            actual = actual.siguiente;
        }
        if (actual != null) {
            if (actual.anterior != null) {
                actual.anterior.siguiente = actual.siguiente;
            } else {
                cabeza = actual.siguiente;
            }
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
            } else {
                cola = actual.anterior;
            }
            size--;
        }
    }

    // Método para modificar el valor de un nodo en una posición específica
    public void modificarNodo(int posicion, T nuevoValor) {
        obtenerNodo(posicion).valor = nuevoValor;
    }

    // Método para ordenar la lista usando el algoritmo de ordenamiento de burbuja
    public void ordenarLista() {
        if (size <= 1) {
            return; // No se puede ordenar una lista con 0 o 1 elementos
        }

        boolean intercambiado;
        do {
            intercambiado = false;
            NodoDoble<T> actual = cabeza;
            while (actual.siguiente != null) {
                if (actual.valor.compareTo(actual.siguiente.valor) > 0) {
                    intercambiarNodos(actual, actual.siguiente);
                    intercambiado = true;
                }
                actual = actual.siguiente;
            }
        } while (intercambiado);
    }

    // Método auxiliar para intercambiar dos nodos en la lista
    private void intercambiarNodos(NodoDoble<T> nodo1, NodoDoble<T> nodo2) {
        T temp = nodo1.valor;
        nodo1.valor = nodo2.valor;
        nodo2.valor = temp;
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para borrar toda la lista
    public void borrarLista() {
        cabeza = null;
        cola = null;
        size = 0;
    }

    // Metodo para invertir una lista doblemente enlazada
    private void invertirListaDoblementeEnlazada(){
        if(size>1){
            int indice = 0;
            invertirListaDoblementeEnlazadaRecursivo(cabeza, indice);
        }
        else{
            System.out.println("La lista doblemente enlazada no puede ser invertida");
        }
    }

    private void invertirListaDoblementeEnlazadaRecursivo(NodoDoble<T> actual, int indice) {
        if(indice == (size-1)){
            //Se intercambian los enlaces
            NodoDoble<T> aux = cola.anterior;
            cola.anterior = cola.siguiente;
            cola.siguiente = aux;

            //Se coloca como la cabeza de la lista
            NodoDoble<T> auxLimites = cabeza;
            cabeza = cola;
            cola = cabeza;
        }
        else{
            invertirListaDoblementeEnlazadaRecursivo(actual.siguiente, indice+1);
            //Se intercambian los enlaces
            NodoDoble<T> aux = actual.anterior;
            actual.anterior = actual.siguiente;
            actual.siguiente = aux;
        }
    }

    // Implementación del método iterator de la interfaz Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoDoble<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T valor = actual.valor;
                actual = actual.siguiente;
                return valor;
            }
        };
    }

    public static void main(String[] args) {
        ListaDoblementeEnlazada<Double> lista = new ListaDoblementeEnlazada<>();
        lista.agregarInicio(100.0);
        lista.agregarFinal(25.0);
        lista.agregar(352.0, 1);

        System.out.println("Iterando sobre la lista...");
        Iterator<Double> iterator = lista.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

        System.out.println(" ");
        System.out.println("Lista:");
        lista.imprimirLista();

//        System.out.println(" ");
//        System.out.println("Lista Ordenada es:");
//        lista.ordenarLista();
//        lista.imprimirLista();

//        System.out.println(" ");
//        System.out.println("Lista Invertida:");
//        lista.invertirListaDoblementeEnlazada();
//        lista.imprimirLista();

        lista.eliminarPrimero();
        lista.eliminarUltimo();
        lista.eliminar(25.0);

        System.out.println("Lista después de eliminar algunos nodos:");
        lista.imprimirLista();

        lista.modificarNodo(0, 5.0);

        System.out.println("Lista después de modificar el nodo en la posición 0:");
        lista.imprimirLista();

        System.out.println("Tamaño de la lista: " + lista.size);

        System.out.println("Prueba de push");

    }
}


