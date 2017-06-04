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
	
	public void relierMain(int i, LabelMain lMain){
		this.getPartie().getJoueurs(i).getCartesEnMain().addObserver(lMain);
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
