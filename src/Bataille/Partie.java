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
	/**
	 * Retourne le paquet initilialisé dans la partie en cours
	 * @return
	 */
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
	
	/**
	 * Renvoie la carte la plus forte parmi les cartes posées
	 * @return
	 */
	public Carte laPlusForte(){
		Carte cMax = null;
		for(Joueur j : this.joueurs){
			if(j.getEstDansBataille()){
				cMax = j.getPileCartes().premiereCarte();
				break;
			}
		}
		for(int i=1; i < this.joueurs.length; i++){
			if(this.joueurs[i].getEstDansBataille()){
				Carte ci = this.joueurs[i].getPileCartes().premiereCarte();
				if(ci.estPlusForte(cMax))
					cMax = ci;
			}
		}

		return cMax;
	}
	
	/**
	 * 
	 */
	public int joueursDansBataille(Carte c){
		int somme = 0;
		for(Joueur j : this.joueurs){
			if(j.getEstDansBataille()){
				if(j.getPileCartes().premiereCarte().aMemeValeur(c))
					somme += 1;
				else
					j.setEstDansBataille(false);
			}
		}
		return somme;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public Joueur gagnantTour(Carte c){
		for(Joueur j : this.joueurs){
			if(j.getEstDansPartie() && j.getPileCartes().premiereCarte().aMemeValeur(c))
				return j;
		}
		
		return null;
	}
	
	/**
	 * Vérifie si la partie est finie ou pas
	 * @return True si la partie est finie
	 */
	public boolean finie(){
		int nbJoueursDansPartie = 0;
		for(Joueur j : this.joueurs){
			if(j.getEstDansPartie())
				nbJoueursDansPartie += 1;
		}
		if(nbJoueursDansPartie > 1)
			return false;
		
		return true;
	}

	
	
}
