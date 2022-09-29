package uniandes.cupi2.centroDeConvenciones.mundo;

import java.io.Serializable;
import java.util.ArrayList;

public class Espacio implements Serializable {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el tipo Al aire libre.
     */
    public final static String TIPO_AIRE_LIBRE = "Al aire libre";

    /**
     * Constante que representa el tipo Auditorio.
     */
    public final static String TIPO_AUDITORIO = "Auditorio";

    /**
     * Constante que representa el tipo Restaurante.
     */
    public final static String TIPO_RESTAURANTE = "Restaurante";

    /**
     * Constante que representa el tipo Sala de c?mputo.
     */
    public final static String TIPO_SALA_COMPUTO = "Sala de c?mputo";

    /**
     * Constante que representa el tipo Sal?n.
     */
    public final static String TIPO_SALON = "Sal?n";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del espacio.
     */
    private String nombre;

    /**
     * Tipo del espacio.
     */
    private String tipo;

    /**
     * Indica si el espacio tiene internet o no.
     */
    private boolean tieneInternet;

    /**
     * Ruta de la imagen de la foto del espacio.
     */
    private String rutaFoto;

    /**
     * Capacidad del espacio.
     */
    private int capacidad;

    /**
     * Costo por hora del espacio.
     */
    private double costoHora;

    /**
     * Tama?o del espacio..
     */
    private double tamanio;

    /**
     * Nombre del responsable del espacio.
     */
    private String responsable;

