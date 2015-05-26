package unit11;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * Clase para probar los métods de la clase CadenaAlumno.java
 * 
 * @author Laura Martinez Priego 1º DAM
 *
 */
public class AlojamientoTest 
{
	static Alojamiento a = new Alojamiento("pepita", "valencia", 15, 60);
	
	@BeforeClass
	public static void setUpsetUpBeforeClass()
	{
		
		a.GuardarReserva("05/07", "09/08", "RESERVAPARALASPRUEBAS");
		
	}
	

	
	@Test
	public void testComprobarDisponibilidad1() 
	{
		String fI = "03/07";
		String fF = "13/07";
		
		boolean resultadoObtenido = a.ComprobarDisponibilidad(fI, fF);
		boolean resultadoEsperado = false;
		assertTrue(resultadoObtenido == resultadoEsperado);
	}
	@Test
	public void testComprobarDisponibilidad2() 
	{
		String fI = "03/03";
		String fF = "13/04";
		
		boolean resultadoObtenido = a.ComprobarDisponibilidad(fI, fF);
		boolean resultadoEsperado = true;
		assertTrue(resultadoObtenido == resultadoEsperado);
	}

	
	
	
	
	@Test
	public void testGuardarReserva1() 
	{
		a.GuardarReserva("05/05", "05/06", "LAURA");
		
		boolean resultadoObtenido = false;
		
		//el 5 de mayo equivale al días 125 del año
		if (a.calendarioReservas[125].equalsIgnoreCase("laura") && a.calendarioReservas[126].equalsIgnoreCase("laura")) resultadoObtenido = true;
		boolean resultadoEsperado = true;
		assertTrue(resultadoObtenido == resultadoEsperado);
		
	}
	@Test
	public void testGuardarReserva2() 
	{
		a.GuardarReserva("05/05", "05/06", "LAURA");
		
		boolean resultadoObtenido = false;
		
		if (a.calendarioReservas[100].equalsIgnoreCase("laura") && a.calendarioReservas[102].equalsIgnoreCase("laura")) resultadoObtenido = true;
		boolean resultadoEsperado = false;
		assertTrue(resultadoObtenido == resultadoEsperado);
		
	}

	
	
	
	
	@Test
	public void testSetTipo1() 
	{
		a.SetTipo("Hotel");
		
		String resultadoObtenido = a.tipo;
		String resultadoEsperado = "Hotel";
		assertEquals(resultadoObtenido, resultadoEsperado);
	}
	@Test
	public void testSetTipo2() 
	{
		a.SetTipo("Motel");
		
		String resultadoObtenido = a.tipo;
		String resultadoEsperado = "Hotel";
		assertNotEquals(resultadoObtenido, resultadoEsperado);
	}
	
	
	@Test
	public void testConvertirDiaDelAnyo1() 
	{
		
		int resultadoObtenido = a.ConvertirDiaDelAnyo("05/05");
		int resultadoEsperado = 125;
		assertEquals(resultadoObtenido, resultadoEsperado);
	}
	@Test
	public void testConvertirDiaDelAnyo2() 
	{
		int resultadoObtenido = a.ConvertirDiaDelAnyo("05/05");
		int resultadoEsperado = 100;
		assertNotEquals(resultadoObtenido, resultadoEsperado);
	}


}
