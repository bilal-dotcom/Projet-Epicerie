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
public class produit {
    
     public int idprod;
    public String nomprod;
    public Double prix;
    public Double qte;
    public String imgprod;
    public String vedette;
     public String shipping;
    public String handling;
     public String devise;
     public ArrayList list;
    
      public produit(int idprod,String nomprod,Double prix,Double qte,
                    String imgprod,String vedette,String shipping,String handling,String devise)
    {
       this.idprod = idprod; 
       this.nomprod=nomprod;
       this.prix=prix;
       this.qte=qte;
       this.imgprod=imgprod;
       this.vedette=vedette;
       this.shipping=shipping;
       this.handling=handling;
       this.devise=devise;
    }

       public produit(ArrayList lp) {
     this.list=lp;  
    }
        public produit() {
       
    }
       
    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public String getVedette() {
        return vedette;
    }

    public void setVedette(String vedette) {
        this.vedette = vedette;
    }
      

 

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getHandling() {
        return handling;
    }

    public void setHandling(String handling) {
        this.handling = handling;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Double getQte() {
        return qte;
    }

    public void setQte(Double qte) {
        this.qte = qte;
    }

    public String getImgprod() {
        return imgprod;
    }

    public void setImgprod(String imgprod) {
        this.imgprod = imgprod;
    }

   
    
}
