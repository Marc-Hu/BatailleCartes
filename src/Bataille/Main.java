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
}
