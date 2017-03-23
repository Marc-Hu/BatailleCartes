package Bataille;
import java.util.HashSet;
import ExceptionBatailles.nombreCarteException;

public class Paquet{
	private HashSet<Carte> paquetCartes;
	
	/**
	 * Permet d'initialiser un paquet de Carte.
	 */
	public Paquet(int nbCarte) throws nombreCarteException{
		if(nbCarte != 32 || nbCarte != 52) throw new nombreCarteException(nbCarte);
		int minValue = (nbCarte == 32) ? 7 : 1;
		this.paquetCartes = new HashSet<Carte>();
		String couleur = new String();
		// on génère les cartes.
		for(int j=0; j<4; j++){
			if(j==0) couleur="Pique";
			if(j==1) couleur="Carré";
			if(j==2) couleur="Trèfle";
			if(j==3) couleur="Coeur";
			for(int valeur = minValue; valeur <= 14; valeur++){
				this.paquetCartes.add(new Carte(couleur, valeur));
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
	
}
