package com.ejerciciosV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Ejercicio1 extends JFrame implements ActionListener {
    public Ejercicio1() {

        setLayout(null);
        setSize(500,500);
        setTitle("Hallar el voltaje, intesidad o resistencia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        char opc;
        float v, i, r;

        JButton voltaje = new JButton();
        voltaje.setBounds(200,100,100,50);
        voltaje.setText("VOLTAJE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridLayout (3,1));
        this.setSize(500,500);
        this.add(voltaje);
        this.setTitle("VOLTAJE");


        JButton resistencia = new JButton();
        resistencia.setBounds(200,100,100,50);
        resistencia.setText("RESISTENCIA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridLayout (3,1));
        this.setSize(500,500);
        this.add(resistencia);
        this.setTitle("RESISTENCIA");

        JButton corriente = new JButton();
        corriente.setBounds(200,100,100,50);
        corriente.setText("CORRIENTE");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridLayout (3,1));
        this.setSize(500,500);
        this.add(corriente);
        this.setTitle("CORRIENTE");

        Scanner entrada = new Scanner(System.in);

        System.out.println("LEY DE OHM \n V Voltaje (Voltios) \n I Intensidad (Amperios) \n R Resistencia (Ohmios)");

    }

    public static void main(String[] args) {

        Ejercicio1 ejercicio1 = new Ejercicio1();
        ejercicio1.setVisible( true );

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
