package interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Izquierda extends JPanel{

	private static final long serialVersionUID = 1L;

	public Izquierda() {
		
		ImageIcon icono = new ImageIcon("data/imagenes/izquierda.jpg");
		setSize(icono.getIconHeight(), icono.getIconWidth());
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(icono);
		add(imagen);
		
		setBackground(Color.WHITE);
		imagen.setBorder(new LineBorder(Color.GRAY));
	}
}
