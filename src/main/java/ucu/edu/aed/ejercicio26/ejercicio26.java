package ucu.edu.aed.ejercicio26;

import ucu.edu.aed.tda.implementaciones.PilaListaEnlazada;
import ucu.edu.aed.tda.implementaciones.TDAListaEnlazada;

public class ejercicio26 {
    public boolean controlCorchetes(TDAListaEnlazada<Character> listaDeEntrada) {
    PilaListaEnlazada<Character> pila = new PilaListaEnlazada<>();
    for (int i = 0; i < listaDeEntrada.tamaño(); i++) {
        Character c = listaDeEntrada.obtener(i);
        if (c == '{') {
            pila.push(c);
        } else if (c == '}') {
            if (pila.esVacia()) {
                return false;
            }
            if (c == '}'){
                pila.pop();
            }
        }
    }
    return pila.esVacia();
    }
}