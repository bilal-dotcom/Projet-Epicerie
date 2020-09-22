<%-- 

    Document   : login
    Created on : 29 juin 2020, 21:55:28
    Author     : fikar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="MyPackage.produit"%>
<%@page import="MyPackage.panier"%>
<%@page import="MyPackage.categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script>
            
          
        </script>
        
    </head>
    <body>
          <%
               
             categorie cat = (categorie)session.getAttribute("categAllProd");
             ArrayList<produit> lP = (ArrayList<produit>)session.getAttribute("listeProd");
            produit pr = (produit)session.getAttribute("prod4"); 
            
              %>
            
      
        <form action="allcat" method="get">
        LOGIN
    
        <table>
            <tr><td>Login </td><td> <input type="text" name="loginadmin" value=""></td>  </tr>
            <tr><td>Password </td><td><input type="password" name="passwordadmin" value=""> </td>  </tr>
            <tr><td><input type="submit" name="entreradmin" value="Entrez"> </td>  </tr>
        </table>
 
   
        
    </body>
</html>
