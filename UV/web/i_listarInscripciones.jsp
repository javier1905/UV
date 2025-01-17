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
                
        <%-- <script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script> --%>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        
        <link href="i_listarInscripciones.css" rel="stylesheet" type="text/css"/>
        <script src="i_listarInscripciones.js" type="text/javascript"></script>
        
    </head>
     <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    <jsp:include page="x_menu.jsp" ></jsp:include>
    <body>
        <h1>INSCRIPCIONES</h1>
        <br>
        <a class="navbar-brand" href="e_servletInscripciones">NUEVA INSCRIPCION</a>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">ID ALUMNO</th>
              <th scope="col">NOMBRE</th>
              <th scope="col">APELLIDO</th>  
              <th scope="col">DNI</th>
              <th scope="col">MATERIA</th>
              <th scope="col">EDITAR</th>
              <th scope="col">ELIMINAR</th>
            </tr>
          </thead>
          <tbody>
              <% int cont=0;%>
              <g:forEach items="${vecInscripciones}" var="insc">
                  <%  cont++;%>
            <tr>
              <th scope="row"><%=cont%></th>
                      <td>${insc.alumno.legajo}</td>
                      <td>${insc.alumno.nombre}</td>  
                      <td>${insc.alumno.apellido}</td>
                      <td>${insc.alumno.dni}</td>
                      <td>${insc.materia.nombre}</td>
                      <td><a href="e_servletInscripciones?dat=${insc.id}" class="btn btn-outline-success" name="editar">EDITAR</a></td>
                      <td>
                          <form method="POST" action="e_servletListarInscripciones">    
                              <input type="hidden" value="${insc.id}" name="txt_idEliminar" id="txt_idEliminar">
                              <input type="submit" value="ELIMINAR" class="btn btn-outline-danger">
                          </form>                      
                      </td>
            </tr>
             </g:forEach>
          </tbody>
        </table>
    </body>
</html>
