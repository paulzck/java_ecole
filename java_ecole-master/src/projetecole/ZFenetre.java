/*
 * Fenêtre Admin
 * System.out.println("aaaaaaaaaaaaaaa");
 */
package projetecole;

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

public class ZFenetre extends JFrame {
    
  String nom_fichier_image = "admin.jpg";
    
  private JMenuBar menuBar = new JMenuBar();
  private JMenu test1 = new JMenu("Inscription");
  private JMenu test2 = new JMenu("Informations");
  private JMenu test3 = new JMenu("Modification");
  private JMenu test4 = new JMenu("Déconexion");
  private JMenu test5 = new JMenu("Modifier");
  private JMenu test6 = new JMenu("Fermer");

  private JMenuItem item1 = new JMenuItem("Enseignant");
  private JMenuItem item2 = new JMenuItem("Élève");
  private JMenuItem item3 = new JMenuItem("Inscrire");
  private JMenuItem item4 = new JMenuItem("Supprimer");
  private JMenuItem item5 = new JMenuItem("Modifier");
  private JMenuItem item6 = new JMenuItem("Élève");
  private JMenuItem item7 = new JMenuItem("Enseignant");
  private JMenuItem item8 = new JMenuItem("Fermer");

  public ZFenetre(){
      
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
    this.test1.add(item3);
    this.test2.add(item1);
    this.test2.add(item2);
    this.test3.add(item4);
    this.test6.add(item8);
    this.test5.add(item6);
    this.test5.add(item7);

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite
    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier
    this.menuBar.add(test1);
    this.menuBar.add(test2);
    this.menuBar.add(test3);
    this.menuBar.add(test4);
    this.test3.add(this.test5);
    this.menuBar.add(test6);
    this.setJMenuBar(menuBar);

    item3.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        ZDialog zd = new ZDialog(null, "", true);
        ZDialogInfo zInfo = zd.showZDialog(); 
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, zInfo.toString(), "Informations de la personne", JOptionPane.INFORMATION_MESSAGE);
      }         
    });
    
    item1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        EDialog zd = new EDialog(null, "", true);
        ZDialogInfo zInfo = zd.showZDialog(); 
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, zInfo.toString(), "Informations de la personne", JOptionPane.INFORMATION_MESSAGE);
      }         
    });
    
    item2.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        EDialog zd = new EDialog(null, "", true);
        ZDialogInfo zInfo = zd.showZDialog(); 
        JOptionPane jop = new JOptionPane();
        jop.showMessageDialog(null, zInfo.toString(), "Informations de la personne", JOptionPane.INFORMATION_MESSAGE);
      }         
    });
    
    this.setVisible(true);      
  }
   
  public static void main(String[] main){
    ZFenetre fen = new ZFenetre();
    new ZFenetre().setVisible(true);
  }

  
  }
