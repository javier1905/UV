<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 
        
    </head>
     <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    <jsp:include page="x_menu.jsp" ></jsp:include>
    <body>
        <br>
        <h1>CANTIDAD DE DESCARGAS POR MATERIAL PUBLICO</h1>        
        <br>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">ID</th>
              <th scope="col">TITULO</th>     
              <th scope="col">FORMATO</th>
              <th scope="col">MATERIA</th>
              <th scope="col">CANTIDAD DESCARGAS</th>
            </tr>
          </thead>
          <tbody>
              <% int cont=0;%>
              <g:forEach items="${vecRecursoParam}" var="recu">
                  <%  cont++;%>
            <tr>
              <th scope="row"><%=cont%></th>
                      <td>${recu.id}</td>
                      <td>${recu.titulo}</td>
                      <td>${recu.formato}</td>
                      <td>${recu.materia.nombre}</td>
                      <td>${recu.cantDescargas}</td>                    
            </tr>
             </g:forEach>
          </tbody>
        </table>  
        
    </body>
</html>
