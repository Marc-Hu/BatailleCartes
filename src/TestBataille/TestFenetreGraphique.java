package TestBataille;

import InterfaceGraphique.BatailleControleur;
import InterfaceGraphique.FenetreGraphique;
import Bataille.*;

public class TestFenetreGraphique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Joueur[] joueurs = {new Joueur("j1"), new Joueur("j2")};
			Partie bataille = new Partie(joueurs);
			BatailleControleur bControleur = new BatailleControleur(bataille);
			new FenetreGraphique("Bataille","images/green_background.jpg", 100, 0, 1000, 1000, 2, bControleur);
	}

}
