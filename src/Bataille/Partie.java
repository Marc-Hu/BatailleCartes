package Bataille;
import java.util.HashSet;

public class Partie {
	private HashSet<Joueur> joueurs;
	private Paquet paquetJ;
	
	/**
	 * Permet d'initialiser une Partie.
	 * @param initJoueur est un tableau de joueur
	 */
	public Partie(HashSet<Joueur> initJoueur, Paquet paquetJoueur){
		this.joueurs = initJoueur;
		this.paquetJ = paquetJoueur;
	}
	
//	public boolean estTerminer(){
//		for(Joueur j: joueurs){
//			if(j.nbCartes() != )
//		}
//	}
	
	
}
