package ucu.edu.aed.tda.implementaciones;

import ucu.edu.aed.ejercicio17.Adquisiciones;
import ucu.edu.aed.ejercicio17.Biblioteca;
import ucu.edu.aed.ejercicio17.Prestamos;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        String adquisiciones = "src/main/resources/adquisiciones.txt";
        String prestamos = "src/main/resources/prestamos.txt";

        System.out.println("========== ADQUISICIONES ==========");
        Adquisiciones.procesarArchivo(adquisiciones, biblioteca);

        System.out.println("\n========== PRÉSTAMOS ==========");
        Prestamos.procesarArchivo(prestamos, biblioteca);

        System.out.println("\n========== CATÁLOGO FINAL ==========");
        biblioteca.listarLibros();
    }
}