package ucu.edu.aed.tda.implementaciones;

import ucu.edu.aed.ejercicio17.Adquisiciones;
import ucu.edu.aed.ejercicio17.Biblioteca;
import ucu.edu.aed.ejercicio17.Prestamos;
import ucu.edu.aed.ejercicio23.GestionSucursales;
import ucu.edu.aed.ejercicio24.Alumno;
import ucu.edu.aed.ejercicio24.Conjunto;
import ucu.edu.aed.tda.interfaces.TDAConjunto;
import ucu.edu.aed.utils.FileUtils;

public class Main {
    public static void main(String[] args) {

        /* EJERCICIO 17 */
        Biblioteca biblioteca = new Biblioteca();

        String adquisiciones = "src/main/resources/adquisiciones.txt";
        String prestamos = "src/main/resources/prestamos.txt";

        System.out.println("========== ADQUISICIONES ==========");
        Adquisiciones.procesarArchivo(adquisiciones, biblioteca);

        System.out.println("\n========== PRÉSTAMOS ==========");
        Prestamos.procesarArchivo(prestamos, biblioteca);

        System.out.println("\n========== CATÁLOGO FINAL ==========");
        biblioteca.listarLibros();

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

        // 2. Mostrar en consol a las ciudades cargadas.
        gestion.listarSucursales();
        // 3. Mostrar el total de elementos (ciudades) contenidas en la estructura

        gestion.contarSucursales();

        // gestion.eliminarSucursal("Chicago");
        gestion.listarSucursales();

        // 3. Levantar el archivo suc2.txt y eliminar las ciudades Shenzen y Tokio.
        /*
         * GestionSucursales gestion2 = new GestionSucursales();
         * FileUtils.leerLineas("suc2.txt", linea -> {
         * gestion2.agregarSucursal(linea);
         * });
         */
        // gestion2.eliminarSucursal("Shenzen");
        // gestion2.eliminarSucursal("Tokio");

        System.err.println("Para suc2 ------------------");
        // gestion2.contarSucursales();

        System.err.println("Para suc3 ------------------");
        GestionSucursales gestion3 = new GestionSucursales();
        FileUtils.leerLineas("suc3.txt", linea -> {
            gestion3.agregarSucursal(linea);
        });

        Alumno<String> alumno1 = new Alumno<>("Juan", 123456, "Perez");
        Alumno<String> alumno2 = new Alumno<>("Maria", 654321, "Gomez");
        Alumno<String> alumno3 = new Alumno<>("Emilia", 123456, "Torres");

        TDAConjunto<Alumno<String>> conjunto1 = new Conjunto<>();
        conjunto1.agregar(alumno1);
        conjunto1.agregar(alumno2);
        conjunto1.agregar(alumno3);
        TDAConjunto<Alumno<String>> conjunto2 = new Conjunto<>();
        conjunto2.agregar(alumno3);

        System.out.println("====== Interseccion ========");
        conjunto1.interseccion(conjunto2).listarElementos();

        System.out.println("====== Union ========");
        conjunto1.union(conjunto2).listarElementos();

    }

}
