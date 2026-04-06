package ucu.edu.aed.tda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prestamos {

    public static int procesarArchivo(String rutaArchivo, Biblioteca biblioteca) {
        int variacionTotal = 0; // positivo = prestados, negativo = devueltos (neto)

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] partes = linea.split(", ");
                if (partes.length != 3) continue;

                String codigo = partes[0].trim();
                String tipo = partes[1].trim();
                int cantidad = Integer.parseInt(partes[2].trim());

                Libro libro = biblioteca.buscarPorCodigo(codigo);

                if (libro == null) {
                    System.out.println("[ERROR] Libro no encontrado: " + codigo);
                    continue;
                }

                if (tipo.equals("PRESTAMO")) {
                    // Si piden más de lo disponible, se presta hasta donde alcance
                    int aPRestar = Math.min(cantidad, libro.getEjemplaresDisponibles());
                    libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() - aPRestar);
                    variacionTotal += aPRestar;

                    if (aPRestar < cantidad) {
                        System.out.printf("[PRÉSTAMO PARCIAL] \"%s\" | Pedido: %d | Prestado: %d | Stock insuficiente%n",
                                libro.getTitulo(), cantidad, aPRestar);
                    } else {
                        System.out.printf("[PRÉSTAMO] \"%s\" | Prestado: %d | Stock restante: %d%n",
                                libro.getTitulo(), aPRestar, libro.getEjemplaresDisponibles());
                    }

                } else if (tipo.equals("DEVOLUCION")) {
                    libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles() + cantidad);
                    variacionTotal -= cantidad;
                    System.out.printf("[DEVOLUCIÓN] \"%s\" | Devuelto: %d | Stock actual: %d%n",
                            libro.getTitulo(), cantidad, libro.getEjemplaresDisponibles());

                } else {
                    System.out.println("[ERROR] Tipo desconocido: " + tipo);
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        System.out.println("\n=== RESUMEN DE PRÉSTAMOS ===");
        System.out.println("Variación neta de ejemplares prestados: " + variacionTotal);
        System.out.println("(positivo = más prestados que devueltos)");
        return variacionTotal;
    }
}