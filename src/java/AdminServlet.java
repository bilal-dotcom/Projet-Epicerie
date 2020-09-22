/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MyPackage.AdminGateWay;
import MyPackage.ProduitGateWay;
import MyPackage.categorie;
import MyPackage.produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fikar
 */
@WebServlet(urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

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
           
             //Au clic sur le bouton conitinue chospping, une redirection vers la page produit.jsp
            if ("Update".equals(request.getParameter("update")))
             {   this.getServletContext().getRequestDispatcher("/produits.jsp").forward(request, response) ;}
             
            
            String ved;
                ved=  request.getParameter("bool");        
           
         
              String idprod;
                idprod=  request.getParameter("proddd");        
            int indexprod = Integer.parseInt(idprod );
             
            
            
             AdminGateWay gtwc = new AdminGateWay(indexprod);
         
            
           ArrayList<produit> listePro= new ArrayList<produit>();
          produit prod4 = new produit();
            categorie categAllProd  ;
        //  listePro = gtwc.getAllProdAdmin();
        prod4= gtwc.getAllProdAdmin();
        
         //  categAllProd = new categorie(listePro,"");  
 
           HttpSession session = request.getSession();
       
         session.setAttribute("prod4",prod4);
              
         //Request dispacther des elements de ma session vers le jsp
        this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        
        
            
            
           
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
