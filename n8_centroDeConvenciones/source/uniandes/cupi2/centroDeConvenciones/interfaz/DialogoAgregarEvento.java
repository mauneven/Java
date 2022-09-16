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
import javax.swing.border.TitledBorder;

/**
 * Diálogo para agregar un nuevo evento.
 */
public class DialogoAgregarEvento extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el cambio en la selección del combo box mes.
     */
    private final static String COMBO_MES = "Combo mes";

    /**
     * Comando Agregar.
     */
    private final static String AGREGAR = "Agregar";

    /**
     * Comando Cancelar.
     */
    private final static String CANCELAR = "Cancelar";

    /**
     * Comando Seleccionar Imagen.
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
     * Campo de texto para el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la cantidad de asistentes.
     */
    private JTextField txtCantidad;

    /**
     * Campo de texto con la imagen del evento.
     */
    private JTextField txtImagen;

    /**
     * Combo box con el día del evento.
     */
    private JComboBox cbDia;

    /**
     * Combo box con el mes del evento.
     */
    private JComboBox cbMes;

    /**
     * Combo box con el año del evento.
     */
    private JComboBox cbAnio;

    /**
     * Combo box con la hora de inicio del evento.
     */
    private JComboBox cbHoraInicio;

    /**
     * Combo box con la hora final del evento.
     */
    private JComboBox cbHoraFin;

    /**
     * Área de texto con la descripción del evento.
     */
    private JTextArea areaDescripcion;

    /**
     * Panel con un scroll que contiene a areaDescripcion.
     */
    private JScrollPane scrollDescripcion;

    /**
     * Botón para agregar.
     */
    private JButton btnAgregar;

    /**
     * Botón para cancelar.
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
     * Crea un nuevo diálogo para agregar un evento a un espacio.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarEvento( InterfazCentroDeConvenciones pPrincipal )
    {
        principal = pPrincipal;
        setTitle( "Nuevo evento" );
        setSize( new Dimension( 400, 300 ) );
        setLocationRelativeTo( principal );
        setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );

        JPanel panelInfo1 = new JPanel( );
        panelInfo1.setLayout( new GridLayout( 5, 2 ) );

        panelInfo1.add( new JLabel( " Nombre:" ) );
        txtNombre = new JTextField( );
        panelInfo1.add( txtNombre );

        panelInfo1.add( new JLabel( " Cantidad de asistentes:" ) );
        txtCantidad = new JTextField( );
        panelInfo1.add( txtCantidad );

        JPanel panelAux = new JPanel( );
        panelAux.setLayout( new GridLayout( 1, 3 ) );

        cbAnio = new JComboBox( );
        cbAnio.addItem( "Año" );
        cbAnio.addItem( "2017" );
        cbAnio.addItem( "2018" );
        cbAnio.addItem( "2019" );
        cbAnio.addItem( "2020" );
        cbAnio.setSelectedItem( 0 );
        panelAux.add( cbAnio );

        cbMes = new JComboBox( );
        cbMes.setActionCommand( COMBO_MES );
        cbMes.addActionListener( this );
        cbMes.addItem( "Mes" );
        for( int i = 1; i <= 12; i++ )
        {
            cbMes.addItem( i + "" );
        }
        cbMes.setSelectedItem( 0 );
        panelAux.add( cbMes );

        cbDia = new JComboBox( );
        cbDia.addItem( "Día" );
        cbDia.setSelectedItem( 0 );
        panelAux.add( cbDia );

        panelInfo1.add( new JLabel( " Fecha:" ) );
        panelInfo1.add( panelAux );

        JPanel panelAux2 = new JPanel( );
        panelAux2.setLayout( new GridLayout( 1, 2 ) );

        cbHoraInicio = new JComboBox( );
        cbHoraInicio.addItem( "Hora inicio" );
        for( int i = 8; i <= 18; i++ )
        {
            cbHoraInicio.addItem( i + ":00" );
        }
        cbHoraInicio.setSelectedItem( 0 );
        panelAux2.add( cbHoraInicio );

        cbHoraFin = new JComboBox( );
        cbHoraFin.addItem( "Hora fin" );
        for( int i = 8; i <= 18; i++ )
        {
            cbHoraFin.addItem( i + ":00" );
        }
        cbHoraFin.setSelectedItem( 0 );
        panelAux2.add( cbHoraFin );

        panelInfo1.add( new JLabel( ) );
        panelInfo1.add( panelAux2 );

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

        JPanel panelInfo2 = new JPanel( );
        panelInfo2.setLayout( new BorderLayout( ) );

        areaDescripcion = new JTextArea( );
        areaDescripcion.setLineWrap( true );

        scrollDescripcion = new JScrollPane( areaDescripcion );
        scrollDescripcion.setPreferredSize( new Dimension( 0, 80 ) );
        scrollDescripcion.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scrollDescripcion.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
        scrollDescripcion.setBorder( new TitledBorder( "Descripción: " ) );

        JPanel panelEventos = new JPanel( );
        panelEventos.setLayout( new BorderLayout( ) );
        panelEventos.add( scrollDescripcion, BorderLayout.CENTER );

        panelInfo2.add( panelEventos, BorderLayout.NORTH );

        add( panelInfo2, BorderLayout.CENTER );

        btnAgregar = new JButton( "Agregar" );
        btnAgregar.setActionCommand( AGREGAR );
        btnAgregar.addActionListener( this );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );

        JPanel pnlSur = new JPanel( );
        pnlSur.setLayout( new GridLayout( 1, 2 ) );
        pnlSur.add( btnAgregar );
        pnlSur.add( btnCancelar );

        add( pnlSur, BorderLayout.SOUTH );
        pack( );
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
        if( comando.equals( COMBO_MES ) )
        {
            try
            {
                String seleccionado = ( String )cbMes.getSelectedItem( );
                int mes = Integer.parseInt( seleccionado );
                if( mes == 2 )
                {
                    cbDia.removeAllItems( );
                    cbDia.addItem( "Día" );
                    for( int i = 1; i <= 28; i++ )
                    {
                        cbDia.addItem( i + "" );
                    }
                }
                else if( mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 )
                {
                    cbDia.removeAllItems( );
                    cbDia.addItem( "Día" );
                    for( int i = 1; i <= 31; i++ )
                    {
                        cbDia.addItem( i + "" );
                    }
                }
                else
                {
                    cbDia.removeAllItems( );
                    cbDia.addItem( "Día" );
                    for( int i = 1; i <= 30; i++ )
                    {
                        cbDia.addItem( i + "" );
                    }
                }

            }
            catch( NumberFormatException pExcepcion )
            {
                // No hace nada
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
        else if( comando.equals( AGREGAR ) )
        {
            String nombre = txtNombre.getText( );
            String descripcion = areaDescripcion.getText( );
            String cantidadAsistentes = txtCantidad.getText( );
            int dia = 0;
            int mes = 0;
            int anio = 0;
            int horaInicio = 0;
            int horaFin = 0;
            String rutaImagen = txtImagen.getText( );

            if( !nombre.isEmpty( ) && !cantidadAsistentes.isEmpty( ) && !rutaImagen.isEmpty( ) && !descripcion.isEmpty( ) )
            {
                try
                {
                    dia = Integer.parseInt( ( String )cbDia.getSelectedItem( ) );
                    mes = Integer.parseInt( ( String )cbMes.getSelectedItem( ) );
                    anio = Integer.parseInt( ( String )cbAnio.getSelectedItem( ) );
                    horaInicio = Integer.parseInt( ( ( String )cbHoraInicio.getSelectedItem( ) ).split( ":" )[ 0 ] );
                    horaFin = Integer.parseInt( ( ( String )cbHoraFin.getSelectedItem( ) ).split( ":" )[ 0 ] );
                    if( horaInicio >= horaFin )
                    {
                        JOptionPane.showMessageDialog( this, "La hora de inicio debe ser menor a la hora de fin del evento.", "Agregar evento", JOptionPane.ERROR_MESSAGE );
                    }
                    else
                    {
                        try
                        {
                            int asistentes = Integer.parseInt( cantidadAsistentes );
                            if( asistentes < 0 )
                            {
                                JOptionPane.showMessageDialog( this, "La cantidad de asistentes debe ser un número mayor a 0.", "Agregar evento", JOptionPane.ERROR_MESSAGE );
                            }
                            else
                            {

                                boolean agregado = principal.agregarEventoAEspacio( nombre, descripcion, asistentes, anio, mes, dia, horaInicio, horaFin, rutaImagen );
                                if( agregado )
                                    dispose( );
                            }
                        }
                        catch( NumberFormatException e )
                        {
                            JOptionPane.showMessageDialog( this, "La cantidad de asistentes deben ser un número.", "Agregar evento", JOptionPane.ERROR_MESSAGE );
                        }
                    }
                }
                catch( NumberFormatException e )
                {
                    JOptionPane.showMessageDialog( this, "Debe seleccionar una fecha válida.", "Agregar evento", JOptionPane.ERROR_MESSAGE );
                }
            }
            else
            {
                JOptionPane.showMessageDialog( this, "Debe llenar todos los campos", "Agregar evento", JOptionPane.ERROR_MESSAGE );
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
    }
}
