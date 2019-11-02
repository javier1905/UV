<%-- 
    Document   : z_cabezeraLogin
    Created on : 30-oct-2019, 21:05:53
    Author     : javie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>   
                
        <%--<script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script> --%>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        
        <link href="z_cabezeraLogin.css" rel="stylesheet" type="text/css"/>
        <script src="z_cabezeraLogin.js" type="text/javascript"></script>
</div>

    <header class="encabezado">
        <h1 id="tituloUV">UV</h1>
        <div class="contenedorLogueo">
            <input type="hidden" value="${usuario.usuario}" id="validaSesion" name="user">
            <div class="sinLoguear">
                <form method="GET" action="LoginServlet">                             
                    <button type="submit" class="btn btn-primary" id="btn_iniciarSesion">INICIAR SESION</button>
                </form>
            </div>
            <div class="logueado">
                <form method="POST" action="servletLoginCerrarCesion"> 
                    <button type="submit" class="btn btn-primary" id="btn_cerrarSesion">CERRAR SESION</button>                  
                    <p>
                        Bienvenido ${usuario.usuario}  (Permiso de ${usuario.tipoUsuario})
                    </p>                
                </form>
            </div>
        </div>
        <div class="frenarFloatLeft">

        </div>            
                    
    </header>
