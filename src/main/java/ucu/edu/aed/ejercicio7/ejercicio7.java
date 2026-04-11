package ucu.edu.aed.ejercicio7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio7 {
    public static void main(String[] args) {

        String archivo = "numeros.txt";
        int N = 0;
        int[] a = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            N = Integer.parseInt(br.readLine());
            a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            return;
        }

        int contadorIf = 0;
        int intercambios = 0;

        for (int i = 1; i <= N - 1; i++) {
            for (int j = N - 1 ; j >= i; j--) {

                contadorIf++;

                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    intercambios++;
                }
            }
        }

        System.out.println("Valor de N: " + N);
        System.out.println("Cantidad de veces que se evaluó el if: " + contadorIf);
        System.out.println("Cantidad de intercambios: " + intercambios);

        if (N > 0) {
            System.out.println("Primer elemento: " + a[0]);
            System.out.println("Último elemento: " + a[N - 1]);
        }
    }
}