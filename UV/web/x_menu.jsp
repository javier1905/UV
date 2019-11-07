<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>   
                
        <%--  <script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script> --%>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/> 
        
        <link href="x_menu.css" rel="stylesheet" type="text/css"/>
        <script src="x_menu.js" type="text/javascript"></script>
</div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light" id="menu">     


      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">INDEX <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="d_servletSubirMaterial">SUBIR MATERIAL <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              MATERIAS
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="b_servletListarMaterias">LISTA DE MATERIAS</a>
         
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              PROFESORES
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="d_servletListarProfesores">LISTA DE PROFESORES</a>
      
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              ALUMNOS
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="c_servletListarAlumnos">LISTA DE ALUMNOS</a>
     
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              DESCARGAS
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="h_servletDescargasPublicas">MATERIAL PUBLICO</a>           
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="i_servletListarDescargasPrivadas">MATERIAL PRIVADO</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              INSCRIPCIONES
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="e_servletListarInscripciones">LISTA DE INSCRIPCIONES</a>          
              <a class="dropdown-item" href="l_servletAsignarProfeMateria">ASIGNAR PROFESOR A MATERIAS</a> 
            </div>           

          </li>
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              REPORTES
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="f_servletListarAlumnosxMateria">LISTA DE ALUMNOS X MATERIA</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="g_servletListarRecursosCantDescargas">DESCARGAS MATERIAL PUBLICO</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="j_servletListarAlumnoDescargas">LISTA PORCENTAGE DE DESCARGA ALUMNOS</a>
            </div>
          </li>
        </ul>
      </div>
    </nav>
