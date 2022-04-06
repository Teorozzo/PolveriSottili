package it.unibs.fp.polverisottili;

import java.util.Arrays;

public class PolveriSottiliMainTest {

	public static void main(String[] args) {
		
		double [] polveriGiornaliere =  {120,10,90,80,40,10,10};
		Settimana week = new Settimana(1950,5, polveriGiornaliere);
		
		System.out.println(Arrays.toString(polveriGiornaliere));
		
		System.out.println(String.format("Valore medio: %.2f", week.valoreMedioSettimanale() ));
		
		System.out.println( week.toString() );
	}

}
