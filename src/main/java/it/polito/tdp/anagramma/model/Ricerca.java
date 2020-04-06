package it.polito.tdp.anagramma.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {

	private List<String> soluzione;
	
	/**
	 * Genera tutti gli anagrammi della parola specificata in ingresso
	 * @param string parola da anagrammare
	 * @return elenco di tutti gli anagrammi
	 */
	public List<String> anagrammi(String parola) {
		
		this.soluzione = new ArrayList<String>();
		
		parola = parola.toUpperCase();
		List<Character> disponibili = new ArrayList<>();
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		 // avvio la ricorsione
		
		cerca("", 0, disponibili);
		
		return this.soluzione;
	}
	/**
	 * Procedura ricorsiva per il calcolo dell'anagramma.
	 * 
	 * @param parziale parte dell'anagramma costruito fin ora
	 * @param livello livello della ricorsione, sempre uguale a parziale.length()
	 * @param disponibili insieme delle lettere non ancora utilizzate
	 */
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		
		if(disponibili.size()==0) { // oppure livello==parola.length()
			// caso terminale
			this.soluzione.add(parziale);
			
		}
		
		// caso normale
		// provare ad aggiungere alla sol parziale, tutti i caratteri presenti fra i disponibili
		
		for(Character ch : disponibili) {
			String tentativo = parziale + ch;
			// OSS
			// non sto modificando la sol parziale ma sto creando un nuovo oggetto stringa
			// di conseguenza non ho bisogno di fare backtracking
			
			// Non posso rimuovere elementi dalla lista disponibili
			// perche' sono all'interno di un ciclo che sta iterando su di essa
			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(ch);
			
			cerca(tentativo, livello+1, rimanenti);
		}
	}
}

/*
 * Dato di partenza: parola da angrammare, di lunghezza N
 *
 * Soluzione parziale: una parte dell'anagramma gia' costruito
 * (i primi  caratteri).
 * Livello: numero di lettere di cui e' composta la soluzione parziale
 * 
 * Soluzione finale: soluzione di lunghezza N -> caso terminale
 * 
 * Caso terminale: salvare la soluzione trovata
 * 
 * Generazione delle nuove soluzioni passa per il provare ad aggiungere
 * una lettere, scegliendo tra quelle che non sono ancora state utilizzate
 * nella soluzione parziale.
 */