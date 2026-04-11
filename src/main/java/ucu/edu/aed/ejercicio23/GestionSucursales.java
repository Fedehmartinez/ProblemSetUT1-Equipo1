package ucu.edu.aed.ejercicio23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ucu.edu.aed.tda.implementaciones.Nodo;
import ucu.edu.aed.tda.implementaciones.TDAListaEnlazada;

public class GestionSucursales {
    TDAListaEnlazada<Sucursal> listaSucursales = new TDAListaEnlazada<Sucursal>();

    /*
     * public GestionSucursales() {
     * listaSucursales = new TDAListaEnlazada<Sucursal>();
     * }
     */

    public void agregarSucursal(String nombre) {
        Sucursal nuevaSucursal = new Sucursal(nombre);
        listaSucursales.agregar(nuevaSucursal);
    }

    public void eliminarSucursal(String nombre) {
        Sucursal nuevaSucursal = new Sucursal(nombre);
        listaSucursales.eliminar(nuevaSucursal);

    }

    public TDAListaEnlazada<Sucursal> listarSucursales() {
        Nodo<Sucursal> actual = listaSucursales.getCabeza();
        System.out.println("Sucursales:");

        while (actual != null) {

            System.out.println("- " + actual.getDato().getNombre());
            actual = actual.getSiguiente();

        }
        return listaSucursales;

    }

    public boolean buscarSucursal(String nombre) {
        Nodo<Sucursal> actual = listaSucursales.getCabeza();

        while (actual != null) {
            if (actual.getDato().getNombre().equals(nombre)) {
                System.out.println("Se encontro la sucursal " + nombre);
                return true;

            }
            actual = actual.getSiguiente();
        }

        System.out.println("No se encontró la sucursal " + nombre);

        return false;
    }

    public int contarSucursales() {
        System.out.println("Cantidad de sucursales: " + listaSucursales.tamaño());
        return listaSucursales.tamaño();
    }

    public boolean directorioVacio() {
        boolean vacio = listaSucursales.esVacio();
        if (vacio) {
            System.out.println("El directorio de sucursales está vacío.");
        } else {
            System.out.println("El directorio de sucursales no está vacío.");
        }
        return vacio;
    }

}
