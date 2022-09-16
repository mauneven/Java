package interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.MatrizTablero;


public class InterfazNonograma extends JFrame{
	

	private static final long serialVersionUID = 1L;

	private MatrizTablero tablero;
	private Arriba panelImagenTitulo;
	private Derecha panelImagenDerecha;

	private Izquierda panelImagenIzquierda;
	private PanelOpciones panelOpciones;
	private PanelTablero panelTablero;

	public InterfazNonograma() {
		
		tablero = new MatrizTablero(this);
		
		getContentPane().setLayout(new BorderLayout());
		setSize(840,710);
		setResizable(false);
		setTitle("Nonogramas");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelImagenTitulo = new Arriba();
		add(panelImagenTitulo, BorderLayout.NORTH);
		
		panelImagenDerecha = new Derecha();
		add(panelImagenDerecha, BorderLayout.EAST);
		
		panelImagenIzquierda = new Izquierda();
		add(panelImagenIzquierda, BorderLayout.WEST);
		
		panelOpciones = new PanelOpciones(this);
		add(panelOpciones, BorderLayout.SOUTH);
		
		panelTablero = new PanelTablero(this);
		add(panelTablero, BorderLayout.CENTER);
	}
	
	public boolean hayUnArchivoSeleccionadoTablero() {
		return panelTablero.hayUnArchivoSeleccionado();
	}

	public String[][] darRespuestasTablero() {
		return tablero.darListaRespuestas(panelTablero.darRespuestasTablero());
	}

	public String darNombreProblema() {
		return panelTablero.darNombreProblema();
	}

	public String[][] darMatrizJugador(){
		return tablero.crearMatrizComparar(panelTablero.darMatrizJugador());
	}

	public void calcularCorrectasPorFila() {
		tablero.calcularCorrectasFila();
	}

	public void calcularCorrectasPorColumna() {
		tablero.calcularCorrectasColumna();
	}
	
	public void llenarPistasColumnas(String[] lColumn, JButton[][] matriz) {
		tablero.llenarPistasColumnas(lColumn, matriz);
	}
	
	public void llenarPistasFilas(String[] lFilas, JButton[][] matriz) {
		tablero.llenarPistasFilas(lFilas, matriz);
	}

	public void compararMatrices() {
		tablero.compararMatrices(darRespuestasTablero(),darMatrizJugador());
	}
	
	public void reqFuncOpcion1() {
		
		String devolver = tablero.metodo1();
		JOptionPane.showMessageDialog(this, devolver, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void reqFuncOpcion2() {
		
		String devolver = tablero.metodo2();
		JOptionPane.showMessageDialog(this, devolver, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) {
		
		InterfazNonograma ventana = new InterfazNonograma();
		ventana.setVisible(true);
	}
}
