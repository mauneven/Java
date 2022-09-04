package uniandes.cupi2.nonogramas.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTablero extends JPanel implements ActionListener
{
	public final static String C = "Cargar";
	public final static String R = "Reiniciar";
	
	private PanelNono pNono;
	private JPanel carga;
	private JButton cargar;
	private JButton reiniciar;
	private InterfazNonograma principal;
	
	public PanelTablero(InterfazNonograma pPrincipal)
	{
		principal = pPrincipal;
		setLayout(new BorderLayout());
		
		pNono = new PanelNono(principal);	
		carga = new JPanel();
		carga.setLayout(new GridLayout(1,2));
		carga.setBorder(BorderFactory.createTitledBorder("Nuevo juego"));
		
		cargar = new JButton(C);	
		cargar.addActionListener(this);
		cargar.setActionCommand(C);
		reiniciar = new JButton(R);
		reiniciar.addActionListener(this);
		reiniciar.setActionCommand(R);
		carga.add(cargar);
		carga.add(reiniciar);

		add(pNono, BorderLayout.CENTER);
		add(carga, BorderLayout.SOUTH);

		setVisible(true);
	}
	
	public void actualizarBotones()
	{
		pNono.actualizarBotones();
	}
	
	public void reiniciarBotones()
	{
		pNono.reiniciarBotones();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if (comando.equals(C))
		{
			principal.cargarJuego();
		}
		else if(comando.equals(R))
		{
			principal.reiniciarNonograma();
		}
	}
}
