package InterfaceGraphique;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Bataille.Carte;

public class LabelCarte extends JLabel implements Observer{
	private Image im;

	public LabelCarte(String nomImage)  {
		super();
		this.setIcon(new ImageIcon(nomImage));
		this.im = Toolkit.getDefaultToolkit().getImage(nomImage);
	}

	public LabelCarte(){
		super();
	}

	public void setImage(String nouvImage){
		ImageIcon icon = new ImageIcon(nouvImage);
		this.setIcon(icon);
		this.im = Toolkit.getDefaultToolkit().getImage(nouvImage);
		this.repaint();
	}
	
	public void update(Observable o, Object arg){
		if(arg instanceof Carte){
			Carte c = (Carte)arg;
			this.setImage(c.nomCarte());
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		// au cas où 
		if (this.im!=null)	{
			// calcul des dimensions du LabelImage
			int hauteurLabel= this.getHeight();
			int largeurLabel = this.getWidth(); 
			// on redimensionne l'image à la dimension du label lui-même
			g.drawImage(this.im, 0, 0, largeurLabel, hauteurLabel, this);
		}
	}
}	// fin de LabelImage*/
