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
	
	/**
	 * Créer une instance de partie, le paquet a 52 cartes par défaut
	 * @param joueurs est un tableau de joueur
	 */
	public Partie(Joueur[] joueurs){
		this.joueurs = joueurs;
		this.paquet = new Paquet(52);
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

	public Carte laPlusForte(){
		Carte cMax = this.joueurs[0].getPileCartes().premiereCarte();
		for(int i=1; i < this.joueurs.length; i++){
			Carte ci = this.joueurs[i].getPileCartes().premiereCarte();
			if(ci.estPlusForte(cMax))
				cMax = ci;
		}

		return cMax;
	}
	
	/**
	 * Vérifie si la partie est finie ou pas
	 * @return True si la partie est finie
	 */
	public boolean finie(){
		for(Joueur j : this.joueurs){
			if(j.getCartesEnMain().taille()==0)
				return true;
		}
		return false;
	}

	
	
}
