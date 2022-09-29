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

package uniandes.cupi2.centroDeConvenciones.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase que representa el centro de convenciones.<br>
 * <b>Invariante: </b> <br>
 * espacios != null
 * En el vector espacios no puede haber espacios con nombres repetidos <br>
 * TODO Parte 1 Punto H: Declare el invariante de la clase.
 */
public class CentroDeConvenciones
{

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Lista de espacios.
     */
    private ArrayList espacios;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Construye un nuevo centro de convenciones sin espacios.<br>
     * <b> post: </b> Las listas de espacios ha sido inicializada.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public CentroDeConvenciones( String pNombreArchivo) throws PersistenciaException, FormatoArchivoException, IOException, ClassNotFoundException
    {
        cargar( pNombreArchivo );
    }

    // -------------------------------------------------------------
    // M?todos
    // -------------------------------------------------------------

    /**
     * Retorna la lista de espacios del centro de convenciones.
     * @return Lista de espacios.
     */
    public ArrayList darEspacios( )
    {
        return espacios;
    }

    /**
     * Agrega un nuevo espacio al centro de convenciones.
     * @param pNombre Nombre del espacio. pNombre != null && pNombre != "".
     * @param pRutaImagen Ruta de la imagen del espacio. pRutaImagen != null && pRutaImagen != "".
     * @param pTipo Tipo de espacio. Pertenece a {Espacio.TIPO_AIRE_LIBRE, Espacio.TIPO_AUDITORIO, Espacio.TIPO_RESTAURANTE, Espacio.TIPO_SALA_COMPUTO y Espacio.TIPO_SALON}.
     * @param pTieneInternet Indica si el espacio tiene internet o no, true si tiene, false en caso contrario.
     * @param pCapacidad Capacidad del espacio. pCapacidad > 0.
     * @param pCostoHora Costo por hora del espacio. pCostoHora > 0.
     * @param pTamanio Tama?o del espacio. pTamanio > 0.
     * @param pResponsable Nombre del responsable del espacio. pResponsable != null && pResponsable != "".
     * @return True si el espacio es agregado al centro de convenciones, false si existe un espacio con el mismo nombre.
     */
    public boolean agregarEspacio( String pNombre, String pTipo, boolean pTieneInternet, String pRutaImagen, int pCapacidad, double pCostoHora, double pTamanio, String pResponsable )
    {
        boolean agregado = false;

        if( buscarEspacio( pNombre ) == null )
        {
            Espacio nuevo = new Espacio( pNombre, pTipo, pTieneInternet, pRutaImagen, pCapacidad, pCostoHora, pTamanio, pResponsable );
            espacios.add( nuevo );
            agregado = true;
            verificarInvariante( );
            // TODO Parte 1 Punto K: Llamado a verificarInvariante.
        }

        return agregado;

    }

    /**
     * Agrega un evento al espacio dado.<br>
     * <b> post: </b> Se agreg? el evento con los datos dados por par?metro al espacio con el nombre dado por par?metro.
     * @param pNombreEspacio Nombre del espacio. pNombreEspacio != null && pNombreEspacio != "".
     * @param pNombreEvento Nombre del evento. pNombreEvento != null && pNombreEvento != "".
     * @param pDescripcion Descripci?n del evento. pDescripcion != null && pDescripcion != "".
     * @param pAsistentes Cantidad de asistentes del evento. pAsistentes >= 0.
     * @param pAnio A?o en que el evento se realiza. pAnio >= 2017 && pAnio <= 2020.
     * @param pMes Mes en que el evento se realiza. pMes >= 1 && pMes <= 12.
     * @param pDia D?a en que el evento se realiza. pDia >= 1 && pDia <= 31.
     * @param pHoraInicio Hora de inicio del evento. pHoraInicio >= 8 && pHoraInicio <= 18.
     * @param pHoraFin Hora de fin del evento. pHoraFin >= 8 && pHoraFin <= 18.
     * @param pRutaImagenPublicidad Ruta de la imagen de la publicidad del evento. pRutaImagenPublicidad != null && pRutaImagenPublicidad != "".
     * @return True si el evento fue agregado al espacio, false en caso contrario.
     * @throws EspacioOcupadoException
     */
    public boolean agregarEventoAEspacio( String pNombreEspacio, String pNombreEvento, String pDescripcion, int pAsistentes, int pAnio, int pMes, int pDia, int pHoraInicio, int pHoraFin, String pRutaImagenPublicidad ) throws EspacioOcupadoException
    {
        boolean agregado = false;

        Espacio buscada = buscarEspacio( pNombreEspacio );
        if( buscada != null )
        {
            Fecha fecha = new Fecha( pAnio, pMes, pDia, pHoraInicio, pHoraFin );
            agregado = buscada.agregarEvento( pNombreEvento, pDescripcion, pAsistentes, fecha, pRutaImagenPublicidad );
        }
        else{
            throw new EspacioOcupadoException("Espacio ocupado.");
        }
        return agregado;
    }


