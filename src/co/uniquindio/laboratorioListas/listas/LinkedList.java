package co.uniquindio.laboratorioListas.listas;

import java.util.Iterator;

class Node<T> {
    T valor;
    Node<T> siguiente;

    // Constructor
    public Node(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    Node<T> cabeza;

    // Constructor
    public LinkedList() {
        this.cabeza = null;
    }

    // Método para agregar un elemento al final de la lista
    public void agregarFinal(T valor) {
        Node<T> nuevoNodo = new Node<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Node<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarInicio(T valor) {
        Node<T> nuevoNodo = new Node<>(valor);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    // Método para agregar un elemento en una posición específica
    public void agregar(T valor, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición inválida");
            return;
        }
        if (posicion == 0) {
            agregarInicio(valor);
            return;
        }
        Node<T> nuevoNodo = new Node<>(valor);
        Node<T> actual = cabeza;
        for (int i = 0; i < posicion - 1 && actual != null; i++) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("Posición fuera de rango");
            return;
        }
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
    }

    // Método para obtener el valor de un nodo en una posición específica
    public T obtenerValorNodo(int posicion) {
        Node<T> actual = cabeza;
        for (int i = 0; i < posicion && actual != null; i++) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            System.out.println("Posición fuera de rango");
            return null; // Valor por defecto para indicar error
        }
        return actual.valor;
    }

    // Método para obtener el nodo en una posición específica
    public Node<T> obtenerNodo(int posicion) {
        Node<T> actual = cabeza;
        for (int i = 0; i < posicion && actual != null; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    // Método para obtener la posición de un nodo dado su valor
    public int obtenerPosicionNodo(T valor) {
        int posicion = 0;
        Node<T> actual = cabeza;
        while (actual != null) {
            if (actual.valor.equals(valor)) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; // Valor por defecto para indicar que no se encontró el valor
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Método para eliminar el primer nodo de la lista
    public void eliminarPrimero() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        }
    }

    // Método para eliminar el último nodo de la lista
    public void eliminarUltimo() {
        if (cabeza == null || cabeza.siguiente == null) {
            cabeza = null;
        } else {
            Node<T> actual = cabeza;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
        }
    }

    // Método para eliminar un nodo dado su valor
    public void eliminar(T valor) {
        if (cabeza == null) {
            return;
        }
        if (cabeza.valor.equals(valor)) {
            cabeza = cabeza.siguiente;
            return;
        }
        Node<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.valor.equals(valor)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    // Método para modificar el valor de un nodo en una posición específica
    public void modificarNodo(int posicion, T nuevoValor) {
        Node<T> nodo = obtenerNodo(posicion);
        if (nodo != null) {
            nodo.valor = nuevoValor;
        } else {
            System.out.println("Posición fuera de rango");
        }
    }

    // Método para ordenar la lista utilizando el algoritmo de ordenación por inserción
    public void ordenarLista() {
        if (cabeza == null || cabeza.siguiente == null) {
            return; // La lista ya está ordenada o vacía
        }

        Node<T> nodoActual = cabeza.siguiente;
        while (nodoActual != null) {
            T valorActual = nodoActual.valor;
            Node<T> nodoAnterior = cabeza;
            Node<T> nodoIterador = cabeza;

            while (nodoIterador != nodoActual) {
                if (valorActual.compareTo(nodoIterador.valor) < 0) {
                    // Si el valor actual es menor que el valor del nodo actual, intercambiarlos
                    T temp = nodoIterador.valor;
                    nodoIterador.valor = valorActual;
                    valorActual = temp;
                }
                nodoIterador = nodoIterador.siguiente;
            }

            nodoActual.valor = valorActual;
            nodoActual = nodoActual.siguiente;
        }
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        Node<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para borrar toda la lista
    public void borrarLista() {
        cabeza = null;
    }

    // Método para verificar si un índice es válido
    private boolean indiceValido(int indice) {
        return indice >= 0 && indice < size();
    }

    // Método para obtener el tamaño de la lista
    private int size() {
        int size = 0;
        Node<T> actual = cabeza;
        while (actual != null) {
            size++;
            actual = actual.siguiente;
        }
        return size;
    }

    //Metodo para invertir una lista enlazada
    private void invertirListaEnlazada(){
        if(cabeza == null || cabeza.siguiente == null ){
            System.out.println("La lista no se puede invertir");
        }
        else{
            invertirRecursivo(cabeza, null);
        }
    }

    //Metodo para invertir una lista enlazada recursivamente
    private void invertirRecursivo(Node<T> actual, Node<T> anterior) {
        if(actual.siguiente==null){
            cabeza = actual;
            cabeza.siguiente = anterior;
        }
        else{
            invertirRecursivo(actual.siguiente, actual);
            actual.siguiente = anterior;
        }
    }

    //Metodo para recorrer una lista enlazada de forma recurisiva
    public void recorrerRecursivo(Node nodo) {
        // Verifica si el nodo actual no es nulo
        if (nodo != null) {
            // Imprime el valor del nodo actual
            System.out.print(nodo.valor + " ");
            // Llama recursivamente al método con el siguiente nodo
            recorrerRecursivo(nodo.siguiente);
        }
    }

    // Implementación del método iterator de la interfaz Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> actual = cabeza;

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
        LinkedList<Integer> lista = new LinkedList<>();
        lista.agregarFinal(5);
        lista.agregarFinal(10);
        lista.agregarFinal(15);
        lista.agregarFinal(20);
        lista.agregarInicio(1);
        lista.agregar(100, 2);

        System.out.println("Lista actual:");
        lista.imprimirLista();

//        System.out.println("Lista ordenada:");
//        lista.ordenarLista();
//        lista.imprimirLista();

        //Se invierte la lista enlazada
//        System.out.println("La lista invertida es:");
//        lista.invertirListaEnlazada();
//        lista.imprimirLista();

        System.out.println("Valor del nodo en la posición 3: " + lista.obtenerValorNodo(3));
        System.out.println("Posición del nodo con valor 10: " + lista.obtenerPosicionNodo(10));

        lista.eliminarPrimero();
        lista.eliminarUltimo();
        lista.eliminar(15);

        System.out.println("Lista después de eliminar algunos nodos:");
        lista.imprimirLista();

        lista.modificarNodo(2, 200);

        System.out.println("Lista después de modificar el nodo en la posición 2:");
        lista.imprimirLista();

        System.out.println("Tamaño de la lista: " + lista.size());

        System.out.println("Iterando sobre la lista:");
        Iterator<Integer> iterator = lista.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


        //Se muestra la lista enlazada actual
        System.out.println("La lista enlazada actual es:");
        lista.imprimirLista();

        //Se invierte la lista enlazada
        System.out.println("La lista invertida es:");
        lista.invertirListaEnlazada();
        lista.imprimirLista();
    }
}
