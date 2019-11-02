<%-- 
    Document   : h_descargasPrivadas
    Created on : 30-oct-2019, 21:30:40
    Author     : javie
enctype="multipart/form-data"
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DESCARGAS PRIVADAS</title>
 
        
        <link href="h_descargasPrivadas.css" rel="stylesheet" type="text/css"/>
        <script src="h_descargasPrivadas.js" type="text/javascript"></script>
       
    </head>
    <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    <jsp:include page="x_menu.jsp" ></jsp:include>
    <body>
        
        <form method="post" action="d_servletDescargas" enctype="multipart/form-data">
            <center>
                <table border="1" width="25%" cellpadding="5">
                    <thead> 
                            <th colspan="3">Upload File</th>        
                    </thead>
                    <tbody>
                        <tr>    
                            <td>Title : </td>
                            <td><input type="text" name="detalle" size="30"></td>
                        </tr>
                        <tr>
                            <td>Choose File : </td>
                            <td><input type="file" name="file_uploaded" /></td>
                        </tr>
                        <tr>
                            <td>Choose File : </td>
                            <td><input type="checkbox" name="pub_priv" /></td>
                        </tr>
                        <tr>
                            <td>Choose File : </td>
                            <td>
                        <select name="idMateria" class="form-control form-control-lg" value="">
                           <d:forEach items="${vecMaterias}" var="mat">
                               <option value="${mat.id}">${mat.nombre}</option>            
                           </d:forEach>
                       </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3"><center><input type="submit" value="Upload"></center></td>
                        </tr>
                    </tbody>             
                </table>
            </center>
        </form>

        
        <div id="accordion">
          
          <h3>Section 1</h3>
          <div>
            <p>
            Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
            ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
            amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
            odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
            </p>
          </div>
          <h3>Section 2</h3>
          <div>
            <p>
            Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
            purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
            velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
            suscipit faucibus urna.
            </p>
          </div>
          <h3>Section 3</h3>
          <div>
            <p>
            Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
            Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
            ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
            lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
            </p>
            <ul>
              <li>List item one</li>
              <li>List item two</li>
              <li>List item three</li>
            </ul>
          </div>
          <h3>Section 4</h3>
          <div>
            <p>
            Cras dictum. Pellentesque habitant morbi tristique senectus et netus
            et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
            faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
            mauris vel est.
            </p>
            <p>
            Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
            Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
            inceptos himenaeos.
            </p>
          </div>
        </div>
    </body>
       <script>     
          $( function() {
    $( "#accordion" ).accordion();
  } );
  </script> 
</html>
