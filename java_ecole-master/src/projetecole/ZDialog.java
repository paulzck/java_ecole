/*
 * Pour qu'un admin enregistre un éléve / enseignant / admin
 */
package projetecole;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ZDialog extends JDialog {
  private ZDialogInfo zInfo = new ZDialogInfo();
  private boolean sendData;
  private JLabel nomLabel, mdpLabel, icon, prenomLabel, statutLabel, mailLabel;
  private JComboBox statut;
  private JTextField nom, prenom, mail, mdp;

  public ZDialog(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(700, 700);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public ZDialogInfo showZDialog(){
    this.sendData = false;
    this.setVisible(true);      
    return this.zInfo;      
  }

  private void initComponent(){
    //Icône
    /*icon = new JLabel(new ImageIcon("images/icone.jpg"));
    JPanel panIcon = new JPanel();
    panIcon.setBackground(Color.white);
    panIcon.setLayout(new BorderLayout());
    panIcon.add(icon);*/

    //Le nom
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Nom de la personne"));
    nomLabel = new JLabel("Saisir un nom :");
    panNom.add(nomLabel);
    panNom.add(nom);
    
    //Le prénom
    JPanel panPrenom = new JPanel();
    panPrenom.setBackground(Color.white);
    panPrenom.setPreferredSize(new Dimension(250, 60));
    prenom = new JTextField();
    prenom.setPreferredSize(new Dimension(100, 25));
    panPrenom.setBorder(BorderFactory.createTitledBorder("Prénom de la personne"));
    prenomLabel = new JLabel("Saisir un prénom :");
    panPrenom.add(prenomLabel);
    panPrenom.add(prenom);
    
    //Le mail
    JPanel panMail = new JPanel();
    panMail.setBackground(Color.white);
    panMail.setPreferredSize(new Dimension(250, 60));
    mail = new JTextField();
    mail.setPreferredSize(new Dimension(100, 25));
    panMail.setBorder(BorderFactory.createTitledBorder("Mail de la personne"));
    mailLabel = new JLabel("Saisir un mail :");
    panMail.add(mailLabel);
    panMail.add(mail);
    
    //Le mot de passe
    JPanel panMdp = new JPanel();
    panMdp.setBackground(Color.white);
    panMdp.setPreferredSize(new Dimension(300, 60));
    mdp = new JTextField();
    mdp.setPreferredSize(new Dimension(100, 25));
    panMdp.setBorder(BorderFactory.createTitledBorder("Mot de passe de la personne"));
    mdpLabel = new JLabel("Saisir un mot de passe :");
    panMdp.add(mdpLabel);
    panMdp.add(mdp);

    //Le statut
    JPanel panStatut = new JPanel();
    panStatut.setBackground(Color.white);
    panStatut.setPreferredSize(new Dimension(220, 60));
    panStatut.setBorder(BorderFactory.createTitledBorder("Satut de la personne"));
    statut = new JComboBox();
    statut.addItem("Enseignant");
    statut.addItem("Étudiant");
    statut.addItem("Admin");
    statutLabel = new JLabel("Statut : ");
    panStatut.add(statutLabel);
    panStatut.add(statut);

    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(panPrenom);
    content.add(panMail);
    content.add(panMdp);
    content.add(panStatut);

    JPanel control = new JPanel();
    JButton okBouton = new JButton("Inscrire");
    
    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        zInfo = new ZDialogInfo(nom.getText(), prenom.getText(), (String)statut.getSelectedItem(), mail.getText(), mdp.getText());
        setVisible(false);
      }    
    });

    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    //this.getContentPane().add(panIcon, BorderLayout.WEST);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}