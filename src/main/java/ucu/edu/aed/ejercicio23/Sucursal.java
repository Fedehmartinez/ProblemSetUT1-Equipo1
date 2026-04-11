package ucu.edu.aed.ejercicio23;

import ucu.edu.aed.tda.implementaciones.Nodo;
import ucu.edu.aed.tda.implementaciones.TDAListaEnlazada;

public class Sucursal {
    String nombre;

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Sucursal other = (Sucursal) obj;
        return nombre.equals(other.nombre);
    }

}
