<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DESCARGAS PRIVADAS</title>       
        <link href="h_descargasPrivadas.css" rel="stylesheet" type="text/css"/>
     <script src="h_subirRecurso.js" type="text/javascript"></script>
    </head>
    <jsp:include page="z_cabezeraLogin.jsp" ></jsp:include>
    <jsp:include page="x_menu.jsp" ></jsp:include>
    <body>
        <h1>INSERCISCON DE RECURSO</h1>
        <br>
        <form method="post" action="d_servletSubirMaterial" enctype="multipart/form-data" class="formulario">
          
            <label for="">Titulo</label>
            <input type="text" name="titulo" id="txt_titulo" class="form-control form-control-lg">
            <label for="">Detalle</label>
            <input type="text" name="detalle" id="txt_detalle" class="form-control form-control-lg">
            <label for="">Formato</label>
            <input type="text" name="formato" id="txt_formato" class="form-control form-control-lg">
            <label for="">Publico o privado</label>
            <input type="checkbox" name="pub_priv" id="cbx_puv_priv" class="form-control form-control-lg">
            <select name="idMateria" class="form-control form-control-lg" value="" class="form-control form-control-lg">
               <d:forEach items="${vecMaterias}" var="mat">
                   <option value="${mat.id}">${mat.nombre}</option>            
               </d:forEach>           
           </select>
            <input type="file" name="archivo" id="directorio" class="input-group-text">
            <div class="input-group mb-3" id="subida_arch">
              <div class="custom-file">
                  <input type="file" class="custom-file-input" name="descarga" id="inputGroupFile03">
                <label class="custom-file-label" for="inputGroupFile02" aria-describedby="inputGroupFileAddon02">Seleccione un archivo</label>
              </div>
              <div class="input-group-append">
                <span class="input-group-text" id="inputGroupFileAddon02">Upload</span>
              </div>
           </div>
           <input type="submit" value="GUARDAR" id="btn_submit" class="btn btn-primary">
        </form>
    </body>
</html>
