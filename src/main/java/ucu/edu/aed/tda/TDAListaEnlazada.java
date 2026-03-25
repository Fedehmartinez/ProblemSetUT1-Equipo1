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

    public void eliminar(T elem) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (cabeza.getDato().equals(elem)) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(elem)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Elemento no encontrado: " + elem);
    }

    public void buscar(T elem) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(elem)) {
                System.out.println("ISBN encontrado: " + actual.getDato().toString());
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("ISBN no encontrado: " + elem);
    }

}
