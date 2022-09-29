package uniandes.cupi2.centroDeConvenciones.mundo;

import java.io.Serializable;

public class Fecha implements Serializable {

    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * A?o de la fecha.
     */
    private int anio;

    /**
     * Mes de la fecha.
     */
    private int mes;

    /**
     * D?a de la fecha.
     */
    private int dia;

    /**
     * Hora de inicio.
     */
    private int horaInicio;

    /**
     * Hora de fin.
     */
    private int horaFin;

    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------

    /**
     * Inicializa la fecha con los valores dados por par?metro. <br>
     * <b> post: </b> Los atributos dia, mes, anio, horaInicio y horaFin fueron inicializados con los valores dados por par?metro.
     * @param pAnio A?o de la fecha. pAnio >= 2017 && pAnio <= 2020.
     * @param pMes Mes del a?o. pMes > 0 && pMes <= 12.
     * @param pDia D?a del mes. pDia > 0 && pDia <= 31.
     * @param pHoraInicio Hora de inicio del evento. pHoraInicio >= 8 && pHoraInicio <= 18.
     * @param pHoraFin Hora final del evento. pHoraFin >= 8 && pHoraFin <= 18.
     */
    public Fecha( int pAnio, int pMes, int pDia, int pHoraInicio, int pHoraFin )
    {
        anio = pAnio;
        mes = pMes;
        dia = pDia;
        horaInicio = pHoraInicio;
        horaFin = pHoraFin;

        verificarInvariante( );
    }

    // -------------------------------------------------------------
    // M?todos
    // -------------------------------------------------------------

    /**
     * Retorna el a?o de la fecha.
     * @return A?o de la fecha.
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * Retorna el mes del a?o.
     * @return Mes del a?o.
     */
    public int darMes( )
    {
        return mes;
    }

    /**
     * Retorna el d?a del mes.
     * @return D?a del mes.
     */
    public int darDia( )
    {
        return dia;
    }

    /**
     * Retorna la hora de inicio.
     * @return Hora de inicio.
     */
    public int darHoraInicio( )
    {
        return horaInicio;
    }

    /**
     * Retorna la hora de fin.
     * @return Hora de fin.
     */
    public int darHoraFin( )
    {
        return horaFin;
    }

    /**
     * Compara dos fechas. <br>
     * @param pFecha Fecha contra la cual se est? comparando. pFecha != null.
     * @return Retorna 0 si las dos fechas son iguales o su horario se cruza. <br>
     *         Retorna -1 si la fecha pFecha es m?s antigua. <br>
     *         Retorna 1 si la fecha pFecha es m?s reciente. <br>
     */
    public int comparar( Fecha pFecha )
    {
        if ( toString( ).equals( pFecha.toString( ) ) || (anio == pFecha.anio && mes == pFecha.mes && dia == pFecha.dia && horaFin >= pFecha.horaInicio && horaInicio <= pFecha.horaFin))
        {
            return 0;
        }

        else if(toString( ).compareTo( pFecha.toString( ) ) < 0)
        {
            return -1;
        }

        else
        {
            return 1;
        }
        // TODO Parte2 PuntoA Complete el m?todo seg?n la documentaci?n dada.
    }

    /**
     * Retorna una cadena con la informaci?n de la fecha.
     * @return Representaci?n de la fecha en String.
     */
    public String toString( )
    {
        return anio + "/" + mes + "/" + dia + "/" + horaInicio + ":00-" + horaFin + ":00";

    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b> inv: </b> <br>
     * dia > 0 && dia <= 31. <br>
     * mes > 0 && mes <= 12. <br>
     * anio >= 2017 && anio <= 2020. <br>
     * horaInicio >= 8 && horaInicio <=18. <br>
     * horaFin >= 8 && horaFin <=18.
     */
    private void verificarInvariante( )
    {
        assert ( dia > 0 && dia <= 31 ) : "El d?a debe tener un valor entre 1 y 31.";
        assert ( mes > 0 && mes <= 12 ) : "El mes debe tener un valor entre 1 y 12.";
        assert ( anio >= 2017 && anio <= 2020 ) : "El a?o debe ser mayor o igual a 2017 o menor o igual a 2020.";
        assert ( horaInicio >= 8 && horaInicio <= 18 ) : "La hora de inicio debe tener un valor entre 8 y 18.";
        assert ( horaFin >= 8 && horaFin <= 18 ) : "La hora de fin debe tener un valor entre 8 y 18.";
    }

}
