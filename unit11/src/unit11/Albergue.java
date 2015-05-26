package unit11;
/**
 * UN TIPO DE ALOJAMIENTO
 * 
 * @author Laura martinez Priego
 * 
 * 
 */
public class Albergue extends Alojamiento
{
	boolean posibilidadDeDuchaIndividual;
	boolean eleccionSobreDuchaindividual;
	
	public Albergue(String nombreAlojamiento, String ciudad, boolean duchaIndividual, int precio, int extras)
	{
		super(nombreAlojamiento, ciudad, precio, extras);
		this.posibilidadDeDuchaIndividual = duchaIndividual;
		super.SetTipo("Albergue");
		
	}
	
	/**
	 * SELECCIONAR SI SE QUIERE O NO DUCHA INDIVIDUAL
	 * @param opcion
	 * @return
	 */
	public int SetDuchaIndividual(String opcion)
	{
		if (opcion.equalsIgnoreCase("s")) 			
			this.eleccionSobreDuchaindividual = true;
		else this.eleccionSobreDuchaindividual = false;
		return super.precioExtras;
	}
	
	/**
	 * DTERMINAR SI SE PUEDE ELEGIR DUCHA INDIVIDUAL
	 * @return
	 */
	public boolean getPosibilidadDucha() 
	{
		return posibilidadDeDuchaIndividual;
	}
	
	/**
	 * METODO DE HERENCIA, MUESTRA LAS CCAS DEL ALBERGUE
	 */
	@Override 
	public void MostrarAlojamiento()
	{
		
		System.out.print("TIPO: "+ super.tipo+ " | NOMBRE: "+ super.nombreAlojamiento+ " | POSIBILIDAD DUCHA INDIV.: ");
		if (posibilidadDeDuchaIndividual) 
		{
			System.out.println("SI(+"+precioExtras+")"+") | PRECIO-NOCHE:" + precio);
		}
		else System.out.println("NO | PRECIO-NOCHE:" + precio);
	}
}
