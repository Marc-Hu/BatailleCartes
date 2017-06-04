package TestBataille;

import InterfaceGraphique.BatailleControleur;
import InterfaceGraphique.FenetreGraphique;
import Bataille.*;

public class TestFenetreGraphique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Joueur[] joueursP1 = new Joueur[4];
			joueursP1[0] = new Joueur("j1");
			joueursP1[1] = new Joueur("j2");
			joueursP1[2] = new Joueur("j3");
			joueursP1[3] = new Joueur("j4");
			Partie p1 = new Partie(joueursP1);
			p1.distribuerPaquet();
			
			Joueur[] joueursP4 = new Joueur[3];
			joueursP4[0] = new Joueur("j1");
			joueursP4[1] = new Joueur("j2");
			joueursP4[2] = new Joueur("j3");
			Partie p4 = new Partie(joueursP4);		
			
			joueursP4[0].getCartesEnMain().ajouter(new Carte(11, "Trefle"));
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

			BatailleControleur bControleur = new BatailleControleur(p4);
			new FenetreGraphique("Bataille","images/green_background.jpg", 100, 0, 1000, 1000, 3, bControleur);
	}

}
