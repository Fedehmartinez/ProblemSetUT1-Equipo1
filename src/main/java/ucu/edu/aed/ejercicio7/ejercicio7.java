package ucu.edu.aed.ejercicio7;

import java.io.File;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("numeros.txt"));

            int N = sc.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
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

            System.out.println("N: " + N);
            System.out.println("Ifs: " + contadorIf);
            System.out.println("Intercambios: " + intercambios);
            System.out.println("Primero: " + a[0]);
            System.out.println("Ultimo: " + a[N - 1]);

            sc.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
    }
}