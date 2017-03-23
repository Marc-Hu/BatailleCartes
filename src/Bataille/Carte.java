package Bataille;

/**
 * Classe représentant des cartes de jeu
 * @version 1.0
 * @author Tony Clonier
 */
public class Carte {

	private String couleur;
	private int valeur;
	//private String nomFichier;
	
/*Constructeur*/
	/**
	 * Construit une instance de Carte
	 * @param couleur		Couleur de la carte(Carreau, Coeur, Trèfle ou Pique)
	 * @param valeur		Valeur de la carte(De 2 à 14 avec 11=Valet, ..., 14=As)
	 */
	public Carte(String couleur, int valeur){
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
/*Getters*/
	/**
	 * Retourne la couleur de la Carte
	 * @return la couleur de la Carte
	 */
	public String getCouleur(){
		return this.couleur;
	}
	
	/**
	 * Retourne la valeur de la Carte
	 * @return la valeur de la Carte
	 */
	public int getValeur(){
		return this.valeur;
	}
	
/*Méthodes*/
	
	/**
	 * Retourne une chaîne de caractères contenant les informations de la Carte
	 */
	public String toString(){
		String str = new String();
		str += "Couleur de la carte : "+getCouleur()+'\n';
		str += "Valeur de la carte : "+getValeur()+'\n';
		
		return str;
	}
	
	/**
	 * Test si les comptes bancaires ont les mêmes caractéristiques
	 * @param o			Compte à comparer avec le compte receveur
	 * @return true		Si les comptes ont les mêmes caractérisques
	 */
	public boolean equals(Object o){
		if(!(o instanceof Carte))
			return false;
		
		Carte c = (Carte)o;
		
		return this.getCouleur().equals(c.getCouleur())
				&& this.getValeur() == c.getValeur();
	}
	
	/**
	 * Vérifie si la Carte courante a une plus grande valeur que la carte c
	 * @param c		La carte à comparer
	 * @return		True si la carte courante a une plus grande valeur que c
	 */
	public boolean estPlusForte(Carte c){
		return this.getValeur() > c.getValeur();
	}
	
	/**
	 * Vérifie si la Carte courante a la même valeur que la carte c
	 * @param c		La carte à comparer
	 * @return		True si la carte courante a la même valeur que c
	 */
	public boolean aMemeValeur(Carte c){
		return this.getValeur() == c.getValeur();
	}
}
