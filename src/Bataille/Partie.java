package Bataille;
import java.util.HashSet;

/**
 * Classe de gestion d'une partie
 * @version 1.0
 * @author Tony Clonier
 */
public class Partie {
	
	private HashSet<Joueur> joueurs;
	private Paquet paquet;
	
/*Constructeur*/
	/**
	 * Créer une instance de partie 
	 * @param joueurs est un tableau de joueur
	 * @param paquet
	 */
	public Partie(HashSet<Joueur> joueurs, Paquet paquet){
		this.joueurs = joueurs;
		this.paquet = paquet;
	}
	
/*Méthodes*/
	
	public String toString(){
		String str = new String();
		str += "Partie en cours : \n";
		str += "Liste des joueurs : \n";
		for(Joueur j : this.joueurs)
			str += j.toString()+'\n';
		
		return str;
	}
	
//	public boolean estTerminer(){
//		for(Joueur j: joueurs){
//			if(j.nbCartes() != )
//		}
//	}
	
	
}
