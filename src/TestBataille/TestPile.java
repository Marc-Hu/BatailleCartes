package TestBataille;
import Bataille.*;
import java.util.*;

public class TestPile {
	public static void main(String[] args){
		System.out.println("Test du constructeur de la classe Pile et de la méthode d'ajout de carte dans la pile");
		Pile pileDeMarc = new Pile();
		pileDeMarc.ajouter(new Carte (10, "trefle"));
		System.out.println(pileDeMarc);
		System.out.println("test de la méthode estVide");
		System.out.println(pileDeMarc.estVide());
		Stack<Carte> test = pileDeMarc.viderPile();
		System.out.println(test);
		System.out.println(pileDeMarc.estVide());
		System.out.println("Test de la méthode taille");
		pileDeMarc.ajouter(new Carte (10, "trefle"));
		pileDeMarc.ajouter(new Carte (9, "trefle"));
		pileDeMarc.ajouter(new Carte (8, "trefle"));
		System.out.println(pileDeMarc);
		System.out.println("Taille de la pile : "+pileDeMarc.taille());
	}
}
