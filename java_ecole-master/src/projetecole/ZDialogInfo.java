/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetecole;

public class ZDialogInfo {
  private String nom, statut, prenom, mail, mdp;

  public ZDialogInfo(){}
  public ZDialogInfo(String nom, String statut, String prenom, String mail, String mdp){
    this.nom = nom;
    this.prenom = prenom;
    this.mail = mail;
    this.mdp = mdp;
    this.statut = statut;
  }

  public String toString(){
    String str;
    if(this.nom != null && this.prenom != null && this.mail != null && this.mdp != null && this.statut != null){
      str = "Description de la personne :" + "\n";
      str += "Nom : " + this.nom + "\n";
      str += "Prénom : " + this.prenom + "\n";
      str += "Mail : " + this.mail + "\n";
      str += "mdp : " + this.mdp + "\n";
      str += "Statut : " + this.statut + "\n";
    }
    else{
      str = "Aucune information !";
    }
    return str;
  }
}