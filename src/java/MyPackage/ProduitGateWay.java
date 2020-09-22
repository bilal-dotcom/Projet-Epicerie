/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author fikar
 */
public class ProduitGateWay {
    
   private PreparedStatement AllCatInfo;
    private PreparedStatement AllSpecifiedModeProdInfo;
    private Connection con;
    
    public ProduitGateWay(int nb)
    {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {    
                Logger.getLogger(ProduitGateWay.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            this.con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bdatp1","root","");
            this.AllCatInfo=con.prepareStatement("select * from produit ");
         
            
          //  this.AllSpecifiedModeCatInfo=con.prepareStatement("select * from produit,catprod where produit.idprod=catprod.idprod and catprod.idcat=3;");
               
         
            this.AllSpecifiedModeProdInfo=con.prepareStatement("select * from produit,catprod where produit.idprod=catprod.idprod and catprod.idcat=? and produit.vedette='oui' limit 4 ;");
           this.AllSpecifiedModeProdInfo.setInt(1,nb);
          
             
        } catch (SQLException ex) {
            Logger.getLogger(ProduitGateWay.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }

    
    
  
    
    public ArrayList<produit> getProdFromCat()
    {
         
      ArrayList<produit > listDeProd = new ArrayList<>();
      ResultSet res ;
               
         try 
         {
               res= this.AllSpecifiedModeProdInfo.executeQuery();
                while (res.next())
                {
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
        
        return listDeProd ;
        
    }
    
      public ArrayList<produit> getAllProd()
    {
         
      ArrayList<produit > listDeProd = new ArrayList<>();
      ResultSet res ;
               
         try 
         {
               res= this.AllCatInfo.executeQuery();
                while (res.next())
                {
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
        
        return listDeProd ;
        
    }
    
    
}

