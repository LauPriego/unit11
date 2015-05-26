package unit11;
/**
* UN TIPO DE ALOJAMIENTO
*
* @author Laura martinez Priego
*  PROYECTO ENTORNOS 2015 
* 
*/
public class Hostal extends Alojamiento
{
	boolean conDesayuno;
	
	/**
	 * CONSTRUCTOR
	 * @param nombreAlojamiento
	 * @param ciudad
	 * @param precio
	 * @param extras
	 */
	public Hostal(String nombreAlojamiento, String ciudad, int precio, int extras)
	{
		super(nombreAlojamiento, ciudad, precio, extras);
		super.SetTipo("Hostal");
	}
	
	
	/**
	 * SELECCIONAR SI SE DESEA DESAYUNO INCLUIDO EN EL PRECIO
	 * @param opcion
	 * @return
	 */
	public int SetDesayuno(String opcion) 
	{
		if (opcion.equalsIgnoreCase("s")) 			
			this.conDesayuno = true;
		else this.conDesayuno = false;
		return super.precioExtras;
	}
	
	
	/**
	 * METODO DE HERENCIA, MUESTRA LAS CCAS DEL HOSTAL
	 */
	@Override 
	public void MostrarAlojamiento()
	{
		
		System.out.println("TIPO: "+ super.tipo+ " | NOMBRE: "+ super.nombreAlojamiento+ " | ofrece posibilidad de desayuno(+"+precioExtras+")"+") | PRECIO-NOCHE:" + precio);
	}
}
