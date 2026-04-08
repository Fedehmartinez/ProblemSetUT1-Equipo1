package ucu.edu.aed.tda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Adquisiciones {

    public static double procesarArchivo(String rutaArchivo, Biblioteca biblioteca) {
        double valorTotal = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] partes = linea.split(", ");
                if (partes.length != 4) continue;

                String codigo = partes[0].trim();
                String titulo = partes[1].trim();
                double precio = Double.parseDouble(partes[2].trim());
                int cantidad = Integer.parseInt(partes[3].trim());
                Libro libro = new Libro(titulo, codigo, cantidad, precio);

                biblioteca.agregarLibro(libro);
                valorTotal += precio * cantidad;
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }

        System.out.printf("Valor total agregado al stock: $%.2f%n", valorTotal);
        return valorTotal;
    }
}
