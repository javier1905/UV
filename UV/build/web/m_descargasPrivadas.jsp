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
                
        <script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script> 
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.css" rel="stylesheet" type="text/css"/>        
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/> 
        
        <link href="m_descargasPrivadas.css" rel="stylesheet" type="text/css"/>
        <script src="m_descargasPrivadas.js" type="text/javascript"></script>
        
    </head>
    <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    <jsp:include page="x_menu.jsp" ></jsp:include>
    <body>
        <h1>DESCARGAS DE MATERIAL PRIVADO</h1>
         <br>
         <div id="box">
            <g:forEach items="${vecRecursoMateria}" var="aluxMamteria">
                    <h3 class="alert alert-secondary" role="alert">${aluxMamteria.materia.nombre}</h3>           
                    <div>
                        <table class="table">
                            <thead>
                                <th>ID</th>
                                <th>TITULO</th>
                                <th>DETALLE</th>
                                <th>FORMATO</th>
                                <th>ARCHIVO</th>
                                <th>PUB O PRIV</th>                                
                            </thead>
                            <tbody>                                
                                <g:forEach items="${aluxMamteria.listaRecursos}" var="recu">
                                    <tr>
                                        <td>${recu.id}</td>
                                        <td>${recu.titulo}</td>
                                        <td>${recu.detalle}</td>
                                        <td>${recu.formato}</td>
                                        <td>
                                            <form action="i_registrarDescargasPrivadas?url=archivos/${recu.titulo}" method="POST" class="cargarDescarga" id="cargarDescarga" name="forFile">
                                                <input type="hide" value="${recu.id}"  style="display: none"  name="idRecurso">
                                                <input type="hide" value="archivos/${recu.titulo}"  style="display: none"  name="urlARchivo">
                                                <a href="#" value="${recu.titulo}" name="urlARchivo2" style="display: none" class="txt_descargar" id="txt_descargar" download>DESCARGAR</a>
                                                <input type="submit" value="DESCARGAR" class="btn btn-primary">
                                            </form>                                          
                                        </td>
                                        <td>${recu.pub_priv}</td>
                                    </tr>       
                                </g:forEach>
                            </tbody>
                        </table>
                    </div>
            </g:forEach>    
            </div>
    </body>
</html>
