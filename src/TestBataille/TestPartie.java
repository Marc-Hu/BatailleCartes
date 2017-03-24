package TestBataille;

import Bataille.*;
import ExceptionBatailles.*;

public class TestPartie {

	public static void main(String[] args) {
		
		try{
			Paquet jeu32cartes = new Paquet(32);
			Joueur[] joueurs = new Joueur[2];
			joueurs[0] = new Joueur("Marc");
			joueurs[1] = new Joueur("Steeve");
			
			Partie bataille1 = new Partie(joueurs, jeu32cartes);
			System.out.println(bataille1.getPaquet());
			bataille1.distribuerPaquet();
			System.out.println("Marc possède "+joueurs[0].getCartesEnMain().taille()+" cartes");
			System.out.println("Main de Marc : \n"+joueurs[0].getCartesEnMain());
			System.out.println("Steeve possède "+joueurs[1].getCartesEnMain().taille()+" cartes");
			System.out.println("Main de Steeve : \n"+joueurs[1].getCartesEnMain());
		}catch(NombreCarteException e){
			System.out.println(e);
		}
		


	}

}
