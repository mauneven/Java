package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BotonesCentro extends JPanel implements ActionListener{
	

	private static final long serialVersionUID = 1L;

	private static final int numFilas = 7;

	private static final int numColumnas = 7;

	private InterfazNonograma principal;

	private JButton matriz[][];

	private ArrayList<JButton> arrayBotones;

	private String rutaImagen;

	public BotonesCentro(InterfazNonograma pPrincipal) {
		
		principal = pPrincipal;
		matriz = new JButton[numFilas][numColumnas];
		arrayBotones = new ArrayList<>();
		rutaImagen = "data/imagenes/casilla_blanco.jpg";
		ImageIcon icono = new ImageIcon(rutaImagen);
		icono = new ImageIcon(icono.getImage().getScaledInstance(56, 50, Image.SCALE_DEFAULT));
		
		setLayout(new GridLayout(7,7));
		setBorder(new TitledBorder("Tablero juego"));
		
		int numBotones = 0;
		for (int i = 0; i < numFilas; i++) {
			
			for (int j = 0; j < numColumnas; j++) {
				JButton boton = new JButton();
				boton.setActionCommand(String.valueOf(numBotones));
				boton.addActionListener(this);
				boton.setIcon(icono);
				boton.setBackground(Color.LIGHT_GRAY);
				boton.setEnabled(false);
				matriz[i][j] = boton;
				arrayBotones.add(boton);
				add(boton);
				
				numBotones++;
			}
			
		}
		
	}

	public JButton[][] darMatriz() {
		return matriz;
	}

	public void habilitarBotones() {

		for (int i = 2; i < 7; i++) {
			
			for (int j = 2; j < 7; j++) {
				matriz[i][j].setEnabled(true);
				establecerCasillaBlanca(matriz[i][j]);
				matriz[i][j].setBackground(Color.WHITE);
			}
		}
	}

	public void establecerCasillaBlanca(JButton boton) {
		
		rutaImagen = "data/imagenes/casilla_blanco.jpg";
		ImageIcon icono = new ImageIcon(rutaImagen);
		icono = new ImageIcon(icono.getImage().getScaledInstance(56, 50, Image.SCALE_DEFAULT));
		boton.setIcon(icono);
		boton.setBackground(Color.WHITE);
	}

	public void establecerCasillaRellena(JButton boton) {
		
		rutaImagen = "data/imagenes/casilla_rellena.png";
		ImageIcon icono = new ImageIcon(rutaImagen);
		icono = new ImageIcon(icono.getImage().getScaledInstance(56, 50, Image.SCALE_DEFAULT));
		boton.setIcon(icono);
		boton.setBackground(Color.BLACK);
	}
	
	public void cambiarImagenBoton(JButton boton) {
		
		if(boton.getBackground() == Color.WHITE) {
			establecerCasillaRellena(boton);
		}
		else if(boton.getBackground() == Color.BLACK) {
			establecerCasillaBlanca(boton);
		}
	}

	public void fBtnReiniciar() {
		
		for (int i = 2; i < 7; i++) {
			
			for (int j = 2; j < 7; j++) {
				JButton boton = matriz[i][j];
				establecerCasillaBlanca(boton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		boolean terminoBotones = false;
		for (int i = 0; i < arrayBotones.size() && !terminoBotones; i++) {
			if(String.valueOf(i).equals(e.getActionCommand())) {
				cambiarImagenBoton(arrayBotones.get(i));
				principal.compararMatrices();
				terminoBotones = true;
			}
		}
	}
}
