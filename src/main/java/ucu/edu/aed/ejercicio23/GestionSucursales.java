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

}
