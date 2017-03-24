package TestBataille;
import Bataille.*;

public class TestMain {
	public static void main(String[] args) {
		
		Main pileCartes = new Main();
		for(int i = 2; i < 15; i++)
			pileCartes.ajouterCarte(new Carte("pique", i, "test"));
		
		System.out.println(pileCartes);
		
		
			
	}
}
