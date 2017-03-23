package Bataille;
import java.util.*;

public class Joueur {
	private String nom;
	private int nbPartiesGagnees;
	private Main cartesEnMain;
	private Pile pileCartes;
	
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
	 * Méthode get qui renvoie le nombre de cartes en Main
	 * @return Nombre de carte en Main
	 */
	
	public int getNbCartesEnMain(){
		return this.cartesEnMain.getMain().size();
	}
	
	public int getNbCartesPile(){
		return this.pileCartes.taillePile();
	}
	
	/**
	 * Méthode set qui va incrémenter le nombre de parties gagnées par le joueur
	 */
	
	public void setNbPartieGagne(){
		this.nbPartiesGagnees++;
	}
	
	/**
	 * Méthode qui va afficher bataille.
	 */
	
	public void direBataille(){
		System.out.println("BATAILLE");
	}
}
