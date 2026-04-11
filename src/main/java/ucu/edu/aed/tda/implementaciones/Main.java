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

        String sucursalesArchivo = "src/main/resources/sucursales.txt";

        /*
         * gestion.agregarSucursal(suc1.getNombre());
         * gestion.agregarSucursal(suc2.getNombre());
         * gestion.agregarSucursal(suc3.getNombre());
         */

        // public void procesarArchivo(String rutaArchivo) {
        GestionSucursales gestion = new GestionSucursales();

        // Leer archivo y agregar sucursales
        FileUtils.leerLineas("sucursales.txt", linea -> {
            gestion.agregarSucursal(linea);
        });

        // Listar sucursales
        gestion.listarSucursales();
    }

}
