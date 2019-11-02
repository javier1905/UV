<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <input type="text" name="txt_apellido" class="form-control form-control-lg" id="txt_nombre" value="${alumnoAeditar.apellido}">
                
                <label for="" class="">DNI</label>
                <input type="number" name="txt_dni" class="form-control form-control-lg" id="txt_nombre" value="${alumnoAeditar.dni}">
                
                <div class="alert alert-danger" role="alert" id="cajaError">
                    <p>Verifique que esten cargados todos los elemnetos</p>
                </div>
		<input type="submit" value="ENVIAR" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
