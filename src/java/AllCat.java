/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MyPackage.CategorieGateWay;
import MyPackage.ProduitGateWay;
import MyPackage.categorie;
import MyPackage.produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fikar
 */
public class AllCat extends HttpServlet {

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
            
           
             
             CategorieGateWay gtwc = new CategorieGateWay();
         
            ArrayList<categorie> listeCategorie= new ArrayList<categorie>(); 
          
          
            categorie categ  ;
        
         listeCategorie=gtwc.getAllCat();
        // categ = gtwc2.getCateg();
         
            
        request.setAttribute("listeCategorie",listeCategorie);
          //request.setAttribute("categ",categ);
           
          //RequestDispatcher dispatch =request.getRequestDispatcher("/produits.jsp");
          // dispatch.forward(request, response);
           
          
   /////////////////////////////////////////////////////////////////////////   
           HttpSession session = request.getSession();
       
         session.setAttribute("listeCategorie",listeCategorie);
              
         //Request dispacther des elements de ma session vers le jsp
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
       
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
