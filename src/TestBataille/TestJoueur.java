package TestBataille;
import Bataille.*;

public class TestJoueur {
	public static void main(String[] args){
		System.out.println("Test du constructeur de la classe Joueur et test de la méthode ditBataille");
		Joueur marc = new Joueur("Marc");
		System.out.println(marc);
		marc.ditBataille();
	}
}
