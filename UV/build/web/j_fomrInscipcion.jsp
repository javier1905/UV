<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="j_fomrInscipcion.css" rel="stylesheet" type="text/css"/>
        <script src="j_fomrInscipcion.js" type="text/javascript"></script>
    </head>
     <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include> 
     
    <body>
        <h1>INSCRIBIR</h1>
        <div class="formulario">
            <form action="e_servletInscripciones" method="POST" id="formularioVenta">
                <input type="hidden" name="id"  id="txt_id" value="${materiaAlumno.inscripcion.id}">
               
                <label for="">Alumno</label>           
                <select name="id_alumno" class="form-control form-control-lg" value="${materiaAlumno.inscripcion.alumno.legajo}" id="list_alumnos">
                    
                    <d:forEach items="${materiaAlumno.vecAlumnos}" var="alu">
                        <option value="${alu.legajo}">${alu.nombre} - ${alu.apellido} - ${alu.dni}</option>            
                    </d:forEach>
                </select>
                
                <label for="">Materia</label>           
                <select name="id_materia" class="form-control form-control-lg" value="${materiaAlumno.inscripcion.materia.id}" id="lista_materias">
                    <d:forEach items="${materiaAlumno.vecMaterias}" var="mat">
                        <option value="${mat.id}">${mat.nombre}</option>            
                    </d:forEach>
                </select>             

                  
                <div class="alert alert-danger" role="alert" id="cajaError">
                    <p>Verifique que esten cargados todos los elemnetos</p>
                </div>
		<input type="submit" value="ENVIAR" class="btn btn-primary">
            </form>
        </div>
    </body>
    <script src="j_fomrInscipcion.js" type="text/javascript"></script>
</html>
