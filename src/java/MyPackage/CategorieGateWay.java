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
public class CategorieGateWay {
     
   private PreparedStatement AllCategorie;
   
    private Connection con;
    
    public CategorieGateWay()
    {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {    
                Logger.getLogger(ProduitGateWay.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            this.con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bdatp1","root","");
            this.AllCategorie=con.prepareStatement("select * from categorie ");
         
        //  this.AllCategorie.setInt(1);
          
             
        } catch (SQLException ex) {
            Logger.getLogger(ProduitGateWay.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }

    
    
  
    
    public ArrayList<categorie> getAllCat()
    {
         
      ArrayList<categorie > listAllCat= new ArrayList<>();
      ResultSet res ;
               
         try 
         {
               res= this.AllCategorie.executeQuery();
                while (res.next())
                {
                    listAllCat.add(new categorie(res.getInt("IDCAT"),res.getString("NOMCAT"), res.getString("IMGCAT")));
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
        
        return listAllCat ;
        
    }
    
}