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
		if (marc.getCartesEnMain().taille()==2 && marc.getPileCartes().taille()==1)
			System.out.println("Marc a bien posé une carte sur sa pile et possède 2 cartes en main et une carte sur sa pile.");
		else
			System.out.println("Erreur! Marc a posé une carte sur sa pile et il a donc 2 cartes en main et une carte sur sa pile.");
		System.out.println("Test de la méthode recupererCartesSurPile");
		marc.recupererCartes(marc.getPileCartes());
		if (marc.getCartesEnMain().taille()==3 && marc.getPileCartes().taille()==0)
			System.out.println("Marc à bien récupéré toutes les cartes sur sa pile et possède 3 cartes en main et 0 sur sa pile.");
		else
			System.out.println("Erreur! Marc a récupéré toutes les cartes sur sa pile et possède donc 3 cartes en main et 0 sur sa pile.");
		System.out.println(marc.getCartesEnMain().taille()+" et "+marc.getPileCartes().taille());
	}
}
