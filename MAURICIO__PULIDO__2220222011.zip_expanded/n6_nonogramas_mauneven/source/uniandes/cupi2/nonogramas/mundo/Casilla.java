package uniandes.cupi2.nonogramas.mundo;

public class Casilla
{
	private int pista;
	private boolean estActual;
	private boolean estSolucion;

	public Casilla() 
	{
		pista = -1;
		estActual = false;
		estSolucion = false;

		verificarInvariante();
	}
	
	public int getPista()
	{
		return pista;
	}

	public void setPista(int pista)
	{
		this.pista = pista;
	}
	
	public boolean isEstActual()
	{
		return estActual;
	}

	public void setEstActual(boolean estActual)
	{
		this.estActual = estActual;
	}

	public boolean isEstSolucion()
	{
		return estSolucion;
	}

	public void setEstSolucion(boolean estSolucion)
	{
		this.estSolucion = estSolucion;
	}

	public void verificarInvariante()
	{
		assert estActual==false || estActual == true ;
		assert estSolucion == false || estSolucion == true;
	}
}
