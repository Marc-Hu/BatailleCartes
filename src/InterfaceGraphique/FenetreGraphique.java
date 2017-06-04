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
    * @param x					Coordonnée x du coin supérieur gauche
    * @param y					Coordonnée y du coin supérieur gauche
    * @param w					Largeur de la fenêtre
    * @param h					Hauteur de la fenêtre
    * @param nbJoueurs			Nombre de joueurs dans la partie
    */
   public FenetreGraphique(String title, String background, int x, int y, int w, int h, int nbJoueurs, BatailleControleur bc){
	    super(title);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;                   
	    this.setBounds(x, y, w, h);
	    this.background = Toolkit.getDefaultToolkit().getImage(background);
	    this.bControleur = bc;
	    this.etatPartie = DEBUT_TOUR;
	    this.initComposants(nbJoueurs);
	    this.setVisible(true);
	    }
   
/*Méthodes d'initialisation de la fenêtre*/
   
   /**
    * Placement des différents JPanel
    */
   private void initComposants(int nbJoueurs){
	   PanelImage PanelPrincipal = new PanelImage(new BorderLayout());
	   //Création de la partie Nord
	   JLabel texte = new JLabel("Texte d'information", SwingConstants.CENTER);
	   texte.setFont(new Font("Arial",Font.BOLD, 15));
	   texte.setForeground(Color.WHITE);
	   PanelPrincipal.add(texte, BorderLayout.NORTH);
	   //Création du panel Centre
	   JPanel pCenter = this.creerPanelCentre(nbJoueurs);
	   PanelPrincipal.add(pCenter, BorderLayout.CENTER);
	   //Création du panel Sud
	   JPanel pSouth = this.creerPanelSud();
	   PanelPrincipal.add(pSouth, BorderLayout.SOUTH);
	   
	   this.add(PanelPrincipal);
   }

   /**
    * Création du JPanel Sud
    * @return JPanel Sud
    */
   private JPanel creerPanelSud(){
	   JPanel pSouth = new JPanel();
	   JButton bTour = new JButton("Poser cartes");
	   JButton bQuitter = new JButton("Quitter");
	   
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
	   //bQuitter.addActionListener(   );
	   
	   pSouth.add(bTour);
	   pSouth.add(bQuitter);
	   pSouth.setOpaque(false);
	   return pSouth;
   }
   
   private JPanel creerPanelCentre(int nbJoueurs){
	   JPanel pCenter = new JPanel(new GridLayout(1, nbJoueurs, 50, 50));
	   
	   for(int i=0; i<nbJoueurs; i++)
		   pCenter.add(this.creerPanelJoueur(i));
	   
	   pCenter.setOpaque(false);
	   
	   return pCenter;
   }
   
   
   private JPanel creerPanelJoueur(int i){
	   JPanel panelJoueur = new JPanel(new GridLayout(2, 1));
	   LabelCarte lCarte = new LabelCarte();
	   bControleur.relierPile(i, lCarte);
	   
	   LabelMain lMain = new LabelMain();
	   bControleur.relierMain(i, lMain);
	   lMain.setFont(new Font("Arial",Font.BOLD, 15));
	   lMain.setForeground(Color.WHITE);
	   lMain.setHorizontalAlignment(JLabel.CENTER);
	   lMain.setVerticalAlignment(JLabel.CENTER);
	   panelJoueur.add(lCarte);
	   panelJoueur.add(lMain);
	   panelJoueur.setOpaque(false);
	   return panelJoueur;
   }
	
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
