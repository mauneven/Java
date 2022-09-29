/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot? - Colombia)
 * Departamento de Ingenier?a de Sistemas y Computaci?n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_centroDeConvenciones
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.centroDeConvenciones.test;

import uniandes.cupi2.centroDeConvenciones.mundo.Fecha;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los m?todos de la clase Fecha est?n correctamente implementados.
 */
public class FechaTest extends TestCase
{
    // -------------------------------------------------------------
    // Atributos
    // -------------------------------------------------------------

    /**
     * Fecha donde se har?n las pruebas.
     */
    private Fecha fecha;

    // -------------------------------------------------------------
    // M?todos
    // -------------------------------------------------------------

    /**
     * Escenario 1: Construye una fecha.
     */
    public void setupEscenario1( )
    {
        fecha = new Fecha( 2017, 05, 13, 10, 14 );
    }

    /**
     * Prueba 1: Se encarga de verificar el m?todo constructor de la clase.<br>
     * <b> M?todos a probar: </b> <br>
     * Fecha<br>
     * darDia<br>
     * darMes<br>
     * darAnio<br>
     * darHoraInicio <br>
     * darHoraFin <br>
     * <b> Casos de prueba:</b><br>
     * 1. Construye correctamente la fecha, cada uno de los valores corresponde al esperado.<br>
     */
    public void testFecha( )
    {
        setupEscenario1( );

        assertEquals( "El a?o no fue inicializado correctamente.", 2017, fecha.darAnio( ) );
        assertEquals( "El mes no fue inicializado correctamente.", 5, fecha.darMes( ) );
        assertEquals( "El d?a no fue inicializado correctamente.", 13, fecha.darDia( ) );
        assertEquals( "La hora de inicio no fue inicializada correctamente.", 10, fecha.darHoraInicio( ) );
        assertEquals( "La hora de fin no fue inicializada correctamente.", 14, fecha.darHoraFin( ) );

    }

    /**
     * Prueba 2: Se encarga de verificar el m?todo comparar de la clase.<br>
     * <b> M?todos a probar: </b> <br>
     * comparar<br>
     * <b> Casos de prueba:</b><br>
     * 1. Las dos fechas son iguales.<br>
     * 2. La fecha a comparar se cruza con la fecha actual. <br>
     * 3. La fecha a comparar es m?s reciente que la fecha actual.<br>
     * 4. La fecha a comparar es m?s antigua que la fecha actual.
     */
    public void testComparar( )
    {
        setupEscenario1( );

        // Caso de prueba 1.
        Fecha fecha2 = new Fecha( 2017, 05, 13, 10, 14 );
        int resultadoComparacion = fecha.comparar( fecha2 );
        assertEquals( "El resultado de la comparaci?n deber?a dar 0: las dos fechas son iguales.", 0, resultadoComparacion );

        // Caso de prueba 2.
        fecha2 = new Fecha( 2017, 05, 13, 9, 11 );
        resultadoComparacion = fecha.comparar( fecha2 );
        assertEquals( "El resultado de la comparaci?n deber?a dar 0: las dos fechas se cruzan.", 0, resultadoComparacion );

        fecha2 = new Fecha( 2017, 05, 13, 13, 16 );
        resultadoComparacion = fecha.comparar( fecha2 );
        assertEquals( "El resultado de la comparaci?n deber?a dar 0: las dos fechas se cruzan.", 0, resultadoComparacion );

        // Caso de prueba 3.
        fecha2 = new Fecha( 2017, 05, 14, 10, 14 );
        resultadoComparacion = fecha.comparar( fecha2 );
        assertEquals( "El resultado de la comparaci?n deber?a dar 1: fecha es m?s antigua.", 1, resultadoComparacion );

        fecha2 = new Fecha( 2017, 12, 13, 9, 15 );
        resultadoComparacion = fecha.comparar( fecha2 );
        assertEquals( "El resultado de la comparaci?n deber?a dar 1: fecha es m?s antigua.", 1, resultadoComparacion );

        // Caso de prueba 4.
        fecha2 = new Fecha( 2017, 05, 12, 9, 11 );
        resultadoComparacion = fecha.comparar( fecha2 );
        assertEquals( "El resultado de la comparaci?n deber?a dar -1: fecha es m?s reciente.", -1, resultadoComparacion );

        fecha2 = new Fecha( 2017, 01, 16, 9, 11 );
        resultadoComparacion = fecha.comparar( fecha2 );
        assertEquals( "El resultado de la comparaci?n deber?a dar -1: fecha es m?s reciente.", -1, resultadoComparacion );
    }

}
