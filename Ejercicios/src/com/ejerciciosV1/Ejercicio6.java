package com.ejerciciosV1;

import java.util.Scanner;

public class Ejercicio6 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		double a,b, resultado;
		
		System.out.println("Digite el valor de a ");
		a = entrada.nextDouble();
		
		System.out.println("Digite el valor de b ");
		b = entrada.nextDouble();
		
		resultado = Math.pow(a, 2) + Math.pow(b, 2) + 2*a*b;
		
		System.out.print("Su resultado es: " + resultado);
		
	}

}
