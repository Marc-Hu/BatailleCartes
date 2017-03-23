package ExceptionBatailles;

public class nombreCarteException extends Exception{
	private int nbCartes;
	
	/**
	 * Permet de génerer un exception si le nombre de carte est inférieur 
	 * @param nbC
	 * @param message
	 */
	public nombreCarteException(int nbC){
		super("Le nombre de Carte est invalide.");
		this.nbCartes = nbC;
	}
	
	/**
	 * Retourne le message d'exception
	 */
	public String toString(){
		String s = super.toString();
		s += "\nOn peut avoir 32 ou 56 cartes.\nVous avez saisie "+this.nbCartes;
		return s;
	}
}
