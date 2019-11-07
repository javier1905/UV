<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALTA RECURSOS</title>   
        
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
                <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        
        <link href="h_descargasPrivadas.css" rel="stylesheet" type="text/css"/>
     <script src="h_subirRecurso.js" type="text/javascript"></script>
    </head>
    <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    <jsp:include page="x_menu.jsp" ></jsp:include>
    <body>
        <a class="btn btn-light" href="index.jsp" id="ind">INDEX</a>
        <h1>ALTA RECURSOS</h1>
        <br>
        <form method="post" action="d_servletSubirMaterial" enctype="multipart/form-data" class="formulario" id="formularioAlta">
          
            <%--<label for="">Titulo</label>
            <input type="text" name="titulo" id="txt_titulo" class="form-control form-control-lg">--%>
            <label for="">Descripcion</label>
            <input type="text" name="detalle" id="txt_detalle" class="form-control form-control-lg">
            <label for="">Formato</label>
            <input type="text" name="formato" id="txt_formato" class="form-control form-control-lg">
            <label for="">Publico o privado</label>            
            <input type="checkbox" name="pub_priv" id="cbx_puv_priv" class="form-control form-control-lg" value="false">
            <div class="fin"></div>
            <select name="idMateria" class="form-control form-control-lg" value="" class="form-control form-control-lg" id="cbx_materias">
               <d:forEach items="${vecMaterias}" var="mat">
                   <option value="${mat.id}">${mat.nombre}</option>            
               </d:forEach>           
           </select>
            <div class="input-group mb-3" id="subida_arch">
              <div class="custom-file">
                  <input type="file" class="custom-file-input" name="descarga" id="inputGroupFile03">
                <label class="custom-file-label" for="inputGroupFile02" aria-describedby="inputGroupFileAddon03">Seleccione un archivo</label>
              </div>
              <div class="input-group-append">
                <span class="input-group-text" id="inputGroupFileAddon02">Upload</span>
              </div>
           </div>
            <div class="alert alert-danger" role="alert" id="cajaError">
                <p>Verifique que esten cargados todos los elemnetos</p>
            </div>
           <input type="submit" value="SUBIR MATERIAL" id="btn_submit" class="btn btn-primary">
        </form>
            
    </body>
</html>
