package TestBataille;

import InterfaceGraphique.BatailleControleur;
import InterfaceGraphique.FenetreGraphique;
import Bataille.*;

import javax.swing.JOptionPane;

public class TestFenetreGraphique {

	public static void main(String[] args) {
		
		final String background = "images/dark_background.jpg";
		
		String[] nomTest = {"jeu d'essai1", "jeu d'essai2", "jeu d'essai3", "jeu d'essai4", "normal"};
		
		JOptionPane jop = new JOptionPane();
		String test = (String)JOptionPane.showInputDialog(null,
				"Choisissez le numéro du test",
				"Choix du jeu de test",
				JOptionPane.QUESTION_MESSAGE,
				null,
				nomTest,
				nomTest[0]
				);
		if(test==null){
			System.exit(0);
		}else if(test=="jeu d'essai1"){
			Joueur[] joueursP1 = new Joueur[2];
			joueursP1[0] = new Joueur("j1");
			joueursP1[1] = new Joueur("j2");
			Partie p1 = new Partie(joueursP1);

			joueursP1[0].getCartesEnMain().ajouter(new Carte(10, "Pique"));
			joueursP1[0].getCartesEnMain().ajouter(new Carte(11, "Trefle"));
			joueursP1[0].getCartesEnMain().ajouter(new Carte(7, "Coeur"));
			joueursP1[0].getCartesEnMain().ajouter(new Carte(13, "Trefle"));
			joueursP1[1].getCartesEnMain().ajouter(new Carte(8, "Coeur"));
			joueursP1[1].getCartesEnMain().ajouter(new Carte(11, "Pique"));
			joueursP1[1].getCartesEnMain().ajouter(new Carte(8, "Pique"));
			joueursP1[1].getCartesEnMain().ajouter(new Carte(7, "Trefle"));

			BatailleControleur bControleur = new BatailleControleur(p1);
			new FenetreGraphique("Bataille", background,/* 100, 0, 1000, 1000,*/ 2, bControleur);
		} else if (test=="jeu d'essai2"){
			Joueur[] joueursP2 = new Joueur[2];
			joueursP2[0] = new Joueur("j1");
			joueursP2[1] = new Joueur("j2");
			Partie p2 = new Partie(joueursP2);

			joueursP2[0].getCartesEnMain().ajouter(new Carte(12, "Trefle"));
			joueursP2[0].getCartesEnMain().ajouter(new Carte(10, "Trefle"));
			joueursP2[0].getCartesEnMain().ajouter(new Carte(14, "Coeur"));
			joueursP2[1].getCartesEnMain().ajouter(new Carte(12, "Pique"));
			joueursP2[1].getCartesEnMain().ajouter(new Carte(8, "Trefle"));
			joueursP2[1].getCartesEnMain().ajouter(new Carte(9, "Trefle"));

			BatailleControleur bControleur = new BatailleControleur(p2);
			new FenetreGraphique("Bataille", background,/* 100, 0, 1000, 1000,*/ 2, bControleur);
		} else if (test=="jeu d'essai3"){
			Joueur[] joueursP3 = new Joueur[2];
			joueursP3[0] = new Joueur("j1");
			joueursP3[1] = new Joueur("j2");
			Partie p3 = new Partie(joueursP3);

			joueursP3[0].getCartesEnMain().ajouter(new Carte(10, "Pique"));
			joueursP3[0].getCartesEnMain().ajouter(new Carte(11, "Trefle"));
			joueursP3[0].getCartesEnMain().ajouter(new Carte(12, "Trefle"));
			joueursP3[1].getCartesEnMain().ajouter(new Carte(8, "Coeur"));
			joueursP3[1].getCartesEnMain().ajouter(new Carte(9, "Trefle"));
			joueursP3[1].getCartesEnMain().ajouter(new Carte(10, "Coeur"));

			BatailleControleur bControleur = new BatailleControleur(p3);
			new FenetreGraphique("Bataille", background,/* 100, 0, 1000, 1000,*/ 2, bControleur);
		} else if (test=="jeu d'essai4"){
			Joueur[] joueursP4 = new Joueur[3];
			joueursP4[0] = new Joueur("j1");
			joueursP4[1] = new Joueur("j2");
			joueursP4[2] = new Joueur("j3");
			
			Partie p4 = new Partie(joueursP4);		
			
			joueursP4[0].getCartesEnMain().ajouter(new Carte(11, "trefle"));
			joueursP4[0].getCartesEnMain().ajouter(new Carte(12, "coeur"));
			joueursP4[0].getCartesEnMain().ajouter(new Carte(5, "coeur"));
			joueursP4[0].getCartesEnMain().ajouter(new Carte(11, "pique"));
			joueursP4[1].getCartesEnMain().ajouter(new Carte(11, "carreau"));
			joueursP4[1].getCartesEnMain().ajouter(new Carte(14, "carreau"));
			joueursP4[1].getCartesEnMain().ajouter(new Carte(2, "carreau"));
			joueursP4[1].getCartesEnMain().ajouter(new Carte(12, "carreau"));
			joueursP4[2].getCartesEnMain().ajouter(new Carte(11, "coeur"));
			joueursP4[2].getCartesEnMain().ajouter(new Carte(6, "pique"));
			joueursP4[2].getCartesEnMain().ajouter(new Carte(4, "coeur"));

			BatailleControleur bControleur = new BatailleControleur(p4);
			new FenetreGraphique("Bataille", background,/* 100, 0, 1000, 1000,*/ 3, bControleur);
		} else{
			Joueur[] joueursP5 = new Joueur[4];
			joueursP5[0] = new Joueur("j1");
			joueursP5[1] = new Joueur("j2");
			joueursP5[2] = new Joueur("j3");
			joueursP5[3] = new Joueur("j4");
			Partie p5 = new Partie(joueursP5);
			p5.distribuerPaquet();

			BatailleControleur bControleur = new BatailleControleur(p5);
			new FenetreGraphique("Bataille", background,/* 100, 0, 1000, 1000,*/ 4, bControleur);
		}
	}
}
