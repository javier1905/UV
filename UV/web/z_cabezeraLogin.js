$(document).ready(function(){
 var validaSesion=$("#validaSesion");   
 var divSinLoguear=$(".sinLoguear");
 var divLogueado=$(".logueado");
 
    if (validaSesion.val()!='')
    {
                divSinLoguear.css('display','none');
        divLogueado.css('display','block');
    }else
    {
           divSinLoguear.css('display','block');
        divLogueado.css('display','none');

    }
   
//     <jsp:include page="acceso loguin"></jsp:include> 
    
    
    
});


