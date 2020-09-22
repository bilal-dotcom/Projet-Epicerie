<%-- 
    Document   : newjsp
    Created on : 27 juil. 2020, 21:23:45
    Author     : fikar
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="MyPackage.categorie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/stylecss.css" />
        
        
        <!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">
          
    
    </head>
    <body>
        
          <%
               
             categorie cat = (categorie)session.getAttribute("categAllProd");
             ArrayList<categorie> lP = (ArrayList<categorie>)session.getAttribute("listeCategorie");
         
              %>
              
              
        <form action="getProd" method="get">

            
          <div class="colorlib-product">
			<div class="container">
                            	
				<div class="row">
					<div class="col-sm-8 offset-sm-2 text-center colorlib-heading">
                                            <img src="img/epi.jpg" class="img-fluid" >
						<h2>Magasin</h2>
					</div>
				</div>
                           
                               
				<div class="row row-pb-md">
                                      <%  for(int i=0;i< lP.size() ;i++)  {%>
                                        <div class="col-lg-3 mb-4 text-center">
                                                 <div class="product-entry border">
                                                         <a  class="prod-img">
                                                             
                                                             <img src="img/<%= lP.get(i).imgcat %>" class="img-fluid" >
                                                                 <input type="submit" value="<%= lP.get(i).nomcat %>" name="<%= lP.get(i).idcat %>" id="cate4"  />
                                                         </a>
                                                         <div class="desc">


                                                         </div>
                                                 </div>
                                         </div>
                                       <%} %>
				</div>
            
                              

                       </div>
              </div>
            
                            
        </form>
    </body>
</html>
