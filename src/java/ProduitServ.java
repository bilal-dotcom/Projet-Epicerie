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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fikar
 */
public class ProduitServ extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
           
             if ("Login".equals(request.getParameter("log")))
             {   this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response) ;}
             
            
                   
             int V = 0;
             int d = 0 ;
             String catt = "" ;
             if ("Produits Laitiers".equals(request.getParameter("1")))
             { V=1;catt = "Produits Laitiers" ;}
             else if ("Fruits et Legumes".equals(request.getParameter("2")))
             { V=2;catt = "Fruits et Legumes " ;  }
             else if ("Viandes".equals(request.getParameter("3")))
             {V=3;catt = "Viandes " ;}
             else if ("Patisseries".equals(request.getParameter("4")))
             {V=4; catt = "Patisseries" ; }
             
            ProduitGateWay gtwc = new ProduitGateWay(V);
          //  CategorieGateWay gtwc2 = new CategorieGateWay(V);
            
           ArrayList<produit> listeProd= new ArrayList<produit>();
            //ArrayList<categorie> listeCategorie= new ArrayList<categorie>(); 
          
          
            categorie categ  ;
         listeProd = gtwc.getProdFromCat();
          //  listeCategorie=gtwc2.getCateg();
        // categ = gtwc2.getCateg();
           
          categ = new categorie(listeProd,catt);  
           
            
       // request.setAttribute("listeProd",listeProd);
          //request.setAttribute("categ",categ);
           
          //RequestDispatcher dispatch =request.getRequestDispatcher("/produits.jsp");
          // dispatch.forward(request, response);
           
          
   /////////////////////////////////////////////////////////////////////////   
           HttpSession session = request.getSession();
       
         session.setAttribute("categ",categ);
              
         //Request dispacther des elements de ma session vers le jsp
        this.getServletContext().getRequestDispatcher("/produits.jsp").forward(request, response);
       
        }
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
        
        
//            response.setContentType("text/html;charset=UTF-8");
//          PrintWriter out = response.getWriter();
//     
//          String nom= request.getParameter("1");
//          out.println("Le bouton cliquer est: " + nom);
          
        
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

    
    public void oncatcl()
    {
        
    }
}

