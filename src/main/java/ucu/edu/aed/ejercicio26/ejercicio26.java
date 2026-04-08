package ucu.edu.aed.ejercicio26;

import java.util.List;
import ucu.edu.aed.tda.PilaListaEnlazada;

public class ejercicio26 {

    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        PilaListaEnlazada<Character> pila = new PilaListaEnlazada<>();
        for (Character c : listaDeEntrada) {
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

