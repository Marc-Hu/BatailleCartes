package Bataille;

import java.util.Observable;

/**
 * Classe de gestion d'une partie
 * @version 1.0
 * @author Tony Clonier
 */
public class Partie extends Observable {
	
	private Joueur[] joueurs;
	private Paquet paquet;
	private int nbTours;
	
	
/*Constructeur*/
	/**
	 * Construit une instance de partie 
	 * @param joueurs 	Joueurs participant à la partie
	 * @param paquet 	Paquet de carte utilisé pour jouer
	 */
	public Partie(Joueur[] joueurs, Paquet paquet){
		this.joueurs = joueurs;
		this.paquet = paquet;
		this.nbTours = 0;
	}
	
	/**
	 * Construit une instance de partie, le paquet a 52 cartes par défaut
	 * @param joueurs 	Joueurs participant à la partie
	 */
	public Partie(Joueur[] joueurs){
		this.joueurs = joueurs;
		this.paquet = new Paquet(52);
		this.nbTours = 0;
	}
	
/*Getters*/
	/**
	 * Retourne le paquet initilialisé dans la partie en cours
	 * @return Paquet initilialisé dans la partie en cours
	 */
	public Paquet getPaquet(){
		return this.paquet;
	}
	
	/**
	 * Retourne les joueurs de la partie en cours
	 * @return Joueurs de la partie en cours
	 */
	public Joueur getJoueurs(int i){
		return this.joueurs[i];
	}

	
/*Méthodes*/
	
	/**
	 * Retourne une chaîne de caractères contenant les informations de la partie en cours
	 */
	public String toString(){
		String str = new String();
		str += "Partie en cours : \n";
		str += "Liste des joueurs : \n";
		for(Joueur j : this.joueurs)
			str += j.toString()+'\n';
		
		return str;
	}
	
	/**
	 * Distribue les cartes du Paquet
	 */
	public void distribuerPaquet(){
		int nbJoueurs = this.joueurs.length;
		int nbCartes = this.paquet.taille();
		for(int i=0; i<nbCartes; i++){
			Carte c = this.paquet.retirer();
			int j = i%nbJoueurs;
			this.joueurs[j].getCartesEnMain().ajouter(c);
		}
	}
	
	/**
	 * Renvoie la carte la plus forte parmi les cartes posées
	 * @return	Carte la plus forte parmi les cartes posées
	 */
	public Carte laPlusForte(){
		Carte cMax = null;
		for(Joueur j : this.joueurs){
			if(j.getEstDansBataille()){
				cMax = j.getPileCartes().premiereCarte();
				break;
			}
		}
		for(int i=1; i < this.joueurs.length; i++){
			if(this.joueurs[i].getEstDansBataille()){
				Carte ci = this.joueurs[i].getPileCartes().premiereCarte();
				if(ci.estPlusForte(cMax))
					cMax = ci;
			}
		}

		return cMax;
	}
	
	/**
	 * Retourne le nombre de joueurs ayant la même carte (et devant donc faire une bataille)
	 * @param c 		Carte la plus forte du tour actuel
	 * @return 			Nombre de joueurs dans la bataille
	 */
	public int joueursDansBataille(Carte c){
		int somme = 0;
		for(Joueur j : this.joueurs){
			if(j.getEstDansBataille()){
				if(j.getPileCartes().premiereCarte().aMemeValeur(c))
					somme += 1;
				else
					j.setEstDansBataille(false);
			}
		}
		return somme;
	}
	
	/**
	 * Retourne le joueur qui a gagné le tour
	 * @param c				Carte la plus forte du tour actuel
	 * @return				Joueur ayant gagné le tour
	 */
	public Joueur gagnantTour(Carte c){
		for(Joueur j : this.joueurs){
			if(j.getEstDansPartie() && j.getPileCartes().premiereCarte().aMemeValeur(c))
				return j;
		}
		
		return null;
	}
	
	/**
	 * Vérifie si la partie est finie ou pas
	 * @return True si la partie est finie
	 */
	public boolean finie(){
		int nbJoueursDansPartie = 0;
		for(Joueur j : this.joueurs){
			if(j.getEstDansPartie())
				nbJoueursDansPartie += 1;
		}
		if(nbJoueursDansPartie > 1)
			return false;
		
		return true;
	}
	
	public void poserCartes(){
		if(!this.finie()){
			for(Joueur j : this.joueurs){
				if(j.getEstDansPartie()){
					j.poserUneCarte();
					System.out.println(j.getNom()+" a posé "+j.getPileCartes().premiereCarte());
				}
			}
			
		}
	}

	public void lancerTour(){
		if(this.finie())
			System.out.println("La partie est terminée");
		else{
			System.out.println("*****************************************");
			System.out.println("Tour n°"+(this.nbTours+1));
			
			//Affiche la situation de chaque joueur
			this.poserCartes();
	
			//Chaque joueur encore en jeu pose une carte

			
			//On regarde la carte le plus forte puis on vérifie si plusieurs joueurs ont posé cette carte
			Carte carteLaPlusGrande = this.laPlusForte();
			System.out.println("Carte la plus forte : "+carteLaPlusGrande);
			int nbJoueursDansBataille = this.joueursDansBataille(carteLaPlusGrande);
			System.out.println("Il y a "+nbJoueursDansBataille+" joueurs dans la bataille");
			
			//Boucle interne simulant une bataille (cas où plusieurs joueurs ont la carte la plus forte)
			if(nbJoueursDansBataille > 1){
				do{
					for(Joueur j : this.joueurs){
						if(j.getEstDansBataille()){
							j.ditBataille();
							j.poserUneCarte();
							System.out.println(j.getNom()+" pose une carte face cachée");
							j.poserUneCarte();
							System.out.println(j.getNom()+" a posé "+j.getPileCartes().premiereCarte());
						}
					}
					
					//On revérifie quelle est la carte la plus forte parmi les joueurs en bataille
					carteLaPlusGrande = this.laPlusForte();
					System.out.println("Carte la plus forte : "+carteLaPlusGrande);
					nbJoueursDansBataille = this.joueursDansBataille(carteLaPlusGrande);
					
				}while(nbJoueursDansBataille > 1);
			}
			
			//Le joueur gagnant le tour récupère toutes les cartes posées
			Joueur gagnantTour = this.gagnantTour(carteLaPlusGrande);
			System.out.println(gagnantTour.getNom()+" récupère les cartes");
			for(Joueur j : this.joueurs){
				if(j.getEstDansPartie())
					gagnantTour.recupererCartes(j.getPileCartes());
			}
			
			//Les joueurs ne possédant plus de cartes ont perdu
			for(Joueur j : this.joueurs){
				if(j.getEstDansPartie() && j.getCartesEnMain().taille() == 0)
					j.setEstDansPartie(false);
			}
			
			//On remet à true le boolean estDansBataille pour le prochain tour
			for(Joueur j : this.joueurs){
				if(j.getEstDansPartie())
					j.setEstDansBataille(true);
			}
	
			this.nbTours+=1;
			this.setChanged();
			this.notifyObservers(this.nbTours);
			System.out.println("*****************************************");
		}
	}
	
	public Joueur joueurGagnant(){
		if(this.finie()){
			Joueur jGagnant = null;
			for(Joueur j : this.joueurs){
				if(j.getEstDansPartie())
					jGagnant = j;
			}
			return jGagnant;
		}
		
		return null;
	}
	
}
