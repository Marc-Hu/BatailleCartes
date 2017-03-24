package Bataille;
import ExceptionBatailles.*;
import java.util.*;

public class Paquet{
	private List<Carte> paquetCartes;
	private HashSet<Main> mainsJoueurs;
	/**
	 * Permet d'initialiser un paquet de Carte.
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
				this.paquetCartes.add(new Carte(couleur, valeur, valeur+"-"+couleur.".png"));
			}
		}
	}
	
	/**
	 * Retourne le nombre de carte dans le paquet
	 * @return
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
	public void distribuer(){
		int tailleMain = this.mainsJoueurs.size();
		int i;
		for(i=0; i<tailleMain; i++){
			int j;
			for(j=0; j<this.mainsJoueurs[i].size(); j++){
				
			}
		}
	}
}
