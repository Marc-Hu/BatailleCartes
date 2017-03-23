package Bataille;
import java.util.*;

public class Main {
	private ArrayDeque<Carte> cartesMain;
	
	/**
	 * Constructeur de la classe Main.
	 */
	
	public Main(){
		this.cartesMain=new ArrayDeque<Carte>();
	}
	
	/** 
	 * Méthode get de la classe Main qui va renvoyer les cartes dans la main
	 * @return Les cartes en main
	 */
	
	public Deque<Carte> getMain(){
		return this.cartesMain;
	}
	
	/**
	 * Méhtode get de la classe Main qui va renvoyer le nombres de cartes dans la main
	 * @return Le nombre de cartes en Main
	 */
	
	public int getNbCartesMain(){
		return this.cartesMain.size();
	}
	
	/**
	 * Méthode de la classe Main qui va ajouter une carte à la fin du Deque
	 * @param carteAjoute Carte à ajouter dans le Deque
	 */
	
	public void ajouterCarte(Carte carteAjoute){
		this.cartesMain.offerLast(carteAjoute);
	}
	
	/**
	 * Méthode de la classe Main qui va retirer une carte au dessus de la pile et la retourner
	 * @return Retourne la carte au dessus de l'arrayDeque
	 */
	
	public Carte retirerCarte(){
		return this.cartesMain.pop();
	}
	
	/**
	 * Méthode de la classe Main qui va vérifier qui la Main est vide.
	 * @return True si le Deque est vide et False si le Deque n'est pas vide.
	 */
	
	public boolean mainVide(){
		return this.cartesMain.isEmpty();
	}
	
	/**
	 * Méthode toString de la classe Main
	 * @return Retourne le toString de la classe Main
	 */
	
	public String toString(){
		String s = "J'ai en Main toutes les cartes suivantes :\n";
		for (Carte carteAffiche : this.cartesMain)
			s+=carteAffiche.toString();
		return s;
	}
}
