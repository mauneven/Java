package com.ejerciciosV1;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		double a,b,c,pos,neg;
		
		System.out.println("digite el valor de a: ");
		a = entrada.nextDouble();
		
		System.out.println("digite el valor de b: ");
		b = entrada.nextDouble();
		
		System.out.println("digite el valor de c: ");
		c = entrada.nextDouble();
		
		pos = (-b + Math.sqrt((Math.pow(b, 2) - 4*a*c)) / 2*a);
		neg = (-b - Math.sqrt((Math.pow(b, 2) - 4*a*c)) / 2*a);
		
		System.out.println("El resultado positivo es: " + pos);
		System.out.println("El resultado negativo es: " + neg);


		
	}

}
