package InterfaceGraphique;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Classe de création d'une fenêtre affichant une carte de jeu
 * @version 1.0
 * @author Tony CLONIER
 *
 */
public class FenetreGraphique extends JFrame {

	private int nbTours;
	
/*Constructeur*/
   /**
    * Construit une instance de fenêtre
    * @param title				Titre de la fenêtre
    * @param x					Coordonnée x du coin supérieur gauche
    * @param y					Coordonnée y du coin supérieur gauche
    * @param w					Largeur de la fenêtre
    * @param h					Hauteur de la fenêtre
    * @param nbJoueurs			Nombre de joueurs dans la partie
    */
   public FenetreGraphique(String title, int x, int y, int w, int h, int nbJoueurs){
	    super(title);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;                   
	    this.setBounds(x, y, w, h);
	    this.nbTours = 0;
	    this.initComposants(nbJoueurs);
	    this.setVisible(true);
	    }
   
/*Méthodes d'initialisation de la fenêtre*/
   
   /**
    * Placement des différents JPanel
    */
   private void initComposants(int nbJoueurs){
	   //Création du panel Nord
	   JPanel pNorth = this.creerPanelNord();
	   this.add(pNorth, BorderLayout.NORTH);
	   //Création du panel Centre
	   JPanel pCenter = this.creerPanelCentre(nbJoueurs);
	   this.add(pCenter, BorderLayout.CENTER);
	   //Création du panel Sud
	   JPanel pSouth = this.creerPanelSud();
	   this.add(pSouth, BorderLayout.SOUTH);
   }
   
   /**
    * Création du JPanel Nord
    * @return JPanel Nord
    */
   private JPanel creerPanelNord(){
	   JPanel pNorth = new JPanel(new BorderLayout());
	   JLabel texte = new JLabel("Texte d'information", SwingConstants.CENTER);
	   
	   pNorth.add(texte, BorderLayout.CENTER);

	   return pNorth;
   }
   
   /**
    * Création du JPanel Centre
    * @return JPanel Centre
    */
   private JPanel creerPanelCentre(int nbJoueurs){
	   JPanel pCenter = new JPanel(new GridLayout(1, nbJoueurs));
	   JLabel[] piles = new JLabel[nbJoueurs];
	    this.setBackground(Color.GREEN);   

	   return pCenter;
   }
   
   /**
    * Création du JPanel Sud
    * @return JPanel Sud
    */
   private JPanel creerPanelSud(){
	   JPanel pSouth = new JPanel();
	   JButton bTour = new JButton("Tour n°"+this.nbTours);
	   JButton bQuitter = new JButton("Quitter");
	   

	   //bTour.addActionListener(   );
	   //bQuitter.addActionListener(   );
	   
	   pSouth.add(bTour);
	   pSouth.add(bQuitter);
	   
	   return pSouth;
   }
}
