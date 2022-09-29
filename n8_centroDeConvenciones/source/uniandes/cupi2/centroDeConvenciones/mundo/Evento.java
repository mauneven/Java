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

import java.io.Serializable;

/**
 * Clase que representa un evento.<br>
 * <b>inv: </b> <br>
 * nombre != null <br>
 * !nombre.equals ("") <br>
 * descripcion != null <br>
 * !descripcion.equals("") <br>
 * asistentes >= 0 <br>
 * fecha != null <br>
 * rutaImagenPublicidad != null <br>
 * !rutaImagenPublicidad.equals ("") <br>
 * TODO Parte 1 Punto A: Declare el invariante de la clase.
 */
public class Evento implements Serializable
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del evento.
     */
    private String nombre;

    /**
     * Descripci?n del evento.
     */
    private String descripcion;

    /**
     * Cantidad de asistentes al evento.
     */
    private int asistentes;

    /**
     * Fecha del evento.
     */
    private Fecha fecha;

    /**
     * Ruta de la imagen de la publicidad del evento.
     */
    private String rutaImagenPublicidad;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo evento. <br>
     * <b> post: </b> El nombre, la descripci?n, los asistentes y la fecha se inicializaron con los valores dados por par?metro.
     * @param pNombre Nombre del evento. pNombre != null && pNombre != "".
     * @param pDescripcion Descripci?n del evento. pDescripcion != null && pDescripcion != "".
     * @param pAsistentes Asistentes al evento. pAsistentes > 0.
     * @param pFecha Fecha del evento. pFecha != null.
     * @param pRutaImagenPublicidad Ruta de la imagen de la publicidad del evento. pRutaImagenPublicidad != null && pRutaImagenPublicidad != "".
     */
    public Evento( String pNombre, String pDescripcion, int pAsistentes, Fecha pFecha, String pRutaImagenPublicidad )
    {
        nombre = pNombre;
        descripcion = pDescripcion;
        asistentes = pAsistentes;
        fecha = pFecha;
        rutaImagenPublicidad = pRutaImagenPublicidad;
        verificarInvariante( );
        // TODO Parte 1 Punto C: Llamado a verificarInvariante.
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del evento.
     * @return Nombre del evento.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la descripci?n del evento.
     * @return Descripci?n del evento.
     */
    public String darDescripcion( )
    {
        return descripcion;
    }

    /**
     * Retorna la cantidad de asistentes del evento.
     * @return Cantidad de asistentes del evento.
     */
    public int darCantidadAsistentes( )
    {
        return asistentes;
    }

    /**
     * Retorna la fecha del evento.
     * @return Fecha del evento.
     */
    public Fecha darFecha( )
    {
        return fecha;
    }

    /**
     * Retorna la ruta de la imagen de la publicidad del evento.
     * @return Ruta de la imagen de la publicidad del evento.
     */
    public String darRutaImagenPublicidad( )
    {
        return rutaImagenPublicidad;
    }

    /**
     * Retorna la fecha y el nombre del evento.
     * @return Fecha del evento y nombre.
     */
    public String toString( )
    {
        return fecha + "-" + nombre;

    }

    // -------------------------------------------------------
    // Invariante
    // -------------------------------------------------------
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertionError. <br>
     * <b>inv: <br>
     * El nombre del evento no es nula ni es una cadena vacia <br>
     * La descripcion del evento no es nula ni es una cadena vacia <br>
     * El numero de asistentes no puede ser menor que 0 <br>
     * La fecha no puede ser nula <br>
     * La ruta de la imagen no es nula ni es una cadena vacia <br>
     */
    private void verificarInvariante( )
    {
        assert (nombre != null) : "El nombre no puede ser null";
        assert (!nombre.equals("")) : "El nombre no puede ser una cadena vacia";
        assert (descripcion != null) : "La descripci?n no puede ser null";
        assert (!descripcion.equals( "" )) : "La descripcion no puede ser una cadena vacia";
        assert (asistentes >= 0) : "El numero de asistentes no puede ser menor a 0";
        assert (fecha != null) : "La fecha no puede ser null";
        assert (rutaImagenPublicidad != null) : "La ruta de la imagen no puede ser null";
        assert (!rutaImagenPublicidad.equals("")) : "La ruta de la imagen no puede ser una cadena vacia";

    }
    // TODO Parte 1 Punto B: Implemente y documente el m?todo verificarInvariante.
}

