package uniandes.cupi2.centroDeConvenciones.mundo;

/**
 * Es la clase de excepci?n que se lanza cuando se presenta un error de serializaci?n/deserializaci?n,
 * al leer o escribir el archivo binario con la informaci?n del estado del mundo.
 * El mensaje asociado con la excepci?n describe el problema que se present?.
 * @author usuario
 *
 */

public class PersistenciaException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepci?n con el mensaje que se pasa como par?metro y que describe la causa del problema
     * @param causa el mensaje que describe el problema
     */
    public PersistenciaException( String causa )
    {
        super( causa );
    }

}
