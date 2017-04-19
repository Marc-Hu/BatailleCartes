package Bataille;

//import java.util.*;

public class BatailleMain {

	public static void main(String[] args) {

// Initialisation partie 1	
		Joueur[] joueursP1 = new Joueur[2];
		joueursP1[0] = new Joueur("j1");
		joueursP1[1] = new Joueur("j2");
		Partie p1 = new Partie(joueursP1);

		joueursP1[0].getCartesEnMain().ajouter(new Carte(10, "Pique"));
		joueursP1[0].getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		joueursP1[0].getCartesEnMain().ajouter(new Carte(7, "Coeur"));
		joueursP1[0].getCartesEnMain().ajouter(new Carte(13, "Trèfle"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(8, "Coeur"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(11, "Pique"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(8, "Pique"));
		joueursP1[1].getCartesEnMain().ajouter(new Carte(7, "Trèfle"));
	
//Initialisation partie 2
		Joueur[] joueursP2 = new Joueur[2];
		joueursP2[0] = new Joueur("j1");
		joueursP2[1] = new Joueur("j2");
		Partie p2 = new Partie(joueursP2);

		joueursP2[0].getCartesEnMain().ajouter(new Carte(12, "Trèfle"));
		joueursP2[0].getCartesEnMain().ajouter(new Carte(10, "Trèfle"));
		joueursP2[0].getCartesEnMain().ajouter(new Carte(14, "Coeur"));
		joueursP2[1].getCartesEnMain().ajouter(new Carte(12, "Pique"));
		joueursP2[1].getCartesEnMain().ajouter(new Carte(8, "Trèfle"));
		joueursP2[1].getCartesEnMain().ajouter(new Carte(9, "Trèfle"));
		
//Initialisation partie 3
		Joueur[] joueursP3 = new Joueur[2];
		joueursP3[0] = new Joueur("j1");
		joueursP3[1] = new Joueur("j2");
		Partie p3 = new Partie(joueursP3);

		joueursP3[0].getCartesEnMain().ajouter(new Carte(10, "Pique"));
		joueursP3[0].getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		joueursP3[0].getCartesEnMain().ajouter(new Carte(12, "Trèfle"));
		joueursP3[1].getCartesEnMain().ajouter(new Carte(8, "Coeur"));
		joueursP3[1].getCartesEnMain().ajouter(new Carte(9, "Trèfle"));
		joueursP3[1].getCartesEnMain().ajouter(new Carte(10, "Coeur"));
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

		
		Partie[] parties = new Partie[3];
		parties[0] = p1;
		parties[1] = p2;
		parties[2] = p3;
		
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
								System.out.println(j.getNom()+" pose une carte face cachée");
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
					System.out.println(j.getNom()+" a gagné \n\n");
			}
			
		}
	}
}
