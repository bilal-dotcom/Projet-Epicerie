/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fikar
 */
public class AdminGateWay {
    
 
    private PreparedStatement AllProd;
    private Connection con;
    
    public AdminGateWay(int nb)
    {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {    
                Logger.getLogger(ProduitGateWay.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            this.con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bdatp1","root","");
           
         
            this.AllProd=con.prepareStatement("update produit set vedette='non' where idprod=? ;");
           this.AllProd.setInt(1,nb);
          
             
        } catch (SQLException ex) {
            Logger.getLogger(ProduitGateWay.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
  
      
    
   // public ArrayList<produit> getAllProdAdmin()
     public produit getAllProdAdmin()
    {
         
        produit prod1 = new produit();
      ArrayList<produit > listDeProd = new ArrayList<>();
      ResultSet res ;
               
         try 
         {
               res= this.AllProd.executeQuery();
                while (res.next())
                {
                    prod1 = new produit(res.getInt("IDPROD"),res.getString("NOMPROD"),res.getDouble("PRIX"),res.getDouble("QUANTITE"),res.getString("IMGPROD"),
                                               res.getString("VEDETTE"), res.getString("SHIPPING"), res.getString("HANDLING"), res.getString("DEVISE"));
                    listDeProd.add(new produit(res.getInt("IDPROD"),res.getString("NOMPROD"),res.getDouble("PRIX"),res.getDouble("QUANTITE"),res.getString("IMGPROD"),
                                               res.getString("VEDETTE"), res.getString("SHIPPING"), res.getString("HANDLING"), res.getString("DEVISE")));
                }
          }
         catch (SQLException ex) {
             
                System.out.println(ex.getMessage());
            }
           
        try {
            this.con.close();
               
        } catch (SQLException ex) {
            Logger.getLogger(ProduitGateWay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     //   return listDeProd ;
        return prod1;
    }
    
}
