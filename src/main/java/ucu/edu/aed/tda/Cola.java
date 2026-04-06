package ucu.edu.aed.tda;

public class Cola<T> extends ListaEnlazada<T> implements TDACola<T> {

    @Override
    public T frente() {
        if (esVacia()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        return obtener(0);
    }

    @Override
    public boolean poneEnCola(T dato) {
        agregar(dato);
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (esVacia()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        return remover(0);
    }
    
}
