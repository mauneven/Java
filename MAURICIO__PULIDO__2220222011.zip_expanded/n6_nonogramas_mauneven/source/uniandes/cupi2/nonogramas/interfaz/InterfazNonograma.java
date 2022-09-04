package uniandes.cupi2.nonogramas.interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.nonogramas.mundo.Nonograma;

public class InterfazNonograma extends JFrame
{
	private JPanel pBanner;
	private JPanel pIzq;
	private JPanel pDer;
	private PanelOpciones pOpciones;
	private PanelTablero pTablero;
	private Nonograma nono;

	public InterfazNonograma()
	{	
		nono = new Nonograma();

		setTitle("Nonograma");
		setSize(820, 700);
		setResizable(false);
		setTitle("Nonogramas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout(10,10));
		setLocationRelativeTo(null);

		pBanner = new JPanel();
		pIzq = new JPanel();
		pDer = new JPanel();
		pOpciones = new PanelOpciones(this);
		pTablero = new PanelTablero(this);

		JLabel banner = new JLabel();
		ImageIcon iconoB = new ImageIcon("./data/imagenes/titulo.jpg");
		banner.setIcon(iconoB);		
		pBanner.add(banner);

		JLabel izq = new JLabel();
		ImageIcon iconoI = new ImageIcon("./data/imagenes/izquierda.jpg");
		izq.setIcon(iconoI);		
		pIzq.add(izq);

		JLabel der = new JLabel();
		ImageIcon iconoD = new ImageIcon("./data/imagenes/derecha.jpg");
		der.setIcon( iconoD );		
		pDer.add(der);

		add(pBanner, BorderLayout.NORTH);
		add(pIzq, BorderLayout.WEST);
		add(pDer, BorderLayout.EAST);
		add(pOpciones, BorderLayout.SOUTH);
		add(pTablero, BorderLayout.CENTER);

		setVisible(true);
	}

	public Nonograma darNono()
	{
		return nono;
	}

	public void cargarJuego()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("./data"));
		chooser.setDialogTitle("Seleccionar archivo");
		chooser.setFileSelectionMode(0);
		chooser.setVisible(true);
		if (chooser.showOpenDialog(this) == 0)
		{
			try
			{
				Properties myProp = new Properties();
				FileInputStream fis = new FileInputStream(chooser.getSelectedFile());
				myProp.load(fis);
				nono.cargarNono(myProp);
				reiniciarNonograma();
				nono.leerInfo();
				pTablero.actualizarBotones();
				fis.close();
				validate();
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, nono.ERROR_CARGAR, "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void reiniciarNonograma()
	{
		nono.reiniciarNonograma();
		pTablero.reiniciarBotones();
	}
	
	public void estaResuelto()
	{
		String mensaje = "¡Felicitaciones!\nDescubrió la figura oculta:\n" + nono.getNombreReto();
		if(nono.estaResuelto())
		{
			JOptionPane.showMessageDialog(this, mensaje, "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void correctasFilas()
	{
		String title = "Casillas correctas por fila";
		try
		{
			JOptionPane.showMessageDialog(this, nono.correctasFila(), title, JOptionPane.INFORMATION_MESSAGE);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), title, JOptionPane.ERROR_MESSAGE);
		}
	}

	public void correctasColumnas()
	{
		String title = "Casillas correctas por columna";
		try
		{
			JOptionPane.showMessageDialog(this, nono.correctasColumna(), title, JOptionPane.INFORMATION_MESSAGE);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage(), title, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void opcion1()
	{
		String mensaje = "Esta es la opción 1";
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void opcion2()
	{
		String mensaje = "Esta es la opción 2";
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public static void main(String[] args)
	{
		InterfazNonograma ventana = new InterfazNonograma();
	}
}
