package ucu.edu.aed.tda;

public class TDAListaEnlazada<T> implements TDALista<T> {
    protected Nodo<T> cabeza;

    public TDAListaEnlazada() {
        this.cabeza = null;
    }

    public void agregar(T elem) {
        Nodo<T> nuevoNodo = new Nodo<>(elem);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public void buscar(T elem) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                System.out.println("Elemento encontrado: " + actual.getDato());
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Elemento no encontrado: " + elem);
    }

}
