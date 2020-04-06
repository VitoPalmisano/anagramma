package it.polito.tdp.anagramma.model;

import java.util.List;

public class TestRicerca {

	public static void main(String[] args) {

		Ricerca ric = new Ricerca();
		
		List<String> ana_dog = ric.anagrammi("dog"); // 3! = 6 parole
		System.out.println(ana_dog);

		List<String> ana_vacanze = ric.anagrammi("vacanze"); // 7! = 5040 parole
		System.out.println(ana_vacanze);
		
		// utilizzando una parola piu' lunga, tipo "programmazione" 14! = 87miliardi di parole -> OutOfMemoryException
	}

}
