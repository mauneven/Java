package uniandes.cupi2.nonogramas.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.cupi2.nonogramas.mundo.Casilla;
import uniandes.cupi2.nonogramas.mundo.Nonograma;

public class PanelNono extends JPanel implements ActionListener
{
	private JButton[][] matriz;
	private String rutImagenV;
	private ImageIcon vacia;
	private String rutImagenM;
	private ImageIcon marcada;
	private Casilla[][] respuestas;
	private InterfazNonograma terfaz;

	public PanelNono(InterfazNonograma pPrincipal)
	{
		terfaz = pPrincipal;
		matriz = new JButton[7][7];
		rutImagenV = "data/imagenes/casilla_blanco.jpg";
		vacia = new ImageIcon(rutImagenV);
		rutImagenM = "data/imagenes/casilla_rellena.png";
		marcada = new ImageIcon(rutImagenM);
		//enBlanco = new ImageIcon(enBlanco.getImage().getScaledInstance(56, 50, Image.SCALE_DEFAULT));
		setLayout(new GridLayout(7,7));
		setBorder(BorderFactory.createTitledBorder("Tablero juego"));

		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0; j < matriz[i].length; j++)
			{
				matriz[i][j] = new JButton();
				(matriz[i][j]).setIcon(vacia);
				(matriz[i][j]).setEnabled(false);
				(matriz[i][j]).addActionListener(this);
				(matriz[i][j]).setActionCommand(i+","+j);
				add(matriz[i][j]);
			}
		}
	}

	public JButton[][] darMatriz()
	{
		return matriz;
	}

	public void actualizarBotones()
	{
		Nonograma elNono = terfaz.darNono();
		respuestas = elNono.darRespuestas();
		int pista;
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				matriz[i][j].setIcon(null);
			}
		}
		for (int i = 0; i < 2; i++)
		{
			for (int j = 2; j < 7; j++)
			{
				matriz[i][j].setIcon(null);
				pista = elNono.darPistasC()[i][j-2].getPista();
				(matriz[i][j]).setText(pista+"");
				if (pista == 0)
				{
					(matriz[i][j]).setText("");
				}
			}
		}
		for (int i = 2; i < 7; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				matriz[i][j].setIcon(null);
				pista = elNono.darPistasF()[i-2][j].getPista();
				(matriz[i][j]).setText(pista+"");
				if (pista == 0)
				{
					(matriz[i][j]).setText("");
				}
			}
		}
		for (int i = 2; i < 7; i++)
		{
			for (int j = 2; j < 7; j++)
			{
				(matriz[i][j]).setEnabled(true);
			}
		}
	}

	public void voltearCara(JButton btn, Casilla csll)
	{
		if (!csll.isEstActual())
		{
			csll.setEstActual(true);
			btn.setIcon(marcada);
			btn.setBackground(Color.BLACK);
		}
		else
		{
			csll.setEstActual(false);
			btn.setIcon(vacia);
			btn.setBackground(Color.WHITE);
		}
	}
	
	public void reiniciarBotones()
	{
		respuestas = terfaz.darNono().darRespuestas();
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				voltearCara(matriz[i+2][j+2], respuestas[i][j]);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		boolean found = false;
		for (int i = 2; i < 7 && !found; i++)
		{
			for (int j = 2; j < 7 && !found; j++)
			{
				if (comando.equals(i+","+j))
				{
					found = true;
					voltearCara(matriz[i][j], respuestas[i-2][j-2]);
				}
			}
		}
		terfaz.estaResuelto();
	}
}
