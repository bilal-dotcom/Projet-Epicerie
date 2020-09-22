/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

import java.util.ArrayList;

/**
 *
 * @author fikar
 */
public class categorie {
     public ArrayList<produit> listproduit;
     public int idcat;
    public String nomcat;
    public String imgcat;
    
      public categorie(int idcat,String nomcat,ArrayList<produit> listeproduit,String imgcat)
    {
       this.listproduit=listeproduit;
       this.idcat = idcat;
       this.nomcat=nomcat; 
       this.imgcat=imgcat;
    }
      
//    public categorie(ArrayList listproduit,String nomcat) {
//         this.listproduit= new ArrayList<produit>(); 
//     this.nomcat=nomcat;
//    }
      
       
    public categorie(ArrayList<produit> listeproduit, String nomcat) {
        this.nomcat=nomcat;
        this.listproduit=listeproduit;
    }
  public categorie(int idcat,String nomcat,String imgcat)
    {
       this.idcat = idcat;
       this.nomcat=nomcat; 
       this.imgcat=imgcat;
    }

    public ArrayList<produit> getListProduit() {
        return listproduit;
    }

    public void setListProduit(ArrayList<produit> listproduit) {
        this.listproduit = listproduit;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }

    public String getImgcat() {
        return imgcat;
    }

    public void setImgcat(String imgcat) {
        this.imgcat = imgcat;
    }
    
      
}
