/*
 * 
 */
package projetecole;

import java.sql.*;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ProjetEcole extends JFrame {
    
    String nom_fichier_image = "accueil.jpg";
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu test7 = new JMenu("Connexion");
    private JMenu test8 = new JMenu("Connexion");
    private JMenu test6 = new JMenu("Fermer");

    private JMenuItem item8 = new JMenuItem("Fermer");
    private JMenuItem item9 = new JMenuItem("Élève");
    private JMenuItem item10 = new JMenuItem("Enseignant");
    private JMenuItem item11 = new JMenuItem("Administrateur");
    
    public ProjetEcole(){
      
    super();
        setBounds(200, 200, 600, 400);
        JPanel panneau = new JPanel()
        {
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
 
                ImageIcon m = new ImageIcon(nom_fichier_image);
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 0, this.getWidth(), this.getHeight(), this);
                //g.drawImage(monImage, 0, 0,this);
 
            }
        };
 
        //ajouter le panneau à la fenétre.
        getContentPane().add(panneau);
      
    this.setSize(900, 900);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    
    item8.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }        
    });
    
    //On initialise nos menus  
    this.test6.add(item8);
    this.test8.add(item9);
    this.test8.add(item10);
    this.test8.add(item11);

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.menuBar.add(test6);
    this.menuBar.add(test7);
    this.test7.add(this.test8);
    this.setJMenuBar(menuBar);

    /*item9.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        ZDialog zd = new ZDialog(null, "", true);
        ZDialogInfo zInfo = zd.showZDialog(); 
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, zInfo.toString(), "Informations de la personne", JOptionPane.INFORMATION_MESSAGE);
      }         
    });*/
    
    item11.addActionListener(new ActionListener(){    
        public void actionPerformed(ActionEvent arg0) {
            ZFenetre fen = new ZFenetre();
        }
    });
    
    this.setVisible(true);      
  }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    ProjetEcole fen = new ProjetEcole();
    new ProjetEcole().setVisible(true);
    
        //Connection à la bdd
      
    try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection tmp = DriverManager.getConnection("jdbc:mysql://localhost/projet_ecole","root","");
        Statement stm = tmp.createStatement();
       String query = "INSERT INTO tab_personne_per (per_nom, per_prenom, per_type) VALUES ('Mercier','Michael', 7)";
        stm.executeUpdate(query);
        
        //PreparedStatement statement = this.connect.
        }catch(SQLException ex)
        {   
            
            System.out.println("aaaaaaaaaaaaaaa");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("bbbbbbbbbbbb");
        
        }
        
    }
    
    
    
    
    
}
