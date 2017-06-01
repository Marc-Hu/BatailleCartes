package InterfaceGraphique;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

public class ButtonTour extends JButton implements Observer{
	private int nbTour;
	
	public ButtonTour(){
		super();
		this.nbTour = 0;
		this.setText("Tour n° :" +this.nbTour);
	}
	
	public void update(Observable o, Object arg){
		int n = (int)arg;
		this.nbTour = n;
		this.setText("Tour n° :" +this.nbTour);
	}

}
