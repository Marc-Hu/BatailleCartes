package InterfaceGraphique;

import Bataille.*;

public class BatailleControleur {
	
	private Partie bataille;
	
	public BatailleControleur(Partie partie){
		this.bataille = partie;
	}
	
	public Partie getPartie(){
		return this.bataille;
	}
	
	public void relierPile(int i, LabelCarte lCarte){
		this.getPartie().getJoueurs(i).getPileCartes().addObserver(lCarte);
	}
	
	public void relierMain(int i, LabelMain lMain){
		this.getPartie().getJoueurs(i).getCartesEnMain().addObserver(lMain);
	}
	

}
