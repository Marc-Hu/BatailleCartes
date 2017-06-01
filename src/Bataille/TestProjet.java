package Bataille;

public class TestProjet {

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
		
//Initialisation partie 4 (3 joueurs)
		Joueur[] joueursP4 = new Joueur[3];
		joueursP4[0] = new Joueur("j1");
		joueursP4[1] = new Joueur("j2");
		joueursP4[2] = new Joueur("j3");
		Partie p4 = new Partie(joueursP4);		
		
		joueursP4[0].getCartesEnMain().ajouter(new Carte(11, "Trèfle"));
		joueursP4[0].getCartesEnMain().ajouter(new Carte(12, "Coeur"));
		joueursP4[0].getCartesEnMain().ajouter(new Carte(5, "Coeur"));
		joueursP4[0].getCartesEnMain().ajouter(new Carte(11, "Pique"));
		joueursP4[1].getCartesEnMain().ajouter(new Carte(11, "Carreau"));
		joueursP4[1].getCartesEnMain().ajouter(new Carte(14, "Carreau"));
		joueursP4[1].getCartesEnMain().ajouter(new Carte(2, "Carreau"));
		joueursP4[1].getCartesEnMain().ajouter(new Carte(12, "Carreau"));
		joueursP4[2].getCartesEnMain().ajouter(new Carte(11, "Coeur"));
		joueursP4[2].getCartesEnMain().ajouter(new Carte(6, "Pique"));
		joueursP4[2].getCartesEnMain().ajouter(new Carte(4, "Coeur"));
	

		Partie[] parties = new Partie[4];
		parties[0] = p1;
		parties[1] = p2;
		parties[2] = p3;
		parties[3] = p4;

		//Tableau pour lancer les 4 parties initialisées
		for(int i = 0; i<parties.length; i++){
			System.out.println("Début de la partie n°i");
			do{
				parties[i].lancerTour();
			}while(!parties[i].finie());
			System.out.println(parties[i].joueurGagnant().getNom()+" a gagné la partie");	
		}
		
		parties[3].lancerTour();

		
	}
}
