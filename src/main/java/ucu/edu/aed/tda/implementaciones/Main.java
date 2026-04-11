package ucu.edu.aed.tda.implementaciones;

import ucu.edu.aed.ejercicio23.Sucursal;
import ucu.edu.aed.utils.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*/
import ucu.edu.aed.ejercicio17.Adquisiciones;
import ucu.edu.aed.ejercicio17.Biblioteca;
import ucu.edu.aed.ejercicio17.Prestamos;*/
import ucu.edu.aed.ejercicio23.GestionSucursales;

public class Main {
    public static void main(String[] args) {
        /*
         * Biblioteca biblioteca = new Biblioteca();
         * 
         * String adquisiciones = "src/main/resources/adquisiciones.txt";
         * String prestamos = "src/main/resources/prestamos.txt";
         * 
         * System.out.println("========== ADQUISICIONES ==========");
         * Adquisiciones.procesarArchivo(adquisiciones, biblioteca);
         * 
         * System.out.println("\n========== PRÉSTAMOS ==========");
         * Prestamos.procesarArchivo(prestamos, biblioteca);
         * 
         * System.out.println("\n========== CATÁLOGO FINAL ==========");
         * biblioteca.listarLibros();
         */

        /*
         * ============ EJECICIO 23 ============
         * Prueba del programa
         * Dado un archivo de entrada, el programa debe:
         * 1. Leer el archivo “sucursales.txt”
         * 2. Mostrar en consola las ciudades cargadas.
         * 3. Mostrar el total de elementos (ciudades) contenidas en la estructura
         */
        GestionSucursales gestion = new GestionSucursales();

        // 1. Leer el archivo “sucursales.txt”.

        FileUtils.leerLineas("sucursales.txt", linea -> {
            gestion.agregarSucursal(linea);
        });

        // 2. Mostrar en consola las ciudades cargadas.
        gestion.listarSucursales();
        // 3. Mostrar el total de elementos (ciudades) contenidas en la estructura

        gestion.contarSucursales();

        gestion.eliminarSucursal("Chicago");
        gestion.listarSucursales();

        // 3. Levantar el archivo suc2.txt y eliminar las ciudades Shenzen y Tokio.
        GestionSucursales gestion2 = new GestionSucursales();
        FileUtils.leerLineas("suc2.txt", linea -> {
            gestion2.agregarSucursal(linea);
        });

        // gestion2.eliminarSucursal("Shenzen");
        // gestion2.eliminarSucursal("Tokio");

        System.err.println("Para suc2 ------------------");
        // gestion2.contarSucursales();

        System.err.println("Para suc3 ------------------");
        GestionSucursales gestion3 = new GestionSucursales();
        FileUtils.leerLineas("suc3.txt", linea -> {
            gestion3.agregarSucursal(linea);
        });
        gestion3.listarSucursales();

    }

}
