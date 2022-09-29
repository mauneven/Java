package com.ejerciciosV2;

// Un programa para determinar el mayor y el menor entre tres numeros
import javax.swing.JOptionPane; // Importa la clase JOptionPane
/**
 *
 * @author Viejo Gus
 */
public class TresNum {

    public static void main(String arg []){
        String primernum, segundonum, tercernum;
        float num1,num2,num3,may,men;
        primernum=JOptionPane.showInputDialog("Digite el primer numero: ");
        segundonum=JOptionPane.showInputDialog("Digite el segundo: ");
        tercernum=JOptionPane.showInputDialog("Digite el tercero : ");
        // Convierte los numeros del tipo String a tipo float
        num1 = Float.parseFloat(primernum);
        num2 = Float.parseFloat(segundonum);
        num3 = Float.parseFloat(tercernum);
        // Determina el mayor
        if (num1 > num2 && num1 > num3)
            may = num1;
        else if (num2 > num1 && num2>num3)
            may = num2;
        else
            may = num3;
        // Determina el menor

        if (num1<num2 && num1<num3)
            men = num1;
        else if (num2 < num1 && num2<num3)
            men = num2;
        else
        men = num3;


        if ( may !=  men)
            JOptionPane.showMessageDialog(null,"El numero mayor es "+may+"\nEl numero menor es "+men, "Resultados ",JOptionPane.PLAIN_MESSAGE);
        else

            JOptionPane.showMessageDialog(null,"Son iguales");

        System.exit(0); // Terminar el programa con la ventana



    } // Fin del metodo main
}
