package com.ejerciciosV1;

import java.util.Scanner;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int horasSemanales;
		float salarioHora, salarioTotal;
		
		System.out.println("Digite las horas semanales trabajadas: ");
		horasSemanales = entrada.nextInt();
		System.out.println("Digite el salario que gana por hora: ");
		salarioHora = entrada.nextFloat();
		
		salarioTotal = horasSemanales * salarioHora;
		
		System.out.println("\n El salario semanal es: "+salarioTotal);
		
		
	}

}
