<%-- 
    Document   : admin
    Created on : 6 juil. 2020, 17:34:10
    Author     : fikar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="MyPackage.produit"%>
<%@page import="MyPackage.categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <%
               
             categorie cat = (categorie)session.getAttribute("categAllProd");
             ArrayList<produit> lP = (ArrayList<produit>)session.getAttribute("listeProd");
            
              %>
            
         <form action="admin" method="post">
              <p>
                <H1>LISTE DES PRODUITS</H1> 
                </p>
       
                <P>
                <input type='submit' name='update' value='Update'>
		<input type='submit' name='del' value='Delete'>	
                </p>
                
      
       
        <table border=5 style="width: 900px;height:1000px"> <th>IdProd</th> <th>Nom</th> <th>Prix</th> <th>Quantite </th><th>Image</th>
                        <th>Vedette</th>
        
                        <% for(int i=0;i< cat.getListProduit().size() ;i++)  {%>
       
              <tr> 
                  <td><input type="submit" name="proddd" value="<%=  i %>"></td>
                 <td><%= cat.getListProduit().get(i).nomprod %></td>
                <td><%= cat.getListProduit().get(i).prix %> $</td>    
                <td><%= cat.getListProduit().get(i).qte %></td>
                <td><img src="img/<%= cat.getListProduit().get(i).imgprod %>"  style='height:100px;width:100px' class="img-fluid" ></td>
                <td><input type="text" name="bool" value="<%= cat.getListProduit().get(i).vedette %>"></td> 

            </tr>
         <%} %>
         
        </table>
    </form>
    </body>
</html>