    /**
     * Organiza la lista de espacios por nombre usando el algoritmo de burbuja. <br>
     * <b> post: </b> La lista de espacios est? ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre( )
    {
        // TODO Parte 3 Punto A: Completar el m?todo seg?n la documentaci?n dada.

        // TODO Parte 1 Punto L: Llamado a verificarInvariante.
        for (int i = espacios.size(); i > 0; i--) {

            for (int j = 0; j < i-1; j++) {

                Espacio e1 = (Espacio) espacios.get(j);
                Espacio e2 = (Espacio) espacios.get(j+1);

                if(e2.compararPorNombre( e1 ) == -1)
                {
                    espacios.set(j, e2);
                    espacios.set(j+1, e1);
                }
            }
        }
        verificarInvariante( );
    }

    /**
     * Organiza la lista de espacios por capacidad usando el algoritmo de selecci?n. <br>
     * <b> post: </b> La lista de espacios est? ordenada por capacidad (orden ascendente).
     */
    public void ordenarPorCapacidad( )
    {
        // TODO Parte 3 Punto B: Completar el m?todo seg?n la documentaci?n dada.

        // TODO Parte 1 Punto M: Llamado a verificarInvariante.
        for (int i = 0; i < espacios.size() ; i++) {

            Espacio espacioMayor = (Espacio) espacios.get(i);
            int posMayor = i;

            for (int j = i+1; j < espacios.size(); j++) {

                Espacio espacioN = (Espacio) espacios.get(j);

                if(espacioMayor.compararPorCapacidad( espacioN ) > 0){
                    espacioMayor = espacioN;
                    posMayor = j;
                }

            }

            if(posMayor != i){
                espacios.set(posMayor, espacios.get(i));
                espacios.set(i, espacioMayor);
            }
        }
        verificarInvariante( );
    }

    /**
     * Organiza la lista de espacios por cantidad de eventos usando el algoritmo de inserci?n. <br>
     * <b> post: </b>La lista de espacios est? ordenada por cantidad de eventos (orden descendente).
     */
    public void ordenarPorCantidadEventos( )
    {
        // TODO Parte 3 Punto C: Completar el m?todo seg?n la documentaci?n dada.

        // TODO Parte 1 Punto N: Llamado a verificarInvariante.
        for (int i = 1; i < espacios.size(); i++) {

            Espacio espacioInsert = (Espacio) espacios.get(i);
            boolean termino = false;

            for (int j = i; j > 0 && !termino; j--) {

                Espacio espacioActual = (Espacio) espacios.get(j-1);

                if(espacioActual.compararPorCantidadEventos( espacioInsert ) < 0){
                    espacios.set(j, espacioActual);
                    espacios.set(j-1, espacioInsert);
                }
                else{
                    termino = true;
                }
            }
        }

    }


