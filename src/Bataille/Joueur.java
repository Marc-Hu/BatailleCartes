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
	private boolean estDansPartie;
	private boolean estDansBataille;
	
/*Constructeur*/
	/**
	 * Constructeur de la classe Joueur qui a un nom est le nombre de parties gagnées.
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
	
	/**
	 * Retourne la valeur de l'attribut estDansPartie
	 * @return
	 */
	public boolean getEstDansPartie(){
		return this.estDansPartie;
	}
	
	/**
	 * Retourne la valeur de l'attribut estDansBataille
	 * @return
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
	 * @return La carte posée
	 */
	public Carte poserUneCarte(){
		Carte c = this.cartesEnMain.retirer();
		this.pileCartes.ajouter(c);
		
		return c;
	}
	
	/**
	 * Méthode recupererCartes qui va récupérer toutes les cartes dans la pile et les ajouter dans la Main
	 */
	public void recupererCartes(Pile p){
		ArrayList<Carte> cartesRecup = p.vider();
		Collections.shuffle(cartesRecup);
		for (Carte carteAjout : cartesRecup)
			this.cartesEnMain.ajouter(carteAjout);
	}
	
}
