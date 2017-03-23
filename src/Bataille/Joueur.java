package Bataille;

/**
 * Classe représentant le joueur
 * @author Marc
 * @version 1.0
 */

public class Joueur {
	private String nom;
	//private int nbPartiesGagnees;
	private Main cartesEnMain;
	private Pile pileCartes;
	
	/**
	 * Constructeur de la classe Joueur qui a un nom est le nombre de parties gagnées.
	 * @param nomJoueur Nom du Joueur
	 * @param nbPartieGagne	Nombre de parties gagnées par le joueur
	 */
	
	public Joueur(String nomJoueur){
		this.nom= nomJoueur;
	}
	
	/**
	 * Méthode get qui renvoie le nom d'un joueur
	 * @return Le nom du joueur.
	 */
	
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Méthode get qui renvoie le nombre de parties gagnées par le joueur
	 * @return Le nombre de parties gagnées
	 */
	/*
	public int getNbPartieGagne(){
		return this.nbPartiesGagnees;
	}
	*/
	/**
	 * Méthode get qui renvoie le nombre de cartes en Main
	 * @return Nombre de carte en Main
	 */
	
	public int getNbCartesEnMain(){
		return this.cartesEnMain.getNbCartesMain();
	}
	
	/**
	 * Méthode get qui renvoie le nombre de cartes sur la pile
	 * @return Nombre de carte sur la pile
	 */
	
	public int getNbCartesPile(){
		return this.pileCartes.taille();
	}
	
	/**
	 * Méthode set qui va incrémenter le nombre de parties gagnées par le joueur
	 */
	
	/*
	public void setNbPartieGagne(){
		this.nbPartiesGagnees++;
	}
	*/
	
	/**
	 * Méthode qui va afficher bataille.
	 */
	
	public void direBataille(){
		System.out.println("BATAILLE");
	}
	
	/**
	 * Méthode toString de la classe Joueur.
	 * @return Le toString de la classe Joueur.
	 */
	
	public String toString(){
		String s = "Je suis le joueur "+this.nom+'.';
		return s;
	}
	
}
