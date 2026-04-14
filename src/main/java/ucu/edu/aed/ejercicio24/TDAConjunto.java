package ucu.edu.aed.ejercicio24;

import ucu.edu.aed.tda.implementaciones.TDAListaEnlazada;

public class TDAConjunto<T> extends TDAListaEnlazada<T> {

    public TDAListaEnlazada<T> union(TDAListaEnlazada<T> l1, TDAListaEnlazada<T> l2) {

        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Listas no pueden ser null");
        }

        TDAListaEnlazada<T> l3 = new TDAListaEnlazada<>();
        l3 = l1;

        for (int i = 0; i < l3.tamaño(); i++) {
            T elemento = l3.obtener(i);
            if (l3.contiene(elemento) == true) {
                continue;
            } else {
                l3.agregar(elemento);
            }
        }

        return l3;
    }

    public <T> TDAListaEnlazada<T> interseccion(TDAListaEnlazada<T> l1, TDAListaEnlazada<T> l2) {

        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Listas no pueden ser null");
        }

        TDAListaEnlazada<T> l3 = new TDAListaEnlazada<>();

        for (int i = 0; i < l1.tamaño(); i++) {

            T elemento = l1.obtener(i);
            if (l2.contiene(elemento) && !l3.contiene(elemento)) {
                l3.agregar(elemento);
            }

        }

        return l3;
    }

}
