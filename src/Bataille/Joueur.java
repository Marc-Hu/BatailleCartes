package Bataille;
import java.util.*;

/**
 * Classe représentant le joueur
 * @author Marc / Tony
 * @version 1.0
 */

public class Joueur {
	private String nom;
	private Main cartesEnMain;
	private Pile pileCartes;
	private boolean estDansPartie;
	private boolean estDansBataille;
	
/*Constructeur*/
	/**
	 * Constructeur de la classe Joueur
	 * @param nomJoueur Nom du Joueur
	 */	
	public Joueur(String nomJoueur){
		this.nom= nomJoueur;
		this.cartesEnMain=new Main();
		this.pileCartes=new Pile();
		this.estDansPartie = true;
		this.estDansBataille = true;
	}

/*Getters*/
	/**
	 * Retourne le nom d'un joueur
	 * @return Le nom du joueur.
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Retourne la main du joueur
	 * @return La main du jouer
	 */
	public Main getCartesEnMain(){
		return this.cartesEnMain;
	}
	
	/**
	 * Retourne la pile du jouer
	 * @return La pile du joueur
	 */
	public Pile getPileCartes(){
		return this.pileCartes;
	}
	
	/**
	 * Retourne la valeur de l'attribut estDansPartie
	 * @return True si le joueur est toujours dans la Partie
	 */
	public boolean getEstDansPartie(){
		return this.estDansPartie;
	}
	
	/**
	 * Retourne la valeur de l'attribut estDansBataille
	 * @return True si le joueur va participer à une bataille
	 */
	public boolean getEstDansBataille(){
		return this.estDansBataille;
	}
	
	
/*Setters*/
	/**
	 * Modifie la valeur de estDansPartie
	 * @param b		True ou False
	 */
	public void setEstDansPartie(boolean b){
		this.estDansPartie=b;
	}
	
	/**
	 * Modifie la valeur de estDansBataille
	 * @param b		True ou False
	 */
	public void setEstDansBataille(boolean b){
		this.estDansBataille=b;
	}
	
/*Méthodes*/
	/**
	 * Méthode toString de la classe Joueur.
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
	 * Retire une carte de la main et l'ajoute dans sa pile
	 * @return La carte posée
	 */
	public Carte poserUneCarte(){
		Carte c = this.cartesEnMain.retirer();
		if(c != null){
			this.pileCartes.ajouter(c);
			return c;
		}
		return null;
	}
	
	/**
	 * Récupére toutes les cartes de la pile c et les ajoute dans sa Main
	 * @param p Pile dont les cartes vont être récupérées
	 */
	public void recupererCartes(Pile p){
		ArrayList<Carte> cartesRecup = p.vider();
		//Collections.shuffle(cartesRecup);
		for (Carte carteAjout : cartesRecup)
			this.cartesEnMain.ajouter(carteAjout);
	}
	
}
