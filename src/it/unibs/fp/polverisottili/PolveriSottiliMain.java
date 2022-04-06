//https://elearning.unibs.it/pluginfile.php/601267/mod_resource/content/1/PolveriSottili.pdf

package it.unibs.fp.polverisottili;

import it.unibs.fp.mylib.InputDati;

import it.unibs.fp.mylib.MyMenu;

public class PolveriSottiliMain {

	// STRINGHE COSTANTI
	private static final String MSG_TITOLO = "CONTROLLO POLVERI SOTTILI SETTIMANALI";
	private static String [] voci= {"Nuova Settimana"};
	
	private static final String MSG_INPUT_POLVERI_GIORNALIERE = "Inserisci la quantità del %d giorno: ";
	private static final String MSG_ANNO = "Inserisci il numero dell'anno: ";
	private static final String MSG_NUMERO_SETTIMANA = "Inserisci il numero della settimana: ";
	
	
	public static void main(String[] args) {

		int scelta = 0;
		
		
		MyMenu menu = new MyMenu(MSG_TITOLO,voci);
		
		do  {
		
		scelta = menu.scegli();
		
		switch(scelta) {
			case 1: //aggiungi settimana
				Settimana week = nuovaSettimana();
				System.out.println( week.toString() );
				break;
				
			default:
				break;
		
			}
		
		} while(scelta != 0);
		
	}
	
	private static Settimana nuovaSettimana () {
		
		int anno = InputDati.leggiIntero(MSG_ANNO, Settimana.OLDEST_YEAR, Settimana.LATEST_YEAR);
		
		int numeroSettimana = InputDati.leggiIntero(MSG_NUMERO_SETTIMANA, 0, Settimana.WEEK_PER_YEAR);
		
		double [] polveriGiornaliere;
		
		polveriGiornaliere = new double[Settimana.DAYS_PER_WEEK];
		
		for(int i = 0; i < Settimana.DAYS_PER_WEEK; i++) {
			polveriGiornaliere[i]= InputDati.leggiDouble(String.format(MSG_INPUT_POLVERI_GIORNALIERE, i+1), Settimana.MIN_PARTICULATES_READABLE, Settimana.MAX_PARTICULATES_READABLE);
		}
		
		Settimana Week = new Settimana(anno, numeroSettimana,polveriGiornaliere);
		
		return Week;
	}

}
