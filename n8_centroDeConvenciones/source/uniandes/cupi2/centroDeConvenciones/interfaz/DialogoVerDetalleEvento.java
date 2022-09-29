/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot? - Colombia)
 * Departamento de Ingenier?a de Sistemas y Computaci?n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_centroDeConvenciones
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.centroDeConvenciones.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.centroDeConvenciones.mundo.Espacio;
import uniandes.cupi2.centroDeConvenciones.mundo.Evento;

/**
 * Di?logo que permite ver el detalle de un evento.
 */
public class DialogoVerDetalleEvento extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la acci?n de aceptar.
     */
    public final static String ACEPTAR = "Aceptar";
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci?n.
     */
    private InterfazCentroDeConvenciones principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del evento.
     */
    private JLabel etiquetaImagen;
    
    /**
     * Campo de texto con el nombre.
     */
    private JTextField txtNombre;
    
    /**
     * Campo de texto con la cantidad de asistentes.
     */
    private JTextField txtAsistentes;

    /**
     * Campo de texto con la fecha de un evento.
     */
    private JTextField txtFecha;

    /**
     * ?rea de texto con la descripci?n del evento.
     */
    private JTextArea areaDescripcion;

    /**
     * Panel con un scroll que contiene a areaDescripcion.
     */
    private JScrollPane scrollDescripcion; 

    /**
     * Bot?n Cancelar.
     */
    private JButton btnAceptar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del di?logo.
     * @param pPrincipal Ventana principal de la aplicaci?n. pPrincipal != null.
     * @param pEvento Evento del que se desea visualizar el detalle. pEvento != null.
     */
    public DialogoVerDetalleEvento( InterfazCentroDeConvenciones pPrincipal, Evento pEvento )
    {
        principal = pPrincipal;

        setTitle( "Ver informaci?n del evento" );
        setSize( 350, 500 );
        setResizable(false);
        setLayout( new BorderLayout( ) );

        setLocationRelativeTo( null );

        JPanel panelImagen = new JPanel( );
        panelImagen.setLayout( new BorderLayout( ) );
        panelImagen.setPreferredSize( new Dimension( 200, 200 ) );
        panelImagen.setBorder( new EmptyBorder( 0, 0, 0, 5 ) );
        panelImagen.setBackground( new Color( 239, 250, 252 ) );
        panelImagen.setBorder( new LineBorder( Color.BLACK ) );

        etiquetaImagen = new JLabel( );
        etiquetaImagen.setPreferredSize( new Dimension( 150, 0 ) );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagen.setIcon( new ImageIcon( pEvento.darRutaImagenPublicidad( ) ) );

        panelImagen.add( etiquetaImagen );
        add( panelImagen, BorderLayout.NORTH );
        
        JPanel panelInfo1 = new JPanel( );
        panelInfo1.setLayout( new GridLayout( 6, 1 ) );
        panelInfo1.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        JLabel etiquetaNombre = new JLabel( " Nombre:" );
        panelInfo1.add( etiquetaNombre );
        txtNombre = new JTextField( pEvento.darNombre( ) );
        txtNombre.setEditable( false );
        panelInfo1.add( txtNombre );
        
        JLabel etiquetaAsistentes = new JLabel( " Cantidad de asistentes:" );
        panelInfo1.add( etiquetaAsistentes );
        txtAsistentes = new JTextField( pEvento.darCantidadAsistentes( )+ "" );
        txtAsistentes.setEditable( false );
        panelInfo1.add( txtAsistentes );
        
        JLabel etiquetaFecha = new JLabel( " Fecha:" );
        panelInfo1.add( etiquetaFecha );
        txtFecha = new JTextField( pEvento.darFecha( ) +"" );
        txtFecha.setEditable( false );
        panelInfo1.add( txtFecha );
        
        add( panelInfo1, BorderLayout.CENTER );
        
        JPanel panelInfo2= new JPanel();
        panelInfo2.setLayout(new BorderLayout());

        areaDescripcion = new JTextArea( );
        areaDescripcion.setEditable( false );
        areaDescripcion.setLineWrap( true );
        areaDescripcion.setText( pEvento.darDescripcion( ) );

        scrollDescripcion = new JScrollPane( areaDescripcion );
        scrollDescripcion.setPreferredSize( new Dimension( 0, 130 ) );
        scrollDescripcion.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scrollDescripcion.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scrollDescripcion.setBorder( new TitledBorder( "Descripci?n: " ) );
        
        
        JPanel panelDescripcion = new JPanel( );
        panelDescripcion.setLayout( new BorderLayout( ) );
        panelDescripcion.add( scrollDescripcion, BorderLayout.NORTH );

        
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        
        panelInfo2.add( panelDescripcion, BorderLayout.NORTH );
        panelInfo2.add( btnAceptar, BorderLayout.CENTER );
        add( panelInfo2, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci?n que gener? el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        
        if( comando.equals( ACEPTAR ) )
        {
            dispose( );
        }
    }

}
