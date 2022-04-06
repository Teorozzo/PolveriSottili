package it.unibs.fp.polverisottili;

public class Settimana {

	// STRINGHE COSTANTI
	private static final String MSG_ALLERT_DAILY_EXCEED = "\nATTENZIONE: valore giornaliero superato!";
	private static final String MSG_ALLERT_WEEKLY_EXCEED = "\nATTENZIONE: valore settimanale superato!";
	private static final String MSG_GOOD_NEWS = "\nBuone notizie, polveri nella norma!";
	
	// VALORI COSTANTI
	public static final int MIN_PARTICULATES_READABLE = 0;
	public static final int MAX_PARTICULATES_READABLE = 150;
	public static final int OLDEST_YEAR = 1800;
	public static final int LATEST_YEAR = 2022;
	public final static int WEEK_PER_YEAR = 52;
	public final static int DAYS_PER_WEEK = 7;
	
	private final int LIMITE_MAX_VALORE_MEDIO = 50;
	private final int LIMITE_MAX_VALORE_GIORNALIERO = 70;
	
	//ATTRIBUTI
	int anno;
	int numeroSettimana;
	static double [] polveriGiornaliere = new double [DAYS_PER_WEEK];
	
	
	public Settimana(int anno, int numeroSettimana, double[] polveriGiornaliere) {
		super();
		this.anno = anno;
		this.numeroSettimana = numeroSettimana;
		Settimana.polveriGiornaliere = polveriGiornaliere;
	}
	
	public double valoreMedioSettimanale() {
		double totale =0;
		for(int i =0; i<DAYS_PER_WEEK; i++) {
			totale = totale + polveriGiornaliere [i];
		}
		
		return (totale/DAYS_PER_WEEK);
	}
	
	public boolean valoreMassimoSuperato() {
		for(int i =0; i<DAYS_PER_WEEK; i++) {
			if(polveriGiornaliere [i] > LIMITE_MAX_VALORE_GIORNALIERO)
			return true;
		}
		return false;
	}
	
	public boolean valoreMedioSuperato() {
		return (valoreMedioSettimanale() > LIMITE_MAX_VALORE_MEDIO);
	}
	
	public String toString() {
		
		StringBuffer testo = new StringBuffer();
		
		allarmi(testo);
		
		testo.append("\n\n");
		
		return testo.toString();
		
		
	}
	
	public String allarmi(StringBuffer testo) {
		if( valoreMassimoSuperato() ) {
			testo.append(MSG_ALLERT_DAILY_EXCEED);
		}
		if( valoreMedioSuperato() ) {
			testo.append(MSG_ALLERT_WEEKLY_EXCEED);
		}
		if( !valoreMedioSuperato() && !valoreMassimoSuperato() ) {
			testo.append(MSG_GOOD_NEWS);
		}
			return testo.toString();
		
	}
	

	
}


