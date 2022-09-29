package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import interfazbrutal.Interfazbrutalbro;

public class PanelTablero extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private static final String CARGAR = "CARGAR";

	private static final String REINICIAR = "REINICIAR";

	private InterfazNonograma principal;

	private JPanel panelOpcionesCentro;

	private BotonesCentro panelCentroBoton;

	private JButton btnCargar;

	private JButton btnReiniciar;

	private File archivoElegido;

	private File archivoActual;

	private Properties archivoProperties;

	private String nombreProblema;

	private String[] kPistasColumnas;

	private String[] kPistasFilas;

	private String[] respuestas;

	public PanelTablero(Interfazbrutalbro pPrincipal) {
		
		principal = pPrincipal;
		archivoElegido = null;
		archivoActual = null;
		archivoProperties = new Properties();
		
		nombreProblema = null;
		kPistasColumnas = new String[5];
		kPistasFilas = new String[5];
		respuestas = new String[5];
		
		setLayout(new BorderLayout());
		
		panelCentroBoton = new BotonesCentro(pPrincipal);
		add(panelCentroBoton,BorderLayout.CENTER);
		
		
		panelOpcionesCentro = new JPanel();
		add(panelOpcionesCentro, BorderLayout.SOUTH);
		
		panelOpcionesCentro.setLayout(new GridLayout(1,2));
		panelOpcionesCentro.setBorder(new TitledBorder("Nuevo juego"));
		
		btnCargar = new JButton("Cargar");
		btnCargar.setActionCommand(CARGAR);
		btnCargar.addActionListener(this);
		panelOpcionesCentro.add(btnCargar);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setActionCommand(REINICIAR);
		btnReiniciar.addActionListener(this);
		panelOpcionesCentro.add(btnReiniciar);
		
	}

	public String[] darRespuestasTablero() {
		return respuestas;
	}

	public JButton[][] darMatrizJugador() {
		return panelCentroBoton.darMatriz();
	}

	public String darNombreProblema() {
		return nombreProblema;
	}

	public void llenarListasValores(Properties archivo) {
		
		int aux = 1;
		for (int i = 0; i < 5; i++) {
			
			String kPColumna = "nonograma.pistasColumna" + String.valueOf(aux);
			String kPFila = "nonograma.pistasFila" + String.valueOf(aux);
			String rFila = "nonograma.tableroFila" + String.valueOf(aux);
			
			kPistasColumnas[i] = archivo.getProperty(kPColumna);
			kPistasFilas[i] = archivo.getProperty(kPFila);
			respuestas[i] = archivo.getProperty(rFila);			aux ++;
		}
	}

	public boolean hayUnArchivoSeleccionado() {
		
		boolean devolver = false;
		if(archivoActual != null) {
			devolver = true;
		}
		return devolver;
	}

	public void seleccionarArchivo() {
		JFileChooser fc = new JFileChooser("data");
		int respuesta = fc.showOpenDialog(principal);
		String mensaje = "";
		String titulo;
		String aComparar = "properties";
		
		if(respuesta == JFileChooser.CANCEL_OPTION) {
			mensaje = "Debe seleccionar un archivo de configuración para poder jugar.";
			titulo = "Empezar a jugar";
			JOptionPane.showMessageDialog(principal, mensaje, titulo, JOptionPane.WARNING_MESSAGE );
		}
		else if(respuesta == JFileChooser.APPROVE_OPTION) {
			archivoElegido = fc.getSelectedFile();
			String path = archivoElegido.getPath();
			
			String extension = "";
			int i = path.lastIndexOf('.');
			extension = path.substring(i+1);
			
			if(!extension.equals(aComparar)) {
				mensaje = "El archivo no tiene el formato esperado.";
				titulo = "Error al cargar el juego";
				JOptionPane.showMessageDialog(principal, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
				
				if(!hayUnArchivoSeleccionado()) {
					archivoElegido = null;
				}
			}
			else {
				archivoActual = archivoElegido;
				try {
					archivoProperties.load(new FileReader(archivoActual));
					nombreProblema = archivoProperties.getProperty("nonograma.nombreProblema");
					llenarListasValores(archivoProperties);
					principal.llenarPistasColumnas(kPistasColumnas,panelCentroBoton.darMatriz());
					principal.llenarPistasFilas(kPistasFilas,panelCentroBoton.darMatriz());
				} catch (IOException e) {
					e.printStackTrace();
				}
				panelCentroBoton.habilitarBotones();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		
		if(CARGAR.equals(e.getActionCommand())) {
			seleccionarArchivo();
		}
		else if(REINICIAR.equals(e.getActionCommand())) {
			
			if(archivoElegido == null) {
				String mensaje = "No hay ningún juego en curso.";
				String titulo = "Reiniciar el juego";
				JOptionPane.showMessageDialog(principal, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
			}
			else {
				panelCentroBoton.fBtnReiniciar();
			}
		}	
	}
}
