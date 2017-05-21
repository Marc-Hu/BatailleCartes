package Bataille;
import java.util.*;

/**
 * Classe de gestion de la main du joueur
 * @version 1.0
 * @author Marc Hu
 */
public class Main extends Observable {
	
	private ArrayDeque<Carte> cartesMain;
	
/*Constructeur*/
	/**
	 * Construit une instance de main
	 */
	public Main(){
		this.cartesMain=new ArrayDeque<Carte>();
	}

/*Méthodes*/
	/**
	 * Méthode toString de la classe Main
	 * @return Retourne le toString de la classe Main
	 */
	
	public String toString(){
		String s = "J'ai en main les cartes suivantes :\n";
		for (Carte carteAffiche : this.cartesMain)
			s+=carteAffiche.toString()+'\n';
		return s;
	}
	
	/**
	 * Ajoute la carte c en dessous de la main 
	 * @param c Carte à ajouter dans le Deque
	 */
	public void ajouter(Carte c){
		if(c != null){
			this.cartesMain.offerLast(c);
			this.setChanged();
			this.notifyObservers(this.taille());
		}
	}
	
	/**
	 * Retire la carte au dessus de la main
	 * @return Carte au dessus de la main
	 */
	public Carte retirer(){
		if(this.cartesMain.size() >= 1){
			Carte c = this.cartesMain.pop();
			this.setChanged();
			this.notifyObservers(this.taille());
			return c;
		}
		
		return null;
	}
	
	/**
	 * Vérifie si la main est vide
	 * @return True si la main est vide, False sinon
	 */
	public boolean estVide(){
		return this.cartesMain.isEmpty();
	}
	
	/**
	 * Retourne le nombre de cartes présentes dans la main
	 * @return Nombre de cartes présentes dans la main
	 */
	public int taille(){
		return this.cartesMain.size();
	}
}
