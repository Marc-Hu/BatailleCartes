package InterfaceGraphique;

import Bataille.*;

public class BatailleControleur {
	
	private Partie partie;
	
	public BatailleControleur(Partie partie){
		this.partie = partie;
	}
	
	public Partie getPartie(){
		return this.partie;
	}
	
	public void relierPile(int i, LabelCarte lCarte){
		this.getPartie().getJoueurs(i).getPileCartes().addObserver(lCarte);
	}
	
	public void relierMain(int i, LabelTexte lMain){
		this.getPartie().getJoueurs(i).getCartesEnMain().addObserver(lMain);
	}
	
	public void relierPartie(LabelTexte lInfo){
		this.partie.addObserver(lInfo);
	}
	
	public String getNomJoueur(int i){
		return this.getPartie().getJoueurs(i).getNom();
	}

	public void lancerTour(){
		this.partie.lancerTour();
	}
	
	public boolean initTour(){
		return this.partie.initTour();
	}
	
	public boolean bataille(){
		return this.partie.bataille();
	}
	
	public void finTour(){
		this.partie.finTour();
	}
	
	public boolean finie(){
		return this.partie.finie();
	}

}
