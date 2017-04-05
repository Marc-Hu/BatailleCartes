package TestBataille;

import Bataille.*;

public class TestPartie {

	public static void main(String[] args) {
		

		Paquet jeu52cartes = new Paquet(52);
		Joueur[] joueurs = new Joueur[4];
		joueurs[0] = new Joueur("Marc");
		joueurs[1] = new Joueur("Steeve");
		joueurs[2] = new Joueur("Tony");
		joueurs[3] = new Joueur("Alice");
		
		Partie bataille1 = new Partie(joueurs, jeu52cartes);
		System.out.println(bataille1.getPaquet());
		bataille1.distribuerPaquet();
		for(int i=0; i<4; i++){
			System.out.println(joueurs[i].getNom()+" possède "+joueurs[i].getCartesEnMain().taille()+" cartes");
			System.out.println(joueurs[i].getCartesEnMain());
		}
		
		System.out.println("Tour 1");
		for(Joueur j : joueurs)
			j.poserUneCarte();
		
		for(int i=0; i<4; i++){
			System.out.println(joueurs[i].getPileCartes());
		}
		
		System.out.println(bataille1.laPlusForte());
			
			
			
			

		


	}

}
