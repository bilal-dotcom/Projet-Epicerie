<%-- 
    Document   : showProd
    Created on : 27 mai 2020, 10:44:32
    Author     : fikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="MyPackage.produit,MyPackage.categorie,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="css/stylecss.css" />

         <!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">
          
         
    </head>
    <body>
        <%--  <form>--%>
     
             
        <%
            //Recuperer depuis la session
           //  ArrayList<produit> p = (ArrayList<produit>)session.getAttribute("listeProd");
           categorie c = (categorie)session.getAttribute("categ");
             
             //Recuperer depuis le request
          //   ArrayList<produit> p = (ArrayList<produit>)request.getAttribute("listeProd");
         // ArrayList<categorie> c = (ArrayList<categorie>)request.getAttribute("listeCategorie");
          //  categorie c =(categorie)request.getAttribute("categ");
        %>
            
 
            <div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
                  <img src="img/epi.jpg" class="img-fluid" >
            </div>
        
       
   <form action="getProd" method="get">
         <div style="float:left;margin-right: 90px;">
            
                <ul style="list-style-type:none">
                 <li>  <input type="submit" value="Produits Laitiers" name="1" class="inputecat" </input>
                 <li>     <input type="submit" value="Fruits et Legumes" name="2" class="inputecat" </input>
                  <li>  <input type="submit" name="3" value="Viandes" class="inputecat" </input>
                  <li>   <input type="submit" name="4" value="Patisseries" class="inputecat" </input>
                </ul>
               
         </div>
          
   </form>     
           <p>
             
                 
         <form action="catserv" method="get">
             
            <input type="submit" value="View cart" name="viewcart" style="height:30px; width:130px; margin-left: 50px">
<!--            <input type="submit" value="Proceed to checkout" name="checkout" style="height:30px;width:130px; margin-left: 50px">-->
         <div class="row row-pb-lg">
        	<div class="col-md-12">
                    <div class="product-name d-flex">
			<div class="one-forth text-left px-4">	
                            <span>Product Details</span>
			</div>
			<div class="one-eight text-center">
                            <span>Price</span>
			</div>
			<div class="one-eight text-center">
                        	<span>Quantity</span>
			</div>
			<div class="one-eight text-center">
				<span>Add To Cart</span>
			</div>
			
                    </div>
		
                     <%  for(int i=0;i< c.getListProduit().size() ;i++)  {%>
                      
                    <div class="product-cart d-flex">
			<div class="one-forth">
                            <div class="product-img" style="background-image:url('img/<%= c.getListProduit().get(i).imgprod  %>')" />
                               
                            </div>
                            <div class="display-tc">
                                <h3><%= c.getListProduit().get(i).nomprod %></h3>
                            </div>
			</div>
			<div class="one-eight text-center">
                        	<div class="display-tc">
                                	<span class="price"><%= c.getListProduit().get(i).prix %> $</span>
				</div>
			</div>
			<div class="one-eight text-center">
				<div class="display-tc">
                        		<%=c.getListProduit().get(i).getQte() %>
				</div>
			</div>
<!--                        Pour payement Paypal-->
			<div class="one-eight text-center">
                            
<!--                             <form target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">
                                <input type="hidden" name="cmd" value="_s-xclick">
                                <input type="hidden" name="hosted_button_id" value="4U7HGXVEXTZSQ">
                                <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_cart_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
                                <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
                             </form>
                            -->
                            <div class="display-tc">
				<input type="submit" name="prod" value="<%= i %>" >
<!--                                <input type="submit" name="prod" value="<%=  c.getListProduit().get(i).getIdprod() %>" >-->
                            </div>
			</div>
                	
                    </div>
                     
                     <%} %>

		</div>
	</div>
             
         </p>
      
       </form>
      
           
           
    </body> 
    
</html>
