$(document).ready(function(){
 
    var txt_nombre=$("#txt_nombre");
    var txt_apellido=$("#txt_apellido");
    var txt_dni=$("#txt_dni");
    var formularioProfesor= $("#formularioProfesor");
    var cajaError=$("#cajaError");
    
        txt_dni.keypress(function(tecla) {
        if(tecla.charCode < 48 || tecla.charCode > 57) return false;        
    });
    
  
    function valida()
    {
        var bandera= true;
         var mensaje="";
        
        if(txt_nombre.val()=='undefined'  || txt_nombre.val()==null || txt_nombre.val()=='')
        {
            bandera=false;
            mensaje=mensaje+"Complete el campo nombre <br>"; 
            
        }
        if(txt_apellido.val()=='undefined'  || txt_apellido.val()==null || txt_apellido.val()=='')
        {
            bandera=false;
            mensaje=mensaje+"Complete el campo apellido <br>" ; 
        }
        if(txt_dni.val()=='undefined' || txt_dni.val()==null || txt_dni.val()=='' || txt_dni.val()<1)
        {
            bandera=false;
            mensaje=mensaje+"Complete el campo dni <br>" ;
        }
        if(bandera==false)
        {
             cajaError.css('display','block');
//             cajaError.effect('shake');
             cajaError.html(mensaje);
           
         }
        
        return bandera;
        
    }
    
    cajaError.css('display','none');
    
    formularioProfesor.submit(function(e){
    
        if(!valida())
        {
             e.preventDefault();
        }else
        {
             cajaError.css('display','none');
        }     
        
    });
    
    
    
    
    
    
    
});


