/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MyPackage.ProduitGateWay;
import MyPackage.categorie;
import MyPackage.panier;
import MyPackage.produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fikar
 */
public class CatServlet extends HttpServlet {
  
        ArrayList<produit> listeProd= new ArrayList<produit>();
        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                
        
        HttpSession session = request.getSession();
     
          categorie categ  ;
            categ= (categorie) session.getAttribute("categ");
          
       
        //Des le clic sur ViewCart, on se dirige vers la page panier
         if ("View cart".equals(request.getParameter("viewcart")))
             {   this.getServletContext().getRequestDispatcher("/panier.jsp").forward(request, response); ;}
         
         //Pour aller au checkout
               if ("Proceed to checkout".equals(request.getParameter("checkout")))
             {
                  this.getServletContext().getRequestDispatcher("/checkout.jsp").forward(request, response);  
             }
   
         
            String rr;
             rr=  request.getParameter("prod");
        
             int indexprod = Integer.parseInt(rr);       
          
//            panier pan ;
//          
              produit p = categ.getListProduit().get(indexprod);
//            listeProd.add(p);
//            pan = new panier(listeProd);           
//               session.setAttribute("cart",pan); 
      
  
       if(session.isNew())
        {
           // produit p = categ.getListProduit().get(indexprod);
           panier pan ;
             listeProd.add(p);
     
              pan = new panier(listeProd); 
            
            session.setAttribute("cart",pan);            
       }
        else
        {
           //Il n'y a aucun panier dans ma session donc je dois creer
            //un nouveau
            
           panier pan  =(panier)session.getAttribute("cart");
            //panier pan ;
               listeProd.add(p);
           pan = new panier(listeProd); 
          
             session.setAttribute("cart",pan);
        }
        
        this.getServletContext().getRequestDispatcher("/produits.jsp").forward(request, response);
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
