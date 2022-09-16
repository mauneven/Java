@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n7_centroDeConvenciones
REM Autor: Equipo cupi2 2017
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..

java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.FechaTest
java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.EventoTest
java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.EspacioTest
java -ea -classpath ./lib/centroDeConvenciones.jar:./test/lib/centroDeConvencionesTest.jar:./test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.centroDeConvenciones.test.CentroDeConvencionesTest