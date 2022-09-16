/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_centroDeConvenciones
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.centroDeConvenciones.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.centroDeConvenciones.mundo.CentroDeConvenciones;
import uniandes.cupi2.centroDeConvenciones.mundo.Espacio;
import uniandes.cupi2.centroDeConvenciones.mundo.EspacioOcupadoException;
import uniandes.cupi2.centroDeConvenciones.mundo.FormatoArchivoException;
import uniandes.cupi2.centroDeConvenciones.mundo.PersistenciaException;

/**
 * Ventana principal de la aplicaci�n.
 */
public class InterfazCentroDeConvenciones extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa la ubicaci�n del archivo con los datos de las recetas.
     */
    private final static String ARCHIVO_SERIALIZACION = "./data/centroDeConvenciones.data";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private CentroDeConvenciones centroConvenciones;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las opciones.
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con la imagen del encabezado.
     */
    private PanelImagen panelImagen;

    /**
     * Panel con la lista de espacios del centro de convenciones.
     */
    private PanelListaEspacios panelListaEspacios;

    /**
     * Panel con la informaci�n detalla de un espacio.
     */
    private PanelInformacionEspacio panelInformacionEspacio;

    /**
     * Panel con las operaciones de ordenamiento y b�squeda.
     */
    private PanelOperaciones panelOperaciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz e inicializa todos sus componentes.
     */
    public InterfazCentroDeConvenciones( )
    {
        try
        {
            centroConvenciones = new CentroDeConvenciones( ARCHIVO_SERIALIZACION );
        }
        catch( PersistenciaException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar el estado del mundo.", "Centro de convenciones", JOptionPane.ERROR_MESSAGE );
        }
        catch( FormatoArchivoException e )
        {
            JOptionPane.showMessageDialog( this, "Error en el formato del archivo.", "Centro de convenciones", JOptionPane.ERROR_MESSAGE );
        }

        setLayout( new BorderLayout( ) );
        setSize( 900, 580 );
        setResizable( false );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "Centro de convenciones" );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelListaEspacios = new PanelListaEspacios( this );
        add( panelListaEspacios, BorderLayout.WEST );

        panelInformacionEspacio = new PanelInformacionEspacio( this );
        add( panelInformacionEspacio, BorderLayout.CENTER );

        JPanel aux = new JPanel( );
        aux.setLayout( new GridLayout( 2, 1 ) );

        panelOperaciones = new PanelOperaciones( this );
        aux.add( panelOperaciones );

        panelOpciones = new PanelOpciones( this );
        aux.add( panelOpciones );

        add( aux, BorderLayout.SOUTH );

        setLocationRelativeTo( null );

        actualizarLista( );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Este m�todo se encarga de salvar la informaci�n del sistema, justo antes de cerrar la aplicaci�n.
     */
    public void dispose( )
    {
        try
        {
            centroConvenciones.guardar( ARCHIVO_SERIALIZACION );
            super.dispose( );
        }
        catch( Exception e )
        {
            setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, "Problemas salvando la informaci�n del sistema:\n" + e.getMessage( ) + "." + "\n�Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION )
            {
                super.dispose( );
            }
        }
    }

    /**
     * Actualiza la lista de espacios mostrada.
     */
    private void actualizarLista( )
    {
        panelListaEspacios.refrescarLista( centroConvenciones.darEspacios( ) );
    }

    /**
     * Actualiza la informaci�n del espacio seleccionado.
     * @param pEspacio Espacio que ha sido seleccionado. pEspacio != null.
     */
    public void actualizarInfoEspacio( Espacio pEspacio )
    {
        panelInformacionEspacio.actualizarInformacion( pEspacio );
    }

    /**
     * Ordena la lista de espacios por su nombre.
     */
    public void ordenarPorNombre( )
    {
        centroConvenciones.ordenarPorNombre( );
        actualizarLista( );
    }

    /**
     * Ordena la lista de espacios por su capacidad.
     */
    public void ordenarPorCapacidad( )
    {
        centroConvenciones.ordenarPorCapacidad( );
        actualizarLista( );
    }

    /**
     * Ordena la lista de espacios por su cantidad de eventos.
     */
    public void ordenarPorCantidadEventos( )
    {
        centroConvenciones.ordenarPorCantidadEventos( );
        actualizarLista( );
    }

    /**
     * Busca el espacio con el nombre dado por par�metro.
     */
    public void buscarPorNombre( )
    {
        String pNombre = JOptionPane.showInputDialog( this, "Nombre: ", "Buscar espacio", JOptionPane.QUESTION_MESSAGE );
        if( pNombre != null && !pNombre.isEmpty( ) )
        {
            centroConvenciones.ordenarPorNombre( );
            actualizarLista( );
            int espacio = centroConvenciones.buscarBinarioPorNombre( pNombre );
            if( espacio > -1 )
            {
                panelListaEspacios.seleccionar( espacio );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No se encontr� un espacio con el nombre dado.", "Buscar espacio", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pNombre != null && pNombre.isEmpty( ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor para realizar la b�squeda.", "Buscar espacio", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca los espacios con el evento dado por par�metro.
     */

    public void buscarPorEvento( )
    {

        String pEvento = JOptionPane.showInputDialog( this, "Evento: ", "Buscar espacios", JOptionPane.QUESTION_MESSAGE );
        if( pEvento != null && !pEvento.isEmpty( ) )
        {
            ArrayList espacios = centroConvenciones.buscarEspaciosConEvento( pEvento );
            if( espacios.size( ) > 0 )
            {
                panelListaEspacios.refrescarLista( espacios );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No existe ning�n espacio con el evento dado.", "Buscar espacios", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pEvento != null && pEvento.isEmpty( ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor para realizar la b�squeda.", "Buscar espacios", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Busca los espacios con eventos cuya fecha coincide con la dada por par�metro.
     */
    public void buscarEventosPorFecha( )
    {

        String pFecha = JOptionPane.showInputDialog( this, "Ingrese la fecha YYYY/MM/DD: ", "Buscar espacios", JOptionPane.QUESTION_MESSAGE );
        if( pFecha != null && !pFecha.isEmpty( ) )
        {
            ArrayList espacios = centroConvenciones.buscarEspacioConEventosEnFecha( pFecha );
            if( espacios.size( ) > 0 )
            {
                panelListaEspacios.refrescarLista( espacios );
            }
            else
            {
                JOptionPane.showMessageDialog( this, "No existe ning�n espacio con un evento en la fecha dada.", "Buscar espacios", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pFecha != null && pFecha.isEmpty( ) )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar un valor para realizar la b�squeda.", "Buscar espacios", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Agrega un nuevo espacio al centro de convenciones.
     * @param pNombre Nombre del espacio. pNombre != null && pNombre != "".
     * @param pTipo Tipo del espacio. Pertenece a {Espacio.TIPO_AIRE_LIBRE, Espacio.TIPO_AUDITORIO, Espacio.TIPO_RESTAURANTE, Espacio.TIPO_SALA_COMPUTO y Espacio.TIPO_SALON}.
     * @param pInternet Indica si el espacio tiene internet, true si tiene, false en caso contrario.
     * @param pRutaImagen Ruta de la imagen del espacio. pRutaImagen != null && pRutaImagen != "".
     * @param pCapacidad Capacidad del espacio. pCapacidad > 0.
     * @param pCostoHora Costo por hora del espacio. pCostoHora > 0.
     * @param pTamanio Tama�o del espacio. pTamanio > 0.
     * @param pResponsable Nombre del responsable del espacio. pResponsable != null && pResponsable != "".
     */
    public void agregarEspacio( String pNombre, String pTipo, boolean pInternet, String pRutaImagen, int pCapacidad, double pCostoHora, double pTamanio, String pResponsable )
    {

        boolean agregado = centroConvenciones.agregarEspacio( pNombre, pTipo, pInternet, pRutaImagen, pCapacidad, pCostoHora, pTamanio, pResponsable );
        if( agregado )
        {
            actualizarLista( );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Ya existe en el centro de convenciones un espacio con el nombre dado.", "Agregar espacio", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Agrega un evento al espacio dado.
     * @param pNombreEvento Nombre del evento. pNombreEvento != null && pNombreEvento != "".
     * @param pDescripcion Descripci�n del evento. pDescripcion != null && pDescripcion != "".
     * @param pAsistentes Cantidad de asistentes del evento. pAsistentes != null && pAsistentes != "".
     * @param pAnio A�o en que el evento se realiza. pAnio >= 2017 && pAnio <= 2020.
     * @param pMes Mes en que el evento se realiza. pMes >= 1 && pMes <= 12.
     * @param pDia D�a en que el evento se realiza. pDia >= 1 && pDia <= 31.
     * @param pHoraInicio Hora de inicio del evento. pHoraInicio >= 8 && pHoraInicio <= 18.
     * @param pHoraFin Hora de fin del evento. pHoraFin >= 8 && pHoraFin <= 18.
     * @param pRutaImagenPublicidad Ruta de la imagen de la publicidad del evento. pRutaImagenPublicidad != null && pRutaImagenPublicidad != "".
     * @return True si el evento fue agregado al espacio, false en caso contrario.
     */
    public boolean agregarEventoAEspacio( String pNombreEvento, String pDescripcion, int pAsistentes, int pAnio, int pMes, int pDia, int pHoraInicio, int pHoraFin, String pRutaImagenPublicidad )
    {
        String espacio = panelListaEspacios.obtenerEspacioSeleccionado( );
        boolean agregado = false;
        try
        {
            agregado = centroConvenciones.agregarEventoAEspacio( espacio, pNombreEvento, pDescripcion, pAsistentes, pAnio, pMes, pDia, pHoraInicio, pHoraFin, pRutaImagenPublicidad );
            if( agregado )
            {
                actualizarLista( );
            }
        }
        catch( EspacioOcupadoException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Agregar evento", JOptionPane.ERROR_MESSAGE );
        }

        return agregado;
    }

    /**
     * Busca el espacio menos usado del centro de convenciones.
     */
    public void buscarEspacioMenosUsado( )
    {

        int indice = centroConvenciones.buscarEspacioMenosUsado( );
        if( indice > -1 )
        {
            actualizarLista( );
            panelListaEspacios.seleccionar( indice );
        }

    }

    /**
     * Busca el espacio m�s usado del centro de convenciones.
     */
    public void buscarEspacioMasUsado( )
    {

        int indice = centroConvenciones.buscarEspacioMasUsado( );
        if( indice > -1 )
        {
            actualizarLista( );
            panelListaEspacios.seleccionar( indice );
        }

    }

    /**
     * Genera un reporte en el archivo seleccionado.
     */
    public void generarReporte( )
    {
        JFileChooser chooser = new JFileChooser( "./data" );
        chooser.setDialogTitle( "Generar reporte" );
        int returnVal = chooser.showSaveDialog( this );
        if( returnVal == JFileChooser.APPROVE_OPTION )
        {
            File ruta = chooser.getSelectedFile( );
            try
            {
                centroConvenciones.generarReporte( ruta.getAbsolutePath( ) );
                JOptionPane.showMessageDialog( this, "Reporte generado.", "Generar reporte", JOptionPane.INFORMATION_MESSAGE );
            }
            catch( PersistenciaException e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Generar reporte", JOptionPane.ERROR_MESSAGE );
            }
        }

    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = centroConvenciones.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * M�todo para la extensi�n 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = centroConvenciones.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------
    /**
     * Este m�todo ejecuta la aplicaci�n, creando una nueva interfaz.
     * @param pArgs No son necesarios.
     */
    public static void main( String[] pArgs )
    {

        InterfazCentroDeConvenciones interfaz = new InterfazCentroDeConvenciones( );
        interfaz.setVisible( true );
    }
}