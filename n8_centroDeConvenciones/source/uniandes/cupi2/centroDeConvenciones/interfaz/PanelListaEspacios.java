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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.centroDeConvenciones.mundo.Espacio;


/**
 * Panel con la lista de espacios del centro de convenciones.
 */
public class PanelListaEspacios extends JPanel implements ListSelectionListener, ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando de agregar un espacio.
     */
    private final static String AGREGAR = "Agregar";

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
     * Lista con los espacios.
     */
    private JList listaEspacios;

    /**
     * Panel con un scroll que contiene a listaEspacios.
     */
    private JScrollPane scroll;

    /**
     * Bot?n para agregar un nuevo espacio.
     */
    private JButton botonAgregar;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicaci?n. pPrincipal != null.
     */
    public PanelListaEspacios( InterfazCentroDeConvenciones pPrincipal )
    {
        interfaz = pPrincipal;

        setLayout( new BorderLayout( ) );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 5, 0, 5 ), new TitledBorder( " Espacios " ) ) );
        setPreferredSize( new Dimension( 250, 0 ) );

        listaEspacios = new JList( );
        listaEspacios.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaEspacios.addListSelectionListener( this );

        scroll = new JScrollPane( listaEspacios );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        botonAgregar = new JButton( AGREGAR );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );

        add( scroll, BorderLayout.CENTER );
        add( botonAgregar, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del espacio seleccionado.
     * @return Nombre del espacio seleccionado.
     */
    public String obtenerEspacioSeleccionado( )
    {
        String nombreEspacio = null;
        if(listaEspacios.getSelectedValue( )!=null)
        {
            nombreEspacio = (( Espacio )listaEspacios.getSelectedValue( )).darNombre();
        }
       return nombreEspacio;
    }
    
    /**
     * Actualiza la lista de espacios con la lista recibida por par?metro.
     * @param pNuevaLista Lista con los espacios. pNuevaLista != null.
     */
    public void refrescarLista( ArrayList pNuevaLista )
    {
        listaEspacios.setListData( pNuevaLista.toArray( ) );
        if( !pNuevaLista.isEmpty( ) )
        {
            listaEspacios.setSelectedIndex( 0 );
        }
    }

    /**
     * Actualiza el espacio seleccionado.
     * @param pIndice Posici?n del espacio que se debe seleccionar.
     */
    public void seleccionar( int pIndice )
    {
        listaEspacios.setSelectedIndex( pIndice );
        listaEspacios.ensureIndexIsVisible( pIndice );
    }

    /**
     * M?todo para atender el evento cuando un usuario selecciona un espacio de la lista.
     * @param pEvento Evento de selecci?n de un elemento de la lista de espacios. pEvento != null.
     */
    public void valueChanged( ListSelectionEvent pEvento )
    {
        if( listaEspacios.getSelectedValue( ) != null )
        {
            Espacio espacio = ( Espacio )listaEspacios.getSelectedValue( );
            interfaz.actualizarInfoEspacio( espacio );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci?n que gener? el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( AGREGAR ) )
        {
            DialogoAgregarEspacio dialogoAgregar = new DialogoAgregarEspacio( interfaz );
            dialogoAgregar.setVisible( true );
        }
    }

}
