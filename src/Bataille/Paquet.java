package Bataille;
import ExceptionBatailles.*;
import java.util.*;

/**
 * Classe de gestion d'un paquet de cartes
 * @version 1.0
 * @author Steeve Jerent/Tony Clonier
 *
 */
public class Paquet{
	
	private List<Carte> paquetCartes;
	private HashSet<Main> mainsJoueurs;
	
/*Constructeur*/
	/**
	 * Construit une instance de paquet
	 */
	public Paquet(int nbCarte, HashSet<Main> lesMains) throws nombreCarteException{
		if(nbCarte != 32 || nbCarte != 52) throw new nombreCarteException(nbCarte);
		int minValue = (nbCarte == 32) ? 7 : 1;
		this.mainsJoueurs = lesMains;
		this.paquetCartes = new ArrayList<Carte>();
		String couleur = new String();
		// on génère les cartes.
		for(int j=0; j<4; j++){
			if(j==0) couleur="Pique";
			if(j==1) couleur="Carré";
			if(j==2) couleur="Trèfle";
			if(j==3) couleur="Coeur";
			for(int valeur = minValue; valeur <= 14; valeur++){
				this.paquetCartes.add(new Carte(valeur, couleur/*, valeur+"-"+couleur.".png"*/));
			}
		}
	}
	
/*Méthodes*/
	
	/**
	 * Retourne une chaîne de caractères contenant les informations de la pile de Cartes
	 */
	public String toString(){
		String str = new String();
		str += "Contenu du paquet de cartes : \n";
		for(Carte c : this.paquetCartes)
			str += c.toString();
		
		return str;	
	}
	
	/**
	 * Retourne le nombre de carte dans le paquet
	 * @return Le nombre de cartes dans le paquet
	 */
	public int taille(){
		return this.paquetCartes.size();
	}
	
	/**
	 * Melange le paquet de Carte
	 */
	public void melanger(){
		Collections.shuffle(paquetCartes);
	}
	
	// à voir pour la distribution
	/*public void distribuer(){
		int tailleMain = this.mainsJoueurs.size();
		int i;
		for(i=0; i<tailleMain; i++){
			int j;
			for(j=0; j<this.mainsJoueurs[i].size(); j++){
				
			}
		}
	}*/
}
