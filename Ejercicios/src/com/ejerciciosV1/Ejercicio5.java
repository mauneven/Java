package com.ejerciciosV1;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		System.out.println("**Bienvenido al informador de notas**");

		Scanner entrada = new Scanner(System.in);
		float participacion, p1, p2, ef, notaFinal;
		
		System.out.print("Cuanto sacó el estudiante en participación: ");
		participacion = entrada.nextFloat() * 0.1f;
		
		System.out.print("Cuanto sacó el estudiante en el primer parcial: ");
		p1 = entrada.nextFloat() * 0.25f;
		
		System.out.print("Cuanto sacó el estudiante en el segundo parcial: ");
		p2 = entrada.nextFloat() * 0.25f;
		
		System.out.print("Cuanto sacó el estudiante en el examen final: ");
		ef = entrada.nextFloat() * 0.4f;
		
		notaFinal = participacion + p1 + p2 + ef;
		
		System.out.println("La nota final del estudiante es: " + notaFinal);
		
		
		
	}
	
}
