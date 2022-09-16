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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 * Panel con las operaciones de ordenamiento y búsqueda.
 */
public class PanelOperaciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando Ordenar.
     */
    private final static String ORDENAR = "Ordenar";

    /**
     * Constante que representa el comando Buscar.
     */
    private final static String BUSCAR = "Buscar";

    /**
     * Constante que representa la opción de ordenamiento por nombre.
     */
    private final static String ORDENAR_NOMBRE = "Nombre";

    /**
     * Constante que representa la opción de ordenamiento por capacidad.
     */
    private final static String ORDENAR_CAPACIDAD = "Capacidad";

    /**
     * Constante que representa la opción de ordenamiento por cantidad de eventos.
     */
    private final static String ORDENAR_CANTIDAD_EVENTOS = "Cantidad de eventos";

    /**
     * Constante que representa la opción de búsqueda por nombre.
     */
    private final static String BUSCAR_NOMBRE = "Nombre";

    /**
     * Constante que representa la opción de búsqueda por evento.
     */
    private final static String BUSCAR_EVENTO = "Evento";

    /**
     * Constante que representa la opción de búsqueda del espacio más usado.
     */
    private final static String BUSCAR_MAS_USADO = "Más usado";

    /**
     * Constante que representa la opción de búsqueda del espacio menos usado.
     */
    private final static String BUSCAR_MENOS_USADO = "Menos usado";

    /**
     * Constante que representa la opción de búsqueda por fecha.
     */
    private final static String BUSCAR_FECHA = "Fecha";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCentroDeConvenciones principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Combo box con las opciones de ordenamiento.
     */
    private JComboBox comboOrdenamiento;

    /**
     * Combo box con las opciones de búsqueda.
     */
    private JComboBox comboBusqueda;

    /**
     * Botón Ordenar.
     */
    private JButton btnOrdenar;

    /**
     * Botón Buscar.
     */
    private JButton btnBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOperaciones( InterfazCentroDeConvenciones pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new GridLayout( 1, 4, 5, 5 ) );
        setBorder( new TitledBorder( " Ordenamientos y búsquedas " ) );

        comboOrdenamiento = new JComboBox( );
        comboOrdenamiento.addItem( ORDENAR_NOMBRE );
        comboOrdenamiento.addItem( ORDENAR_CAPACIDAD );
        comboOrdenamiento.addItem( ORDENAR_CANTIDAD_EVENTOS );
        add( comboOrdenamiento );

        btnOrdenar = new JButton( ORDENAR );
        btnOrdenar.setActionCommand( ORDENAR );
        btnOrdenar.addActionListener( this );
        add( btnOrdenar );

        comboBusqueda = new JComboBox( );
        comboBusqueda.addItem( BUSCAR_NOMBRE );
        comboBusqueda.addItem( BUSCAR_MAS_USADO );
        comboBusqueda.addItem( BUSCAR_MENOS_USADO );
        comboBusqueda.addItem( BUSCAR_EVENTO );
        comboBusqueda.addItem( BUSCAR_FECHA );
        add( comboBusqueda );

        btnBuscar = new JButton( BUSCAR );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        add( btnBuscar );

    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ORDENAR ) )
        {
            String ordenamiento = ( String )comboOrdenamiento.getSelectedItem( );
            if( ordenamiento.equals( ORDENAR_NOMBRE ) )
            {
                principal.ordenarPorNombre( );
            }
            else if( ordenamiento.equals( ORDENAR_CAPACIDAD ) )
            {
                principal.ordenarPorCapacidad( );
            }
            else if( ordenamiento.equals( ORDENAR_CANTIDAD_EVENTOS ) )
            {
                principal.ordenarPorCantidadEventos( );
            }
        }
        else if( comando.equals( BUSCAR ) )
        {
            String busqueda = ( String )comboBusqueda.getSelectedItem( );
            if( busqueda.equals( BUSCAR_NOMBRE ) )
            {
                principal.buscarPorNombre( );
            }
            else if( busqueda.equals( BUSCAR_EVENTO ) )
            {
                principal.buscarPorEvento( );
            }
            else if( busqueda.equals( BUSCAR_MENOS_USADO ) )
            {
                principal.buscarEspacioMenosUsado( );
            }
            else if( busqueda.equals( BUSCAR_MAS_USADO ) )
            {
                principal.buscarEspacioMasUsado( );
            }
            else if( busqueda.equals( BUSCAR_FECHA ) )
            {
                principal.buscarEventosPorFecha( );
            }
        }
    }
}
