package unit11;

enum Pension{DESAYUNO, MEDIA, COMPLETA};

/**
* UN TIPO DE ALOJAMIENTO
*  
* @author Laura martinez Priego
* PROYECTO ENTORNOS 2015
* 
*/
public class Hotel extends Alojamiento
{
	Pension TipoDePension;
	int estrellas;
	boolean piscina;
	
	/**
	 * CONSTRUCTOR
	 * @param nombreAlojamiento
	 * @param ciudad
	 * @param estrellas
	 * @param piscina
	 * @param precio
	 * @param extras
	 */
	public Hotel(String nombreAlojamiento, String ciudad, int estrellas, boolean piscina, int precio, int extras)
	{
		super(nombreAlojamiento, ciudad, precio, extras);
		this.estrellas = estrellas;
		this.piscina = piscina;
		
		super.SetTipo("Hotel"); 
		
	}
	
	
	/**
	 * SELECCIONAR EL TIPO DE PENSION QUE SE QUIERE
	 * @param num
	 * @return
	 */
	public int SetPension(int num)
	{
		int precio =0;
		switch (num)
		{
			case 1:
				{
					TipoDePension = Pension.DESAYUNO;
					precio = super.precioExtras;
				}
			break;
			case 2:
				{
					TipoDePension = Pension.MEDIA;
					precio = super.precioExtras*2;
				}
			break;
			case 3:
				{
					TipoDePension = Pension.COMPLETA;
					precio = super.precioExtras*3;
				}
			break;
		}
		return precio;
	}
	
	/**
	 * METODO DE HERENCIA, MUESTRA LAS CCAS DEL HOTEL
	 */
	@Override 
	public void MostrarAlojamiento()
	{
		//piscina mostrará true, pero por el momento busco funcionalidad que no hay tiempo para muchomás
		System.out.println("TIPO: "+ super.tipo+ " | NOMBRE: "+ super.nombreAlojamiento+ " | ESTRELLAS: "+ estrellas+ " | PISCINA: "+ piscina+ " | PENSIÓN: desayno,media o completa(+"+precioExtras+") | PRECIO-NOCHE:" + precio);
	}
}
