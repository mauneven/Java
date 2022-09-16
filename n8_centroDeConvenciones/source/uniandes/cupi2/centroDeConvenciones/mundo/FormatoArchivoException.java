/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_centroDeConvenciones
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.centroDeConvenciones.mundo;

/**
 * Excepción que sirve para indicar que hubo un problema procesando el archivo con la información de los espacios. <br>
 */
public class FormatoArchivoException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepción con el mensaje que se pasa como parámetro y que describe la causa del problema.
     * @param pCausa Mensaje que describe el problema. pCausa != null && pCausa != "".
     */
    public FormatoArchivoException( String pCausa )
    {
        super( pCausa );
    }

}
