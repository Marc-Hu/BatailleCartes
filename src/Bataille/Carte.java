package Bataille;

/**
 * Classe représentant des cartes de jeu
 * @version 1.0
 * @author Tony Clonier
 */
public class Carte {

	private int valeur;
	private String couleur;
	private String nomFichier;
	
/*Constructeur*/
	/**
	 * Construit une instance de Carte
	 * @param couleur		Couleur de la carte(Carreau, Coeur, Trèfle ou Pique)
	 * @param valeur		Valeur de la carte(De 2 à 14 avec 11=Valet, ..., 14=As)
	 */
	public Carte(int valeur, String couleur){
		this.valeur = valeur;
		this.couleur = couleur;
		this.nomFichier = this.nomCarte();
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
	
	/**
	 * Retourne la valeur de la Carte
	 * @return la valeur de la Carte
	 */
	public String getNomFichier(){
		return this.nomFichier;
	}
	
/*Méthodes*/
	/**
	 * Retourne une chaîne de caractères contenant les informations de la Carte
	 */
	public String toString(){
		return this.getValeur()+" de "+this.getCouleur();
	}

	/**
	 * Vérifie si la Carte courante a une plus grande valeur que la carte c
	 * @param c 	La carte à comparer
	 * @return 		True si la carte courante a une plus grande valeur que c
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
	
   /**
    * Retourne le nom du fichier correspondant aux valeurs des variables d'instance numeroCarte et couleurCarte
    * @return Le nom du fichier (String)
    */
   private String nomCarte(){
	   String s = new String();
	   
		if(this.valeur < 10)
			s = "images/"+this.couleur+"_0"+this.valeur+".GIF";
		else
			s = "images/"+this.couleur+"_"+this.valeur+".GIF";
		
		return s;
   }
}
