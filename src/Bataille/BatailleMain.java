package Bataille;

import java.util.*;

public class BatailleMain {

	public static void main(String[] args) {
		Joueur j1 = new Joueur("j1");
		Joueur j2 = new Joueur("j2");
		
		Joueur[] joueurs = new Joueur[2];
		joueurs[0] = j1;
		joueurs[1] = j2;
		Partie bataille = new Partie(joueurs);
		
		j1.getCartesEnMain().ajouter(new Carte(10, "Pique"));
		j1.getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		j1.getCartesEnMain().ajouter(new Carte(7, "Coeur"));
		j1.getCartesEnMain().ajouter(new Carte(13, "Coeur"));
		
		j2.getCartesEnMain().ajouter(new Carte(8, "Coeur"));
		j2.getCartesEnMain().ajouter(new Carte(11, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(8, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(7, "Trèfle"));
		
		/*
		j1.getCartesEnMain().ajouter(new Carte(12, "Trèfle"));
		j1.getCartesEnMain().ajouter(new Carte(10, "Trèfle"));
		j1.getCartesEnMain().ajouter(new Carte(14, "Coeur"));
		j2.getCartesEnMain().ajouter(new Carte(12, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(8, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(9, "Pique"));
		*/
		/*
		j1.getCartesEnMain().ajouter(new Carte(10, "Trèfle"));
		j1.getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		j1.getCartesEnMain().ajouter(new Carte(12, "Coeur"));
		j2.getCartesEnMain().ajouter(new Carte(8, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(9, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(10, "Pique"));
		*/
		int nbTours = 0;
		do{
			System.out.println("Tour n°"+(nbTours+1));
			
			for(Joueur j : joueurs)
				System.out.println(j.getCartesEnMain());

			for(int i=0; i<joueurs.length; i++){
				joueurs[i].poserUneCarte();
				System.out.println(joueurs[i].getNom()+" a posé "+joueurs[i].getPileCartes().premiereCarte());
			}
			
			if(j1.getPileCartes().premiereCarte().estPlusForte(j2.getPileCartes().premiereCarte())){
				for(Joueur j : joueurs)
					j1.recupererCartes(j.getPileCartes());
				System.out.println(j1.getNom()+" récupère les cartes du plateau");
			}else if(j2.getPileCartes().premiereCarte().estPlusForte(j1.getPileCartes().premiereCarte())){
				for(Joueur j : joueurs)
					j2.recupererCartes(j.getPileCartes());
				System.out.println(j2.getNom()+" récupère les cartes du plateau");
			}else{
				j1.ditBataille();
				for(int i=0; i<joueurs.length; i++)
					joueurs[i].poserUneCarte();
			}
		
			nbTours+=1;
		}while(!bataille.finie());
		
		for(Joueur j : joueurs){
			if(j.getCartesEnMain().taille()==0)
				System.out.println(j.getNom()+" a perdu");
		}
	}
}
