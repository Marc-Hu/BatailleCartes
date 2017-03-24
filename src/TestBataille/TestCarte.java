package TestBataille;

import java.util.*;
import Bataille.*;

public class TestCarte {

	public static void main(String[] args) {
		
		//Création d'une liste de Cartes
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		for(int i=1; i<10; i++)
			cartes.add(new Carte(i, "Coeur"));
		//Test de l'affichage
		for(Carte c : cartes)
			System.out.println(c);
	
		Carte c1 = cartes.get(0);
		Carte c10 = cartes.get(9);
		
		//Test estPlusForte()
		if(c1.estPlusForte(c10))
			System.out.println(c1+" est plus forte que "+c10);
		else
			System.out.println(c1+" n'est pas plus forte que "+c10);
		
		if(c10.estPlusForte(c1))
			System.out.println(c10+" est plus forte que "+c1);
		else
			System.out.println(c10+" n'est pas plus forte que "+c1);
		
		//
		if(c1.aMemeValeur(c10))
			System.out.println(c1+" a la même valeur que "+c10);
		else
			System.out.println(c10+" est plus forte que "+c1);

	}

}
