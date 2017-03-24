package Bataille;
import java.util.*;

/**
 * Classe représentant le joueur
 * @author Marc
 * @version 1.0
 */

public class Joueur {
	private String nom;
	private Main cartesEnMain;
	private Pile pileCartes;
	
/*Constructeur*/
	/**
	 * Constructeur de la classe Joueur qui a un nom est le nombre de parties gagnées.
	 * @param nomJoueur Nom du Joueur
	 */	
	public Joueur(String nomJoueur){
		this.nom= nomJoueur;
		this.cartesEnMain=new Main();
		this.pileCartes=new Pile();
	}

/*Getters*/
	/**
	 * Méthode get qui renvoie le nom d'un joueur
	 * @return Le nom du joueur.
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Méthode get qui renvoie la main du joueur
	 * @return La main du jouer
	 */
	public Main getCartesEnMain(){
		return this.cartesEnMain;
	}
	
	/**
	 * Méthode get qui renvoie la pile du jouer
	 * @return la pile du joueur
	 */
	public Pile getPileCartes(){
		return this.pileCartes;
	}
	
/*Méthodes*/
	/**
	 * Méthode toString de la classe Joueur.
	 * @return Le toString de la classe Joueur.
	 */
	public String toString(){
		String s = "Je suis le joueur "+this.nom+'.';
		return s;
	}

	/**
	 * Méthode qui va afficher bataille.
	 */
	public void ditBataille(){
		System.out.println(this.nom+" crie : BATAILLE");
	}
	
	/**
	 * Méthode poserUneCarte qui va retirer une carte dans la main et l'ajouter dans sa pile
	 */
	public void poserUneCarte(){
		this.pileCartes.ajouter(this.cartesEnMain.retirer());
	}
	
	/**
	 * Méthode recupererCartes qui va récupérer toutes les cartes dans la pile et les ajouter dans la Main
	 */
	public void recupererCartes(Pile p){
		Stack<Carte> cartesRecup = p.viderPile();
		for (Carte carteAjout : cartesRecup)
			this.cartesEnMain.ajouter(carteAjout);
	}
	
}
