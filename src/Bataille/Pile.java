package Bataille;
import java.util.Stack;

public class Pile {
	private Stack<Carte> pile;
	
	/**
	 * Permet d'initialiser une pile de carte.
	 */
	public Pile(){
		this.pile = new Stack<Carte>(); 
	}
	
	/*
	 * Retourne la pile de carte
	 */
	public Stack<Carte> getPile(){
		return this.pile;
	}
	
	/**
	 * Ajoute un carte au dessus de la pile
	 * @param c
	 */
	public void ajouter(Carte c){
		pile.push(c);
	}
	
	/**
	 * Test si la pile est vide.
	 * @return retourne True si la est vide sinon False 
	 */
	public boolean vide(){
		return pile.empty();
	}
	
	/**
	 * Vide la pile de carte
	 * @return retourne la copie de la pile supprimer
	 */
	public Stack<Carte> viderPile(){
		Stack<Carte> tmp = pile;
		pile.removeAllElements();
		return tmp;
	}
	
	public int taillePile(){
		return pile.size();
	}
	
}
