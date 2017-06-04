package InterfaceGraphique;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Bataille.*;

/**
 * Classe de création d'une fenêtre affichant une carte de jeu
 * @version 1.0
 * @author Tony CLONIER
 *
 */
public class FenetreGraphique extends JFrame {

	private Image background;
	private BatailleControleur bControleur;
	private final static int DEBUT_TOUR = 0;
	private final static int BATAILLE = 1;
	private final static int FIN_TOUR = 2;
	private int etatPartie;
	
	
/*Constructeur*/
   /**
    * Construit une instance de fenêtre
    * @param title				Titre de la fenêtre
    * @param background			Nom de l'image à mettre en fond d'écran
    * @param x					Coordonnée x du coin supérieur gauche
    * @param y					Coordonnée y du coin supérieur gauche
    * @param w					Largeur de la fenêtre
    * @param h					Hauteur de la fenêtre
    * @param nbJoueurs			Nombre de joueurs dans la partie
    * @param					Contrôleur faisant le lien avec la partie à superviser
    */
   public FenetreGraphique(String title, String background,/* int x, int y, int w, int h,*/ int nbJoueurs, BatailleControleur bc){
	    super(title);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;                   
	    //this.setBounds(x, y, w, h);
	    this.background = Toolkit.getDefaultToolkit().getImage(background);
	    this.bControleur = bc;
	    this.etatPartie = DEBUT_TOUR;
	    this.initComposants(nbJoueurs);
	    this.pack();
	    this.setVisible(true);
	    }
   
/*Méthodes d'initialisation de la fenêtre*/
   
   /**
    * Placement des différents JPanel
    */
   private void initComposants(int nbJoueurs){
	   PanelImage PanelPrincipal = new PanelImage(new BorderLayout());
	   //Création de la partie Nord
	   JPanel pNorth = creerPanelNord();
	   PanelPrincipal.add(pNorth, BorderLayout.NORTH);
	   //Création du panel Centre
	   JPanel pCenter = this.creerPanelCentre(nbJoueurs);
	   PanelPrincipal.add(pCenter, BorderLayout.CENTER);
	   //Création du panel Sud
	   JPanel pSouth = this.creerPanelSud();
	   PanelPrincipal.add(pSouth, BorderLayout.SOUTH);
	   
	   this.add(PanelPrincipal);
   }
   
   /**
    * Création du JPanel Nord
    * @return JPanel Nord
    */
   private JPanel creerPanelNord(){
	   JPanel pNorth = new JPanel();
	   
	   LabelTexte lInfo = new LabelTexte("Informations : ");
	   this.bControleur.relierPartie(lInfo);
	   lInfo.setFont(new Font("Arial",Font.BOLD, 15));
	   lInfo.setForeground(Color.WHITE);
	   
	   pNorth.setOpaque(false);
	   pNorth.add(lInfo, JLabel.CENTER);
	   
	   return pNorth;
   }

   /**
    * Création du JPanel Sud
    * @return JPanel Sud
    */
   private JPanel creerPanelSud(){
	   JPanel pSouth = new JPanel();
	   
	   JButton bTour = new JButton("Poser cartes");
	   JButton bQuitter = new JButton("Quitter");
	   
	   //Lance le premier tour lors de la création de la fenêtre
		boolean faireBataille = FenetreGraphique.this.bControleur.initTour();
		if(faireBataille){
			FenetreGraphique.this.etatPartie = BATAILLE;
			bTour.setText("Continuer bataille");
		}else{
			FenetreGraphique.this.etatPartie = FIN_TOUR;
			bTour.setText("Ramasser Cartes");
		}

		//Bouton principal dont le rôle évolue en fonction de l'avancement de la partie
		bTour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			   
			   switch(FenetreGraphique.this.etatPartie){
			   		case DEBUT_TOUR :
			   			boolean faireBataille = FenetreGraphique.this.bControleur.initTour();
			   			if(faireBataille){
			   				FenetreGraphique.this.etatPartie = BATAILLE;
			   				bTour.setText("Continuer bataille");
			   			}else{
			   				FenetreGraphique.this.etatPartie = FIN_TOUR;
			   				bTour.setText("Ramasser Cartes");
			   			}
			   			break;
			   		case BATAILLE :
			   			boolean continuerBataille = FenetreGraphique.this.bControleur.bataille();
			   			if(!continuerBataille){	
			   				FenetreGraphique.this.etatPartie = FIN_TOUR;
			   				bTour.setText("Ramasser Cartes");
			   			}
			   			break;
			   		case FIN_TOUR :
			   			FenetreGraphique.this.bControleur.finTour();
			   			if(!FenetreGraphique.this.bControleur.finie()){
				   			FenetreGraphique.this.etatPartie = DEBUT_TOUR;
				   			bTour.setText("Poser cartes");
			   			}else{
			   				bTour.setText("Partie finie");
			   				bTour.setEnabled(false);
			   			}
			   				
			   			break;
			   }
		   }
	   });
	   
		
		bQuitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FenetreGraphique.this.dispose();
			}
		});
	   
	   pSouth.add(bTour);
	   pSouth.add(bQuitter);
	   pSouth.setOpaque(false);
	   return pSouth;
   }
   
   /**
    * Création du JPanel Centre, affiche les informations associées aux joueurs
    * @param nbJoueurs 	Nombre de joueurs de la partie en cours
    * @return	JPanel Centre
    */
   private JPanel creerPanelCentre(int nbJoueurs){
	   JPanel pCenter = new JPanel(new GridLayout(1, nbJoueurs, 50, 0));
	   
	   for(int i=0; i<nbJoueurs; i++)
		   pCenter.add(this.creerPanelJoueur(i));
	   
	   pCenter.setOpaque(false);
	   
	   return pCenter;
   }
   
   /**
    * Permet de créer un JPanel affichant toutes les informations associées à un joueur
    * @param i	Indice du joueur
    * @return	Le JPanel correspondant au joueur i
    */
   private JPanel creerPanelJoueur(int i){
	   JPanel panelJoueur = new JPanel(new BorderLayout());
	   
	   LabelCarte lCarte = new LabelCarte();
	   this.bControleur.relierPile(i, lCarte);
	   

	   LabelTexte lMain = new LabelTexte(this.bControleur.getNomJoueur(i)+" :  Nombre de cartes en main : ");
	   this.bControleur.relierMain(i, lMain);
	   lMain.setFont(new Font("Arial",Font.BOLD, 15));
	   lMain.setForeground(Color.WHITE);
	   lMain.setHorizontalAlignment(JLabel.CENTER);
	   
	   panelJoueur.add(lCarte, BorderLayout.CENTER);
	   panelJoueur.add(lMain, BorderLayout.SOUTH);
	   panelJoueur.setOpaque(false);
	   return panelJoueur;
   }
	
 /*Inner class*/
   
   /**
    * Classe permettant de créer un JPanel vide avec fond d'écran
    * @author Tony CLONIER
    *
    */
	class PanelImage extends JPanel {
		public PanelImage(){
			super();
		}
		public PanelImage(BorderLayout borderLayout) {
			super(borderLayout);
		}
		public void paintComponent(Graphics g) {
		    	super.paintComponent(g);
				int hauteurFrame = this.getHeight();
				int largeurFrame = this.getWidth(); 
				g.drawImage(FenetreGraphique.this.background, 0, 0, largeurFrame, hauteurFrame, this);
			
		    }
		}

}
