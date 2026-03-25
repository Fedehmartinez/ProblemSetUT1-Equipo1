package ucu.edu.aed.tda;

public class PilaListaEnlazada<T> extends TDAListaEnlazada<T> {

    public void push(Object elem) {
        Nodo nuevoNodo = new Nodo(elem);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
    }

    public Object pop() {
        if (cabeza == null) {
            System.out.println("La pila está vacía.");
            return null;
        }
        Object dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        return dato;
    }

    public Object peek() {
        if (cabeza == null) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return cabeza.getDato();
    }
    
}
