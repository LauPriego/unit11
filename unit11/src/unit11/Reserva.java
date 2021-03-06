package unit11;

/**
* CLASE SOBRE LA CUAL SE GUARDAN LAS RESERVAS
* 
* @author Laura martinez Priego
* PROYECTO ENTORNOS 2015 
* 
*/
public class Reserva 
{
	String nombre, fechaEntrada, fechaSalida, nombreAlojamiento;
	
	/**
	 * CONSTRUCTOR
	 * @param nombreAlojamiento
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param nombre
	 */
	public Reserva(String nombreAlojamiento, String fechaEntrada, String fechaSalida, String nombre)
	{
		this.nombre = nombre;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida; 
		this.nombreAlojamiento = nombreAlojamiento;
	}
}
