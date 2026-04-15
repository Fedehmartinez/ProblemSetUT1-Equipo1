package ucu.edu.aed.ejercicio24;

import ucu.edu.aed.tda.implementaciones.*;
import ucu.edu.aed.tda.interfaces.TDAConjunto;

public class Conjunto<T> extends ListaEnlazada<T> implements TDAConjunto<T> {

    public Conjunto() {
        super();
    }

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro) {
        TDAConjunto<T> resultado = new Conjunto<>();

        for (int i = 0; i < this.tamaño(); i++) {
            T elemento = this.obtener(i);
            resultado.agregar(elemento);
        }

        for (int i = 0; i < otro.tamaño(); i++) {
            T elemento = otro.obtener(i);
            if (!resultado.contiene(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;

    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro) {
        TDAConjunto<T> resultado = new Conjunto<>();

        for (int i = 0; i < this.tamaño(); i++) {
            T elemento = this.obtener(i);
            if (otro.contiene(elemento)) {

                resultado.agregar(elemento);

            }
        }

        return resultado;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diferencia'");
    }

    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esSubconjuntoDe'");
    }

    @Override
    public ListaEnlazada<T> listarElementos(TDAConjunto<T> conjunto) {
        if (conjunto == null) {
            throw new IllegalArgumentException("Conjunto no puede ser null");
        }

        ListaEnlazada<T> lista = new ListaEnlazada<>();

        for (int i = 0; i < conjunto.tamaño(); i++) {
            T elemento = conjunto.obtener(i);
            lista.agregar(elemento);
            System.out.println("- " + elemento);

        }

        return lista;
    }

}
