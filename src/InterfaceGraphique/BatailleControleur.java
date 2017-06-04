package InterfaceGraphique;

import Bataille.*;

/**
 * Controlleur permettant de faire le lien entre la FenetreGraphique et la bataille
 * @version 1.0
 * @author Tony CLONIER
 *
 */
public class BatailleControleur {
	private Partie partie;
	
/*Constructeur*/
	/**
	 * Construit une instance de BatailleControleur
	 * @param partie à superviser
	 */
	public BatailleControleur(Partie partie){
		this.partie = partie;
	}
	
/*Getters*/
	/**
	 * Retourne la partie supervisée par le contrôleur
	 * @return
	 */
	public Partie getPartie(){
		return this.partie;
	}
	
/*Méthodes*/
	/**
	 * Fait le lien entre le joueur i et le LabelCarte
	 * @param i			indice du joueur
	 * @param lCarte	LabelCarte correspondant
	 */
	public void relierPile(int i, LabelCarte lCarte){
		this.getPartie().getJoueurs(i).getPileCartes().addObserver(lCarte);
	}
	
	/**
	 * Fait le lien entre le joueur i et le LabelTexte affichant le nombre de cartes en main
	 * @param i			indice du joueur
	 * @param lMain		LabelTexte correspondant
	 */
	public void relierMain(int i, LabelTexte lMain){
		this.getPartie().getJoueurs(i).getCartesEnMain().addObserver(lMain);
	}
	
	/**
	 * Fait le lien entre les informations de la partie en cours et le LabelTexte associé
	 * @param lInfo		Labeltexte associé à l'affichage des informations de la partie supervisés
	 */
	public void relierPartie(LabelTexte lInfo){
		this.partie.addObserver(lInfo);
	}
	
	/**
	 * Appel la méthode permettant de retourner le nom du joueur i de la partie supervisée
	 * @param i		Indice du joueur
	 * @return 		Nom du joueur d'indice i
	 */
	public String getNomJoueur(int i){
		return this.getPartie().getJoueurs(i).getNom();
	}

	/**
	 * Appel la méthode permettant d'initialiser le Tour
	 * @return true si une bataille doit être effectuée
	 */
	public boolean initTour(){
		return this.partie.initTour();
	}
	
	/**
	 * Appel la méthode permettant de faire une bataille
	 * @return true si la bataille doit être continuée
	 */
	public boolean bataille(){
		return this.partie.bataille();
	}
	
	/**
	 * Appel la méthode permettant de finaliser le tour
	 */
	public void finTour(){
		this.partie.finTour();
	}
	
	/**
	 * Appel la méthode vérifiant si la partie supervisée est terminée
	 * @return	true si la partie supervisée est terminée
	 */
	public boolean finie(){
		return this.partie.finie();
	}

}
