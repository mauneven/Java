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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con los opciones.
 */
public class PanelOpciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando Opci?n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opci?n 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Comando Generar reporte.
     */
    private static final String GENERAR_REPORTE = "GENERAR_REPORTE";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci?n.
     */
    private InterfazCentroDeConvenciones principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot?n Opci?n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot?n Opci?n 2.
     */
    private JButton btnOpcion2;

    /**
     * Bot?n para generar reporte.
     */
    private JButton btnGenerarReporte;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal. pPrincipal != null.
     */
    public PanelOpciones( InterfazCentroDeConvenciones pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridLayout( 1, 3 ) );

        // Bot?n reporte
        btnGenerarReporte = new JButton( "Generar reporte" );
        btnGenerarReporte.setActionCommand( GENERAR_REPORTE );
        btnGenerarReporte.addActionListener( this );
        add( btnGenerarReporte );

        // Bot?n opci?n 1
        btnOpcion1 = new JButton( "Opci?n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        add( btnOpcion1 );

        // Bot?n opci?n 2
        btnOpcion2 = new JButton( "Opci?n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        add( btnOpcion2 );
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param pEvento Acci?n que gener? el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( OPCION_1.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( pEvento.getActionCommand( ) ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( GENERAR_REPORTE.equals( pEvento.getActionCommand( ) ) )
        {
           principal.generarReporte( );
        }
    }

}
