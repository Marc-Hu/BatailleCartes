package Bataille;

//import java.util.*;

public class BatailleMain {

	public static void main(String[] args) {

		Joueur j1 = new Joueur("j1");
		Joueur j2 = new Joueur("j2");
		Joueur j3 = new Joueur("j3");
		Paquet jeuCartes = new Paquet(52);
	
		Joueur[] joueurs = new Joueur[3];
		joueurs[0] = j1;
		joueurs[1] = j2;
		joueurs[2] = j3;

		Partie bataille = new Partie(joueurs);


		j1.getCartesEnMain().ajouter(new Carte(10, "Pique"));
		j1.getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		j1.getCartesEnMain().ajouter(new Carte(7, "Coeur"));
		j1.getCartesEnMain().ajouter(new Carte(13, "Coeur"));	
		j2.getCartesEnMain().ajouter(new Carte(8, "Coeur"));
		j2.getCartesEnMain().ajouter(new Carte(11, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(8, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(7, "Trèfle"));
		j3.getCartesEnMain().ajouter(new Carte(2, "Coeur"));
		j3.getCartesEnMain().ajouter(new Carte(11, "Pique"));
		j3.getCartesEnMain().ajouter(new Carte(12, "Pique"));
		j3.getCartesEnMain().ajouter(new Carte(14, "Trèfle"));

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
			System.out.println("*****************************************");
			System.out.println("Tour n°"+(nbTours+1));
			
			for(Joueur j : joueurs){
				System.out.println(j.getNom()+" : ");
				System.out.println("Nombre de cartes en main : "+j.getCartesEnMain().taille());
				System.out.println(j.getCartesEnMain());
			}

			for(Joueur j :joueurs){
				if(j.getEstDansPartie()){
					j.poserUneCarte();
					System.out.println(j.getNom()+" a posé "+j.getPileCartes().premiereCarte());
				}
			}
			
			Carte carteLaPlusGrande = bataille.laPlusForte();
			System.out.println("Carte la plus forte : "+carteLaPlusGrande);
			int nbJoueursDansBataille = bataille.joueursDansBataille(carteLaPlusGrande);
			System.out.println("Il y a "+nbJoueursDansBataille+" joueurs dans la bataille");
			
			if(nbJoueursDansBataille > 1){
				do{
					for(Joueur j : joueurs){
						if(j.getEstDansBataille()){
							j.ditBataille();
							j.poserUneCarte();
							j.poserUneCarte();
							System.out.println(j.getNom()+" a posé "+j.getPileCartes().premiereCarte());
						}
					}
					carteLaPlusGrande = bataille.laPlusForte();
					nbJoueursDansBataille = bataille.joueursDansBataille(carteLaPlusGrande);
				}while(nbJoueursDansBataille > 1);
			}
			
			Joueur gagnantTour = bataille.gagnantTour(carteLaPlusGrande);
			System.out.println(gagnantTour.getNom()+" récupère les cartes");
			
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

			nbTours+=1;
			System.out.println("*****************************************");
		}while(!bataille.finie());
		
		for(Joueur j : joueurs){
			if(j.getEstDansPartie())
				System.out.println(j.getNom()+" a gagné");
		}
	}
}
