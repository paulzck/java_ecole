/*
 * 
 */
package projetecole;

import java.sql.*;
/**
 *
 * @author Grouhel
 */
public class ProjetEcole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
