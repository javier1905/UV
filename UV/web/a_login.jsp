<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        <script src="WEB-INF/jquery-3.4.1.min.js" type="text/javascript"></script>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="WEB-INF/jquery-ui-1.12.1/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
        
        <link href="a_login.css" rel="stylesheet" type="text/css"/>
        <script src="a_login.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Login</h1>
        <div class="logueo">
            <form method="POST" action="LoginServlet" id="formularioLogin">
                <input type="hidden" name="patch" value="<%=request.getParameter("patch") %>">
                <input type="text" name="user" placeholder="Nombre de usuario" id="txt_usuario" class="form-control form-control-lg">
                <input type="password" name="password" placeholder="Password" id="txt_password" class="form-control form-control-lg">
                <input type="submit" name="btn_submit" id="btn_submit" value="Loguiar" class="btn btn-primary btn-lg">
            </form>            
        </div>
    </body>
</html>
