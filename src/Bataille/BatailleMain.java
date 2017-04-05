package Bataille;

//import java.util.*;

public class BatailleMain {

	public static void main(String[] args) {

		Joueur j1 = new Joueur("j1");
		Joueur j2 = new Joueur("j2");
		Paquet jeuCartes = new Paquet(52);
	
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
		Carte[] cartesPosees = new Carte[joueurs.length];
		do{
			System.out.println("*****************************************");
			System.out.println("Tour n°"+(nbTours+1));
			
			for(Joueur j : joueurs){
				System.out.println(j.getNom()+" : ");
				System.out.println("Nombre de cartes en main : "+j.getCartesEnMain().taille());
				System.out.println(j.getCartesEnMain());
			}

			for(int i=0; i<joueurs.length; i++){
				if(joueurs[i].getEstDansPartie()){
					cartesPosees[i] = joueurs[i].poserUneCarte();
					System.out.println(joueurs[i].getNom()+" a posé "+cartesPosees[i]);
				}
			}
			
			Carte carteLaPlusGrande = bataille.laPlusForte();
			int nbJoueursDansBataille = bataille.joueursDansBataille(carteLaPlusGrande);
			
			if(nbJoueursDansBataille > 1){
				do{
					for(Joueur j : joueurs){
						if(j.getEstDansBataille()){
							j.poserUneCarte();
							j.poserUneCarte();
						}
						carteLaPlusGrande = bataille.laPlusForte();
						nbJoueursDansBataille = bataille.joueursDansBataille(carteLaPlusGrande);
					}
				}while(nbJoueursDansBataille > 1);
			}
			
			Joueur gagnantTour = bataille.gagnantTour(carteLaPlusGrande);
			
			for(Joueur j : joueurs){
				if(j.getEstDansPartie())
					gagnantTour.recupererCartes(j.getPileCartes());
			}
			
			for(Joueur j : joueurs){
				if(j.getEstDansPartie() && j.getCartesEnMain().taille() == 0)
					j.setEstDansPartie(false);
			}
			
			for(Joueur j : joueurs){
				if(j.getEstDansPartie())
					j.setEstDansBataille(true);
			}
/*
			if(cartesPosees[0].estPlusForte(cartesPosees[1])){
				for(Joueur j : joueurs)
					j1.recupererCartes(j.getPileCartes());
				System.out.println(j1.getNom()+" récupère les cartes du plateau");
			}else if(cartesPosees[1].estPlusForte(cartesPosees[0])){
				for(Joueur j : joueurs)
					j2.recupererCartes(j.getPileCartes());
				System.out.println(j2.getNom()+" récupère les cartes du plateau");
			}else{
				j1.ditBataille();
				for(int i=0; i<joueurs.length; i++){
					joueurs[i].poserUneCarte();
					System.out.println(joueurs[i].getPileCartes());
				}
			}
*/	
			nbTours+=1;
			System.out.println("*****************************************");
		}while(!bataille.finie());
		
		for(Joueur j : joueurs){
			if(j.getCartesEnMain().taille()==bataille.getPaquet().taille())
				System.out.println(j.getNom()+" a gagné");
		}
	}
}
