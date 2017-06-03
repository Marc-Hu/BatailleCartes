package Bataille;

import java.util.*;

/**
 * Classe de gestion d'un paquet de cartes
 * @version 1.0
 * @author Steeve Jerent/Tony Clonier
 *
 */
public class Paquet{
	
	private List<Carte> paquetCartes;
	
/*Constructeur*/
	/**
	 * Construit une instance de paquet
	 * @param nbCarte 	Nombre de cartes du paquet à initialiser
	 */
	public Paquet(int nbCarte) /*throws NombreCarteException*/{
		/*if(nbCarte != 32 && nbCarte != 52) throw new NombreCarteException(nbCarte);*/
		int minValue = (nbCarte == 32) ? 7 : 2;
		this.paquetCartes = new ArrayList<Carte>();
		String couleur = new String();
		// on génère les cartes.
		for(int j=0; j<4; j++){
			if(j==0) couleur="Pique";
			if(j==1) couleur="Carreau";
			if(j==2) couleur="Trefle";
			if(j==3) couleur="Coeur";
			for(int valeur = minValue; valeur <= 14; valeur++){
				this.paquetCartes.add(new Carte(valeur, couleur/*, valeur+"-"+couleur.".png"*/));
			}
		}
		this.melanger();
	}
	
/*Méthodes*/
	
	/**
	 * Retourne une chaîne de caractères contenant les informations de la pile de Cartes
	 */
	public String toString(){
		String str = new String();
		str += "Contenu du paquet de cartes : \n";
		for(Carte c : this.paquetCartes)
			str += c.toString()+"\n";
		
		return str;	
	}
	
	/**
	 * Retourne le nombre de carte dans le paquet
	 * @return Nombre de cartes dans le paquet
	 */
	public int taille(){
		return this.paquetCartes.size();
	}
	
	/**
	 * Melange le paquet de Carte
	 */
	private void melanger(){
		Collections.shuffle(paquetCartes);
	}
	
	/**
	 * Permet de de déterminer si une carte est bien contenu dans le paquet
	 * @param c		Carte dont on souhaite vérifier la présence
	 * @return		true si la carte est présente dans le paquet
	 */
	public boolean contient(Carte c){
		return this.paquetCartes.contains(c);
	}
	
	/**
	 * retourne la premiere carte du paquet et la supprime du paquet
	 * @return Première carte du paquet (ou null)
	 */
	public Carte retirer(){
		if(this.taille() > 0){ 
			Carte c = this.paquetCartes.get(0);
			this.paquetCartes.remove(0);
			return c;
		}
		return null;
	}
}