    /**
     * Busca un espacio con el nombre dado por par?metro.
     * @param pNombre Nombre del espacio. pNombre != null && pNombre != "".
     * @return Retorna el espacio con el nombre dado, null si no lo encuentra.
     */
    public Espacio buscarEspacio( String pNombre )
    {
        Espacio pEspacio = null;
        boolean si = false;
        for ( int i = 0; i < espacios.size( ) && !si ; i++)
        {
            Espacio aux = (Espacio) espacios.get( i );
            if ( aux.darNombre( ).equals( pNombre ))
            {
                pEspacio = aux;
                si = true;
            }
        }

        return pEspacio;
        // TODO Parte 4 Punto A: Completar el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Busca un espacio utilizando una b?squeda binaria. <br>
     * <b>pre: </b> La lista de espacios se encuentra ordenada por nombre.
     * @param pNombre Nombre del espacio. pNombre != null && pNombre != "".
     * @return La posici?n del espacio con el nombre dado. <br>
     *         Si el centro de convenciones no tiene espacios se retorna -1.
     */
    public int buscarBinarioPorNombre( String pNombre )
    {
        int posicion = -1;
        int inicio = 0;
        int fin = espacios.size( )-1;
        Espacio pEspacio = buscarEspacio( pNombre );
        if ( pEspacio != null)
        {
            while( inicio <= fin && posicion == -1 )
            {
                int medio = ( inicio + fin ) / 2;
                Espacio mitad = ( Espacio )espacios.get( medio );
                if( mitad.compararPorNombre( pEspacio ) == 0 )
                {
                    posicion = medio;
                }
                else if( mitad.compararPorNombre( pEspacio ) > 0 )
                {
                    fin = medio - 1;
                }
                else
                {
                    inicio = medio + 1;
                }
            }
        }
        return posicion;
        // TODO Parte 4 Punto B: Completar el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Busca el espacio m?s usado del centro de convenciones. <br>
     * @return La posici?n del espacio m?s usado del centro de convenciones. <br>
     *         Si el centro de convenciones no tiene espacios se retorna -1. <br>
     *         Si existen varios espacios con el uso m?s alto, se retorna el primer espacio encontrado.
     */
    public int buscarEspacioMasUsado( )
    {
        int posicion = -1;
        if (espacios.size( ) > 0)
        {
            Espacio menor = (Espacio)espacios.get( 0 );
            posicion = 0;
            for ( int i = 1; i < espacios.size( ); i++)
            {
                Espacio comparar = (Espacio)espacios.get( i );
                if ( menor.compararPorCantidadEventos( comparar ) == -1)
                {
                    posicion = i;
                    menor = comparar;
                }
            }

        }
        return posicion;
        // TODO Parte 4 Punto C: Completar el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Busca el espacio menos usado del centro de convenciones. <br>
     * @return La posici?n del espacio menos usado del centro de convenciones. <br>
     *         Si el centro de convenciones no tiene espacios se retorna -1. <br>
     *         Si existen varios espacios con el uso m?s bajo, se retorna el primer espacio encontrado.
     */
    public int buscarEspacioMenosUsado( )
    {
        int posicion = -1;
        if (espacios.size( ) > 0)
        {
            Espacio menor = (Espacio)espacios.get( 0 );
            posicion = 0;
            for ( int i = 1; i < espacios.size( ); i++)
            {
                Espacio comparar = (Espacio)espacios.get( i );
                if ( menor.compararPorCantidadEventos( comparar ) == 1)
                {
                    posicion = i;
                    menor = comparar;
                }
            }

        }
        return posicion;
        // TODO Parte 4 Punto D: Completar el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Busca los espacios que tienen un evento con el nombre dado por par?metro. <br>
     * @param pNombreEvento Nombre del evento que se desea buscar en el espacio. pNombreEvento != null && pNombreEvento != "".
     * @return Lista de los espacios que tienen un evento con el nombre dado.
     */
    public ArrayList buscarEspaciosConEvento( String pNombreEvento )
    {
        ArrayList respuesta = new ArrayList( );

        for( int i = 0; i < espacios.size( ); i++ )
        {
            Espacio espacio = ( Espacio )espacios.get( i );
            if( espacio.tieneEvento( pNombreEvento ) )
            {
                respuesta.add( espacio );
            }
        }

        return respuesta;
    }

    /**
     * Busca los espacios que tienen eventos con la fecha dada por par?metro. <br>
     * @param pFecha Fecha de los eventos que se desea buscar. pFecha != null && pFecha != "".
     * @return Lista de los espacios con eventos que est?n en la fecha dada.
     */
    public ArrayList buscarEspacioConEventosEnFecha( String pFecha )
    {
        ArrayList respuesta = new ArrayList( );
        String[] fechaPartes = pFecha.split( "/" );
        int anio = Integer.parseInt( fechaPartes[ 0 ] );
        int mes = Integer.parseInt( fechaPartes[ 1 ] );
        int dia = Integer.parseInt( fechaPartes[ 2 ] );
        Fecha fechaComparar = new Fecha( anio, mes, dia, 8, 18 );

        for( int i = 0; i < espacios.size( ); i++ )
        {
            Espacio espacio = ( Espacio )espacios.get( i );
            ArrayList eventos = espacio.darEventos( );

            for( int j = 0; j < eventos.size( ); j++ )
            {

                if( ( ( Evento )eventos.get( j ) ).darFecha( ).comparar( fechaComparar ) == 0 )
                {
                    respuesta.add( espacio );
                }
            }
        }

        return respuesta;
    }

    public void cargar(String pNombreArchivo) throws PersistenciaException, IOException, ClassNotFoundException{
        String archivo = pNombreArchivo;
        File f = new File(archivo);

        espacios = new ArrayList<>();


        if (f.exists()) {

            try {
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(f));
                espacios = (ArrayList) ois.readObject();
                ois.close();
            } catch (IOException e) {
                throw new PersistenciaException(
                        "Error al cargar archivo de cocteles");
            }

        }

        verificarInvariante();
    }

    public void guardar(String nomberArchivo) throws Exception{
        File arch = new File(nomberArchivo);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arch));
            oos.writeObject(espacios);
            oos.close();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage() + " - Error al guardar la galeria");
        }
    }

    public void generarReporte(String pRuta) throws PersistenciaException{
        PrintWriter pw;
        try
        {
            pw = new PrintWriter(new File(pRuta));
            pw.println( "Reporte espacios" );
            pw.println( "Una fecha" );
            pw.println( "Total espacios: "+espacios.size( ) );

            pw.println( "----------------------------------------" );
            for( int i = 0; i < espacios.size( ); i++ )
            {
                Espacio ingrediente = ( Espacio )espacios.get( i );
                pw.println("Nombre:" + ingrediente.darNombre( ) );
                pw.println("Tipo:" + ingrediente.darTipo( ) );
                pw.println("Capacidad:" + ingrediente.darCapacidad( ) );
                pw.println("Tama?o:" + ingrediente.darTamanio( ) );
                pw.println("Costo por hora:" + ingrediente.darCostoHora( ) );
                pw.println("Cantidad de eventos:" + ingrediente.darEventos( ).size( ) );
                pw.println("Responsable:" + ingrediente.darResponsable( ) );

            }
            pw.println( "----------------------------------------" );
        }
        catch( FileNotFoundException e )
        {
            // TODO Auto-generated catch block
            throw new PersistenciaException( "Error." );
        }


    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Clase que representa el centro de convenciones.<br>
     * <b>Invariante: </b> <br>
     */

    private boolean buscarEspaciosConNombresRepetidos ( )
    {
        boolean si = false;
        for (int i = 0; i < espacios.size( ) && !si; i++)
        {
            Espacio buscado = (Espacio)espacios.get( i );
            String nombreDeBus = buscado.darNombre( );
            for (int j = i + 1; j < espacios.size( ); j++ )
            {
                Espacio otro = (Espacio)espacios.get( j );
                String nombreOtro = otro.darNombre( );
                if ( nombreDeBus.equals(nombreOtro))
                {
                    si = true;
                }
            }

        }
        return si;
    }

    private void verificarInvariante ( )
    {
        assert (espacios != null ) : "La lista de espacios no debe ser null";
        assert !buscarEspaciosConNombresRepetidos( ) : "No pueden haber espacios con nombres repetidos";
    }

    // TODO Parte 1 Punto I: Documente e implemente el m?todo verificarInvariante.
    // Si lo necesita, puede crear m?todo privados adicionales.

    // -----------------------------------------------------------------
    // Puntos de Extensi?n
    // -----------------------------------------------------------------

    /**
     * M?todo para la extensi?n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1.";
    }

    /**
     * Metodo para la extensi?n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2.";
    }

}