    /**
     * Eventos realizados en el espacio.
     */
    private ArrayList eventos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo espacio. <br>
     * <b> post: </b> El nombre, el tipo, si tiene internet, la ruta de la imagen, la capacidad, el costo por hora, el tama?o y el nombre del responsable se inicializaron con
     * los valores dados por par?metro.<br>
     * Los eventos se inicializaron como una lista vac?a.
     * @param pNombre Nombre del espacio. pNombre != null && pNombre != "".
     * @param pTipo Tipo del espacio. pTipo pertenece a {TIPO_AIRE_LIBRE, TIPO_AUDITORIO, TIPO_RESTAURANTE, TIPO_SALA_COMPUTO y TIPO_SALON}.
     * @param pInternet Indica si tiene o no internet el espacio.
     * @param pRutaFoto Ruta de la foto del espacio. pRutaFoto != null && pRutaFoto != "".
     * @param pCapacidad Capacidad del espacio. pCapacidad > 0.
     * @param pCostoHora Costo por hora del espacio. pCostoHora > 0.
     * @param pTamanio Tama?o del espacio. pTamanio > 0.
     * @param pResponsable Nombre del responsable del espacio. pResponsable != null && pResponsable != "".
     */
    public Espacio( String pNombre, String pTipo, boolean pInternet, String pRutaFoto, int pCapacidad, double pCostoHora, double pTamanio, String pResponsable )
    {
        nombre = pNombre;
        tipo = pTipo;
        tieneInternet = pInternet;
        rutaFoto = pRutaFoto;
        capacidad = pCapacidad;
        costoHora = pCostoHora;
        tamanio = pTamanio;
        responsable = pResponsable;
        eventos = new ArrayList( );

        verificarInvariante( );
        // TODO Parte 1 Punto F: Llamado a verificarInvariante.
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del espacio.
     * @return Nombre del espacio.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el tipo del espacio.
     * @return Tipo del espacio.
     */
    public String darTipo( )
    {
        return tipo;
    }

    /**
     * Indica si el espacio tiene internet o no.
     * @return True si tiene internet el espacio, de lo contrario false.
     */
    public boolean tieneInternet( )
    {
        return tieneInternet;
    }

    /**
     * Retorna la ruta de la foto del espacio.
     * @return Ruta de la foto del espacio.
     */
    public String darRutaFoto( )
    {
        return rutaFoto;
    }

    /**
     * Retorna la capacidad del espacio.
     * @return Capacidad del espacio.
     */
    public int darCapacidad( )
    {
        return capacidad;
    }

    /**
     * Retorna el tama?o del espacio.
     * @return Tama?o del espacio.
     */
    public double darTamanio( )
    {
        return tamanio;
    }

    /**
     * Retorna el costo por hora del espacio.
     * @return Costo por hora del espacio.
     */
    public double darCostoHora( )
    {
        return costoHora;
    }

    /**
     * Retorna el nombre del responsable del espacio.
     * @return Nombre del responsable del espacio.
     */
    public String darResponsable( )
    {
        return responsable;
    }
    /**
     * Retorna la lista de eventos.
     * @return Lista de eventos.
     */
    public ArrayList darEventos( )
    {
        return eventos;
    }

    /**
     * Agrega un evento a la lista de eventos.<br>
     * <b> post: </b> Se agreg? el evento con los datos dados por par?metro.
     * @param pNombreEvento Nombre del evento. pNombreEvento != null && pNombreEvento != "".
     * @param pDescripcion Descripci?n del evento. pDescripcion != null && pDescripcion != "".
     * @param pAsistentes Asistentes al evento. pAsistentes > 0.
     * @param pFecha Fecha del evento. pFecha != null.
     * @param pRutaImagenPublicidad Ruta de la imagen del evento. pRutaImagenPublicidad != null && pRutaImagenPublicidad != "".
     * @return True si el evento fue agregado, false en caso contrario.
     */
    public boolean agregarEvento( String pNombreEvento, String pDescripcion, int pAsistentes, Fecha pFecha, String pRutaImagenPublicidad )throws EspacioOcupadoException
    {
        boolean agregado = false;
        if( !buscarEventoFecha( pFecha ) )
        {
            Evento nuevo = new Evento( pNombreEvento, pDescripcion, pAsistentes, pFecha, pRutaImagenPublicidad );
            eventos.add( nuevo );
            agregado = true;
            verificarInvariante( );
            // TODO Parte 1 Punto G: Llamado a verificarInvariante.
        }

        else{
            throw new EspacioOcupadoException("Error" );
        }
        return agregado;
    }

    /**
     * Compara dos espacios seg?n el nombre. <br>
     * @param pEspacio Espacio contra el que se est? comparando. pEspacio != null.
     * @return Retorna 0 si los espacios tienen el mismo nombre. <br>
     *         Retorna -1 si el espacio par?metro tiene un valor mayor para el nombre. <br>
     *         Retorna 1 si el espacio par?metro tiene una valor menor para el nombre. <br>
     */
    public int compararPorNombre( Espacio pEspacio )
    {
        int comparar = nombre.compareToIgnoreCase( pEspacio.darNombre( ) );
        if ( comparar == 0 )
        {
            comparar = 0;
        }
        else if ( comparar < 0)
        {
            comparar = -1;
        }
        else
        {
            comparar = 1;
        }
        return comparar;
        // TODO Parte 2 Punto C: Completar el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Compara dos espacios seg?n la capacidad. <br>
     * @param pEspacio Espacio contra el que se est? comparando. pEspacio != null.
     * @return Retorna 0 si los espacios tienen la misma capacidad. <br>
     *         Retorna -1 si el espacio par?metro tiene una valor mayor para la capacidad. <br>
     *         Retorna 1 si el espacio par?metro tiene una valor menor para la capacidad.
     */
    public int compararPorCapacidad( Espacio pEspacio )
    {
        if ( capacidad == pEspacio.darCapacidad( ) )
        {
            return 0;
        }
        else if ( capacidad < pEspacio.darCapacidad( ) )
        {
            return -1;
        }
        else
        {
            return 1;
        }
        // TODO Parte 2 Punto D: Completar el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Compara dos espacios seg?n la cantidad de eventos. <br>
     * @param pEspacio Espacio contra el que se est? comparando. pEspacio != null.
     * @return Retorna 0 si los espacios tiene la misma cantidad de eventos. <br>
     *         Retorna -1 si el espacio par?metro tiene un valor mayor para la cantidad de eventos. <br>
     *         Retorna 1 si el espacio par?metro tiene un valor menor para la cantidad de eventos.
     */
    public int compararPorCantidadEventos( Espacio pEspacio )
    {
        if ( pEspacio.darEventos( ).size( ) == eventos.size( ) )
        {
            return 0;
        }
        else if ( eventos.size( ) < pEspacio.darEventos( ).size( ) )
        {
            return -1;
        }
        else
        {
            return 1;
        }
        // TODO Parte 2 Punto E: Completar el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Indica si en la lista de eventos del espacio se encuentra un evento con el nombre dado por par?metro.
     * @param pNombreEvento Nombre del evento que se desea buscar. pNombreEvento != null && pNombreEvento != "".
     * @return True si en la lista de eventos se encuentra el evento, false en caso contrario.
     */
    public boolean tieneEvento( String pNombreEvento )
    {
        boolean tieneEvento = false;

        for( int i = 0; i < eventos.size( ) && !tieneEvento; i++ )
        {
            Evento actual = ( Evento )eventos.get( i );
            if( actual.darNombre( ).equals( pNombreEvento ) )
            {
                tieneEvento = true;
            }
        }

        return tieneEvento;
    }

    /**
     * Indica si en la lista de eventos del espacio hay un evento cuya fecha se cruza con la fecha dada.
     * @param pFecha Fecha del evento que se desea buscar. pFecha != null && pFecha != "".
     * @return True si en la lista de eventos se encuentra un evento en la fecha dada, false en caso contrario.
     */
    public boolean buscarEventoFecha( Fecha pFecha )
    {
        boolean tieneEvento = false;

        for( int i = 0; i < eventos.size( ) && !tieneEvento; i++ )
        {
            Evento actual = ( Evento )eventos.get( i );
            if( actual.darFecha( ).comparar( pFecha ) == 0 )
            {
                tieneEvento = true;
            }
        }

        return tieneEvento;
    }

    /**
     * Retorna una cadena con el nombre del espacio.
     * @return Representaci?n del espacio en String.
     */
    public String toString( )
    {
        return nombre;
    }
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Valida que no existan dos eventos en la misma fecha . <br>
     * @return True si no se repite la fecha del evento. False en caso contrario
     */
    private boolean hayEventosMismaFecha ( )
    {
        boolean si = false;
        for (int i = 0; i < eventos.size( )-1 && !si; i++)
        {
            Evento evento = (Evento)eventos.get( i );
            Fecha fecha = evento.darFecha( );
            for( int j = i + 1; j < eventos.size( ); j++ )
            {
                Evento otro = (Evento)eventos.get( j );
                Fecha pFecha = otro.darFecha( );
                if (pFecha.comparar( fecha ) == 0)
                {
                    si = true;
                }
            }
        }

        return si;
    }
    /**
     * Clase que representa un espacio del centro de convenciones.<br>
     * <b>inv: </b> <br>
     * El nombre del espacio no puede ser ni nulo ni una cadena vacia <br>
     * El tipo de espacio puede ser al aire libre, auditorio, restaurante, sala de computo o salon <br>
     * La ruta de la foto no es ni nula ni cadena vacia <br>
     * La capacidad, el costo por hora y el tama?o del espacio deben ser mayores que 0 <br>
     * El nombre del responsable no puede ser ni nulo ni una cadena vacia <br>
     * En el vector eventos no pueden haber eventos con la misma fecha <br>
     */
    private void verificarInvariante ( )
    {
        assert (eventos != null ) : "La lista de eventos no debe ser null";
        assert (nombre != null && !nombre.equals("") ) : "El nombre no es valido";
        assert (!tipo.equals( TIPO_AIRE_LIBRE ) || !tipo.equals( TIPO_AUDITORIO) || !tipo.equals( TIPO_RESTAURANTE ) || !tipo.equals( TIPO_SALA_COMPUTO) || tipo.equals( TIPO_SALON )) : "El tipo de espacio no es valido";
        assert (rutaFoto != null && !rutaFoto.equals( "" ) ) : "La ruta de la foto no es valida";
        assert (capacidad > 0 ) : "La capacidad debe ser mayor que cero";
        assert (costoHora > 0 ) : "El costo por hora no puede ser cero";
        assert (tamanio > 0 ) : "El tama?o del espacio debe ser mayor que cero";
        assert (responsable != null && !responsable.equals( "" )) : "El nombre del responsable es valido";
        assert !hayEventosMismaFecha ( ) : "Ya existe un evento en esa fecha";

    }
    // TODO Parte 1 Punto E: Documente e implemente la invariante de la clase.
    // Si lo necesita, puede crear m?todo privados adicionales.


}
