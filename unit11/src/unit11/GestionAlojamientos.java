package unit11;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Nucleo del software que gestiona las demás clases y su funcionalidad
 * @author Laura martinez Priego
 * PROYECTO ENTORNOS 2015 
 * 
 */
public class GestionAlojamientos 
{
	private static ArrayList<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
	

	public static void main(String[] args) 
	{
		Scanner lectura = new Scanner(System.in);
		String ciudad ="", salir = "";
		boolean hayAlojamiento = false;
		Alojamiento alojamientoElegido = null;
		int precioTotal = 0;
		
		rellenaAlojamientos();
		
		do
		{
			do
			{
				
				System.out.println("\nHOLA, BIENVENIDO AL SISTEMA DE GESTÓN DE RESERVAS DE VIAJAMUCHO.COM\nPor favor, dinos a qué ciudad deseas viajar o escribe S para salir");
				ciudad = lectura.next();
				
				hayAlojamiento = mostrarAlojamientosPorCiudad(ciudad);
			
				if (hayAlojamiento) 
					System.out.println("Por favor indica el nombre del alojamiento que prefieras");
				
				else 
					{
						if (ciudad.equals("S"));
						else	System.out.println("No disponemos de alojamientos disponibles en " + ciudad + "\nPuede que haya escrito mal el nombre ¿es así?");
					}
			}
			while (!ciudad.equals("S") && !hayAlojamiento);
			
			if (!ciudad.equals("S")) 
			{
				
				String nombreAlojamiento = lectura.next();
				
				
				do
				{
					alojamientoElegido = extraeAlojamientoElegido(nombreAlojamiento); //no lo extraigo con indexof porque da errores de iteracion
					if(alojamientoElegido == null) 
						{
							System.out.println("No hemos encontrado el alojamiento que indicas, ¿Tal vez lo escribieses mal?\nInténtado de nuevo");
							nombreAlojamiento = lectura.next();
						}
										
					
				}
				while (alojamientoElegido == null);
				
				
				System.out.print("Has elegido: \n");
				alojamientoElegido.MostrarAlojamiento();
				
				//POR AHORA DESESTIMO EL AÑO, EN LA SIGUIENTE ITERACIÓN L OPUEDO IMPLEMENTAR
				System.out.println("\nEn qué fecha deseas entrar dd/mm?");
				String fInicioS = lectura.next();
				
				
				System.out.println("\nEn qué fecha deseas salir dd/mm/?");
				String fFinS = lectura.next();
				
				
				if (alojamientoElegido.ComprobarDisponibilidad(fInicioS,fFinS)) 
				{
					System.out.println(alojamientoElegido.nombreAlojamiento + " está disponible en esas fechas, desea reservarla ya? S/N");
					
					if (lectura.next().equalsIgnoreCase("s")) 
					{
						precioTotal = alojamientoElegido.precio;
						
						System.out.println("Indica tu nombre para efectuar la reserva");
						String nombreReserva = lectura.next();
						if (alojamientoElegido.tipo == "Hotel")
							{
								alojamientoElegido.GuardarReserva(fInicioS, fFinS, nombreReserva);
								System.out.println("Qué tipo de pensión deseas:\n1-Sólo desayuno\n2-Media pensión\n3-Pensión Completa \n(elige1,2,3)");
								precioTotal += ((Hotel) alojamientoElegido).SetPension(lectura.nextInt());
								//por ahora los estras valían todo sigual, en la siguiente iteración ya implementaremos más

							}
						if(alojamientoElegido.tipo == "Hostal")
						{
							alojamientoElegido.GuardarReserva(fInicioS, fFinS, nombreReserva);
							System.out.println("Deseas incluir desayuno? S/N");
							
							precioTotal += ((Hostal) alojamientoElegido).SetDesayuno(lectura.next());
							
						}
						if(alojamientoElegido.tipo == "Albergue")
						{
							alojamientoElegido.GuardarReserva(fInicioS, fFinS, nombreReserva);
							if (((Albergue) alojamientoElegido).getPosibilidadDucha() == true) 
							{
								System.out.println("Este Albergue ofrece la posibilidad de tener duchas individuales.\n"
										+ "Deseas una habitación comunitaria con duchas individuales? S/N");
								precioTotal += ((Albergue) alojamientoElegido).SetDuchaIndividual(lectura.next());
							}
							
							
						}
						
						System.out.println("RESERVA EFECTUADA PARA " + nombreReserva + " desde " + fInicioS + " hasta " + fFinS+" en "+ alojamientoElegido.nombreAlojamiento);
						System.out.println("Al llegar al alojamiento deberás pagar " + precioTotal + "€, recuerda llevarlos encima y BUEN VIAJE!!");
					}
					
				}
				else System.out.println("Lo sentimos, no tenemos disponibilidad en estas fechas para este alojamiento");
			
				
				
				
			
			}
			System.out.println("\nESTAS SON LAS RESERVAS ACTUALES: ");
			
			for (Alojamiento a : alojamientos) 
			{
				a.MostrarReservas();
			}
			
			
			System.out.println("Ahora deseas salir del programa?");
			salir = lectura.next();
		}
		while(!salir.equalsIgnoreCase("s"));
		
		
		
		System.out.println("HASTA PRONTO!!");
		
		
		
		
		
		
	}
	
	
	/**
	 * Llena el array de alojamientos, en esta primera implementacion los creo así, 
	 * en sucesivas se podría guardar en un BD y extraer de ella o 
	 * guardaren archivos
	 */
	public static void rellenaAlojamientos()
	{
		alojamientos.add(new Hostal("Pepita", "Valencia", 40, 10));
		alojamientos.add(new Albergue("JustSleep", "Madrid", false, 15, 5));
		alojamientos.add(new Hotel("Los madriles", "Madrid", 5,  true, 59, 20));
		alojamientos.add(new Hotel("villa Valencia", "Valencia", 3,  false, 90, 25));
		alojamientos.add(new Albergue("Barnacity", "Barcelona", true, 40, 10));
		alojamientos.add(new Hotel("EL Montjuic", "Barcelona", 4,  false, 180, 39));
		alojamientos.add(new Hostal("Ramblas", "Barcelona", 27, 12));
		alojamientos.add(new Hotel("Caceres", "Barcelona", 1,  false, 97, 26));
		alojamientos.add(new Hotel("Luguito", "Madrid", 5,  true, 390, 67));
		alojamientos.add(new Albergue("Mochilismo", "Valencia", true, 39, 18));
		alojamientos.add(new Hostal("Jamones", "Madrid", 67, 21));
		alojamientos.add(new Hotel("Gasteiz", "Barcelona", 2,  true, 76, 20));
		alojamientos.add(new Albergue("Caminito", "Valencia", true, 43, 19));
	}
	
	
	/**
	 * la clase muetsra os alojamientos en la ciudad deseada y nos retorna un booleano que indica si los hay o no
	 * @param ciudad
	 * @return
	 */
	public static boolean mostrarAlojamientosPorCiudad(String ciudad)
	{
		boolean existenAlojamientos = false;
		
		if (ciudad.equals("S")) return false;
		
		System.out.println("En " + ciudad + " disponemos de los siguientes alojamientos:\n");
		for (Alojamiento a : alojamientos) 
		{
			if (a.ciudad.equalsIgnoreCase(ciudad)) 
			{
				
				a.MostrarAlojamiento();
				existenAlojamientos = true;
			}
		}
		
		
		return existenAlojamientos;
			
		
	}
	
	
	
	
	/**
	 * metodo para extraer el alojamiento elegido de forma segura
	 * 
	 */
	public static Alojamiento extraeAlojamientoElegido(String nombre)
	{
		for (Alojamiento a : alojamientos) 
		{
			if (a.nombreAlojamiento.equalsIgnoreCase(nombre)) return a;
		}
		return null;
		
		
		//alojamientos.get(alojamientos.indexOf(lectura.next()));
	}
}
