package ucu.edu.aed.ejercicio23;

import ucu.edu.aed.tda.implementaciones.*;

public class GestionSucursales extends ListaEnlazada<Sucursal> {

    ListaEnlazada<Sucursal> listaSucursales = new ListaEnlazada<>();

    public GestionSucursales() {
        super();
    }

    public void agregarSucursal(String dato) {
        Nodo<Sucursal> nodo = new Nodo<>(new Sucursal(dato));
        Sucursal sucursal = nodo.getDato();
        listaSucursales.agregar(sucursal);
    }

    public void eliminarSucursal(String nombre) {
        Nodo<Sucursal> actual = listaSucursales.getCabeza();
        while (actual != null) {
            if (actual.getDato().getNombre().equals(nombre)) {
                listaSucursales.remover(actual.getDato());
                System.out.println("Se eliminó la sucursal " + nombre);
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("No se encontró la sucursal " + nombre);
    }

    public ListaEnlazada<Sucursal> listarSucursales() {
        Nodo<Sucursal> actual = listaSucursales.getCabeza();
        System.out.println("Sucursales:");

        while (actual != null) {

            System.out.println("- " + actual.getDato());
            actual = actual.getSiguiente();

        }
        return listaSucursales;

    }

    public boolean buscarSucursal(Sucursal nombre) {
        Nodo<Sucursal> actual = listaSucursales.getCabeza();

        while (actual != null) {
            if (actual.getDato().equals(nombre)) {
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
