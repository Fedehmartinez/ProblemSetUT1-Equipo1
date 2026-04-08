package ucu.edu.aed.tda.implementaciones;

import ucu.edu.aed.tda.interfaces.TDACola;

public class Cola<T> extends TDAListaEnlazada<T> implements TDACola<T> {
     protected Nodo<T> ultimo;

    @Override
    public T frente() {
        if (esVacia()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        return ultimo.getDato();
    }

    @Override
    public boolean poneEnCola(T dato) {
        Nodo<T> nuevodato = new Nodo<>(dato);
        agregar(dato);
        this.ultimo = nuevodato;
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (esVacia()) {
            throw new java.util.NoSuchElementException("La cola está vacía");
        }
        T datoFrente = cabeza.getDato();
        eliminar(datoFrente);
        return datoFrente;
    }
    @Override
    public boolean esVacio() {
        return cabeza == null;
    }
    @Override 
    public void vaciar() {
        cabeza = null;
        ultimo = null;
    }
    @Override
    public int tamaño() {
        int contador = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
    
}
