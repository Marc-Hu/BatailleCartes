package InterfaceGraphique;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class LabelTexte extends JLabel implements Observer {
	private String str;

	public LabelTexte(String s)  {
		super();
		this.str = s;
		this.setText(s);
	}

	public void update(Observable o, Object arg){
			this.setText(this.str+arg);
		}
	}
