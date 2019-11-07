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
        
        <%-- <script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script> --%>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>ASIGNAR PROFESOR A MATERIA</h1>
        
        <div class="formulario">
            <form action="l_servletAsignarProfeMateria" method="POST" id="formularioMateria">
                <input type="hidden" name="txt_id"  id="txt_id" value="IDPROFEMATERIA">
		<label for="" class="">MATERIA</label>
                   <select name="idMateria" class="form-control form-control-lg" value="" class="form-control form-control-lg">
                       <d:forEach items="${materiaProfesor.vecMateria}" var="mat">
                           <option value="${mat.id}">${mat.nombre}</option>            
                       </d:forEach>           
                   </select>
                		<label for="" class="">PROFEASOR</label>
                   <select name="idProfesor" class="form-control form-control-lg" value="" class="form-control form-control-lg">
                       <d:forEach items="${materiaProfesor.vecProfesor}" var="pro">
                           <option value="${pro.legajo}">${pro.nombre}</option>            
                       </d:forEach>           
                   </select> 
                <!--<div class="alert alert-danger" role="alert" id="cajaError">
                    <p>Verifique que esten cargados todos los elemnetos</p>
                </div>-->
		<input type="submit" value="ENVIAR" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
