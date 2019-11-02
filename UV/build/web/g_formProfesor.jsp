<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="g_formProfesor.css" rel="stylesheet" type="text/css"/>
        <script src="g_formProfesor.js" type="text/javascript"></script>
    </head>
        <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    
    <body>
        <h1 id="tituloProfesor">Profesor</h1>
        <br>
        <div class="formulario">
            <form action="d_servletProfesores" method="POST" id="formularioProfesor">
                
                <input type="hidden" name="txt_id"  id="txt_id" value="${profesorAeditar.legajo}">
		<label for="" class="">NOMBRE</label>
                <input type="text" name="txt_nombre" class="form-control form-control-lg" id="txt_nombre" value="${profesorAeditar.nombre}">
                
                <label for="" class="">APELLIDO</label>
                <input type="text" name="txt_apellido" class="form-control form-control-lg" id="txt_apellido" value="${profesorAeditar.apellido}">
                
                <label for="" class="">DNI</label>
                <input type="number" name="txt_dni" class="form-control form-control-lg" id="txt_dni" value="${profesorAeditar.dni}">
                
                <div class="alert alert-danger" role="alert" id="cajaError">
                    <p>Verifique que esten cargados todos los elemnetos</p>
                </div>
		<input type="submit" value="ENVIAR" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
