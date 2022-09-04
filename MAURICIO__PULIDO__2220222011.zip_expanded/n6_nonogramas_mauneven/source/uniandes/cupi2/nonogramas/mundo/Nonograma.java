package uniandes.cupi2.nonogramas.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Nonograma
{
	public final static String ERROR_CARGAR = "El archivo no tiene el formato esperado.";
	public final static String SIN_CARGAR = "No hay ningún juego en curso";
	
	private String nombreReto;
	private Casilla[][] pistasF;
	private Casilla[][] pistasC;
	private Casilla[][] respuestas;
	private Properties myProp;
	
	public void cargarNono(Properties pProp)
	{
		myProp = pProp;
		pistasC = new Casilla[2][5];
		pistasF = new Casilla[5][2];
		respuestas = new Casilla[5][5];
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				respuestas[i][j] = new Casilla();
			}
		}
	}

	public void leerInfo()
	{
		for (int i = 0; i < 5; i++)
		{
			nombreReto = myProp.getProperty("nonograma.nombreProblema");
			String spistasC = myProp.getProperty("nonograma.pistasColumna"+(i+1));
			String spistasF = myProp.getProperty("nonograma.pistasFila"+(i+1));

			String[] cpistasC = new String[2];
			cpistasC = spistasC.split(";");
			pistasC[0][i] = new Casilla();
			pistasC[1][i] = new Casilla();
			(pistasC[0][i]).setPista(Integer.parseInt(cpistasC[0].trim()));
			(pistasC[1][i]).setPista(Integer.parseInt(cpistasC[1].trim()));
			
			String[] cpistasF = new String[2];
			cpistasF = spistasF.split(";");
			pistasF[i][0] = new Casilla();
			pistasF[i][1] = new Casilla();
			(pistasF[i][0]).setPista(Integer.parseInt(cpistasF[0].trim()));
			(pistasF[i][1]).setPista(Integer.parseInt(cpistasF[1].trim()));
			
			String sresp = myProp.getProperty("nonograma.tableroFila"+(i+1));
			for (int j = 0; j < 5; j++)
			{
				boolean marcado = false;
				int marca = (Integer.parseInt((sresp.charAt(j)+"").trim()));
				if (marca == 1)
				{
					marcado = true;
				}
				(respuestas[i][j]).setEstSolucion(marcado);;
			}
		}
	}	
	
	public String getNombreReto()
	{
		return nombreReto;
	}

	public void setNombreReto(String nombreReto)
	{
		this.nombreReto = nombreReto;
	}

	public Casilla[][] darPistasC()
	{
		return pistasC;
	}
	
	public Casilla[][] darPistasF()
	{
		return pistasF;
	}
	
	public Casilla[][] darRespuestas()
	{
		return respuestas;
	}

	public boolean estaResuelto()
	{
		for(int i = 0; i < respuestas.length; i++)
		{
			for(int j = 0; j < respuestas[i].length;j++)
			{
				if(respuestas[i][j].isEstActual() != respuestas[i][j].isEstSolucion())
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public String correctasFila() throws Exception
	{
		if (myProp != null)
		{
			int correctasFila[] = new int[5];
			for (int i = 0; i < respuestas.length; i++)
			{
				for (int j = 0; j < respuestas[i].length; j++)
				{
					if(respuestas[i][j].isEstActual() == respuestas[i][j].isEstSolucion())	
					{
						correctasFila[i]++;
					}
				}
			}
			String mensajeFilas = "";
			for (int i = 0; i < 5; i++)	
			{
				mensajeFilas += "Fila " + (i+1) + ": "
			+ correctasFila[i] + " casillas correctas\n";
			}
			return mensajeFilas;
		}
		else
		{
			throw new Exception(SIN_CARGAR);
		}
	}
	
	public String correctasColumna() throws Exception
	{	
		if (myProp != null)
		{
			int correctasColumna[] = new int[5];
			for (int i = 0; i < respuestas.length; i++)
			{
				for (int j = 0; j < respuestas[i].length; j++)
				{
					if(respuestas[i][j].isEstActual() == respuestas[i][j].isEstSolucion())	
					{
						correctasColumna[j]++;
					}
				}
			}
			String mensajeColumnas = "";
			for (int i = 0; i < 5; i++)	
			{
				mensajeColumnas += "Columna " + (i+1) + ": " + correctasColumna[i] + " casillas correctas\n";
			}
			return mensajeColumnas;
		}
		else
		{
			throw new Exception(SIN_CARGAR);
		}
	}
	
	public void reiniciarNonograma()
	{
		for (int i = 0; i < respuestas.length; i++)
		{
			for (int j = 0; j < respuestas[i].length;j++)
			{
				respuestas[i][j].setEstActual(true);
			}
		}
	}
	
}
