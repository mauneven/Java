package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import interfazbrutal.Interfazbrutalbro;

public class PanelOpciones extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	private static final String CORRECTAS_POR_FILA = "CORRECTAS_POR_FILA";

	private static final String CORRECTAS_POR_COLUMNA = "CORRECTAS_POR_COLUMNA";

    private static final String OPCION_1 = "OPCION_1";
    
    private static final String OPCION_2 = "OPCION_2";

	private InterfazNonograma principal;

	private JButton btnCorrectasPorFila;

	private JButton btnCorrectasPorColumna;

	private JButton btnOpcion1;

	private JButton btnOpcion2;

	public PanelOpciones(Interfazbrutalbro pPrincipal) {
		
		principal = pPrincipal;
		
		setBorder(new TitledBorder("Opciones"));
		setLayout(new GridLayout(1, 4));
		
		btnCorrectasPorFila = new JButton("Correctas por fila");
		btnCorrectasPorFila.setActionCommand(CORRECTAS_POR_FILA);
		btnCorrectasPorFila.addActionListener(this);
		add(btnCorrectasPorFila);
		
		btnCorrectasPorColumna = new JButton("Correctas por columna");
		btnCorrectasPorColumna.setActionCommand(CORRECTAS_POR_COLUMNA);
		btnCorrectasPorColumna.addActionListener(this);
		add(btnCorrectasPorColumna);
		
        btnOpcion1 = new JButton( "Opción 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener(this);
        btnOpcion1.setEnabled(true);
        add( btnOpcion1 );

        btnOpcion2 = new JButton( "Opción 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener(this);
        add( btnOpcion2 );
		
	}

    public void actionPerformed( ActionEvent e ) {
        
        if(CORRECTAS_POR_FILA.equals(e.getActionCommand())) {
        	
        	if(!principal.hayUnArchivoSeleccionadoTablero()) {
        		
        		String mensaje = "No hay ningún juego en curso.";
        		String titulo = "Casillas correctas por fila";
        		JOptionPane.showMessageDialog(principal, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
        	}
        	else{
        		principal.calcularCorrectasPorFila();
        	}
        }
        else if(CORRECTAS_POR_COLUMNA.equals(e.getActionCommand())) {
        	
        	if(!principal.hayUnArchivoSeleccionadoTablero()) {
        		String mensaje = "No hay ningún juego en curso.";
            	String titulo = "Casillas correctas por columna";
            	JOptionPane.showMessageDialog(principal, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
        	}
        	else {
        		principal.calcularCorrectasPorColumna();
        	}
        }
        else if(OPCION_1.equals(e.getActionCommand())) {
        	
        	principal.reqFuncOpcion1();
        }
        else if(OPCION_2.equals(e.getActionCommand())) {
        	
        	principal.reqFuncOpcion2();
        }
    }
}
