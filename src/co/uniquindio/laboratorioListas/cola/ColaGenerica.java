package co.uniquindio.laboratorioListas.cola;

import java.util.LinkedList;

public class ColaGenerica<T> {
    private LinkedList<T> elementos;
    private int capacidadMaxima;

    // Constructor que permite especificar la capacidad máxima de la cola
    public ColaGenerica(int capacidadMaxima) {
        elementos = new LinkedList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    // Método para crear una cola
    public static <T> ColaGenerica<T> crearCola(int capacidadMaxima) {
        return new ColaGenerica<T>(capacidadMaxima);
    }

    // Método para insertar un elemento en la cola
    public void insertar(T elemento) {
        if (colaLlena()) {
            throw new IllegalStateException("La cola está llena");
        }
        elementos.add(elemento);
    }

    // Método para quitar y devolver el primer elemento de la cola
    public T quitar() {
        if (colaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.removeFirst();
    }

    // Método para verificar si la cola está vacía
    public boolean colaVacia() {
        return elementos.isEmpty();
    }

    // Método para verificar si la cola está llena
    public boolean colaLlena() {
        return elementos.size() == capacidadMaxima;
    }

    // Método para obtener el primer elemento de la cola sin quitarlo
    public T getPrimerElemento() {
        if (colaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.getFirst();
    }

    // Método para obtener el tamaño de la cola
    public int tamañoCola() {
        return elementos.size();
    }

    public static void main(String[] args) {
        ColaGenerica<Integer> cola = ColaGenerica.crearCola(5);
        cola.insertar(1);
        cola.insertar(2);
        cola.insertar(3);

        System.out.println("Primer elemento: " + cola.getPrimerElemento());
        System.out.println("Quitando: " + cola.quitar());
        System.out.println("Primer elemento después de quitar: " + cola.getPrimerElemento());
        System.out.println("Tamaño de la cola: " + cola.tamañoCola());
        System.out.println("¿La cola está vacía? " + cola.colaVacia());
        System.out.println("¿La cola está llena? " + cola.colaLlena());
    }
}
