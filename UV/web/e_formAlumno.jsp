<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        
        <script src="e_formAlumno.js" type="text/javascript"></script>
    </head>
        <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>    
    <body>
        <h1>Alumno</h1>
        <br>
        <div class="formulario">
            <form action="c_servletAlumnos" method="POST" id="formularioAlumno">
                
                <input type="hidden" name="txt_id"  id="txt_id" value="${alumnoAeditar.legajo}">
		<label for="" class="">NOMBRE</label>
                <input type="text" name="txt_nombre" class="form-control form-control-lg" id="txt_nombre" value="${alumnoAeditar.nombre}">
                
                <label for="" class="">APELLIDO</label>
                <input type="text" name="txt_apellido" class="form-control form-control-lg" id="txt_apellido" value="${alumnoAeditar.apellido}">
                
                <label for="" class="">DNI</label>
                <input type="number" name="txt_dni" class="form-control form-control-lg" id="txt_dni" value="${alumnoAeditar.dni}">
                
                <div class="alert alert-danger" role="alert" id="cajaError">
                    <p>Verifique que esten cargados todos los elemnetos</p>
                </div>
                <input type="submit" value="ENVIAR" class="btn btn-primary" id="btn_submit">
            </form>
        </div>
    </body>
</html>
