package Bataille;

//import java.util.*;

public class BatailleMain {

	public static void main(String[] args) {

		
		Joueur[] joueursP1 = new Joueur[2];
		joueursP1[0] = new Joueur("j1");
		joueursP1[1] = new Joueur("j2");

		Partie p1 = new Partie(joueursP1);


		joueursP1[0].getCartesEnMain().ajouter(new Carte(10, "Pique"));
		joueursP1[0].getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		joueursP1[0].getCartesEnMain().ajouter(new Carte(7, "Coeur"));
		joueursP1[0].getCartesEnMain().ajouter(new Carte(13, "Trèfle"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(8, "Pique"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(10, "Pique"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(8, "Pique"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(7, "Pique"));
/*		
		j1.getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		j1.getCartesEnMain().ajouter(new Carte(7, "Coeur"));
		j1.getCartesEnMain().ajouter(new Carte(14, "Coeur"));	
		j2.getCartesEnMain().ajouter(new Carte(8, "Coeur"));
		j2.getCartesEnMain().ajouter(new Carte(11, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(8, "Pique"));
		j2.getCartesEnMain().ajouter(new Carte(7, "Trèfle"));
		j3.getCartesEnMain().ajouter(new Carte(2, "Coeur"));
		j3.getCartesEnMain().ajouter(new Carte(11, "Pique"));
		j3.getCartesEnMain().ajouter(new Carte(8, "Pique"));
		j3.getCartesEnMain().ajouter(new Carte(14, "Trèfle"));
*/
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
		
		Partie[] parties = new Partie[1];
		parties[0] = p1;
		
		for(Partie p : parties){
			
			System.out.println("Début de la partie");
			int nbTours = 0;
			do{
				System.out.println("*****************************************");
				System.out.println("Tour n°"+(nbTours+1));
				
				for(Joueur j : p.getJoueurs()){
					if(j.getEstDansPartie()){
					System.out.println(j.getNom()+" : ");
					System.out.println("Nombre de cartes en main : "+j.getCartesEnMain().taille());
					System.out.println(j.getCartesEnMain());
					}else
						System.out.println(j.getNom()+" a perdu \n");
				}
	
				for(Joueur j : p.getJoueurs()){
					if(j.getEstDansPartie()){
						j.poserUneCarte();
						System.out.println(j.getNom()+" a posé "+j.getPileCartes().premiereCarte());
					}
				}
				
				Carte carteLaPlusGrande = p.laPlusForte();
				System.out.println("Carte la plus forte : "+carteLaPlusGrande);
				int nbJoueursDansBataille = p.joueursDansBataille(carteLaPlusGrande);
				System.out.println("Il y a "+nbJoueursDansBataille+" joueurs dans la bataille");
				
				if(nbJoueursDansBataille > 1){
					do{
						for(Joueur j : p.getJoueurs()){
							if(j.getEstDansBataille()){
								j.ditBataille();
								j.poserUneCarte();
								j.poserUneCarte();
								System.out.println(j.getNom()+" a posé "+j.getPileCartes().premiereCarte());
							}
						}
						carteLaPlusGrande = p.laPlusForte();
						nbJoueursDansBataille = p.joueursDansBataille(carteLaPlusGrande);
					}while(nbJoueursDansBataille > 1);
				}
				
				Joueur gagnantTour = p.gagnantTour(carteLaPlusGrande);
				System.out.println(gagnantTour.getNom()+" récupère les cartes");
				
				for(Joueur j : p.getJoueurs()){
					if(j.getEstDansPartie())
						gagnantTour.recupererCartes(j.getPileCartes());
				}
				
				for(Joueur j : p.getJoueurs()){
					if(j.getEstDansPartie() && j.getCartesEnMain().taille() == 0)
						j.setEstDansPartie(false);
				}
				
				for(Joueur j : p.getJoueurs()){
					if(j.getEstDansPartie())
						j.setEstDansBataille(true);
				}
	
				nbTours+=1;
				System.out.println("*****************************************");
			}while(!p.finie());
			
			for(Joueur j : p.getJoueurs()){
				if(j.getEstDansPartie())
					System.out.println(j.getNom()+" a gagné");
			}
			
		}
	}
}
