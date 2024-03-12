package co.uniquindio.laboratorioListas.listas;
import java.util.Iterator;

public class CircularLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private int size;

    // Constructor
    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Método para agregar un elemento al inicio de la lista
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            newNode.next = newNode; // Hace que el siguiente del nuevo nodo apunte a sí mismo
            head = newNode; // La cabeza apunta al nuevo nodo
        } else {
            newNode.next = head.next; // Establece el siguiente del nuevo nodo como el siguiente de la cabeza
            head.next = newNode; // Establece el siguiente de la cabeza como el nuevo nodo
        }
        size++;
    }

    // Método para agregar un elemento al final de la lista
    public void addLast(T value) {
        addFirst(value); // Simplemente llamamos a addFirst ya que estamos agregando al final de una lista circular
        head = head.next; // Mueve la cabeza al nuevo nodo agregado
    }

    // Método para agregar un elemento en una posición específica
    public void add(T value, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == size) {
            addLast(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // Método para obtener el valor de un nodo en una posición específica
    public T obtenerValorNodo(int position) {
        if (!indiceValido(position)) {
            System.out.println("Invalid position");
            return null;
        }
        Node<T> current = head.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.value;
    }

    // Método para obtener el nodo en una posición específica
    public Node<T> obtenerNodo(int position) {
        if (!indiceValido(position)) {
            System.out.println("Invalid position");
            return null;
        }
        Node<T> current = head.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    // Método para obtener la posición de un nodo dado su valor
    public int obtenerPosicionNodo(T value) {
        int position = 0;
        Node<T> current = head.next;
        while (current != head) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Indica que el valor no fue encontrado
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
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        head.next = head.next.next;
        size--;
    }

    // Método para eliminar el último nodo de la lista
    public void eliminarUltimo() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head.next;
        while (current.next != head) {
            current = current.next;
        }
        current.next = head.next;
        head = current;
        size--;
    }

    // Método para eliminar un nodo dado su valor
    public void eliminar(T value) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head.next;
        Node<T> previous = head;
        while (current != head) {
            if (current.value.equals(value)) {
                previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Value not found");
    }

    // Método para modificar el valor de un nodo en una posición específica
    public void modificarNodo(int position, T newValue) {
        if (!indiceValido(position)) {
            System.out.println("Invalid position");
            return;
        }
        Node<T> current = head.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        current.value = newValue;
    }

    // Método para ordenar la lista
    public void ordenarLista() {
        if (isEmpty() || size == 1) {
            return; // Lista ya está ordenada o vacía
        }
        for (int i = 0; i < size - 1; i++) {
            Node<T> current = head.next;
            for (int j = 0; j < size - 1 - i; j++) {
                if (current.value.compareTo(current.next.value) > 0) {
                    T temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                }
                current = current.next;
            }
        }
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head.next;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head.next);
        System.out.println();
    }

    // Método para borrar toda la lista
    public void borrarLista() {
        head.next = null;
        size = 0;
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return head == null;
    }


    // Implementación del método iterator de la interfaz Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head.next;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                count++;
                return value;
            }
        };
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Methods for Laboratory

    //Method (insert)
    public void insert(T value, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position == size) {
            addLast(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    //Method (search)
    //Return the position of the node
    //If the node isin´t on the list returns -1
    public int search(T value) {
        int position = 0;
        Node<T> current = head.next;
        while (current != head) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Indica que el valor no fue encontrado
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Main

    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        // Prueba de agregar al inicio
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        // Debería imprimir: 3 2 1
        System.out.println("Lista después de agregar al inicio:");
        list.imprimirLista();

        // Prueba de agregar al final
        list.addLast(4);
        list.addLast(5);
        // Debería imprimir: 3 2 1 4 5
        System.out.println("Lista después de agregar al final:");
        list.imprimirLista();

        // Prueba de agregar en una posición específica
        list.add(6, 2);
        // Debería imprimir: 3 2 6 1 4 5
        System.out.println("Lista después de agregar en la posición 2:");
        list.imprimirLista();

        // Prueba de obtener el valor de un nodo en una posición específica
        System.out.println("Valor del nodo en la posición 3: " + list.obtenerValorNodo(3));

        // Prueba de obtener el nodo en una posición específica
        System.out.println("Nodo en la posición 2: " + list.obtenerNodo(2).value);

        // Prueba de obtener la posición de un nodo dado su valor
        System.out.println("Posición del nodo con valor 6: " + list.obtenerPosicionNodo(6));

        // Prueba de verificar si la lista está vacía
        System.out.println("¿La lista está vacía? " + list.estaVacia());

        // Prueba de eliminar el primer nodo de la lista
        list.eliminarPrimero();
        // Debería imprimir: 2 6 1 4 5
        System.out.println("Lista después de eliminar el primer nodo:");
        list.imprimirLista();

        // Prueba de eliminar el último nodo de la lista
        list.eliminarUltimo();
        // Debería imprimir: 2 6 1 4
        System.out.println("Lista después de eliminar el último nodo:");
        list.imprimirLista();

        // Prueba de eliminar un nodo dado su valor
        list.eliminar(1);
        // Debería imprimir: 2 6 4
        System.out.println("Lista después de eliminar el nodo con valor 1:");
        list.imprimirLista();

        // Prueba de modificar el valor de un nodo en una posición específica
        list.modificarNodo(1, 10);
        // Debería imprimir: 2 10 4
        System.out.println("Lista después de modificar el nodo en la posición 1:");
        list.imprimirLista();

        // Prueba de ordenar la lista
        list.addFirst(7);
        list.addFirst(3);
        list.ordenarLista();
        // Debería imprimir: 2 3 4 7 10
        System.out.println("Lista después de ordenar:");
        list.imprimirLista();

//        // Prueba de borrar toda la lista
//        list.borrarLista();
//        // Debería imprimir: Lista está vacía
//        System.out.println("Lista después de borrar toda la lista:");
//        list.imprimirLista();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("Elemento: "+iterator.next());
        }

    }

}
