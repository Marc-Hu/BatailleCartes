package ExceptionBatailles;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import Bataille.*;

public class ValeurCarteException extends Exception {

	int valeur;
	
/*Constructeurs*/
	
	/**
	 * Construit une instance de ValeurCarteException
	 * @param c						Carte concernée par l'exception
	 * @param message				Message d'erreur associé à l'exception
	 */
	public ValeurCarteException(int valeur, String message){
		super(message);
		this.valeur = valeur;
	}
	
/*Méthodes*/
	/**
	 * Retourne une chaîne de caractères contenant les informations de l'exception
	 */
	public String toString(){
		return super.toString()+" Carte non valide : "+c.toString();
	}
	
}
