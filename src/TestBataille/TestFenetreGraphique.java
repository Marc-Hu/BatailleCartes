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

			BatailleControleur bControleur = new BatailleControleur(p1);
			new FenetreGraphique("Bataille","images/green_background.jpg", 100, 0, 1000, 1000, 4, bControleur);
	}

}
