#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot� - Colombia)
# Departamento de Ingenier�a de Sistemas y Computaci�n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n7_centroDeConvenciones
# Autor: Equipo Cupi2 2017
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci�n de las pruebas
# ---------------------------------------------------------

cd ../..
	
java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.FechaTest
java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.EventoTest
java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.EspacioTest
java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.CentroDeConvencionesTest

cd bin/mac

stty echo
