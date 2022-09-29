package com.ejerciciosV1;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		int horasTotales, semanas, dias, horas;
		
		System.out.println("Digite el numero total de horas: ");
		horasTotales = entrada.nextInt();
		
		semanas = horasTotales / 168;
		
		dias = horasTotales%168 / 24;
		
		horas = horasTotales%24;
		
		System.out.println("Han pasado "+semanas+" semanas, " +dias +" dias y " +horas+" horas");
		
	}
	
}
