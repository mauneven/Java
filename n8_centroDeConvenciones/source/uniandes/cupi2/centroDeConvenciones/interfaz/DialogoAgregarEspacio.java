/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_centroDeConvenciones
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.centroDeConvenciones.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.centroDeConvenciones.mundo.Espacio;

/**
 * Diálogo que permite agregar un nuevo espacio al centro de convenciones.
 */
public class DialogoAgregarEspacio extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Agregar.
     */
    private final static String AGREGAR = "Agregar";

    /**
     * Comando Cancelar.
     */
    private final static String CANCELAR = "Cancelar";

    /**
     * Comando Seleccionar imagen.
     */
    private final static String SELECCIONAR = "...";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCentroDeConvenciones principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto con la imagen del espacio.
     */
    private JTextField txtImagen;

    /**
     * Campo de texto con el nombre del espacio.
     */
    private JTextField txtNombre;

    /**
     * Combo box con los tipos de espacio.
     */
    private JComboBox comboTipo;

    /**
     * Campo de texto con la capacidad del espacio.
     */
    private JTextField txtCapacidad;

    /**
     * Campo de texto con el costo por hora del espacio.
     */
    private JTextField txtCostoHora;

    /**
     * Campo de texto con el tamaño del espacio.
     */
    private JTextField txtTamanio;

    /**
     * Campo de texto con el nombre del responsable.
     */
    private JTextField txtNombreResponsable;

    /**
     * Caja de chequeo que indica si tiene internet el espacio.
     */
    private JCheckBox chkInternet;

    /**
     * Botón Agregar.
     */
    private JButton btnAgregar;

    /**
     * Botón Cancelar.
     */
    private JButton btnCancelar;

    /**
     * Botón Seleccionar Imagen.
     */
    private JButton btnSeleccionar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarEspacio( InterfazCentroDeConvenciones pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );
        setSize( 320, 270 );
        setLocationRelativeTo( null );
        setTitle( "Agregar espacio" );

        JPanel panelInfo1 = new JPanel( );
        panelInfo1.setLayout( new GridLayout( 8, 2 ) );

        panelInfo1.add( new JLabel( " Nombre: " ) );
        txtNombre = new JTextField( );
        panelInfo1.add( txtNombre );

        panelInfo1.add( new JLabel( " Tipo: " ) );
        comboTipo = new JComboBox( );
        comboTipo.addItem( Espacio.TIPO_AIRE_LIBRE );
        comboTipo.addItem( Espacio.TIPO_AUDITORIO );
        comboTipo.addItem( Espacio.TIPO_RESTAURANTE );
        comboTipo.addItem( Espacio.TIPO_SALA_COMPUTO );
        comboTipo.addItem( Espacio.TIPO_SALON );
        panelInfo1.add( comboTipo );

        panelInfo1.add( new JLabel( " Capacidad: " ) );
        txtCapacidad = new JTextField( );
        panelInfo1.add( txtCapacidad );

        panelInfo1.add( new JLabel( " Precio por hora: " ) );
        txtCostoHora = new JTextField( );
        panelInfo1.add( txtCostoHora );

        panelInfo1.add( new JLabel( " Tamaño (m2): " ) );
        txtTamanio = new JTextField( );
        panelInfo1.add( txtTamanio );

        panelInfo1.add( new JLabel( " Nombre del responsable: " ) );
        txtNombreResponsable = new JTextField( );
        panelInfo1.add( txtNombreResponsable );

        JLabel etiquetaTiempo = new JLabel( "¿Tiene internet?" );
        etiquetaTiempo.setHorizontalAlignment( JLabel.LEFT );
        panelInfo1.add( etiquetaTiempo );
        chkInternet = new JCheckBox( "" );
        panelInfo1.add( chkInternet );

        JPanel aux = new JPanel( );
        aux.setLayout( new BorderLayout( ) );

        panelInfo1.add( new JLabel( " Imagen: " ) );
        txtImagen = new JTextField( );
        txtImagen.setEditable( false );
        aux.add( txtImagen, BorderLayout.CENTER );
        btnSeleccionar = new JButton( SELECCIONAR );
        btnSeleccionar.setActionCommand( SELECCIONAR );
        btnSeleccionar.addActionListener( this );
        btnSeleccionar.setPreferredSize( new Dimension( 50, 0 ) );
        aux.add( btnSeleccionar, BorderLayout.EAST );

        panelInfo1.add( aux );
        add( panelInfo1, BorderLayout.NORTH );

        btnAgregar = new JButton( AGREGAR );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        btnCancelar = new JButton( CANCELAR );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );

        JPanel pnlSur = new JPanel( );
        pnlSur.setLayout( new GridLayout( 1, 2 ) );
        pnlSur.add( btnAgregar );
        pnlSur.add( btnCancelar );

        add( pnlSur, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            String nombre = txtNombre.getText( );
            String tipo = ( String )comboTipo.getSelectedItem( );
            String capacidadS = txtCapacidad.getText( );
            String imagen = txtImagen.getText( );
            boolean tieneInternet = chkInternet.isSelected( );
            String costoS = txtCostoHora.getText( );
            String tamanioS = txtTamanio.getText( );
            String responsable = txtNombreResponsable.getText( );

            if( nombre != null && !nombre.isEmpty( ) && capacidadS != null && !capacidadS.isEmpty( ) && imagen != null && !imagen.isEmpty( ) )
            {
                try
                {
                    int capacidad = Integer.parseInt( capacidadS );
                    double precio = Double.parseDouble( costoS );
                    double tamanio = Double.parseDouble( tamanioS );
                    if( capacidad > 0 && precio > 0 && tamanio > 0 )
                    {
                        principal.agregarEspacio( nombre, tipo, tieneInternet, imagen, capacidad, precio, tamanio, responsable );
                        this.dispose( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "La capacidad, costo por hora y tamaño del espacio deben ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE );
                    }
                }
                catch( NumberFormatException ex )
                {
                    JOptionPane.showMessageDialog( this, "La capacidad del espacio debe ser un valor numérico.", "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Por favor ingrese la información completa del espacio", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( SELECCIONAR ) )
        {
            JFileChooser fileChooser = new JFileChooser( "./data/imagenes" );
            if( fileChooser.showOpenDialog( principal ) == JFileChooser.APPROVE_OPTION )
            {
                try
                {
                    txtImagen.setText( "." + fileChooser.getSelectedFile( ).getAbsolutePath( ).substring( fileChooser.getSelectedFile( ).getAbsolutePath( ).indexOf( "\\data" )) );
                }
                catch (Exception e)
                {
                    // do nothing
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }

}
