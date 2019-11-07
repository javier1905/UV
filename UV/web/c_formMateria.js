$(document).ready(function(){
 
    var txt_nombre=$("#txt_nombre");

    var formularioMateria= $("#formularioMateria");
    var cajaError=$("#cajaError");
    
        cajaError.css('display','none');
    
//        txt_dni.keypress(function(tecla) {
//        if(tecla.charCode < 48 || tecla.charCode > 57) return false;    

    
    formularioMateria.submit(function(e){
    
        if(!valida())
        {
             e.preventDefault();
        }else
        {
             cajaError.css('display','none');
        }     
        
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

        if(bandera==false)
        {
             cajaError.css('display','block');
//             cajaError.effect('shake');
             cajaError.html(mensaje);
           
         }
        
        return bandera;
        
    }
    });
    
  

    


    
    
    
    
    
    
    
