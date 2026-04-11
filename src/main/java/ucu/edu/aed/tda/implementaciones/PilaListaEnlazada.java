package ucu.edu.aed.tda.implementaciones;

public class PilaListaEnlazada<T> extends TDAListaEnlazada<T> {

    public void push(T elem) {
        Nodo<T> nuevoNodo = new Nodo<>(elem);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    public T pop() {
        if (cabeza == null) {
            System.out.println("La pila está vacía.");
            return null;
        }
        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        return dato;
    }

    public T peek() {
        if (cabeza == null) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return cabeza.getDato();
    }
    public boolean esVacia() {
        return cabeza == null;
    }
    
}
