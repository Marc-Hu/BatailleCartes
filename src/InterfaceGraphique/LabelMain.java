package InterfaceGraphique;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class LabelMain extends JLabel implements Observer {
	private int nbcartes;

	public LabelMain()  {
		super();
		this.nbcartes = 0;
		this.setText("Nombre de cartes en main :" +this.nbcartes);
	}

	public void update(Observable o, Object arg){
			int n = (int)arg;
			this.nbcartes = n;
			this.setText("Nombre de cartes en main :" +this.nbcartes);
		}
	}
