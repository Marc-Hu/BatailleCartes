package TestBataille;

import Bataille.*;
import java.util.*;

/*
 * Pour chaque test on regarde si la méthode à bien été effectué, un message d'erreur apparaît si il y a un problème
 */

public class TestPile {
	public static void main(String[] args){
		/*
		 * Test constructeur
		 */
		System.out.println("=====>Test du constructeur de la classe Pile et de la méthode d'ajout de carte dans la pile\n");
		Pile pileDeMarc = new Pile();
		pileDeMarc.ajouter(new Carte (10, "trefle"));
		System.out.println(pileDeMarc);
		if (pileDeMarc.taille()==1)
			System.out.println("Test réussi! La pile de Marc contient bien une carte\n");
		else
			System.out.println("Erreur! La pile de Marc contient une carte et non "+pileDeMarc.taille()+" cartes.");
		/*
		 * Test méthode estVide
		 */
		System.out.println("=====>Test de la méthode estVide\n");
		if (!pileDeMarc.estVide())
			System.out.println("Test réussi! La pile de Marc contient des cartes\n");
		else
			System.out.println("Erreur! La pile de Marc n'est pas vide.\n");
		ArrayList<Carte> cartesRetirees = pileDeMarc.vider();
		System.out.println("Cartes retirées : \n"+cartesRetirees);
		if (pileDeMarc.estVide())
			System.out.println("\nTest réussi! La pile de Marc est vide.\n");
		else
			System.out.println("Erreur! La piple de Marc est vide!\n");
		/*
		 * Test méthode taille
		 */
		System.out.println("=====>Test de la méthode taille\n");
		pileDeMarc.ajouter(new Carte (10, "trefle"));
		pileDeMarc.ajouter(new Carte (9, "trefle"));
		pileDeMarc.ajouter(new Carte (8, "trefle"));
		System.out.println(pileDeMarc);
		if (pileDeMarc.taille()==3)
			System.out.println("Test réussi! La pile de Marc contient bien 3 cartes\n");
		else
			System.out.println("Erreur! La pile de Marc contient 3 cartes et non "+pileDeMarc.taille()+ " cartes.");
	}
}
