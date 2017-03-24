package TestBataille;
import Bataille.*;

public class TestJoueur {
	public static void main(String[] args){
		System.out.println("Test du constructeur de la classe Joueur et test de la méthode ditBataille");
		Main mainDeMarc = new Main();
		mainDeMarc.ajouter(new Carte (8, "pique"));
		mainDeMarc.ajouter(new Carte (9, "pique"));
		mainDeMarc.ajouter(new Carte (6, "pique"));
		Pile pileDeMarc = new Pile();
		Joueur marc = new Joueur("Marc", mainDeMarc, pileDeMarc);
		System.out.println(marc);
		marc.ditBataille();
		System.out.println("Test de la méthode poserUneCarte");
		marc.poserUneCarte();
		if (marc.getNbCartesEnMain()==2 && marc.getNbCartesPile()==1)
			System.out.println("Marc à bien 2 cartes en main et une carte sur sa pile.");
		else
			System.out
	}
}
