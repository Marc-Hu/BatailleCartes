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
   public FenetreGraphique(String title, String background, int x, int y, int w, int h, int nbJoueurs){
	    super(title);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE) ;                   
	    this.setBounds(x, y, w, h);
	    this.background = Toolkit.getDefaultToolkit().getImage(background);
	    this.nbTours = 0;
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
	   JButton bTour = new JButton("Tour n°"+this.nbTours);
	   JButton bQuitter = new JButton("Quitter");
	   

	   //bTour.addActionListener(   );
	   //bQuitter.addActionListener(   );
	   
	   pSouth.add(bTour);
	   pSouth.add(bQuitter);
	   pSouth.setOpaque(false);
	   return pSouth;
   }
   
   private JPanel creerPanelCentre(int nbJoueurs){
	   JPanel pCenter = new JPanel(new GridLayout(1, nbJoueurs, 50, 50));
	   for(int i=0; i<nbJoueurs; i++)
		   pCenter.add(this.creerPanelJoueur("images/trefle_14.GIF", "TEST"));
	   
	   pCenter.setOpaque(false);
	   
	   return pCenter;
   }
   
   
   private JPanel creerPanelJoueur(String img, String desc){
	   JPanel panelJoueur = new JPanel(new GridLayout(2, 1));
	   LabelImage imCarte = new LabelImage(img);
	   JLabel description = new JLabel(desc);
	   description.setFont(new Font("Arial",Font.BOLD, 15));
	   description.setForeground(Color.WHITE);
	   description.setHorizontalAlignment(JLabel.CENTER);
	   description.setVerticalAlignment(JLabel.CENTER);
	   description.setBackground(Color.BLUE);
	   panelJoueur.add(imCarte);
	   panelJoueur.add(description);
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
