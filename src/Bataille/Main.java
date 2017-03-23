package Bataille;
import java.util.*;

public class Main {
	private Deque<Carte> cartesMain;
	
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
	 * Méthode de la classe Main qui va ajouter une carte à la fin du Deque
	 * @param carteAjoute Carte à ajouter dans le Deque
	 */
	
	public void ajouterCarte(Carte carteAjoute){
		this.cartesMain.offerLast(carteAjoute);
	}
	
	/**
	 * Méthode de la classe Main qui va retirer la carte qui se situe tout en haut du Deque
	 */
	
	public void retirerCarte(){
		this.cartesMain.pop();
	}
	
	/**
	 * Méthode de la classe Main qui va vérifier qui la Main est vide.
	 * @return True si le Deque est vide et False si le Deque n'est pas vide.
	 */
	
	public boolean mainVide(){
		return this.cartesMain.isEmpty();
	}
}
