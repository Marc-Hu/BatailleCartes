package TestBataille;
import Bataille.*;


public class TestPile {
	public static void main(String[] args){
		System.out.println("=====>Test du constructeur de la classe Pile et de la méthode d'ajout de carte dans la pile");
		Pile pileDeMarc = new Pile();
		pileDeMarc.ajouter(new Carte (10, "trefle"));
		System.out.println(pileDeMarc);
		if (pileDeMarc.taille()==1)
			System.out.println("Test réussi! La pile de Marc contient bien une carte");
		else
			System.out.println("Erreur! La pile de Marc contient une carte et non "+pileDeMarc.taille()+" cartes.");
		System.out.println("=====>Test de la méthode estVide");
		if (!pileDeMarc.estVide())
			System.out.println("Test réussi! La pile de Marc contient des cartes");
		else
			System.out.println("Erreur! La pile de Marc n'est pas vide.");
		pileDeMarc.viderPile();
		if (pileDeMarc.estVide())
			System.out.println("Test réussi! La pile de Marc est vide.");
		else
			System.out.println("Erreur! La piple de Marc est vide!");
		System.out.println("=====>Test de la méthode taille");
		pileDeMarc.ajouter(new Carte (10, "trefle"));
		pileDeMarc.ajouter(new Carte (9, "trefle"));
		pileDeMarc.ajouter(new Carte (8, "trefle"));
		System.out.println(pileDeMarc);
		if (pileDeMarc.taille()==3)
			System.out.println("Test réussi! La pile de Marc contient bien 3 cartes");
		else
			System.out.println("Erreur! La pile de Marc contient 3 cartes et non "+pileDeMarc.taille()+ " cartes.");
	}
}
