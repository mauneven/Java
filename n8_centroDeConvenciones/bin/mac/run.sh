#!/bin/sh
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# Universidad de los Andes (Bogot? - Colombia)
# Departamento de Ingenier?a de Sistemas y Computaci?n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
# Ejercicio: n7_centroDeConvenciones
# Autor: Equipo Cupi2 2017
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

stty -echo

# ---------------------------------------------------------
# Ejecuci?n del programa
# ---------------------------------------------------------

cd ../..
java -ea -classpath ./lib/centroDeConvenciones.jar uniandes.cupi2.centroDeConvenciones.interfaz.InterfazCentroDeConvenciones
cd bin/mac

stty echo
