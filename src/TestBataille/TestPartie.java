package TestBataille;

import Bataille.*;

public class TestPartie {

	public static void main(String[] args) {
		/*
		 * Initialisation d'un jeu de 52 cartes
		 */
		Paquet jeu52cartes = new Paquet(52);
		/*
		 * Initialisation de 4 joueurs
		 */
		Joueur[] joueurs = new Joueur[4];
		joueurs[0] = new Joueur("Marc");
		joueurs[1] = new Joueur("Steeve");
		joueurs[2] = new Joueur("Tony");
		joueurs[3] = new Joueur("Alice");
		
		/*
		 * Démarrage de la partie
		 */
		Partie bataille1 = new Partie(joueurs, jeu52cartes);
		System.out.println(bataille1.getPaquet());
		bataille1.distribuerPaquet();
		for(int i=0; i<4; i++){
			System.out.println(joueurs[i].getNom()+" possède "+joueurs[i].getCartesEnMain().taille()+" cartes");
			System.out.println(joueurs[i].getCartesEnMain());
		}
		/*
		 * On va jouer un tour
		 */
		System.out.println("Tour 1");
		for(Joueur j : joueurs)
			j.poserUneCarte();
		/*
		 * On affiche la pile de chaque joueur
		 */
		for(int i=0; i<4; i++){
			System.out.println(joueurs[i].getPileCartes());
		}
		/*
		 * On affiche la carte ou il y aura peut-être une bataille
		 */
		System.out.println("La bataille se jouera donc sur la carte : "+bataille1.laPlusForte());

	}

}
