<%-- 
    Document   : panier
    Created on : 15 juin 2020, 17:47:21
    Author     : fikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="MyPackage.produit,MyPackage.panier,MyPackage.categorie,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CART</title>
          <link rel="stylesheet" type="text/css" href="css/stylecss.css" />
         
	<link rel="stylesheet" href="css/style.css">
            <script>
            window.addEventListener('load', function () {
              var rr=document.getElementById("quantity"). ;
              alert(rr);
            });
        </script>
    </head>
    <body>
        
             <%
                int cnt=1;
                categorie c = (categorie)session.getAttribute("categ");
                panier pann = (panier)session.getAttribute("cart");
            
              %>
            
        
            <div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
                  <img src="img/epi.jpg" class="img-fluid" >
            </div>
      
              
        <form action="pan" method="get" >
            <p>
         <input type="submit" name="clearcart"  value="Clear Cart"  style="height:30px; width:130px; margin-left: 50px">
         
          <input type="submit" name="continue" value="Continue Shopping" style="height:30px;width:130px; margin-left: 50px"> 
     
      
            </p>
      
              <div style="visibility:hidden">  <%double total=0, total1,total2=0,qtee; 
                        for(int i=0;i< pann.getListProduit().size();i++)  {%>
                      <%= total+= pann.getListProduit().get(i).prix  %>
                      <%= total2 +=(pann.getListProduit().get(i).prix)* (pann.getListProduit().get(i).qte)%>
                    
                <%} %>
              </div>
                
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
				<span>Total</span>
			</div>
			<div class="one-eight text-center px-4">
				<span>Remove</span>
			</div>
                    </div>
		
                     <% for(produit p: pann.getListProduit())  {%>
                   
                       <div>
                         <% String qtt= request.getParameter("quantity") ;%> 
                      </div> 
                    <div class="product-cart d-flex">
			<div class="one-forth">
                            <div class="product-img" style="background-image:url('img/<%=p.imgprod %>')" />
                               
                            </div>
                            <div class="display-tc">
                                <h3><%= p.nomprod %></h3>
                            </div>
			</div>
			<div class="one-eight text-center">
                        	<div class="display-tc">
                                	<span class="price"><%= p.prix %> $</span>
				</div>
			</div>
			<div class="one-eight text-center">
				<div class="display-tc">
                                    <input type="text" id="quantity" name="quantity" class="form-control input-number text-center" value="<%= p.qte %>" min="1" max="100">
				</div>
			</div>
			<div class="one-eight text-center">
                            <div class="display-tc">
				<span class="price"> <%= (p.prix)*(p.qte) %> $</span>
                            </div>
			</div>
                	<div class="one-eight text-center">
                            <div class="display-tc">
				<input  type="submit" name="remove" value="<%= cnt %>" >
                                
                            </div>
                        </div>
                              
<!--                                <div class="one-eight text-center">
                            <div class="display-tc">
                                <span id="quantity" name="quantity"></span>
                                
                        	</div>
                        </div>-->
                    </div>
                     
                     <% cnt++;} 
                     
                         cnt=1; %>
                         
                     
                 <div class="product-cart d-flex">	
                    <div class="one-forth"><span>Total</span>   </div>  
                    <div class="one-eight text-center">
                        	<div class="display-tc">
                                    <span class="price"> 
                                       <%= total %> $
                                    </span>    
				</div>
			</div>
                       <div class="one-eight text-center">
                            <div class="display-tc">
				<span class="price" > </span>
                            </div>
                    </div>
                     <div class="one-eight text-center">
                            <div class="display-tc">
				<span class="price" ><%= total2 %> $</span>
                            </div>
                    </div>
                </div>
	</div>
         
        </form>                
         <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
         
             <input type="hidden" name="cmd" value="_cart">
             <input type="hidden" name="upload" value="1">
             <input type="hidden" name="business" value="bilalbusiness@gmail.com">
         
              <% for(produit p: pann.getListProduit())  {%>
                <input type="hidden" name="item_name_<%=cnt%>" value="<%= p.nomprod %>">
                <input type="hidden" name="amount_<%=cnt%>" value="<%= total2 %>">
               <input type="hidden" name="quandtity_<%=cnt%>" value="<%= cnt %>"> 
                <input type="hidden" name="shipping_<%=cnt%>" value="<%= p.shipping %>">
                <input type="hidden" name="handling <%=cnt%>" value="<%= p.handling %>">
            
              <% cnt++;}%>
              
               <input type="hidden" name="currency_code" value="CAD">
               
               <input type="hidden" name="return" value="https://www.youtube.com/">
                <input type="hidden" name="cancel_return" value="https://www.netflix.com/">
              
                 
                <input type="submit" name="submit" value="Checkout" style="margin-left: 40px" >
                
         </form>
         
         
   
         <script src=script/java.js></script>  
    </body>
</html>
 