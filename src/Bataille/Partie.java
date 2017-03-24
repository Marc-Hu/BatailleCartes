package Bataille;


/**
 * Classe de gestion d'une partie
 * @version 1.0
 * @author Tony Clonier
 */
public class Partie {
	
	private Joueur[] joueurs;
	private Paquet paquet;
	
/*Constructeur*/
	/**
	 * Créer une instance de partie 
	 * @param joueurs est un tableau de joueur
	 * @param paquet
	 */
	public Partie(Joueur[] joueurs, Paquet paquet){
		this.joueurs = joueurs;
		this.paquet = paquet;
	}
	
/*Getters*/
	
	public Paquet getPaquet(){
		return this.paquet;
	}
	
/*Méthodes*/
	
	/**
	 * Retourne une chaîne de caractères contenant les informations de la partie en cours
	 */
	public String toString(){
		String str = new String();
		str += "Partie en cours : \n";
		str += "Liste des joueurs : \n";
		for(Joueur j : this.joueurs)
			str += j.toString()+'\n';
		
		return str;
	}
	
	/**
	 * Distribue les cartes du Paquet
	 */
	public void distribuerPaquet(){
		int nbJoueurs = this.joueurs.length;
		int nbCartes = this.paquet.taille();
		for(int i=0; i<nbCartes; i++){
			Carte c = this.paquet.retirer();
			int j = i%nbJoueurs;
			this.joueurs[j].getCartesEnMain().ajouter(c);
		}
	}

//	public boolean estTerminer(){
//		for(Joueur j: joueurs){
//			if(j.nbCartes() != )
//		}
//	}
	
	
}
