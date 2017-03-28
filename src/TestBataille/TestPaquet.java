package TestBataille;
import Bataille.*;
import ExceptionBatailles.*;

public class TestPaquet {
	public static void main(String[] args){
<<<<<<< HEAD
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
=======
		try{
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
			
			// On vérifie que l'on a bien enlevé la bonne carte
			if(p.contient(c)) System.out.println("Le paquet contient toujours la carte.");
			else System.out.println("La carte à bien été retirer");
			
		}catch(NombreCarteException e){
			System.out.println(e);

		}
>>>>>>> 328395432fc08372e48e7071b4d0ad6a1c55c60b
	}
}
