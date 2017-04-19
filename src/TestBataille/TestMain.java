package TestBataille;
import Bataille.*;
import java.util.*;

public class TestMain {
	public static void main(String[] args) {
		
		Main cartesMain = new Main();
		ArrayList<Carte> cartesRetirees = new ArrayList<Carte>();
		
		//Test ajouter
		for(int i=2; i<15; i++)
			cartesMain.ajouter(new Carte(i, "pique"));
		System.out.println(cartesMain);
		
		//Test retirer
		System.out.println("Je retire 5 cartes");
		for(int i=0; i<5; i++)
			cartesRetirees.add(cartesMain.retirer());
		System.out.println("Cartes retirées : "+cartesRetirees);
		
		//On rajoute 1 carte
		cartesMain.ajouter(new Carte(1, "pique"));
		System.out.println(cartesMain);
		
		//Test estVide() + taille()
		if(cartesMain.estVide())
			System.out.println("Vous n'avez pas de cartes en main");
		else
			System.out.println("Vous avez "+cartesMain.taille()+" cartes en main");
		System.out.println("J'enlève les cartes de la main");
		int tailleMain = cartesMain.taille();
		for(int i =0; i<tailleMain; i++)
			cartesMain.retirer();
		System.out.println(cartesMain);
		
		if(cartesMain.estVide())
			System.out.println("Vous n'avez pas de cartes en main");
		else
			System.out.println("Vous avez "+cartesMain.taille()+" cartes en main");
			
	}
}
