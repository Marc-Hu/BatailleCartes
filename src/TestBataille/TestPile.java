package TestBataille;
import Bataille.*;

public class TestPile {
	public static void main(String[] args){
		System.out.println("Test du constructeur de la classe Pile et de la méthode d'ajout de carte dans la pile");
		Pile pileDeMarc = new Pile();
		pileDeMarc.ajouter(new Carte ("trefle", 10));
		System.out.println(pileDeMarc);
		System.out.println("test de la méthode estVide");
		System.out.println(pileDeMarc.estVide());
		pileDeMarc.viderPile();
		System.out.println(pileDeMarc.estVide());
		System.out.println("Test de la méthode taille");
		pileDeMarc.ajouter(new Carte ("trefle", 10));
		pileDeMarc.ajouter(new Carte ("trefle", 9));
		pileDeMarc.ajouter(new Carte ("trefle", 8));
		System.out.println(pileDeMarc);
		System.out.println("Taille de la pile : "+pileDeMarc.taille());
	}
}
