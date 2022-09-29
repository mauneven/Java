package com.ejerciciosV1;

import java.util.Scanner;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		final int salario = 1000;
		int  nCarroVendido;
		float salarioTotal, ventaPorCarro;
		
		System.out.println("Cuantos carros vendió el empleado: ");
		nCarroVendido = entrada.nextInt();
		
		System.out.println("Que precio tenia cada venta de los carros: ");
		ventaPorCarro = (entrada.nextFloat()) * 0.05f * nCarroVendido;
		
		salarioTotal = salario + nCarroVendido*150 + ventaPorCarro;
		
		System.out.println(ventaPorCarro);
		
		System.out.println("El salario total del empleado es: "+ salarioTotal);
	}

}
