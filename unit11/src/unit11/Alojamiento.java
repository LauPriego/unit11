package unit11;

import java.util.ArrayList;


/**
 * 
 * @author LAURA MARTINEZ PRIEGO
 * CLASE BASE DE LOS DIFERENTES ALOJAMIENTOS
 * LAS DEMAS HEREDAN DE ELLA
 *
 */
public class Alojamiento 
{
	String ciudad, nombreAlojamiento;
	protected String tipo;
	String[] calendarioReservas;
	ArrayList<Reserva> reservas = new  ArrayList<Reserva>();
	int precio;
	int precioExtras;//por ahora los extras seránúnicos
	
	/**
	 * CONSTRUCTOR PARAMETRICO
	 * @param nombreAlojamiento
	 * @param ciudad
	 * @param precio
	 * @param extras
	 */
	public Alojamiento(String nombreAlojamiento, String ciudad, int precio, int extras)
	{
		this.ciudad = ciudad;
		calendarioReservas = new String[366];
		this.precio = precio;
		this.precioExtras = extras;
				
		//INICIALIZO EL CALENDARIO CON VACIOS PARA EVITAR ERRORES DE PUNTOS NULOS
		for (int i = 0; i < 366; i++) 
		{
			calendarioReservas[i] = "";
		}
		this.nombreAlojamiento = nombreAlojamiento;
	}
	
	/**
	 * DEVUELVE UN BOOLENA CON TRUE SI ESTA DISPONIBL Y FALSE SI NO LO ESTA
	 * @param fInicio
	 * @param fFin
	 * @return
	 */
	public boolean ComprobarDisponibilidad(String fInicioS, String fFinS)
	{
		int fInicio = ConvertirDiaDelAnyo(fInicioS);
		int fFin = ConvertirDiaDelAnyo(fFinS);
		
		for (int i = fInicio-1; i < fFin-1; i++) 
		{
			if (!calendarioReservas[i].equals("")) 
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * INTRODUCE EN EL ARRAY DE DIAS DEL AÑO  en el de reservas LA RESERVA 
	 * @param fInicio
	 * @param fFin
	 * @param nombreReserva
	 */
	public void GuardarReserva(String fInicioS, String fFinS, String nombreReserva)
	{
		int fInicio = ConvertirDiaDelAnyo(fInicioS);
		int fFin = ConvertirDiaDelAnyo(fFinS);
		
		for (int i = fInicio-1; i < fFin-1; i++) 
		{
			calendarioReservas[i] = nombreReserva;
		}
		reservas.add(new Reserva(nombreAlojamiento,fInicioS, fFinS, nombreReserva));
		
		
	}
	
	
	/**
	 * ASIGNA TIPO DE ALOJAMIENTO
	 * @param tipo
	 */
	public void SetTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
	
	/**
	 * muetsra las reservas
	 */
	public void MostrarReservas()
	{
		if (!reservas.isEmpty())
		{
			System.out.println("-----------------------------------------\n"+nombreAlojamiento + "    |    "+ ciudad);
			
			for (Reserva r : reservas) 
			{
				System.out.println(r.nombre + " Tiene reserdado de "+ r.fechaEntrada + " a " + r.fechaSalida+"\n----------------------------------------\n");
			}
			
		}
		
		
	}
	
	/**
	 * Dado un string modelo dd/mm retorna el día del año que es esa fecha
	 * EN LA SIGUIENTE ITERACION SI DA TIEMPO IMPLEEMENTO CON AÑOS
	 * así lo podré poner en la matriz de reservas introduciendo el dia delaño como el indice en el array
	 */
	public int ConvertirDiaDelAnyo(String fecha)
	{
		String[] fechaNum = fecha.split("/");
		
		int dia = Integer.parseInt(fechaNum[0]);
		int mes = Integer.parseInt(fechaNum[1]);
		int fechaConvertida = 0;
		
		//System.out.println("el dia es" + dia);
		
		
		//desestimo el año porque es una versión preliminar de la app
		int[] diasMeses = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		
		for (int i = 0; i < mes-1; i++) 
		{
			fechaConvertida += diasMeses[i];
		}
		
		return fechaConvertida +=dia;		
		
		
	}
	
	/**PARA IMPLEMENTAR EN LAS SUCESIVAS HEREDADAS*/
	public void MostrarAlojamiento(){}
	
}
