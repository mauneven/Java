package com.ejerciciosV1;

import java.util.Scanner;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		float dolaresGuillermo, dolaresLuis, dolaresJuan, total;
		
		System.out.println("Digite el valor en dolares de Guillermo: ");
		
		dolaresGuillermo = entrada.nextFloat();
		dolaresLuis = dolaresGuillermo / 2;
		dolaresJuan = (dolaresGuillermo / 2)+(dolaresLuis / 2);
		total = dolaresGuillermo + dolaresJuan + dolaresLuis;
		
		System.out.println("El valor de dolares que tienen es:  \n Guillermo: "+dolaresGuillermo +"\n Luis: "+dolaresLuis+"\n Juan: "+dolaresJuan + "\n en total tienen: "+ total);
		
	}

}
