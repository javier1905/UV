<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MATERIA</title>
        
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        <%-- <script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script> --%>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        
        <link href="c_formMateria.css" rel="stylesheet" type="text/css"/>
        <script src="c_formMateria.js" type="text/javascript"></script>
        
    </head>
    <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    <body>
         <a class="btn btn-light" href="index.jsp" id="ind">INDEX</a>
        <h1>MATERIA</h1>
        <br> 
        <div class="formulario">
                
            <form action="b_servletMaterias" method="POST" id="formularioMateria">
                <input type="hidden" name="txt_id"  id="txt_id" value="${materiaAeditar.id}">
		<label for="" class="">NOMBRE</label>
                <input type="text" name="txt_nombre" class="form-control form-control-lg" id="txt_nombre" value="${materiaAeditar.nombre}">                   
                <div class="alert alert-danger" role="alert" id="cajaError">
                    <p>Verifique que esten cargados todos los elemnetos</p>
                </div>
                <input type="submit" value="ENVIAR" class="btn btn-primary" id="btn_submit">
            </form>
                
        </div>
        
    </body>
</html>
