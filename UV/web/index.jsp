<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UV</title>
       
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>   
                
     

        <script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        
        <%--SLIDER  --%>   
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
        <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
        
        <%-- fin SLIDER  --%> 
        
        <link href="index.css" rel="stylesheet" type="text/css"/>
        <script src="index.js" type="text/javascript"></script>
    </head>
    
    <header class="encabezado">
        <h1>UV</h1>
        <div class="contenedorLogueo">
              <input type="hidden" value="${usuario.usuario}" id="validaSesion">
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
    <nav class="navbar navbar-expand-lg navbar-light bg-light" id="menu">     


      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">INDEX <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              MATERIAS
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="b_servletListarMaterias">LISTA DE MATERIAS</a>
              <a class="dropdown-item" href="#">Another action</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              PROFESORES
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="d_servletListarProfesores">LISTA DE PROFESORES</a>
              <a class="dropdown-item" href="#">Another action</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              ALUMNOS
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="c_servletListarAlumnos">LISTA DE ALUMNOS</a>
              <a class="dropdown-item" href="#">Another action</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              DESCARGAS
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="c_servletListarAlumnos">MATERIAL PUBLICO</a>           
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="/UV/h_descargasPrivadas.jsp">MATERIAL PRIVADO</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              INSCRIPCIONES
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="e_servletListarInscripciones">LISTA DE INSCRIPCIONES</a>           
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="/UV/h_descargasPrivadas.jsp">MATERIAL PRIVADO</a>
            </div>
          </li>
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              REPORTES
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="f_servletListarAlumnosxMateria">LISTA DE ALUMNOS X MATERIA</a>
              <a class="dropdown-item" href="#">Another action</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
          </li>
        </ul>
      </div>
    </nav>
    

    <body>
            <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
              <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="iconos/utn.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="iconos/pc.jpg" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="iconos/tup.jpg" class="d-block w-100" alt="...">
                </div>
              </div>
            </div>
  
    
        
    </body>
</html>
