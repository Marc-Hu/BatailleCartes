package Bataille;

public class Joueur {
	private String nom;
	private int nbPartiesGagnees;
	
	/**
	 * Constructeur de la classe Joueur qui a un nom est le nombre de parties gagnées.
	 * @param nomJoueur Nom du Joueur
	 * @param nbPartieGagne	Nombre de parties gagnées par le joueur
	 */
	
	public Joueur(String nomJoueur, int nbPartieGagne){
		this.nom= nomJoueur;
		this.nbPartiesGagnees=nbPartieGagne;
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
	
	public int getNbPartieGagne(){
		return this.nbPartiesGagnees;
	}
	
	/**
	 * Méthode set qui va incrémenter le nombre de parties gagnées par le joueur
	 */
	
	public void setNbPartieGagne(){
		this.nbPartiesGagnees++;
	}
}
