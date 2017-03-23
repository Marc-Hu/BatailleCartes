package Bataille;

/**
 * Classe représentant des cartes de jeu
 * @version 1.0
 * @author Tony Clonier
 */
public class Carte {

	private String couleur;
	private int valeur;
	private String nomFichier;
	
/*Constructeur*/
	/**
	 * Construit une instance de Carte
	 * @param couleur		Couleur de la carte(Carreau, Coeur, Trèfle ou Pique)
	 * @param valeur		Valeur de la carte(De 2 à 14 avec 11=Valet, ..., 14=As)
	 */
	public Carte(String couleur, int valeur){
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
/*Getters*/
	/**
	 * Retourne la couleur de la Carte
	 * @return la couleur de la Carte
	 */
	public String getCouleur(){
		return this.couleur;
	}
	/**
	 * Retourne la valeur de la Carte
	 * @return la valeur de la Carte
	 */
	public int getValeur(){
		return this.valeur;
	}
}
