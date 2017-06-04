package InterfaceGraphique;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * JLabel permettant d'afficher une chaîne et une valeur associée à un Observable
 * @version 1.0
 * @author Tony CLONIER
 *
 */
public class LabelTexte extends JLabel implements Observer {
	private String str;

/*Constructeur*/
	/**
	 * Construit une instance de LabelTexte
	 * @param s texte à afficher
	 */
	public LabelTexte(String s)  {
		super();
		this.str = s;
		this.setText(s);
	}

/*Méthodes*/
	/**
	 * Met à jour le texte affiché en fonction d'un changement de valeur chez l'observable
	 */
	public void update(Observable o, Object arg){
			this.setText(this.str+arg);
		}
	}
