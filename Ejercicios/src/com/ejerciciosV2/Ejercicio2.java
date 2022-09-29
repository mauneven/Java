package com.ejerciciosV2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int a[], b[], c[];

        a = new int[10];
        b = new int[10];
        c = new int[20];

        System.out.println("Digite el primer arreglo: ");

        for (int i = 0; i < 10; i++) {

            System.out.print(i + ". Digite un numero: ");
            a[i] = entrada.nextInt();


        }

        System.out.print("\nDigite el segundo arreglo: ");

        for (int i = 0; i < 10; i++) {

            System.out.print(i + ". Digite un numero: ");
            b[i] = entrada.nextInt();


        }

        int j = 0;

        for (int i = 0; i < 10; i++) {
            c[j] = a[i];
            j++;
            c[j] = b[i];
            j++;

        }

        System.out.println("\nEl tercer arreglo es: ");
        for (int i = 0; i < 20  ; i++) {

            System.out.print(c[i] + " ");

        }

    }

}
