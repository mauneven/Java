package uniandes.cupi2.nonogramas.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener
{
	public final static String CPF = "Correctas por filas";
	public final static String CPC = "Correctas por columnas";
	public final static String O1 = "Opción 1";
	public final static String O2 = "Opción 2";
	
	private InterfazNonograma terfaz;
	private JButton cpFilas;
	private JButton cpColumnas;
	private JButton opc1;
	private JButton opc2;
	
	
	public PanelOpciones(InterfazNonograma pInterfaz)
	{
		setLayout(new GridLayout(1,4));
		setBorder(BorderFactory.createTitledBorder("Opciones"));
		
		terfaz = pInterfaz;
		
		cpFilas = new JButton(CPF);
		cpColumnas = new JButton(CPC);
		opc1 = new JButton(O1);
		opc2 = new JButton(O2);
		
		cpFilas.addActionListener(this);
		cpFilas.setActionCommand(CPF);
		cpColumnas.addActionListener(this);
		cpColumnas.setActionCommand(CPC);
		opc1.addActionListener(this);
		opc1.setActionCommand(O1);
		opc2.addActionListener(this);
		opc2.setActionCommand(O2);
		
		add(cpFilas);
		add(cpColumnas);
		add(opc1);
		add(opc2);
	}

	@Override
	public void actionPerformed(ActionEvent pEvento)
	{
		if (pEvento.getActionCommand().equals(CPC))	
		{
			terfaz.correctasColumnas();
		}
		else if (pEvento.getActionCommand().equals(CPF)) 
		{
			terfaz.correctasFilas();	
		}
		else if (pEvento.getActionCommand().equals(O1)) 
		{
			terfaz.opcion1();
		} 
		else if (pEvento.getActionCommand().equals(O2))
		{
			terfaz.opcion2();
		}
	}
}
