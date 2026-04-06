package ucu.edu.aed.tda;

import java.util.Comparator;
import java.util.function.Predicate;

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

    public T eliminar(T elem) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return null;
        }

        if (cabeza.getDato().equals(elem)) {
            cabeza = cabeza.getSiguiente();
            return cabeza.getDato();
        }

        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(elem)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return actual.getSiguiente().getDato();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Elemento no encontrado: " + elem);
        return null;
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
    public boolean esVacia() {
        return cabeza == null;
    }
    public T obtener(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Índice negativo: " + index);
        }
        Nodo<T> actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == index) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            contador++;
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
    }

    @Override
    public void agregar(int index, T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregar'");
    }

    @Override
    public T remover(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public boolean remover(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public boolean contiene(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contiene'");
    }

    @Override
    public int indiceDe(T elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indiceDe'");
    }

    @Override
    public T buscar(Predicate<T> criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public TDALista<T> ordenar(Comparator<T> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenar'");
    }

    @Override
    public int tamaño() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamaño'");
    }

    @Override
    public boolean esVacio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esVacio'");
    }

    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciar'");
    }


}
