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
public class panier {
    
    int total;
    private ArrayList<produit> listProduit;
 
    
    public panier()
    {
    this.listProduit= new ArrayList<produit>();
    }
    
        public panier(ArrayList<produit> listeproduit) {
       
        this.listProduit=listeproduit;
    }

    public ArrayList<produit> getListProduit() {
        return listProduit;
    }

    public void setListProduit(ArrayList<produit> listProduit) {
        this.listProduit = listProduit;
    }

    
    
    public void addProduit(produit p)
    {
        this.listProduit.add(p);
    }
    
    public void removeProduit(produit p)
    {
       this.listProduit.remove(p);
       
    }
    
    public void updateProduit(produit p,int qte)
    {
        
    }
    
    public void clearPanier()
    {
     this.listProduit.clear();
    }
    
    public double totalPanier()
    {
        return this.total;
        
    }
    
    public ArrayList<produit>showPanier()
    {
        return this.listProduit;
    }
    
} 


