package mundo;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import interfaz.InterfazNonograma;


public class MatrizTablero {

	private InterfazNonograma principal;

	public MatrizTablero(InterfazNonograma pPrincipal) {
		principal = pPrincipal;
	}

	public String[][] darListaRespuestas(String[] respuestas) {
		String[][] devolver = new String[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				char temp= respuestas[i].charAt(j);
				devolver[i][j] = String.valueOf(temp);
			}
		}
		return devolver;
	}

	public String[][] crearMatrizComparar(JButton[][] matriz){
		String[][] devolver = new String[5][5];
		
		for (int i = 2; i < 7; i++) {
			for (int j = 2; j < 7; j++) {
				if(matriz[i][j].getBackground() == Color.WHITE) {
					devolver[i-2][j-2] = "0";
				}
				else if(matriz[i][j].getBackground() == Color.BLACK) {
					devolver[i-2][j-2] = "1";
				}
			}
		}
		return devolver;
	}

	public void llenarPistasColumnas(String[] lColum, JButton[][] matriz) {
		
		int aux = 0;
		int aux2= 0;
		char agregarFila = '0';
		
		for (int i = 0; i < 2; i++) {
			for (int j = 2; j < 7; j++) {
				JButton btn = matriz[i][j];
				btn.setBackground(null);
				if(i == 0) {
					agregarFila = lColum[aux].charAt(i);
					btn.setIcon(null);
					aux++;
					btn.setText(String.valueOf(agregarFila));
					if(btn.getText().equals("0")) {
						btn.setText("");
					}
				}
				else {
					agregarFila = lColum[aux2].charAt(2);
					btn.setIcon(null);
					btn.setText(String.valueOf(agregarFila));
					if(btn.getText().equals("0")) {
						btn.setText("");
					}
					aux2++;
				}
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				JButton btn = matriz[i][j];
				btn.setIcon(null);
				btn.setBackground(null);
			}
		}
	}

	public void llenarPistasFilas(String[] lFilas, JButton[][] matriz) {
		
		int aux = 0;
		int aux2 = 0;
		char agregarColumna = '0';
		
		for (int i = 2; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				JButton btn = matriz[i][j];
				btn.setBackground(null);
				if(j == 0) {
					agregarColumna = lFilas[aux].charAt(0);
					btn.setIcon(null);
					aux++;
					btn.setText(String.valueOf(agregarColumna));
					if(btn.getText().equals("0")) {
						btn.setText("");
					}
				}
				else {
					agregarColumna = lFilas[aux2].charAt(2);
					btn.setIcon(null);
					btn.setText(String.valueOf(agregarColumna));
					if(btn.getText().equals("0")) {
						btn.setText("");
					}
					aux2++;
				}
			}
		}
	}

	public void calcularCorrectasFila() {
		
		int fila1 = 5;
		int fila2 = 5;
		int fila3 = 5;
		int fila4 = 5;
		int fila5 = 5;
		String [][]respuestas = principal.darRespuestasTablero();
		String[][] matrizUsuario = principal.darMatrizJugador();
		String temp;
		String tempUsuario;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp = respuestas[i][j];
				tempUsuario = matrizUsuario[i][j];

				if((i == 0) && (!temp.equals(tempUsuario))) {
					fila1 -= 1;
				}
				else if((i == 1) && (!temp.equals(tempUsuario))) {
					fila2 -= 1;
				}
				else if((i == 2) && (!temp.equals(tempUsuario))) {
					fila3 -= 1;
				}
				else if((i == 3) && (!temp.equals(tempUsuario))) {
					fila4 -= 1;
				}
				else if((i == 4) && (!temp.equals(tempUsuario))) {
					fila5 -= 1;
				}
			}
		}
		String mensaje = "Fila 1: " + fila1 + " casillas correctas.\n"
				+ "Fila 2: " + fila2 + " casillas correctas.\n"
						+ "Fila 3: " + fila3 + " casillas correctas.\n"
								+ "Fila 4: " + fila4 + " casillas correctas.\n"
										+ "Fila 5: " + fila5 + " casillas correctas.";
		String titulo = "Casillas correctas por fila";
		JOptionPane.showMessageDialog(principal, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		

	}

	public void calcularCorrectasColumna() {
		
		int columna1 = 5;
		int columna2 = 5;
		int columna3 = 5;
		int columna4 = 5;
		int columna5 = 5;
		String [][]respuestas = principal.darRespuestasTablero();
		String[][] matrizUsuario = principal.darMatrizJugador();
		String temp;
		String tempUsuario;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp = respuestas[i][j];
				tempUsuario = matrizUsuario[i][j];

				if((j == 0) && (!temp.equals(tempUsuario))) {
					columna1 -= 1;
				}
				else if((j == 1) && (!temp.equals(tempUsuario))) {
					columna2 -= 1;
				}
				else if((j == 2) && (!temp.equals(tempUsuario))) {
					columna3 -= 1;
				}
				else if((j == 3) && (!temp.equals(tempUsuario))) {
					columna4 -= 1;
				}
				else if((j == 4) && (!temp.equals(tempUsuario))) {
					columna5 -= 1;
				}
			}
		}
		String mensaje = "Columna 1: " + columna1 + " casillas correctas.\n"
				+ "Columna 2: " + columna2 + " casillas correctas.\n"
						+ "Columna 3: " + columna3 + " casillas correctas.\n"
								+ "Columna 4: " + columna4 + " casillas correctas.\n"
										+ "Columna 5: " + columna5 + " casillas correctas.";
		String titulo = "Casillas correctas por columna";
		JOptionPane.showMessageDialog(principal, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void compararMatrices(String[][] respuestas, String[][] generada) {
		String mensaje = "¡Felicitaciones!\nDescubrió la figura oculta:\n" + principal.darNombreProblema();
		if(Arrays.deepEquals(respuestas, generada)) {
			JOptionPane.showMessageDialog(principal, mensaje, "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public String metodo1() {
		
		return "Respuesta 1";
	}

	public String metodo2() {
		
		return "Respuesta 2";
	}
}
