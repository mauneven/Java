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
# Asegura la creaci?n de los directorios classes y lib
# ---------------------------------------------------------

cd ../..
mkdir classes
mkdir lib

# ---------------------------------------------------------
# Compila las clases del directorio source
# ---------------------------------------------------------

cd source
javac -encoding ISO-8859-1 -source 1.5 -nowarn -d ../classes/ uniandes/cupi2/centroDeConvenciones/mundo/*.java
javac -encoding ISO-8859-1 -source 1.5 -nowarn -d ../classes/ uniandes/cupi2/centroDeConvenciones/interfaz/*.java

# ---------------------------------------------------------
# Crea el archivo jar a partir de los archivos compilados
# ---------------------------------------------------------

cd ../classes
jar cf ../lib/centroDeConvenciones.jar uniandes/*

cd ../bin/mac

stty echo