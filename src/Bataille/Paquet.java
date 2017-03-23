package Bataille;
import java.util.HashSet;

public class Paquet {
	private HashSet<Carte> paquetCartes;
	
	/**
	 * Permet d'initialiser un paquet de Carte
	 */
	public Paquet(int nbCarte){
		
		this.paquetCartes = new HashSet<Carte>();
		String couleur = new String();
		for(int j=0; j<4; j++){
			if(j==0) couleur="Pique";
			if(j==1) couleur="Carré";
			if(j==2) couleur="Trèfle";
			if(j==3) couleur="Coeur";
			for(int valeur = 1; valeur <= 14; valeur++){
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
