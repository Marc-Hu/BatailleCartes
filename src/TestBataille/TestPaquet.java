package TestBataille;
import Bataille.*;

public class TestPaquet {
	public static void main(String[] args){

		// on instancie un paquet
		Paquet p = new Paquet(32);
		
		// on vérifie la taille du paquet
		if(p.taille() != 32 && p.taille() != 52) System.out.println("La taille du paquet est invalide : "+p.taille());
		else System.out.println("La taille du paquet valide : "+p.taille());
		
		// On retire la premier carte
		Carte c = p.retirer();
		if(c == null) System.out.println("Aucun carte n'est retirée.");
		else System.out.println("La carte : "+ c +" est retirée du paquet");
		
		// On vérifie la taille du paquet
		if(p.taille() != 31 && p.taille() != 51) System.out.println("la taille est invalide : "+p.taille());
		else System.out.println("La taille est valide : "+p.taille());
		System.out.println(p);


			
	}
}
