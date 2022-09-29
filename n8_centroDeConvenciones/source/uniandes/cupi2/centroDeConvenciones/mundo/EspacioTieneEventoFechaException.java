package uniandes.cupi2.centroDeConvenciones.mundo;

public class EspacioTieneEventoFechaException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepci?n indicando indica el nombre del espacio y el nombre del evento que se intent? agregar.
     * @param nombreEspacio nombre del espacio
     * @param nombreEvento nombre del evento
     */
    public EspacioTieneEventoFechaException ( String nombreEspacio, String nombreEvento  )
    {
        super( nombreEspacio );
    }
}