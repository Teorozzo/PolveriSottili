package it.unibs.fp.polverisottili;

import static org.junit.Assert.*;

import org.junit.Test;

public class SettimanaTest {

	
	@Test
	public void testValoreMassimoNonSuperato() {
		double [] polveriGiornaliere =  {10,10,10,10,10,10,10};
		Settimana week = new Settimana(1950,5, polveriGiornaliere);
		assertFalse("Daily max value not exceeded", week.valoreMassimoSuperato());
	}
	
	@Test
	public void testValoreMassimoSuperato() {
		double [] polveriGiornaliere =  {10,10,10,80,10,10,10};
		Settimana week = new Settimana(1950,5, polveriGiornaliere);
		assertTrue("Daily max value exceeded", week.valoreMassimoSuperato());
	}

	@Test
	public void testValoreMedioNonSuperato() {
		double [] polveriGiornaliere =  {10,40,10,60,10,60,30};
		Settimana week = new Settimana(1950,5, polveriGiornaliere);
		assertTrue("Weekly max value exceeded", week.valoreMedioSuperato());
	}
	
	@Test
	public void testValoreMedioSuperato() {
		double [] polveriGiornaliere =  {10,70,10,60,10,90,100};
		Settimana week = new Settimana(1950,5, polveriGiornaliere);
		assertTrue("Weekly max value exceeded", week.valoreMedioSuperato());
	}

}
