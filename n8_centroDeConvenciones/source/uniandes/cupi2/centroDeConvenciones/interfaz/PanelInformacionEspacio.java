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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.centroDeConvenciones.mundo.Espacio;
import uniandes.cupi2.centroDeConvenciones.mundo.Evento;

/**
 * Panel con la informaci?n detallada de un espacio.
 */
public class PanelInformacionEspacio extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando de agregar un evento.
     */
    private final static String AGREGAR = "Agregar";

    /**
     * Constante que representa el comando de ver el detalle de un evento.
     */
    private final static String VER_DETALLE = "Ver detalle";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci?n.
     */
    private InterfazCentroDeConvenciones interfaz;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del espacio.
     */
    private JLabel etiquetaImagen;

    /**
     * Campo de texto con el tipo del espacio.
     */
    private JTextField txtTipo;

    /**
     * Campo de texto con la capacidad del espacio.
     */
    private JTextField txtCapacidad;
    
    /**
     * Campo de texto con el tama?o del espacio.
     */
    private JTextField txtTamanio;
    
    /**
     * Campo de texto con el precio por hora del espacio.
     */
    private JTextField txtPrecioHora;
    
    /**
     * Campo de texto con el nombre del responsable del espacio.
     */
    private JTextField txtResponsable;

    /**
     * Caja de chequeo que indica si el espacio tiene internet.
     */
    private JCheckBox chkInternet;

    /**
     * Lista con los eventos.
     */
    private JList listaEventos;

    /**
     * Panel con un scroll que contiene a listaEventos.
     */
    private JScrollPane scrollEventos;

    /**
     * Bot?n para agregar un nuevo evento.
     */
    private JButton botonAgregar;

    /**
     * Bot?n para ver en detalle del evento seleccionado.
     */
    private JButton botonVerDetalle;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicaci?n. pPrincipal != null.
     */
    public PanelInformacionEspacio( InterfazCentroDeConvenciones pPrincipal )
    {
        interfaz = pPrincipal;
        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5 ), new TitledBorder( "" ) ) );

        JPanel panelImagen = new JPanel( );
        panelImagen.setLayout( new BorderLayout( ) );
        panelImagen.setBorder( new EmptyBorder( 0, 0, 0, 5 ) );
        panelImagen.setBackground( new Color( 239, 250, 252 ) );
        panelImagen.setBorder( new LineBorder( Color.BLACK ) );

        etiquetaImagen = new JLabel( );
        etiquetaImagen.setPreferredSize( new Dimension( 200, 200 ) );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );

        panelImagen.add( etiquetaImagen );

        JPanel panelInfo = new JPanel( );
        panelInfo.setLayout( new BorderLayout( ) );

        JPanel panelInfo1 = new JPanel( );
        panelInfo1.setLayout( new GridLayout( 3, 4 ) );
        panelInfo1.setBorder( new EmptyBorder( 5, 0, 0, 0 ) );

        JLabel etiquetaCategoria = new JLabel( " Tipo:  " );
        etiquetaCategoria.setHorizontalAlignment( JLabel.LEFT );
        panelInfo1.add( etiquetaCategoria );
        txtTipo = new JTextField( );
        txtTipo.setEditable( false );
        panelInfo1.add( txtTipo );

        JLabel etiquetaDificultad = new JLabel( " Capacidad:  " );
        etiquetaDificultad.setHorizontalAlignment( JLabel.LEFT );
        panelInfo1.add( etiquetaDificultad );
        txtCapacidad = new JTextField( );
        txtCapacidad.setEditable( false );
        panelInfo1.add( txtCapacidad );

        JLabel etiquetaTamanio = new JLabel( " Tama?o (m2):  " );
        etiquetaTamanio.setHorizontalAlignment( JLabel.LEFT );
        panelInfo1.add( etiquetaTamanio );
        txtTamanio = new JTextField( );
        txtTamanio.setEditable( false );
        panelInfo1.add( txtTamanio );
        
        JLabel etiquetaPrecio = new JLabel( " Costo hora:  " );
        etiquetaPrecio.setHorizontalAlignment( JLabel.LEFT );
        panelInfo1.add( etiquetaPrecio );
        txtPrecioHora = new JTextField( );
        txtPrecioHora.setEditable( false );
        panelInfo1.add( txtPrecioHora );
        
        JLabel etiquetaResponsable = new JLabel( " Responsable:  " );
        etiquetaResponsable.setHorizontalAlignment( JLabel.LEFT );
        panelInfo1.add( etiquetaResponsable );
        txtResponsable = new JTextField( );
        txtResponsable.setEditable( false );
        panelInfo1.add( txtResponsable );

        JLabel etiquetaTiempo = new JLabel( "?Tiene internet?" );
        etiquetaTiempo.setHorizontalAlignment( JLabel.LEFT );
        panelInfo1.add( etiquetaTiempo );
        chkInternet = new JCheckBox( "" );
        chkInternet.setEnabled( false );
        panelInfo1.add( chkInternet );

        panelInfo.add( panelImagen, BorderLayout.NORTH );
        panelInfo.add( panelInfo1, BorderLayout.SOUTH );

        add( panelInfo, BorderLayout.WEST );

        JPanel panelInfo2 = new JPanel( );
        panelInfo2.setLayout( new BorderLayout( ) );

        listaEventos = new JList( );
        listaEventos.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );

        scrollEventos = new JScrollPane( listaEventos );
        scrollEventos.setPreferredSize( new Dimension( 0, 240 ) );
        scrollEventos.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scrollEventos.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scrollEventos.setBorder( new TitledBorder( "Eventos: " ) );
        scrollEventos.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        panelInfo2.add( scrollEventos, BorderLayout.NORTH );

        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridLayout( 1, 2 ) );

        botonAgregar = new JButton( AGREGAR );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );

        botonVerDetalle = new JButton( VER_DETALLE );
        botonVerDetalle.setActionCommand( VER_DETALLE );
        botonVerDetalle.addActionListener( this );

        panelBotones.add( botonAgregar );
        panelBotones.add( botonVerDetalle );
        panelInfo2.add( panelBotones, BorderLayout.SOUTH );

        add( panelInfo2, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Actualiza la informaci?n del panel con el espacio que entra por par?metro.
     * @param pEspacio Espacio cuya informaci?n debe ser mostrada. pEspacio != null.
     */
    public void actualizarInformacion( Espacio pEspacio )
    {
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5 ), new TitledBorder( pEspacio.darNombre( ) ) ) );
        txtTipo.setText( pEspacio.darTipo( ) );
        txtCapacidad.setText( "" + pEspacio.darCapacidad( ) );
        txtTamanio.setText( "" + pEspacio.darTamanio() );
        txtPrecioHora.setText( "" + pEspacio.darCostoHora() );
        txtResponsable.setText( "" + pEspacio.darResponsable() );
        chkInternet.setSelected( pEspacio.tieneInternet( ) );
        etiquetaImagen.setIcon( new ImageIcon( pEspacio.darRutaFoto( ) ) );

        ArrayList eventos = pEspacio.darEventos( );

        scrollEventos.setBorder( new TitledBorder( "Eventos (" + eventos.size( ) + "): " ) );
        refrescarLista( eventos );
    }

    /**
     * Actualiza la lista de eventos con la lista recibida por par?metro.
     * @param pNuevaLista Lista con los eventos. pNuevaLista != null.
     */
    public void refrescarLista( ArrayList pNuevaLista )
    {
        listaEventos.setListData( pNuevaLista.toArray( ) );
        if( !pNuevaLista.isEmpty( ) )
        {
            listaEventos.setSelectedIndex( 0 );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci?n que gener? el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            DialogoAgregarEvento dialogoAgregar = new DialogoAgregarEvento( interfaz );
            dialogoAgregar.setVisible( true );
        }
        else if( comando.equals( VER_DETALLE ) )
        {
            Evento seleccionado = ( Evento )listaEventos.getSelectedValue( );
            if( seleccionado != null )
            {
                DialogoVerDetalleEvento dialogoVer = new DialogoVerDetalleEvento( interfaz, seleccionado );
                dialogoVer.setVisible( true );
            }
        }

    }

    /**
     * M?todo para atender el evento cuando un usuario selecciona un evento de la lista.
     * @param pEvento Evento de selecci?n de un elemento de la lista de eventos. pEvento != null.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        // No se implementa.
    }
}
