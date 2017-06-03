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

	private int nbTours;
	private Image background;
	private BatailleControleur bControleur;
	private boolean debutTour;
	public boolean faireBataille;
	
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
	    this.nbTours = 0;
	    this.bControleur = bc;
	    this.debutTour = true;
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
	   ButtonTour bTour = new ButtonTour();
	   JButton bQuitter = new JButton("Quitter");
	   
	   this.bControleur.relierBouton(bTour);
	   bTour.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){

			   FenetreGraphique.this.faireBataille = FenetreGraphique.this.bControleur.initTour();

			   /*
			   if(FenetreGraphique.this.faireBataille)
				   FenetreGraphique.this.faireBataille = FenetreGraphique.this.bControleur.bataille();
			   
			   FenetreGraphique.this.bControleur.finTour();
				*/
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
		   pCenter.add(this.creerPanelJoueur("images/trefle_14.GIF", i));
	   
	   pCenter.setOpaque(false);
	   
	   return pCenter;
   }
   
   
   private JPanel creerPanelJoueur(String img, int i){
	   JPanel panelJoueur = new JPanel(new GridLayout(2, 1));
	   LabelCarte lCarte = new LabelCarte(img);
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
 /*  
   class PanelJoueur extends JPanel{
	   private JLabel image;
	   private JLabel description;
	     
	   public PanelJoueur(String img, String desc){
		   this.setLayout(new GridLayout(2, 1));
		   this.image = new JLabel(new ImageIcon(img));
		   this.description = new JLabel(desc);
		   this.description.setFont(new Font("Arial",Font.PLAIN, 15));
		   this.description.setForeground(Color.WHITE);	
		   
		   this.add(image);
		   this.add(description);
	   }
	   
	   public void setImg(JLabel img){
		   this.image = img;
	   }
	   
	   public void setDesc(JLabel desc){
		   this.description = desc;
	   }
	 
	    public void paintComponent(Graphics g) {
	    	super.paintComponent(g);
     
	    }
	}
*/
}
